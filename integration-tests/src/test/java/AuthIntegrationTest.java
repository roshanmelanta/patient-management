import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;
import static io.restassured.RestAssured.given;

class AuthIntegrationTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    void shouldReturnOKWithValidToken() {
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
                .post("/api/v1/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();

        System.out.println("Generated Token: " + response.jsonPath().get("token"));
    }

    @Test
    void shouldReturnUnauthorizedWithInvalidCredentials() {
        String loginPayload = """
            {
                "email": "invalid_user@test.com",
                "password": "wrong_password"
            }
            """;

        given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/api/v1/auth/login")
                .then()
                .statusCode(401);
    }
}
