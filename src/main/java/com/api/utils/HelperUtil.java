package com.api.utils;

import com.api.basicValidator.BasicValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static utils.ApiLogger.logResponse;

public class HelperUtil {

    protected BasicValidator validators = new BasicValidator();

    public  Response curlCallCreationGet(String endpoint, int statusCode)
    {
        Response response =
                given()
                        .header("Accept", "application/json")
                        .when()
                        .get(endpoint)
                        .then()
                        .extract()
                        .response();
        logResponse(response);
        validators.statusCode(response,statusCode);
        validators.bodyNotEmpty(response);
        return  response;

    }

}
