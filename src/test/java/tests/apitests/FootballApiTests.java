package tests.apitests;

import automationframework.basetests.BaseFootballApiTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FootballApiTests extends BaseFootballApiTest {

    @Test
    @Description("Query Parameter to get one areas")
    public void getDetailsOfOneAreaTest() {
        given()
                .queryParam("areas", 2076)
                .when()
                .get("/areas")
                .then();
    }

    @Test
    @Description("Query Parameter to get details of multiple areas")
    public void getDetailsOfMultipleAreasTest() {
        given()
                .urlEncodingEnabled(true) // not needed, but just to show
                .queryParam("areas", 2076)
                .when()
                .get("/areas")
                .then();
    }

    @Test
    @Description("Assert the body of a HTTP response")
    public void getDataFoundedTest() {
        given()
                .when()
                .get("teams/57")
                .then()
                .body("founded", equalTo(1886)); // looking for founded field in the response body
    }

    @Test
    @Description("Assert the first team name in the response body")
    public void getFirstTeamNameTest() {
        given()
                .when()
                .get("competitions/2021/teams")
                .then()
                .body("teams.name[0]", equalTo("Arsenal FC")); // looking for the first team name in the response body
    }

    @Test
    @Description("Extracting values from the response body")
    public void getAllTeamDataFromResponseTest() {
        String responseBody = get("teams/57").asString(); // extracting the entire response body as a String
        System.out.println(responseBody);
    }

    @Test
    @Description("Extract all team data, checking the content type is JSON")
    public void getAllTeamData_WithCheckFirstTest() {
        Response response =
                given()
                        .when()
                        .get("teams/57")
                        .then()
                        .contentType(ContentType.JSON) // checking content type is JSON
                        .extract().response(); // extracting the response

        String jsonResponse = response.asString(); // converting the response to a String
        System.out.println("Response Body: " + jsonResponse);
    }

    @Test
    @Description("Extract multiple headers from the response")
    public void extractHeadersTest() {
        Response response = get("teams/57")
                .then()
                .extract().response();

        String contentType = response.getHeader("Content-Type");
        System.out.println("Content-Type: " + contentType);

        String header = response.getHeader("Content-Type");
        System.out.println("Header Content-Type: " + header);

        String apiVersionHeader = response.getHeader("X-API-VERSION");
        System.out.println("API Version Header: " + apiVersionHeader);
    }

    @Test
    @Description("Extract explicit data from the response body")
    public void extractFirstTeamNamesTest() {
        String firstTeamName = get("competitions/2021/teams").jsonPath().getString("teams.name[0]");
        System.out.println(firstTeamName);
    }

    @Test
    @Description("Extract all team names from the response body")
    public void extractAllTeamNamesTest() {
        Response response =
                get("competitions/2021/teams")
                        .then()
                        .extract().response();

        List<String> teamNames = response.path("teams.name");

        for (String teamName : teamNames) {
            System.out.println(teamName);
        }
    }

}
