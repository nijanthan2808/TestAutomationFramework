package com.example.framework.core;

import com.example.framework.config.ConfigLoader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class ApiTestBase {

    @BeforeClass(alwaysRun = true)
    public void configureApi() {
        RestAssured.baseURI = ConfigLoader.getOrDefault("api.baseUrl", "https://reqres.in");
    }
}
