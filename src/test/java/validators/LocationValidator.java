package validators;

import com.api.pojo.Invalid.InvalidRoot;
import com.api.pojo.currentLocation.Valid.CurrentLocationRoot;
import com.api.pojo.forecastData.ForeCastDataRoot;
import com.api.pojo.latLongg.Valid.LatLongRoot;
import org.testng.Assert;

public class LocationValidator {

    public static  void currentValidLocatonValidator(CurrentLocationRoot response,String city)
    {
        Assert.assertEquals(city,response.location.name);
        Assert.assertEquals("City",response.request.type);
        Assert.assertNotNull(response.current);
        Assert.assertNotNull(response.request);
    }
    public static void validLatLong(LatLongRoot response)
    {
        Assert.assertEquals("New Delhi",response.location.name);
        Assert.assertNotNull(response.current);
        Assert.assertNotNull(response.request);
        Assert.assertNotNull(response.current.air_quality);
        Assert.assertNotNull(response.current.astro);

    }
    public static void validForecast(ForeCastDataRoot response,String city, String day)
    {
        Integer responseday= response.forecast.toString().length();
        Assert.assertEquals(city,response.location.name);
        Assert.assertEquals(Integer.parseInt(day), responseday);
        Assert.assertNotNull(response.current);
        Assert.assertNotNull(response.request);

    }
    public static void inValidResponse(InvalidRoot response)
    {
        Assert.assertEquals(false,response.success);
        Assert.assertEquals(615,response.error.code);
        Assert.assertEquals("request_failed",response.error.type);
        Assert.assertEquals("Your API request failed. Please try again or contact support.",response.error.info.toString());


    }
    public static void inValidForecast(InvalidRoot response)
    {
        Assert.assertEquals(false,response.success);
        Assert.assertEquals(608,response.error.code);
        Assert.assertEquals("invalid_forecast_days",response.error.type);
        Assert.assertEquals("You have specified an invalid forecast days value. [Maximum: \\\"7\\\" or \\\"14\\\" depending on your subscription plan]",response.error.info.toString());


    }
    public static void inValidAPIKey(InvalidRoot response)
    {
        Assert.assertEquals(false,response.success);
        Assert.assertEquals(101,response.error.code);
        Assert.assertEquals("missing_access_key",response.error.type);
        Assert.assertEquals("You have not supplied an API Access Key. [Required format: access_key=YOUR_ACCESS_KEY]",response.error.info.toString());


    }
}
