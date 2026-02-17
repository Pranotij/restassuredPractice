package dataproviders;

public class APIKeyRequest {
    private final String apiKey;

    private APIKeyRequest(Builder builder) {
        this.apiKey = builder.apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static class Builder {
        private String apiKey;

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public APIKeyRequest build() {
            return new APIKeyRequest(this);
        }
    }
}
