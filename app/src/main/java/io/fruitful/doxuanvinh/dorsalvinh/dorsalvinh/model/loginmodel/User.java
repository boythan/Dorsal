package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.loginmodel;

/**
 * Created by admin on 8/29/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.Error;


public class User {

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