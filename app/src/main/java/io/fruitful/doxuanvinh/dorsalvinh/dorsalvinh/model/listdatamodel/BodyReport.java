package io.fruitful.doxuanvinh.dorsalvinh.dorsalvinh.model.listdatamodel;

/**
 * Created by admin on 8/31/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BodyReport {
    public BodyReport(Integer pageSize, int timeRange, int pageIndex) {
        this.approved = true;
        this.country = "Australia";
        this.timeRange = timeRange;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }


    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("timeRange")
    @Expose
    private Integer timeRange;
    @SerializedName("pageIndex")
    @Expose
    private Integer pageIndex;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;

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
     * The timeRange
     */
    public Integer getTimeRange() {
        return timeRange;
    }

    /**
     *
     * @param timeRange
     * The timeRange
     */
    public void setTimeRange(Integer timeRange) {
        this.timeRange = timeRange;
    }

    /**
     *
     * @return
     * The pageIndex
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     *
     * @param pageIndex
     * The pageIndex
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     *
     * @return
     * The pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     *
     * @param pageSize
     * The pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
