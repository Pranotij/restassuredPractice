package com.api.helper;

import com.api.endPoints.LocationEndpoints;
import com.api.pojo.Invalid.InvalidRoot;
import com.api.pojo.currentLocation.Valid.CurrentLocationRoot;
import com.api.pojo.latLongg.Valid.LatLongRoot;
import com.api.pojo.multipleCities.Valid.MultipleCitiesRoot;

import io.restassured.response.Response;
import com.api.utils.HelperUtil;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static utils.ApiLogger.logInfo;


public class CurrentLocationHelper  implements LocationEndpoints {
    HelperUtil helperUtil = new HelperUtil();


    public CurrentLocationRoot getbyCurrentLocationValid(String value, String apiKey, int statusCode)
    {

        String endpoint = String.format(GET_WEATHER,
                URLEncoder.encode(value, StandardCharsets.UTF_8),apiKey);
        logInfo("MyEnpoint Keyis: "+ endpoint);

        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        CurrentLocationRoot currentLocationRoot =
                response.as(CurrentLocationRoot.class);
         return  currentLocationRoot;
    }

    public InvalidRoot getbyCurrentLocationInvalid(String value, String apiKey, int statusCode)
    {

        String endpoint = String.format(GET_WEATHER,
                URLEncoder.encode(value, StandardCharsets.UTF_8),apiKey);

        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        InvalidRoot currentInvalidRoot =
                response.as(InvalidRoot.class);
        return  currentInvalidRoot;
    }

    public MultipleCitiesRoot getbyMultiplelocation(String city, String apiKey, int statusCode)
    {
        String endpoint = String.format(GET_WEATHER,city,
                apiKey);
        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        MultipleCitiesRoot multipleCitiesRoot  = response.as(MultipleCitiesRoot.class);

        return  multipleCitiesRoot;
    }
    public InvalidRoot getbyInvalidMultiplelocation(String city, String apiKey, int statusCode)
    {
        String endpoint = String.format(GET_WEATHER,city,
                apiKey);
        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        InvalidRoot invalidRoot  = response.as(InvalidRoot.class);

        return  invalidRoot;
    }

    public LatLongRoot getbyValidLocationCordinates(String cordinates, String apiKey, int statusCode)
    {
        String endpoint = String.format(GET_WEATHER,
                cordinates ,apiKey);

        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        LatLongRoot latLongRoot = response.as(LatLongRoot.class);

        return  latLongRoot;

    }

    public InvalidRoot getbyInValidLocationCordinates(String cordinates, String apiKey, int statusCode)
    {
        String endpoint = String.format(GET_WEATHER,
                cordinates ,apiKey);

        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        InvalidRoot latLongRoot = response.as(InvalidRoot.class);

        return  latLongRoot;

    }
}
