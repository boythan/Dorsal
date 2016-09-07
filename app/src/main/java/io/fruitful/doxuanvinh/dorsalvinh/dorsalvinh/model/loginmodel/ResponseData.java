package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.loginmodel;

/**
 * Created by admin on 8/30/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResponseData {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("account")
    @Expose
    private Account account;

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
