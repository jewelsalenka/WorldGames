package com.testtask.xyrality.worldgames.rest.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 1:58 PM .
 */
public class WorldsResponse {
    @SerializedName("googleLoginSwitchOn")
    @Expose private boolean mLogOn;

    @SerializedName("serverVersion")
    @Expose private String mVersion;

    @SerializedName("facebookLoginSwitchOn")
    @Expose private String mFacebookOn;

    @SerializedName("allAvailableWorlds")
    @Expose private List<World> mWorlds;

    public List<World> getmWorlds() {
        return mWorlds;
    }

    public void setmWorlds(List<World> mWorlds) {
        this.mWorlds = mWorlds;
    }

    public String getmVersion() {
        return mVersion;
    }

    public String getmFacebookOn() {
        return mFacebookOn;
    }

    public void setmFacebookOn(String mFacebookOn) {
        this.mFacebookOn = mFacebookOn;
    }

    public void setmVersion(String mVersion) {
        this.mVersion = mVersion;
    }

    public boolean ismLogOn() {
        return mLogOn;
    }

    public void setmLogOn(boolean mLogOn) {
        this.mLogOn = mLogOn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WorldsResponse{" +
                "mLogOn=" + mLogOn +
                ", mVersion='" + mVersion + '\'' +
                ", mFacebookOn='" + mFacebookOn + '\'' +
                "   [");
        for (World mWorld : mWorlds) {
            builder.append("    mWorld = " + mWorld);
        }
        builder.append("    ]"+'\''+"}");
        return builder.toString();
    }
}
