package com.example.tests;

import com.example.Exceptions.NotFoundIdDataSet;
import com.example.models.DatasetInfo;
import com.example.models.Version;
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
    public void getReleaseAndVersionTest() throws IOException {
        String category = "Велодорожки";
        VersionAndRelease expected=new VersionAndRelease();
        VersionAndRelease data;
        expected.setReleaseNumber(2);
        expected.setVersionNumber(3);
        try {

            DataSetsRequests service = BaseService.getRetrofit().create(DataSetsRequests.class);
            long id = DataSetsService.getIdDataSetOnName(category);
            logger.debug(String.format("idDataSet:", id));
            Call<VersionAndRelease> call =  service.getVersionAndRelease(id);
            data = call.execute().body();
            logger.debug("Реальность:"+"Версия: "+data.getVersionNumber()+" Релиз: "+" "+data.getReleaseNumber());
            logger.debug("Ожидание:"+"Версия: "+expected.getVersionNumber()+" Релиз: "+" "+expected.getReleaseNumber());


            Assert.assertEquals(data.getVersionNumber(), expected.getVersionNumber());
            Assert.assertEquals(data.getReleaseNumber(), expected.getReleaseNumber());

        } catch (NotFoundIdDataSet e) {
            logger.error(e);
            Assert.assertTrue(false);
        }


    }



}
