package com.api.basicValidator;


import io.restassured.response.Response;
import org.testng.Assert;


public class BasicValidator {

    public void statusCode(Response response, int code) {
        Assert.assertEquals(response.statusCode(), code, "Expected Code: " + code + "Actual Code: " + response.statusCode());
    }

    public void bodyNotEmpty(Response response) {
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getBody().asString().trim().length() > 0,
                "Response body is empty");
    }
}




