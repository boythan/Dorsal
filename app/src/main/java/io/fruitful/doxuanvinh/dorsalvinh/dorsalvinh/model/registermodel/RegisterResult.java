package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.registermodel;

/**
 * Created by admin on 9/3/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.Error;


public class RegisterResult {

    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("responseData")
    @Expose
    private ResponseData responseData;

    /**
     *
     * @return
     * The error
     */
    public Error getError() {
        return error;
    }

    /**
     *
     * @param error
     * The error
     */
    public void setError(Error error) {
        this.error = error;
    }

    /**
     *
     * @return
     * The responseData
     */
    public ResponseData getResponseData() {
        return responseData;
    }

    /**
     *
     * @param responseData
     * The responseData
     */
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

}
