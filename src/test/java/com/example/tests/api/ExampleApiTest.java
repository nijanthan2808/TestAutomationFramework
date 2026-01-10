package com.example.tests.api;

import com.example.framework.core.ApiTestBase;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleApiTest extends ApiTestBase {

    @Test
    public void shouldFetchUsers() {
        int statusCode = RestAssured
            .given()
            .when()
            .get("/users")
            .then()
            .extract()
            .statusCode();

        Assert.assertEquals(statusCode, 200);
    }
}
