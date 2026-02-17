package dataproviders;

import com.api.base.BaseTest;
import org.testng.annotations.DataProvider;

public class APIKeyDataProviders extends BaseTest {

    @DataProvider(name = "invalidAccessKey")
    public Object[][] invalidKeys() {
        return new Object[][]{
                { new APIKeyRequest.Builder().apiKey("").build() },         // empty key
                { new APIKeyRequest.Builder().apiKey("WRONG_KEY").build() },// incorrect key
                { new APIKeyRequest.Builder().apiKey("123").build() },      // too short
                { new APIKeyRequest.Builder().apiKey("@@@@@").build() }     // invalid format
        };
    }
}
