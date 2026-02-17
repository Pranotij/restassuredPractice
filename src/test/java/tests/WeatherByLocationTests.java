package tests;

import com.api.helper.CurrentLocationHelper;
import com.api.base.BaseTest;
import com.api.helper.ForecastLocationHelper;
import com.api.pojo.Invalid.InvalidRoot;
import com.api.pojo.currentLocation.Valid.CurrentLocationRoot;
import com.api.pojo.forecastData.ForeCastDataRoot;

import com.api.pojo.latLongg.Valid.LatLongRoot;
import com.api.pojo.multipleCities.Valid.MultipleCitiesRoot;
import dataproviders.APIKeyDataProviders;
import dataproviders.APIKeyRequest;
import dataproviders.WeatherDataProvider;
import dataproviders.WeatherRequest;
import org.testng.annotations.Test;
import validators.LocationValidator;

public class WeatherByLocationTests extends BaseTest {


    @Test(dataProvider = "validSingleCity", dataProviderClass = WeatherDataProvider.class)
    public void getValidWeatherByCurrentLocation(WeatherRequest request) {
        CurrentLocationRoot currentLocationResponse = new CurrentLocationHelper().getbyCurrentLocationValid(request.getCity(), apiKey, 200);
        LocationValidator.currentValidLocatonValidator(currentLocationResponse,request.getCity());
    }


    @Test(dataProvider = "invalidSingleCity", dataProviderClass = WeatherDataProvider.class)
    public void getInvalidWeatherByCurrentLocation(WeatherRequest request) {
        InvalidRoot invalidCurrentLocationResponse = new CurrentLocationHelper().getbyCurrentLocationInvalid(request.getCity(), apiKey, 400);
        LocationValidator.inValidResponse(invalidCurrentLocationResponse);
    }

    @Test(dataProvider = "validMultiCity", dataProviderClass = WeatherDataProvider.class)
    public void getValidWeatherByMultipleLocation(WeatherRequest request) {
         MultipleCitiesRoot multipleLocationsResponse = new CurrentLocationHelper().getbyMultiplelocation(request.getMultiCity(),apiKey, 200);

    }

    @Test(dataProvider = "invalidMultiCity", dataProviderClass = WeatherDataProvider.class)
    public void getInvalidWeatherByMultipleLocation(WeatherRequest request) {
        InvalidRoot  invalidMultipleLocationsResponse = new CurrentLocationHelper().getbyInvalidMultiplelocation(request.getMultiCity(), apiKey, 200);
        LocationValidator.inValidResponse(invalidMultipleLocationsResponse);
    }

    @Test(dataProvider = "validLatLong", dataProviderClass = WeatherDataProvider.class)
    public void getValidWeatherByLatLongLocation(WeatherRequest request) {

        LatLongRoot cordinatesResponse = new CurrentLocationHelper().getbyValidLocationCordinates(request.getLatLong(), apiKey, 200);
        LocationValidator.validLatLong(cordinatesResponse);
    }

    @Test(dataProvider = "invalidLatLong", dataProviderClass = WeatherDataProvider.class)
    public void getInvalidWeatherByLatLongLocation(WeatherRequest request) {

        InvalidRoot invalidCordinatesResponse = new CurrentLocationHelper().getbyInValidLocationCordinates(request.getLatLong(), apiKey, 400);
        LocationValidator.inValidResponse(invalidCordinatesResponse);

    }

    @Test(dataProvider = "validForecastData", dataProviderClass = WeatherDataProvider.class)
    public void getValidForecast(WeatherRequest request) {
        ForeCastDataRoot forecastDataResponse = new ForecastLocationHelper().getForecastData(request.getCity(), request.getDays(), apiKey, 200);
        LocationValidator.validForecast(forecastDataResponse,request.getCity(), request.getDays());

    }

    @Test(dataProvider = "invalidForecastData", dataProviderClass = WeatherDataProvider.class)
    public void getInvalidForecast(WeatherRequest request)  {
        InvalidRoot forecastDataResponse = new ForecastLocationHelper().getInvalidForecastData(request.getCity(), request.getDays(), apiKey, 400);
        LocationValidator.inValidForecast(forecastDataResponse);
    }

// ---------------------Invalid API Keys--------------------------------------------------

    @Test(dataProvider = "invalidAccessKey", dataProviderClass = APIKeyDataProviders.class)
    public void getInvalidKey(APIKeyRequest request) {
        InvalidRoot currentLocationResponse = new CurrentLocationHelper().getbyCurrentLocationInvalid("Pune", request.getApiKey(), 200);
        LocationValidator.inValidAPIKey(currentLocationResponse);
        InvalidRoot forecastDataResponse = new ForecastLocationHelper().getInvalidForecastData("Mumbai", "7", request.getApiKey(), 200);
        LocationValidator.inValidAPIKey(forecastDataResponse);
        InvalidRoot cordinatesResponse = new CurrentLocationHelper().getbyInValidLocationCordinates( "28.6139,77.2090", request.getApiKey(), 200);
        LocationValidator.inValidAPIKey(cordinatesResponse);
        InvalidRoot multipleLocationsResponse = new CurrentLocationHelper().getbyInvalidMultiplelocation("Mumbai;Delhi;Goa",request.getApiKey(), 200);
        LocationValidator.inValidAPIKey(multipleLocationsResponse);

    }


}


