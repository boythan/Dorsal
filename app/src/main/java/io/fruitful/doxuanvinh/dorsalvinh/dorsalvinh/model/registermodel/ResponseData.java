package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.registermodel;

/**
 * Created by admin on 9/3/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResponseData {

    @SerializedName("data")
    @Expose
    private Object data;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("account")
    @Expose
    private Account account;

    /**
     *
     * @return
     * The data
     */
    public Object getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     * The account
     */
    public Account getAccount() {
        return account;
    }

    /**
     *
     * @param account
     * The account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

}