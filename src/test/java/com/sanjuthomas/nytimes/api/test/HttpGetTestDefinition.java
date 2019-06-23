package com.sanjuthomas.nytimes.api.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class HttpGetTestDefinition {

  private Response response;
  private ValidatableResponse json;
  private RequestSpecification request;

  @Given("^a api key \"([^\"]*)\"$")
  public void verifyAccount(String apiKey) throws Exception {
    this.request = given().queryParam("api-key", apiKey);
  }

  @When("^a user list book category using api \"([^\"]*)\" in the format \"([^\"]*)\"$")
  public void aUserListBookCategoryUsingApiInTheFormat(String endpoint, String format)
      throws Exception {
    response = request.when().get(endpoint.concat(".").concat(format));
  }

  @Then("^the status code is (\\d+)$")
  public void theStatusCodeIs(int statusCode) throws Exception {
    json = response.then().statusCode(statusCode);
  }

  @And("^response includes the following$")
  public void responseIncludesTheFollowing(Map<String, String> responseMap) throws Exception {
    responseMap.entrySet().forEach(response -> {
      json.body(response.getKey(), equalTo(StringUtils.isNumeric(response.getValue()) ? Integer
          .valueOf(response.getValue().toString()) : response.getValue()));
    });
  }

  @And("response includes the following in an array")
  public void response_contains_in_any_order(Map<String, String> responseMap) throws Exception {
    responseMap.entrySet().forEach(responseElement -> {
      json.body(responseElement.getKey(), hasItem(responseElement.getValue()));
    });
  }
}
