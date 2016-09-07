package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel;

/**
 * Created by admin on 8/31/2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ResponseDatum {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("coordinate")
    @Expose
    private String coordinate;
    @SerializedName("reportTime")
    @Expose
    private long reportTime;
    @SerializedName("formattedReportTime")
    @Expose
    private String formattedReportTime;
    @SerializedName("typeOfEncounter")
    @Expose
    private String typeOfEncounter;
    @SerializedName("typeOfShark")
    @Expose
    private String typeOfShark;
    @SerializedName("sharkLength")
    @Expose
    private String sharkLength;
    @SerializedName("distanceFromShore")
    @Expose
    private String distanceFromShore;
    @SerializedName("weatherCondition")
    @Expose
    private Object weatherCondition;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("unreadMessages")
    @Expose
    private Object unreadMessages;
    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("official")
    @Expose
    private Boolean official;
    @SerializedName("platformType")
    @Expose
    private int platformType;
    @SerializedName("totalComment")
    @Expose
    private Object totalComment;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("sharkPhotos")
    @Expose
    private List<Object> sharkPhotos = new ArrayList<Object>();
    @SerializedName("sharkVideos")
    @Expose
    private List<Object> sharkVideos = new ArrayList<Object>();
    @SerializedName("sharkVideoLinks")
    @Expose
    private List<Object> sharkVideoLinks = new ArrayList<Object>();
    @SerializedName("messages")
    @Expose
    private Object messages;
    @SerializedName("userLocation")
    @Expose
    private Object userLocation;
    @SerializedName("latestComments")
    @Expose
    private Object latestComments;
    @SerializedName("platformVersion")
    @Expose
    private String platformVersion;

    public ResponseDatum(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The zone
     */
    public String getZone() {
        return zone;
    }

    /**
     *
     * @param zone
     * The zone
     */
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The coordinate
     */
    public String getCoordinate() {
        return coordinate;
    }

    /**
     *
     * @param coordinate
     * The coordinate
     */
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    /**
     *
     * @return
     * The reportTime
     */
    public long getReportTime() {
        return reportTime;
    }

    /**
     *
     * @param reportTime
     * The reportTime
     */
    public void setReportTime(long reportTime) {
        this.reportTime = reportTime;
    }

    /**
     *
     * @return
     * The formattedReportTime
     */
    public String getFormattedReportTime() {
        return formattedReportTime;
    }

    /**
     *
     * @param formattedReportTime
     * The formattedReportTime
     */
    public void setFormattedReportTime(String formattedReportTime) {
        this.formattedReportTime = formattedReportTime;
    }

    /**
     *
     * @return
     * The typeOfEncounter
     */
    public String getTypeOfEncounter() {
        return typeOfEncounter;
    }

    /**
     *
     * @param typeOfEncounter
     * The typeOfEncounter
     */
    public void setTypeOfEncounter(String typeOfEncounter) {
        this.typeOfEncounter = typeOfEncounter;
    }

    /**
     *
     * @return
     * The typeOfShark
     */
    public String getTypeOfShark() {
        return typeOfShark;
    }

    /**
     *
     * @param typeOfShark
     * The typeOfShark
     */
    public void setTypeOfShark(String typeOfShark) {
        this.typeOfShark = typeOfShark;
    }

    /**
     *
     * @return
     * The sharkLength
     */
    public String getSharkLength() {
        return sharkLength;
    }

    /**
     *
     * @param sharkLength
     * The sharkLength
     */
    public void setSharkLength(String sharkLength) {
        this.sharkLength = sharkLength;
    }

    /**
     *
     * @return
     * The distanceFromShore
     */
    public String getDistanceFromShore() {
        return distanceFromShore;
    }

    /**
     *
     * @param distanceFromShore
     * The distanceFromShore
     */
    public void setDistanceFromShore(String distanceFromShore) {
        this.distanceFromShore = distanceFromShore;
    }

    /**
     *
     * @return
     * The weatherCondition
     */
    public Object getWeatherCondition() {
        return weatherCondition;
    }

    /**
     *
     * @param weatherCondition
     * The weatherCondition
     */
    public void setWeatherCondition(Object weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     * The unreadMessages
     */
    public Object getUnreadMessages() {
        return unreadMessages;
    }

    /**
     *
     * @param unreadMessages
     * The unreadMessages
     */
    public void setUnreadMessages(Object unreadMessages) {
        this.unreadMessages = unreadMessages;
    }

    /**
     *
     * @return
     * The approved
     */
    public Boolean getApproved() {
        return approved;
    }

    /**
     *
     * @param approved
     * The approved
     */
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    /**
     *
     * @return
     * The official
     */
    public Boolean getOfficial() {
        return official;
    }

    /**
     *
     * @param official
     * The official
     */
    public void setOfficial(Boolean official) {
        this.official = official;
    }

    /**
     *
     * @return
     * The platformType
     */
    public int getPlatformType() {
        return platformType;
    }

    /**
     *
     * @param platformType
     * The platformType
     */
    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }

    /**
     *
     * @return
     * The totalComment
     */
    public Object getTotalComment() {
        return totalComment;
    }

    /**
     *
     * @param totalComment
     * The totalComment
     */
    public void setTotalComment(Object totalComment) {
        this.totalComment = totalComment;
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

    /**
     *
     * @return
     * The sharkPhotos
     */
    public List<Object> getSharkPhotos() {
        return sharkPhotos;
    }

    /**
     *
     * @param sharkPhotos
     * The sharkPhotos
     */
    public void setSharkPhotos(List<Object> sharkPhotos) {
        this.sharkPhotos = sharkPhotos;
    }

    /**
     *
     * @return
     * The sharkVideos
     */
    public List<Object> getSharkVideos() {
        return sharkVideos;
    }

    /**
     *
     * @param sharkVideos
     * The sharkVideos
     */
    public void setSharkVideos(List<Object> sharkVideos) {
        this.sharkVideos = sharkVideos;
    }

    /**
     *
     * @return
     * The sharkVideoLinks
     */
    public List<Object> getSharkVideoLinks() {
        return sharkVideoLinks;
    }

    /**
     *
     * @param sharkVideoLinks
     * The sharkVideoLinks
     */
    public void setSharkVideoLinks(List<Object> sharkVideoLinks) {
        this.sharkVideoLinks = sharkVideoLinks;
    }

    /**
     *
     * @return
     * The messages
     */
    public Object getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     * The messages
     */
    public void setMessages(Object messages) {
        this.messages = messages;
    }

    /**
     *
     * @return
     * The userLocation
     */
    public Object getUserLocation() {
        return userLocation;
    }

    /**
     *
     * @param userLocation
     * The userLocation
     */
    public void setUserLocation(Object userLocation) {
        this.userLocation = userLocation;
    }

    /**
     *
     * @return
     * The latestComments
     */
    public Object getLatestComments() {
        return latestComments;
    }

    /**
     *
     * @param latestComments
     * The latestComments
     */
    public void setLatestComments(Object latestComments) {
        this.latestComments = latestComments;
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

}
