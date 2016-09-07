package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 8/31/2016.
 */
import com.google.gson.annotations.Expose;


public class Error {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     *
     * @return
     * The code
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
