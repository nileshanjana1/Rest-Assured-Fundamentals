package prestassured.responsebody;

import groovy.json.JsonOutput;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class BasicResponseBodyDemo {
    static final String LIMIT_EP = "https://api.github.com/rate_limit";
    @Test
    public void jsonPathReturnsMap(){
        Response response = RestAssured.get(LIMIT_EP);
        ResponseBody<?> body = response.body();
        JsonPath jpath = body.jsonPath();

        JsonPath jpath2 = response.body().jsonPath();

        Map<String, String> fullJson = jpath2.get();
        Map<String, String> subMap = jpath2.get("resources");
        Map<String, String> subMap2 = jpath2.get("resources.core");

        int value = jpath2.get("resources.core.limit");
        int value2 = jpath2.get("resources.graphql.remaining");

        System.out.println("Full Json: " +fullJson);
        System.out.println("Sub Map: " +subMap);
        System.out.println("Sub Map2: " +subMap2);
        System.out.println("Value: " +value);
        System.out.println("Value2: " +value2);

        assertEquals(value, 60);
        assertEquals(value2, 0);
    }
}
