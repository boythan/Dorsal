package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.interface_shark;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel.BodyReport;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel.ResponseData;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.loginmodel.BodyLogin;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.loginmodel.User;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.registermodel.RegisterResult;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.verificationmodel.BodyVerify;
import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.verificationmodel.VerificationResult;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by admin on 8/30/2016.
 */
public interface RequestInterface {
        @POST("/login")
        Call<User> postUser(@Header("X-Auth-Username") String userName, @Header("X-Auth-Password") String password, @Body BodyLogin body);

        @POST("/report/list")
        Call<ResponseData> postReport(@Header("X-Auth-Token") String token, @Header("Content-Type") String contentType, @Body BodyReport body);

        @Multipart
        @POST("/register")
        Call<RegisterResult> register(@Part("data") RequestBody jsonBody, @Part MultipartBody.Part file);

        @POST("/public/account/activate")
        Call<VerificationResult> postVerify(@Header("Content-Type") String contentType, @Body BodyVerify body);

}
//    @Body int platformType, @Body String platformVersion, @Body String deviceToken, @Body String deviceId, @Body String buildNumber