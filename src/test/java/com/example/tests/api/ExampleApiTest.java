package com.example.tests.api;

import com.example.framework.core.ApiTestBase;
import com.example.framework.reporting.TestLogger;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleApiTest extends ApiTestBase {

    @Test
    public void shouldFetchUsers() {
        TestLogger.info("Send GET /users");
        int statusCode = RestAssured
            .given()
            .when()
            .get("/users")
            .then()
            .extract()
            .statusCode();

        TestLogger.info("Verify status code is 200");
        Assert.assertEquals(statusCode, 200);
    }
}
