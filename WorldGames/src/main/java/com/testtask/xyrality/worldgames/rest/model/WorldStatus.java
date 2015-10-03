package com.testtask.xyrality.worldgames.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 2:30 PM .
 */
public class WorldStatus {
    @SerializedName("id")
    @Expose private String mStatusId;

    @SerializedName("description")
    @Expose private String mDesc;

    public String getmStatusId() {
        return mStatusId;
    }

    public void setmStatusId(String mStatusId) {
        this.mStatusId = mStatusId;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }
}
