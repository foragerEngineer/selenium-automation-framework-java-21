package tests.apitests;

import apiTestConfig.endpoints.VideoGameEndpoints;
import apiTestConfig.objects.VideoGame;
import automationframework.basetests.BaseVideoGameApiTest;
import io.qameta.allure.Description;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class VideoGameTests extends BaseVideoGameApiTest {

    // Swagger reference: https://www.videogamedb.uk/swagger-ui/index.html

    @Test
    public void getAllGamesTest() {
        given()
                .when()
                .get(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    @Description("GET request to retrieve a single game by ID")
    public void createNewGameByJSONTest() {
        String gameBodyJson = "{\n" +
                "  \"category\": \"Platform\",\n" +
                "  \"name\": \"Mario\",\n" +
                "  \"rating\": \"Mature\",\n" +
                "  \"releaseDate\": \"2025-05-04\",\n" +
                "  \"reviewScore\": 89\n" +
                "}";

        given()
                .body(gameBodyJson)
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    @Description("POST request to create a new game using XML")
    public void createNewGameByXML() {
        String gameBodyXml = "<VideoGameRequest>\n" +
                "\t<category>Platform</category>\n" +
                "\t<name>Mario</name>\n" +
                "\t<rating>Mature</rating>\n" +
                "\t<releaseDate>2012-05-04</releaseDate>\n" +
                "\t<reviewScore>85</reviewScore>\n" +
                "</VideoGameRequest>";

        given()
                .body(gameBodyXml)
                .contentType("application/xml")
                .accept("application/xml")
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    @Description("PUT request to update a game")
    public void updateGameTest() {
        String gameUpdateJson = "{\n" +
                "  \"category\": \"Platform\",\n" +
                "  \"name\": \"Mario\",\n" +
                "  \"rating\": \"Mature\",\n" +
                "  \"releaseDate\": \"2012-05-04\",\n" +
                "  \"reviewScore\": 85\n" +
                "}";

        given()
                .body(gameUpdateJson)
                .when()
                .put("videogame/3")
                .then();
    }

    @Test
    @Description("DELETE request to remove a game by ID")
    public void deleteGameByIdTest() {
        given()
                .accept("text/plain")
                .when()
                .delete("videogame/8")
                .then();
    }

    @Test
    @Description("Path params")
    public void getSingleGameByIdTest() {
        given()
                .pathParam("videoGameId", 5)
                .when()
                .get(VideoGameEndpoints.SINGLE_VIDEO_GAME)
                .then();
    }

    @Test
    @Description("Serialization of a VideoGame object to JSON")
    public void serializationByJSONTest() {
        VideoGame videoGame = new VideoGame("Shooter", "Wicked Spoons", "Mature", "2025-10-01", 95);

        given()
                .body(videoGame)
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    @Description("Validating Serialization of a VideoGame object to XML")
    public void videoGameSchemaXMLTest() {
        given()
                .pathParam("videoGameId", 5)
                .accept("application/xml")
                .when()
                .get(VideoGameEndpoints.SINGLE_VIDEO_GAME)
                .then()
                .body(RestAssuredMatchers.matchesXsdInClasspath("VideoGameXSD.xsd"));
    }

    @Test
    @Description("Validate JSON schema of a VideoGame object")
    public void videoGameJsonSchemaTest() {
        given()
                .pathParam("videoGameId", 5)
                .accept("application/json")
                .when()
                .get(VideoGameEndpoints.SINGLE_VIDEO_GAME)
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("VideoGameJsonSchema.json"));
    }

    @Test
    @Description("Validate convertion of JSON response to POJO")
    public void validateConvertionOfJsonToPojoTest() {
        Response response =
                given()
                        .pathParam("videoGameId", 5)
                        .when()
                        .get(VideoGameEndpoints.SINGLE_VIDEO_GAME);

        VideoGame videoGame = response.getBody().as(VideoGame.class);
        System.out.println(videoGame.toString());
    }

    @Test
    @Description("Capture response time of a GET request")
    public void captureResponseTimeTest() {
        long responseTime = get(VideoGameEndpoints.ALL_VIDEO_GAMES).time();
        System.out.println("Response time: " + responseTime);
    }

    @Test
    @Description("Assert response time is less than 1000 milliseconds")
    public void assertOnResponseTime() {
        get(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then().time(lessThan(4000L));
    }

}
