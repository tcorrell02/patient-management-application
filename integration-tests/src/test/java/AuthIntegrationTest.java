import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnOkWithValidToken() {
        // 1. Arrange: any setup to have test work 100% of the time (lines 24 - 33)
        // 2. Act: doing the actions necessary for the test (lines 34 - 35)
        // 3. Assert: assert the result (lines 36 - 38)

        String loginPayload = """
                {
                    "email": "testuser@test.com",
                    "password": "password123"
                }
                """;

        Response response = given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token: " + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin() {

        String loginPayload = """
                {
                    "email": "invalid_user@test.com",
                    "password": "wrongpassword"
                }
                """;

        given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(401);

    }


}
