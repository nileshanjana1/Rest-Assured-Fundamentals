package prestassured.params;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

public class PathParamsDemo {
    static final String REPO_EP = "https://api.github.com/repos";
    static final String BASE_URL = "https://api.github.com/search/repositories";


    @Test
    void withoutParamHardcoded(){
        RestAssured.get(REPO_EP +"/andrejs-ps/automated-web-testing-in-java-with-playwright/")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(412446871));

        RestAssured.get(REPO_EP +"/andrejs-ps/Getting-Started-With-TestNG/")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(227642020));
    }

    @Test
    void withOverloadedGet(){
        RestAssured
                .get("https://api.github.com/repos/{user}/{repo}", "andrejs-ps", "/andrejs-ps/automated-web-testing-in-java-with-playwright/")
                .then()
                .statusCode(200);
                //.body("id", equalTo(412446871));
    }

    @Test
    void withoutParam(){
        RestAssured
                .get(BASE_URL + "?q=java")
                .prettyPeek()
                .then()
                .statusCode(200);
    }
    @Test
    void withoutParam2(){
        RestAssured
                .get(BASE_URL + "?q=java&per_page=1")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void withParam(){
        RestAssured
                .given()
                .pathParam("user", "andrejs-ps")
                .pathParam("repo", "/automated-web-testing-in-java-with-playwright/")
                .get(REPO_EP + "/{user}/{repo}")
                .then()
                .statusCode(200);
                //.body("id" , equalTo(412446871));
    }

    @Test
    void withParamAsMap(){
        Map<String, String> reusableMap = Map.of("user", "andrejs-ps", "repo", "/automated-web-testing-in-java-with-playwright/");
        RestAssured
                .given()
                .pathParams(reusableMap)
                .get(REPO_EP + "/{user}/{repo}")
                .then()
                .statusCode(200);
                //.body("id", equalTo(412446871));
    }

    @Test
    void withQueryParamAsMap(){
        Map<String, String> reusableMap = Map.of("q", "java", "per_page", "1");
        RestAssured
                .given()
                .queryParams(reusableMap)
                .get(BASE_URL)
                .then()
                .statusCode(200);
        //.body("id", equalTo(412446871));
    }
}
