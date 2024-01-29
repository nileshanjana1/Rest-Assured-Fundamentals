package prestassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DemoTest {

    static final String BASE_URL = "https://api.github.com";

    @Test
    void someTest(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200);

    }

    @Test
    void peek(){
        RestAssured.get(BASE_URL)
                .peek()
                .then()
                .statusCode(200);

    }

    @Test
    void prettyPeek(){
        RestAssured.get(BASE_URL)
                .prettyPeek()
                .then()
                .statusCode(200);

    }

    @Test
    void print(){
        RestAssured.get(BASE_URL)
                .print();

    }

    @Test
    void prettyPrint(){
        RestAssured.get(BASE_URL)
                .prettyPrint();

    }
}
