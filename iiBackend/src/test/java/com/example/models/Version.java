package com.example.models;

import com.google.gson.Gson;
public class Version {
    private String Version;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
