package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.verificationmodel;

/**
 * Created by admin on 9/4/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.Error;


public class VerificationResult {

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
