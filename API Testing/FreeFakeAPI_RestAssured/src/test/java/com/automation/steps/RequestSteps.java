package com.automation.steps;

import com.automation.pojo.CreateCommentRequestPojo;
import com.automation.pojo.CreatePostRequestPojo;
import com.automation.pojo.UpdateCommentPojo;
import com.automation.pojo.UpdatePostPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.reflect.Field;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        RestAssuredUtils.clear();
        if(endPoint.contains("@postId")){
            endPoint = endPoint.replace("@postId",ConfigReader.getConfigValue("post.id"));
        }else if(endPoint.contains("@commentId")){
            endPoint = endPoint.replace("@commentId",ConfigReader.getConfigValue("comment.id"));
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }


    @When("user performs post call")
    public void userPerformsPostCall() {
        RestAssuredUtils.post();
    }


    @And("set request body from file {string} with create post request pojo")
    public void setRequestBodyFromFileWithCreatePostRequestPojo(String fileName) throws Exception {
        String content = RestAssuredUtils.getContentFromJson(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePostRequestPojo requestPojo = objectMapper.readValue(content, CreatePostRequestPojo.class);

        RestAssuredUtils.setBody(requestPojo);
    }

    @When("user performs get call")
    public void userPerformsGetCall() {
        RestAssuredUtils.get();
    }

    @When("user performs put call")
    public void userPerformsPutCall() {
        RestAssuredUtils.put();
    }

    @When("user performs delete call")
    public void userPerformsDeleteCall() {
        RestAssuredUtils.delete();
    }

    @And("set request body from file {string} with {string} value {string} in update post pojo")
    public void setRequestBodyFromFileWithValueInUpdatePostPojo(String fileName, String fieldName, String fieldValue) throws Exception {
        String content = RestAssuredUtils.getContentFromJson(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdatePostPojo requestPojo = objectMapper.readValue(content, UpdatePostPojo.class);

        Field field = UpdatePostPojo.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(requestPojo, Integer.valueOf(ConfigReader.getConfigValue(fieldValue)));

        RestAssuredUtils.setBody(requestPojo);
    }

    @And("set request body from file {string} with create comment request pojo")
    public void setRequestBodyFromFileWithCreateCommentRequestPojo(String fileName) throws Exception {
        String content = RestAssuredUtils.getContentFromJson(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateCommentRequestPojo requestPojo = objectMapper.readValue(content, CreateCommentRequestPojo.class);

        RestAssuredUtils.setBody(requestPojo);
    }

    @And("set request body from file {string} with {string} value {string} in update comment pojo")
    public void setRequestBodyFromFileWithValueInUpdateCommentPojo(String fileName, String fieldName, String fieldValue) throws Exception {
        String content = RestAssuredUtils.getContentFromJson(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        UpdateCommentPojo requestPojo = objectMapper.readValue(content, UpdateCommentPojo.class);

        Field field = UpdateCommentPojo.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(requestPojo,Integer.valueOf(ConfigReader.getConfigValue(fieldValue)));

        RestAssuredUtils.setBody(requestPojo);
    }
}
