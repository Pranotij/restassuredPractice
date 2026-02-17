package com.api.endPoints;

public interface LocationEndpoints {

    String GET_WEATHER = "/current?query=%s&access_key=%s";

    String FORECAST_DATA= "/forecast?query=%s&forecast_days=%s&access_key=%s";
}
