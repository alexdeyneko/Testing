package com.example.services;

import com.example.models.Dataset;
import com.example.models.DatasetInfo;
import com.example.models.Version;
import com.example.models.VersionAndRelease;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface DataSetsRequests {
    //Получение информации о наборе данных
    @GET("datasets/{id}")
    Call<DatasetInfo> getDataSetInfo(@Path("id")long id);

    @GET("datasets?$top=1")
    Call<List<Dataset>> getDataSetOnName(@Query("$filter") String nameDataset);
    @GET("version")
    Call<Version> getVersion();
    @GET("datasets/{id}/version")
    Call<VersionAndRelease> getVersionAndRelease(@Path("id")long id);
}
