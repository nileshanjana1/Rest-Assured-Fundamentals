package prestassured.responsebody;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ValidatableResponseBodyDemo {
    static final String BASE_URL = "https://api.github.com/";

    @Test
    public void matcherExample(){
        RestAssured
                .get(BASE_URL)
                .then()
                .body("current_user_url", equalTo(BASE_URL + "user"))
                .body(containsString("feeds_url"));
    }
}
