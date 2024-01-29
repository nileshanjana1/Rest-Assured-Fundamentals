package prestassured.responsebody;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class ValidatableNestedBodyDemo {
    static final String RATE_EP = "https://api.github.com/rate_limit";

    @Test
    public void nestedBodyValidation(){
        RestAssured
                .get(RATE_EP)
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60))
                    .body("remaining", lessThanOrEqualTo(60))
                    .body("reset",notNullValue())
                .rootPath("resources.search")
                    .body("limit", equalTo(10))
                    .body("remaining", lessThanOrEqualTo(10))
                    .body("reset",notNullValue())
                .noRootPath()
                    .body("resources.graphql.limit", equalTo(0));
    }
}
