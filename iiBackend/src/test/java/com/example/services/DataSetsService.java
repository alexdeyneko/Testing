package com.example.services;


import com.example.Exceptions.NotFoundIdDataSet;
import com.example.Exceptions.NotFoundVersionNumber;
import com.example.models.Dataset;
import com.example.models.DatasetInfo;
import com.example.models.Version;
import com.example.models.VersionAndRelease;
import com.google.gson.Gson;
import retrofit2.Call;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataSetsService {

    public static long getIdDataSetOnName(String name) throws IOException, NotFoundIdDataSet {

        DataSetsRequests service = BaseService.getRetrofit().create(DataSetsRequests.class);

        Call<List<Dataset>> response = service.getDataSetOnName("Caption eq '" + name + "'");

        List<Dataset> dataset = response.execute().body();

        if (dataset == null) throw new NotFoundIdDataSet();

        return dataset.get(0).getId();
    }


    public static DatasetInfo getExpectedDataSetInfo(String path) throws FileNotFoundException {

        FileReader reader = new FileReader(path);
        DatasetInfo datasetInfo = new Gson().fromJson(reader, DatasetInfo.class);

        return datasetInfo;
    }
    public static String getVersion() throws IOException, NotFoundVersionNumber {

        DataSetsRequests service = BaseService.getRetrofit2().create(DataSetsRequests.class);

        Call<Version> response = service.getVersion();

        Version data = response.execute().body();

        if (data == null) throw new NotFoundVersionNumber();
        return data.getVersion();
    }

    public static VersionAndRelease getVersionandRelease() throws IOException, NotFoundIdDataSet {

        DataSetsRequests service = BaseService.getRetrofit().create(DataSetsRequests.class);

        Call<VersionAndRelease> response = service.getVersionAndRelease(897);

        VersionAndRelease data = response.execute().body();

        if (data == null) throw new NotFoundIdDataSet();

        return data;
    }


}
