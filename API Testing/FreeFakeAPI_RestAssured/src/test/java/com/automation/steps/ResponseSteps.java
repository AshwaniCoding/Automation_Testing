package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response body has field {string} is {string}")
    public void verifyResponseBodyHasFieldIs(String jsonPath, String fieldValue) {
        Assert.assertEquals(fieldValue, RestAssuredUtils.getResponseFieldValue(jsonPath));
    }

    @And("verify response schema is {string}")
    public void verifyResponseSchemaIs(String fileName) {
        Response response = RestAssuredUtils.getResponse();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data/" + fileName));
    }

    @And("store {string} into {string}")
    public void storeInto(String jsonPath, String key) {
        ConfigReader.setConfigValue(key, RestAssuredUtils.getResponseFieldValue(jsonPath));
    }
}
