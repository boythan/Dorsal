package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel;

/**
 * Created by admin on 8/31/2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.Error;

public class ResponseData {
    public ResponseData() {
    }

    @SerializedName("error")
    @Expose
    private Error error;
    @SerializedName("responseData")
    @Expose
    private List<ResponseDatum> responseData = new ArrayList<ResponseDatum>();

    /**
     *
     * @return
     * The error
     */
    public Object getError() {
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
    public List<ResponseDatum> getResponseData() {
        return responseData;
    }

    /**
     *
     * @param responseData
     * The responseData
     */
    public void setResponseData(List<ResponseDatum> responseData) {
        this.responseData = responseData;
    }

}
