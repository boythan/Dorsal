package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.registermodel;

/**
 * Created by admin on 9/3/2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BodyRegister {
    public BodyRegister() {
        this.name = "XuanVinh";
        this.email = "user@dorsal.ft";
        this.password = "123456";
    }

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("mobile")
    @Expose
    private String mobile;
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

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     * The mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
