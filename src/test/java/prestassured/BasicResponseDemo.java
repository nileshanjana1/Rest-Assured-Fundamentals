package prestassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

public class BasicResponseDemo {

    static final String BASE_URL = "https://api.github.com";

    @Test
    void convenienceMethods(){
        Response response = RestAssured.get(BASE_URL);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");


    }

    @Test
    void genericHeaders(){
        Response response = RestAssured.get(BASE_URL);
        Assert.assertEquals(response.getHeader("server"), "GitHub.com");
        Assert.assertEquals(response.getHeader("x-ratelimit-limit"), "60");


    }

    @Test
    void basicValidationExample(){
        RestAssured.get(BASE_URL)
                        .then()
                                .statusCode(200)
                                        .contentType(ContentType.JSON)
                                                .header("x-ratelimit-limit", "60");
    }

    @Test
    void simpleHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .statusCode(lessThan(300))
                .header("cache-control", containsStringIgnoringCase("max-age=60"))
                .time(lessThan(2L), TimeUnit.SECONDS)
                .header("etag", notNullValue())
                .header("etag", not(emptyString()));
    }
}
