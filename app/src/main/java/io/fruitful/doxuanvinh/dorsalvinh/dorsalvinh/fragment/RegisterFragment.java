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
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.MainActivity;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.R;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.ConstantKey;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.registermodel.RegisterResult;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark.RequestInterface;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by admin on 8/30/2016.
 */
public class RegisterFragment extends Fragment {

    EditText nameText;
    EditText emailText;
    EditText passwordText;
    EditText passwordRetypeText;
    public RegisterFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.sig_up, container, false);

        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.my_toolbar); // Attaching the layout to the toolbar object
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.registor_title);
        toolbar.setTitleTextColor(this.getResources().getColor(R.color.white));

        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        nameText = (EditText) rootView.findViewById(R.id.name_register);
        emailText = (EditText) rootView.findViewById(R.id.email_register);
        passwordText = (EditText) rootView.findViewById(R.id.password_register);
        passwordRetypeText = (EditText) rootView.findViewById(R.id.password_retype_register);


        Button btn_signUp = (Button) rootView.findViewById(R.id.sign_up_register);
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }


        });
        return rootView;
    }

    private void signUp() {

        Call<RegisterResult> call = setRetrofitResult();
        if(call == null){
            return;
        }
        call.enqueue(new Callback<RegisterResult>() {
            @Override
            public void onResponse(Call<RegisterResult> call, final Response<RegisterResult> response) {
                int errorCode = response.body().getError().getCode();
                if(response.isSuccessful() &&(errorCode == ConstantKey.ERROR_ACCOUNT_NOT_ACTIVATED)) {
                    RegisterResult jsonResponse = response.body();
                    Bundle bundle = new Bundle();
                    bundle.putInt("accountId", jsonResponse.getResponseData().getAccount().getId());
                    Fragment mFragment = new VerificationFragment();
                    mFragment.setArguments(bundle);
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main, mFragment);
                    ft.commit();
                }
                else{
                    ConstantKey.alertDialog(getActivity(),response.body().getError().getMessage());
                }
            }

            @Override
            public void onFailure(Call<RegisterResult> call, Throwable t) {
                Log.d("Error3", t.getMessage());
            }
        });

    }

    public Call<RegisterResult> setRetrofitResult() {
        Call<RegisterResult> call = null;
        final String name = nameText.getText().toString();
        final String email = emailText.getText().toString();
        final String password = passwordText.getText().toString();
        final String passwordRetype = passwordRetypeText.getText().toString();

        if(password.equals(passwordRetype) == false && password.length() !=0 ){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Oops");
            builder.setMessage(ConstantKey.MESSAGE_PASS_NOT_MATCH);
            builder.setCancelable(false);
            builder.setNeutralButton("OKE", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return null;
        }

        try {
            JSONObject registerJson  = new JSONObject("{\"name\": \"" + name + "\",\n" +
                    "                \"email\": \"" + email + "\",\n" +
                    "                \"password\": \"" + password + "\",\n" +
                    "                \"mobile\": \"0412345678\",\n" +
                    "                \"platformType\": 1,\n" +
                    "                \"platformVersion\": \"1.0\",\n" +
                    "                \"deviceToken\": \"PUSH NOTIFICATION DEVICE TOKEN\",\n" +
                    "                \"deviceId\": \"DEVICE ID\",\n" +
                    "                \"buildNumber\": \"20160126\"\n" +
                    "        };");
            String json = registerJson.toString();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantKey.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RequestInterface request = retrofit.create(RequestInterface.class);
            RequestBody jsonBody = RequestBody.create(MediaType.parse(ConstantKey.CONTENT_TYPE), json);
            call =  request.register(jsonBody, null);
            return call;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return call;

    }
}
