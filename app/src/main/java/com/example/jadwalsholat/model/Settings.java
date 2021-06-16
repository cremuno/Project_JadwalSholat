package com.example.jadwalsholat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {

    @SerializedName("timeformat")
    @Expose
    private String timeformat;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("juristic")
    @Expose
    private String juristic;
    @SerializedName("highlat")
    @Expose
    private String highlat;
    @SerializedName("fajr_angle")
    @Expose
    private Integer fajrAngle;
    @SerializedName("isha_angle")
    @Expose
    private Integer ishaAngle;

    public String getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(String timeformat) {
        this.timeformat = timeformat;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getJuristic() {
        return juristic;
    }

    public void setJuristic(String juristic) {
        this.juristic = juristic;
    }

    public String getHighlat() {
        return highlat;
    }

    public void setHighlat(String highlat) {
        this.highlat = highlat;
    }

    public Integer getFajrAngle() {
        return fajrAngle;
    }

    public void setFajrAngle(Integer fajrAngle) {
        this.fajrAngle = fajrAngle;
    }

    public Integer getIshaAngle() {
        return ishaAngle;
    }

    public void setIshaAngle(Integer ishaAngle) {
        this.ishaAngle = ishaAngle;
    }

}
