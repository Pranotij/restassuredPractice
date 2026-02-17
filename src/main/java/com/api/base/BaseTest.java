package com.api.base ;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import com.api.utils.ConfigReader;

import static utils.ApiLogger.logInfo;

public class BaseTest {


    protected String apiKey;

   @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
       apiKey = ConfigReader.getApiKey();
    }

    protected void logResponse(Response response) {
        utils.ApiLogger.logResponse(response);
    }
}


