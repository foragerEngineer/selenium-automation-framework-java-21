package tests.apitests;

import automationframework.basetests.BaseVideoGameApiTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class GpathJSONTests extends BaseVideoGameApiTest {

    @Test
    @Description("Extract a single element from JSON using Gpath")
    public void extractMapOfElementsWithFindTest() {
        Response response = get("competitions/2021/teams");

        // Extracting data into a map using Gpath
        Map<String, ?> allTeamDataForSingleTeam = response.path("teams.find { it.name == 'Manchester United FC' }");
        System.out.println("All team data: " + allTeamDataForSingleTeam);
    }

    @Test
    @Description("Extract a single value from JSON using Gpath")
    public void extractSingleValueWithFindTest() {
        Response response = get("teams/57");
        String certainPlayer = response.path("squad.find { it.id == 7784}.name");
        System.out.println("Player name: " + certainPlayer);
    }

    @Test
    @Description("Extract a list of values from JSON using Gpath")
    public void extractListOfValuesWithFindAllTest() {
        Response response = get("teams/57");
        List<String> playerNames = response.path("squad.findAll { it.id >= 7784 }.name");
        System.out.println("Player names: " + playerNames);
    }

    @Test
    @Description("Extracts value with highest number")
    public void extractSingleValueWithHighestNumberTest() {
        Response response = get("teams/57");
        String playerName = response.path("squad.max { it.id }.name");
        System.out.println("Player with highest ID: " + playerName);
    }

    @Test
    @Description()
    public void extractMultipleValuesAndSumTest() {
        Response response = get("teams/57");
        int sumOfIds = response.path("squad.collect { it.id }.sum()");
        System.out.println("Sum of player IDs: " + sumOfIds);
    }

    @Test
    @Description("Extracts a map with find and findAll methods")
    public void extractMapWithFindAndFindAllTest() {
        String position = "Offense";
        String nationality = "England";

        Response response = get("teams/57");

        Map<String, ?> playerOfCertainPosition = response.path(
                "squad.findAll { it.position == '%s'}.find { it.nationality == '%s'}",
                position, nationality
        );
        System.out.println("Details of player: " + playerOfCertainPosition);
    }

    @Test
    @Description("Extracts a map with find and findAll methods")
    public void extractMultiplePlayersTest() {
        String position = "Offense";
        String nationality = "England";

        Response response = get("teams/57");

        ArrayList<Map<String, ?>> allPlayerOfCertainPositiion = response.path(
                "squad.findAll { it.position == '%s'}.find { it.nationality == '%s'}",
                position, nationality
        );
        System.out.println("Details of player: " + allPlayerOfCertainPositiion);
    }

}
