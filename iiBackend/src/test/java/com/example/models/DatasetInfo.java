package com.example.models;

import com.google.gson.Gson;

import java.util.List;

public class DatasetInfo {

    private long Id;
    private long CategoryId;
    private String CategoryCaption;
    private long DepartmentId;
    private String DepartmentCaption;
    private String Caption;
    private String Description;
    private boolean ContainsGeodata;
    private String VersionNumber;
    private String VersionDate;
    private long ItemsCount;
    private List<Column> Columns;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


    public long getItemsCount() {
        return ItemsCount;
    }

    public void setItemsCount(long itemsCount) {
        ItemsCount = itemsCount;
    }
}
