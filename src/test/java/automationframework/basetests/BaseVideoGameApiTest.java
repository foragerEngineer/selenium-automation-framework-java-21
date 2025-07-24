package automationframework.basetests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class BaseVideoGameApiTest {

    @BeforeClass
    public static void setup() {
        /**
         * Request specification usage example
         * Actions to INCLUDE in every HTTP request:
         * headers, cookies, form parameters, query parameters, authentication, etc.
         */
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://videogamedb.uk/")
                .setBasePath("api/v2/")
                .setContentType("application/json")
                .addHeader("Accept", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        /**
         * Response specification usage example
         * Actions to TAKE AFTER every HTTP request:
         * Check status code, check response time, check headers, etc.
         */
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(3000L)) // Response time should be less than 5 seconds
                .build();
    }

}
