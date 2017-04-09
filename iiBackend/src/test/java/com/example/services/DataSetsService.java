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



}
