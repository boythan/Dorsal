package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.verificationmodel;

/**
 * Created by admin on 9/4/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BodyVerify {

    @SerializedName("accountId")
    @Expose
    private Integer accountId;
    @SerializedName("activationCode")
    @Expose
    private String activationCode;
    @SerializedName("platformType")
    @Expose
    private Integer platformType;
    @SerializedName("platformVersion")
    @Expose
    private String platformVersion;
    @SerializedName("deviceToken")
    @Expose
    private String deviceToken;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("buildNumber")
    @Expose
    private String buildNumber;

    public BodyVerify(Integer accountId, String activationCode) {
        this.accountId = accountId;
        this.activationCode = activationCode;
        this.platformType = 1;
        this.platformVersion = "1.0";
        this.deviceToken = "PUSH NOTIFICATION DEVICE TOKEN";
        this.deviceId = "DEVICE ID";
        this.buildNumber = "20160829";
    }

    /**
     *
     * @return
     * The accountId
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     * The accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return
     * The activationCode
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     *
     * @param activationCode
     * The activationCode
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    /**
     *
     * @return
     * The platformType
     */
    public Integer getPlatformType() {
        return platformType;
    }

    /**
     *
     * @param platformType
     * The platformType
     */
    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    /**
     *
     * @return
     * The platformVersion
     */
    public String getPlatformVersion() {
        return platformVersion;
    }

    /**
     *
     * @param platformVersion
     * The platformVersion
     */
    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    /**
     *
     * @return
     * The deviceToken
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     *
     * @param deviceToken
     * The deviceToken
     */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /**
     *
     * @return
     * The deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     *
     * @param deviceId
     * The deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     *
     * @return
     * The buildNumber
     */
    public String getBuildNumber() {
        return buildNumber;
    }

    /**
     *
     * @param buildNumber
     * The buildNumber
     */
    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

}
