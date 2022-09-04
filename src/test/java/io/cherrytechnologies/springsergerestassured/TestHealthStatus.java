package io.cherrytechnologies.springsergerestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class TestHealthStatus {

    private static final String CONTEXT_PATH = "/v1/api";

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    final void Test_health_status_api() {
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .get(CONTEXT_PATH + "/status")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertNotNull(response.getBody());
    }

}
