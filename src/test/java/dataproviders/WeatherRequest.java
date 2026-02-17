package dataproviders;

public class WeatherRequest {
    private final String city;
    private final String multiCity;
    private final String latLong;
    private final String days;

    private WeatherRequest(Builder builder) {
        this.city = builder.city;
        this.multiCity = builder.multiCity;
        this.latLong = builder.latLong;
        this.days = builder.days;
    }

    public String getCity() {
        return city;
    }

    public String getMultiCity() {
        return multiCity;
    }

    public String getLatLong() {
        return latLong;
    }

    public String getDays() {
        return days;
    }

    public static class Builder {
        private String city;
        private String multiCity;
        private String latLong;
        private String days;

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder multiCity(String multiCity) {
            this.multiCity = multiCity;
            return this;
        }

        public Builder latLong(String latLong) {
            this.latLong = latLong;
            return this;
        }

        public Builder days(String days) {
            this.days = days;
            return this;
        }

        public WeatherRequest build() {
            return new WeatherRequest(this);
        }
    }
}
