
package com.example.tests;

import com.example.Exceptions.NotFoundIdDataSet;
import com.example.models.DatasetInfo;
import com.example.services.BaseService;
import com.example.services.DataSetsRequests;
import com.example.services.DataSetsService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.FileNotFoundException;
import java.io.IOException;


public class DatasetsTest {
    private final static Logger logger = Logger.getLogger(DatasetsTest.class);
    @Test
    public void getDataSetInfoTest() throws IOException {
        int expectedItemsCount=51;
        String category = "Физическая культура и спорт"; //пам
        String dataSetName = "Велодорожки";

        logger.debug(String.format("Category: ", category));
        logger.debug(String.format("dataSetName:", dataSetName));

        try {

            DataSetsRequests service = BaseService.getRetrofit().create(DataSetsRequests.class);

            long id = DataSetsService.getIdDataSetOnName(dataSetName);

            logger.debug(String.format("idDataSet:", id));

            Call<DatasetInfo> call =  service.getDataSetInfo(id);

            logger.debug(call);

            DatasetInfo datasetInfo = call.execute().body();
            logger.debug(datasetInfo.toString());
            logger.debug(expectedItemsCount);


            Assert.assertEquals(datasetInfo.getItemsCount(), expectedItemsCount);

        } catch (IllegalArgumentException e) {
            logger.error(e);
        } catch (NotFoundIdDataSet e) {
            logger.error(e);
            Assert.assertTrue(false);
        }

    }
}
