package prestassured.crud;

import io.restassured.RestAssured;
import org.hamcrest.Description;
import org.testng.annotations.Test;

public class OtherMethodsDemo {
    static final String REPOS_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";

    @Test(description = "Create a Repo")
    void postTest(){
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                //.header("Authorization", "token " + TOKEN)
                .body("{\"name\": \"deleteme\"}")
                .when()
                .post(REPOS_EP)
                .then()
                .statusCode(201);
    }

    @Test(description = "Update a Repo")
    void patchTest(){
        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                .body("{\"name\": \"deleteme-patched\"}")
                .when()
                .patch("https://api.github.com/repos/nileshanjana1/deleteme")
                .then()
                .statusCode(200);
    }

    @Test(description = "Delete a Repo")
    void deleteTest(){
        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                .when()
                .delete("https://api.github.com/repos/nileshanjana1/deleteme-patched")
                .then()
                .statusCode(204);
    }
}
