package tests.apitests;

import apiTestConfig.endpoints.VideoGameEndpoints;
import automationframework.basetests.BaseVideoGameApiTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ApiTests extends BaseVideoGameApiTest {

    @Test
    public void firstTest() {
        given()
                .log().all()
                .when()
                .get("/videogame")
                .then()
                .log().all();
    }

    @Test
    public void videoGameEndpointTest() {
        get(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then().log().all();
    }

}
