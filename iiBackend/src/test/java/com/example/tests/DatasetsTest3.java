package com.example.tests;

import com.example.Exceptions.NotFoundIdDataSet;
import com.example.models.DatasetInfo;
import com.example.models.VersionAndRelease;
import com.example.services.BaseService;
import com.example.services.DataSetsRequests;
import com.example.services.DataSetsService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;
public class DatasetsTest3 {
    private final static Logger logger = Logger.getLogger(DatasetsTest.class);
    @Test
    public void getDataSetInfoTest() throws IOException {
        try {

            DataSetsRequests service = BaseService.getRetrofit().create(DataSetsRequests.class);

            long id = 897;
            Call<VersionAndRelease> response =  service.getVersionAndRelease(id);

            logger.debug(response);

            VersionAndRelease data = response.execute().body();
            logger.debug(data.toString());

            Assert.assertEquals(data.getVersionNumber(), 3);
            Assert.assertEquals(data.getReleaseNumber(), 2);


        } catch (IllegalArgumentException e) {
            logger.error(e);
        }
    }

}
