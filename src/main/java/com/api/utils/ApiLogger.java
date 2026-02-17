package utils;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiLogger {

    private static final Logger log =
            LoggerFactory.getLogger(ApiLogger.class);

    private ApiLogger() {
    }

    public static void logResponse(Response response) {

        if (response == null) {
            log.error("Response is NULL");
            return;
        }

        log.info("=========== API RESPONSE ===========");
        log.info("Status Code: {}", response.getStatusCode());
        log.info("Status Line: {}", response.getStatusLine());
        log.info("Headers: {}", response.getHeaders());
        log.info("Body:\n{}", response.asPrettyString());
        log.info("====================================");
    }

    public static void logInfo(String message) {
        log.info(message);
    }

    public static void logError(String message) {
        log.error(message);
    }
}
