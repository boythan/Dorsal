package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.R;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.ConstantKey;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.verificationmodel.BodyVerify;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.verificationmodel.VerificationResult;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark.RequestInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 8/31/2016.
 */
public class VerificationFragment extends Fragment {
    TextView codeVerify;
    public VerificationFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.verification, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.my_toolbar); // Attaching the layout to the toolbar object
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.verifi_title);
        toolbar.setTitleTextColor(this.getResources().getColor(R.color.white));

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        codeVerify = (TextView) rootView.findViewById(R.id.code_verify);

        Button btn_done = (Button) rootView.findViewById(R.id.sign_up_done);
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerDone();


            }


        });
        return rootView;
    }

    private void registerDone() {
        Call<VerificationResult> call = setRetrofitResult();
        call.enqueue(new Callback<VerificationResult>() {
            @Override
            public void onResponse(Call<VerificationResult> call, final Response<VerificationResult> response) {
                int error = 0;
                if(response.body().getError()!= null){
                    error= response.body().getError().getCode();
                }
                if (response.isSuccessful() && error!= ConstantKey.ERROR_CODE_VERIFICATION) {
                    Fragment mFragment = new SharkDataFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("tokenKey", response.body().getResponseData().getToken());
                    mFragment.setArguments(bundle);
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main, mFragment);
                    ft.commit();
                } else {
                    ConstantKey.alertDialog(getActivity(),response.body().getError().getMessage() );
                }

            }

            @Override
            public void onFailure(Call<VerificationResult> call, Throwable t) {
                Log.d("Error3", "aaa+" + t.getMessage());
            }
        });

    }

    public Call<VerificationResult> setRetrofitResult() {
        int accountId = getArguments().getInt("accountId");
        String activationCode = codeVerify.getText().toString();
        BodyVerify body = new BodyVerify(accountId, activationCode);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantKey.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<VerificationResult> call = request.postVerify(ConstantKey.CONTENT_TYPE, body);
        return call;
    }
}
