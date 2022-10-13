package StepDefination;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class AccountApiAutomation {
	
	@Given("i have baseurl for get reuest")
	public void i_have_baseurl_for_get_reuest() {
	    baseURI = "http://localhost:3000";
	    
	    given().accept(ContentType.JSON)
		.header("content-type","application/json");
	}

	@When("i have end point for get url")
	public void i_have_end_point_for_get_url() {
	   when().
		get("/user").then().statusCode(200).log().all();
	}
	@Then("i need to check the status code")
	public void i_need_to_check_the_status_code() {
		
	}

}
