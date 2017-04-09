package com.example.tests;

import com.example.Exceptions.NotFoundVersionNumber;
import com.example.models.Version;
import com.example.services.BaseService;
import com.example.services.DataSetsRequests;
import com.example.services.DataSetsService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class DatasetsTest2 {
    private final static Logger logger = Logger.getLogger(DatasetsTest2.class);
    @Test
    public void versionTest() throws NotFoundVersionNumber,Exception {


        try {
            DataSetsRequests service = BaseService.getRetrofit2().create(DataSetsRequests.class);

            Call<Version> response = service.getVersion();

            Version data = response.execute().body();

            if (data == null) throw new NotFoundVersionNumber();

            assertEquals("1", data.getVersion());
            logger.debug(data.toString());

        }  catch (NotFoundVersionNumber e) {
            logger.error(e.toString());
            throw new Exception(e.toString());
        }

    }

}
