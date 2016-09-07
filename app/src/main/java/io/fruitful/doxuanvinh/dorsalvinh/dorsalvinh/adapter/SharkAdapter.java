package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.R;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel.ResponseDatum;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark.OnLoadMoreListener;

/**
 * Created by admin on 8/31/2016.
 */
public class SharkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseDatum> mDataSet;
    Context mContext;

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;
    private final int VISIBLE_THRESHOLD = 1;
    private OnLoadMoreListener mOnLoadMoreListener;

    private boolean isLoading;
    private int lastVisibleItem, totalItemCount;

    public SharkAdapter(List<ResponseDatum> mDataSet, Context mContext, RecyclerView mRecyclerView) {
        this.mDataSet = mDataSet;
        this.mContext = mContext;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (!isLoading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    if (mOnLoadMoreListener != null) {
                        mOnLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSet.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
            return new PlaceViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_progressbar, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof PlaceViewHolder) {
            PlaceViewHolder sharkViewHolder = (PlaceViewHolder) holder;
            ResponseDatum result = mDataSet.get(position);
            String destinationText = result.getState() + " - " + result.getZone() + " - " + result.getLocation();
            sharkViewHolder.destinationView.setText(destinationText);
            sharkViewHolder.timeView.setText(result.getFormattedReportTime());

        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }

    // place view horder
    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView destinationView;
        public TextView timeView;

        public PlaceViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.card_view);
            destinationView = (TextView) view.findViewById(R.id.destination);
            timeView = (TextView) view.findViewById(R.id.time);
        }
    }

    // loading view holder
    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }
    }
    public void setLoaded() {
        isLoading = false;
    }
}
