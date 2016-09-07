package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.R;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.adapter.SharkAdapter;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.ConstantKey;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel.BodyReport;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel.ResponseData;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel.ResponseDatum;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark.OnLoadMoreListener;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark.RequestInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 8/31/2016.
 */
public class SharkDataFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    BodyReport bodyReport;
    private Menu menu;
    private SharkAdapter sharkAdapter;
    List<ResponseDatum> resultList = new ArrayList<>();
    private String tokenKey;

    public SharkDataFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        final SwipeRefreshLayout swipeLayout;

        //tool bar
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.my_toolbar_home);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_list);
        toolbar.setTitleTextColor(this.getResources().getColor(R.color.white));
        setHasOptionsMenu(true);

        //navigation
        DrawerLayout drawer = (DrawerLayout) rootView.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this.getActivity(), drawer, toolbar, R.string.app_name, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) rootView.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Swipe Refresh
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                resultList.clear();
                sharkAdapter.notifyDataSetChanged();
                getRetrofitResult(recyclerView);
                swipeLayout.setRefreshing(false);

            }
        });

        //setting RecycleView
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        getRetrofitResult(recyclerView);
        return rootView;
    }

    public void getRetrofitResult(final RecyclerView recyclerView) {
        final int[] pageIndex = {0};
        final Call<ResponseData> call = setRetrofitResult(ConstantKey.PAGE_SIZE, ConstantKey.TIME_START, ConstantKey.PAGE_INDEX_START);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, final Response<ResponseData> response) {
                ResponseData jsonResponse = response.body();
                resultList = jsonResponse.getResponseData();
                sharkAdapter = new SharkAdapter(resultList, getContext(), recyclerView);
                recyclerView.setAdapter(sharkAdapter);
                sharkAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        resultList.add(null);
                        sharkAdapter.notifyItemInserted(resultList.size() - 1);
                        //Load more data for reyclerview
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Call<ResponseData> call_recursive = setRetrofitResult(ConstantKey.PAGE_SIZE, ConstantKey.TIME_START, ++pageIndex[0]);
                                call_recursive.enqueue(new Callback<ResponseData>() {
                                    @Override
                                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                        ResponseData jsonResponse2 = response.body();
                                        //removeload item
                                        resultList.remove(resultList.size() - 1);
                                        //Load data
                                        resultList.addAll(jsonResponse2.getResponseData());
                                        sharkAdapter.notifyDataSetChanged();
                                        sharkAdapter.setLoaded();
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseData> call, Throwable t) {
                                        Log.d("Error3", "recursive fail+" + t.getMessage());
                                    }
                                });
                            }
                        }, 5000);
                    }
                });

            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.e("Error3", "aaa+" + t.getMessage());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.filter, menu);
        this.menu = menu;
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuItem titleFilter = menu.findItem(R.id.title_filter);
        switch (item.getItemId()) {
            case R.id.filter1:
                filter(0);
                titleFilter.setTitle("All");
                return true;
            case R.id.filter2:
                filter(12);
                titleFilter.setTitle("12h");
                return true;
            case R.id.filter3:
                filter(24);
                titleFilter.setTitle("24h");
                return true;
            case R.id.filter4:
                filter(168);
                titleFilter.setTitle("7d");
                return true;
            case R.id.filter5:
                filter(720);
                titleFilter.setTitle("30d");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public Call<ResponseData> setRetrofitResult(int pageSize, int timeRange, int pageIndex) {
        bodyReport = new BodyReport(pageSize, timeRange, pageIndex);
        tokenKey = getArguments().getString("tokenKey");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantKey.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<ResponseData> call = request.postReport(tokenKey, ConstantKey.CONTENT_TYPE, bodyReport);
        return call;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) (View) getView().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void filter(int time) {

        final int final_time = time;
        final int[] pageIndex = {0};
        Call<ResponseData> call_recursive = setRetrofitResult(ConstantKey.PAGE_SIZE, time, pageIndex[0]);
        call_recursive.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                ResponseData jsonResponse2 = response.body();
                resultList.clear();
                resultList.addAll(jsonResponse2.getResponseData());
                sharkAdapter.notifyDataSetChanged();

                sharkAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        resultList.add(null);
                        sharkAdapter.notifyItemInserted(resultList.size() - 1);
                        //Load more data for reyclerview
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Load data
                                Call<ResponseData> call_recursive = setRetrofitResult(ConstantKey.PAGE_SIZE, final_time, ++pageIndex[0]);
                                call_recursive.enqueue(new Callback<ResponseData>() {
                                    @Override
                                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                        ResponseData jsonResponse2 = response.body();
                                        //Remove loading item
                                        resultList.remove(resultList.size() - 1);
                                        resultList.addAll(jsonResponse2.getResponseData());
                                        sharkAdapter.notifyDataSetChanged();
                                        sharkAdapter.setLoaded();
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseData> call, Throwable t) {
                                        Log.d("Error3", "recursive fail+" + t.getMessage());
                                    }
                                });
                            }
                        }, 5000);
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("Error3", "recursive fail+" + t.getMessage());
            }
        });
    }
}
