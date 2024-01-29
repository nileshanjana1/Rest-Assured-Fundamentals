package prestassured.framework.badendpoint;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static prestassured.framework.ResponseSpecs.badEndpointSpec;

public class BadEndpointTest {
    static final String BAD_URL = "https://api.github.com/non/existing/url";

    @Test
    void testWithSpecOne() {

        RestAssured.get(BAD_URL)
                .then()
                .spec(badEndpointSpec())
                .body("message", equalTo("Not Found"));
    }

    @Test
    void testWithSpecTwo() {

        RestAssured.get(BAD_URL)
                .then()
                .spec(badEndpointSpec())
                .body("documentation_url", equalTo("https://docs.github.com/rest"));
    }
}
