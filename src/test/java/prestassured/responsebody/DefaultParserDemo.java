package prestassured.responsebody;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static prestassured.responsebody.ValidatableResponseRepeatingItemsDemo.USERS_EP;

public class DefaultParserDemo {
    static final String BASE_URL = "https://api.github.com/";

    @Test
    public void parseAndSyntacticSugar(){
        RestAssured
                .get(BASE_URL)
                .then()
                .using()
                .defaultParser(Parser.JSON)
                .body("current_user_url", equalTo(BASE_URL + "user"));
    }
}
