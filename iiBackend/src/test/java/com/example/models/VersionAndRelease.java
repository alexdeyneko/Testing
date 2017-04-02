package com.example.models;


import com.google.gson.Gson;

public class VersionAndRelease {
    private int versionNumber;
    private int releaseNumber;

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
