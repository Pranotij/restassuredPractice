package com.api.helper;

import com.api.endPoints.LocationEndpoints;
import com.api.pojo.Invalid.InvalidRoot;
import com.api.pojo.forecastData.ForeCastDataRoot;
import io.restassured.response.Response;
import com.api.utils.HelperUtil;

public class ForecastLocationHelper implements LocationEndpoints {

    HelperUtil helperUtil = new HelperUtil();

    public ForeCastDataRoot getForecastData (String city,String days,String apiKey,int statusCode )
    {

        String endpoint = String.format(FORECAST_DATA,city,days,apiKey);
        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        ForeCastDataRoot foreCastDataRoot =
                response.as(ForeCastDataRoot.class);
        return  foreCastDataRoot;
    }

    public InvalidRoot getInvalidForecastData (String city, String days, String apiKey, int statusCode )
    {

        String endpoint = String.format(FORECAST_DATA,city,days,apiKey);
        Response response= helperUtil.curlCallCreationGet(endpoint,statusCode);
        InvalidRoot invalidRoot =
                response.as(InvalidRoot.class);
        return  invalidRoot;
    }
}
