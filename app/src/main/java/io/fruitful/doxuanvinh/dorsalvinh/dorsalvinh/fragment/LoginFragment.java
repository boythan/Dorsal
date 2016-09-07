package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.fragment;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.R;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.ConstantKey;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.loginmodel.BodyLogin;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.loginmodel.User;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark.RequestInterface;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.registermodel.RegisterResult;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 8/29/2016.
 */
public class LoginFragment extends Fragment {
    BodyLogin body = new BodyLogin();
    EditText userName;
    EditText password;

    public LoginFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);
        userName = (EditText) rootView.findViewById(R.id.email);
        password = (EditText) rootView.findViewById(R.id.password);
        Button btn_login = (Button) rootView.findViewById(R.id.login);
        Button btn_signUp = (Button) rootView.findViewById(R.id.sign_up);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_Login();
            }
        });

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main, new RegisterFragment()).addToBackStack(null).commit();
            }
        });
        return rootView;
    }

    private void check_Login() {
        Call<User> call = setRetrofitResult();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, final Response<User> response) {
                User jsonResponse = response.body();
                int errorCode = 0;
                if(jsonResponse!= null && jsonResponse.getError()!= null) {
                    errorCode = jsonResponse.getError().getCode();
                }
                if (response.isSuccessful() && errorCode != ConstantKey.ERROR_ACCOUNT_NOT_ACTIVATED ) {
                        Fragment mFragment = new SharkDataFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("tokenKey", jsonResponse.getResponseData().getToken());
                        mFragment.setArguments(bundle);
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main, mFragment);
                        ft.commit();
                    }
                else {
//                    if (jsonResponse == null) {
                    if(errorCode == ConstantKey.ERROR_ACCOUNT_NOT_ACTIVATED){
//                        ConstantKey.alertDialog(getActivity(),response.body().getError().getMessage());
                        Bundle bundle = new Bundle();
                        bundle.putInt("accountId", jsonResponse.getResponseData().getAccount().getId());
                        Fragment mFragment = new VerificationFragment();
                        mFragment.setArguments(bundle);
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main, mFragment);
                        ft.commit();
                    }
                    else {
                        String errorBody = "";

                        try {
                            errorBody = response.errorBody().string();
                            JSONObject jsonObject = new JSONObject(errorBody);
                            JSONObject errorObject = jsonObject.getJSONObject("error");
                            String message = errorObject.getString("message");
                            ConstantKey.alertDialog(getActivity(), message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Error3", t.getMessage());
            }
        });

    }

    public Call<User> setRetrofitResult() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantKey.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<User> call = request.postUser(userName.getText().toString(), password.getText().toString(), body);
//        Call<User> call = request.postUser("vinh5@yopmail.com", "123456", body);
        return call;
    }
}

