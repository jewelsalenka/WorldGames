package com.testtask.xyrality.worldgames.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 1:58 PM .
 */
public class World {
    @SerializedName("id")
    @Expose private String mId;

    @SerializedName("language")
    @Expose private String mLang;

    @SerializedName("url")
    @Expose private String mUrl;

    @SerializedName("country")
    @Expose private String mCountry;

    @SerializedName("worldStatus")
    @Expose private WorldStatus mStatus;

    @SerializedName("mapURL")
    @Expose private String mMap;

    @SerializedName("name")
    @Expose private String mName;

    public String getmLang() {
        return mLang;
    }

    public void setmLang(String mLang) {
        this.mLang = mLang;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public WorldStatus getmStatus() {
        return mStatus;
    }

    public void setmStatus(WorldStatus mStatus) {
        this.mStatus = mStatus;
    }

    public String getmMap() {
        return mMap;
    }

    public void setmMap(String mMap) {
        this.mMap = mMap;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return "World{" +
                "mId='" + mId + '\'' +
                ", mLang='" + mLang + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mCountry='" + mCountry + '\'' +
                ", mStatus=" + mStatus +
                ", mMap='" + mMap + '\'' +
                ", mName='" + mName + '\'' +
                '}';
    }
}
