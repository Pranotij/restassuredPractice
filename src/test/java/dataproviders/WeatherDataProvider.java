package dataproviders;

import org.testng.annotations.DataProvider;

public class WeatherDataProvider {

    @DataProvider(name = "invalidSingleCity")
    public Object[][] invalidSingleCity() {
        return new Object[][]{
                { new WeatherRequest.Builder().city("").build() },          // empty city
                { new WeatherRequest.Builder().city("   ").build() },       // blank spaces
                { new WeatherRequest.Builder().city("InvalidCity123").build() },
                { new WeatherRequest.Builder().city("12345").build() }
        };
    }

    @DataProvider(name = "validSingleCity")
    public Object[][] validSingleCity() {
        return new Object[][]{
                { new WeatherRequest.Builder().city("New Delhi").build() },
                { new WeatherRequest.Builder().city("Mumbai").build() }
        };
    }

    @DataProvider(name = "validMultiCity")
    public Object[][] validMultiCity() {
        return new Object[][]{
                { new WeatherRequest.Builder().multiCity("Goa;Mumbai;Pune").build() }
        };
    }

    @DataProvider(name = "invalidMultiCity")
    public Object[][] invalidMultiCity() {
        return new Object[][]{
                { new WeatherRequest.Builder().multiCity("Singapore;Shanghai").build() },
                { new WeatherRequest.Builder().multiCity("@@@;###;$$$").build() },
                { new WeatherRequest.Builder().multiCity("123;456;789").build() },
                { new WeatherRequest.Builder().multiCity("InvalidCity;FakeTown;Nowhere").build() }
        };
    }

    @DataProvider(name = "validLatLong")
    public Object[][] validLatLong() {
        return new Object[][]{
                { new WeatherRequest.Builder().latLong("28.6139,77.2090").build() }
        };
    }

    @DataProvider(name = "invalidLatLong")
    public Object[][] invalidLatLong() {
        return new Object[][]{
                { new WeatherRequest.Builder().latLong("200,300").build() },
                { new WeatherRequest.Builder().latLong("@@@,###").build() }
        };
    }

    @DataProvider(name = "validForecastData")
    public Object[][] validForecastData() {
        return new Object[][]{
                { new WeatherRequest.Builder().city("Mumbai").days("7").build() }
        };
    }

    @DataProvider(name = "invalidForecastData")
    public Object[][] invalidForecastData() {
        return new Object[][]{
                { new WeatherRequest.Builder().city("London").days("-1").build() },
                { new WeatherRequest.Builder().city("Tokyo").days("0").build() },
                { new WeatherRequest.Builder().city("Mumbai").days("abc").build() }
        };
    }
}
