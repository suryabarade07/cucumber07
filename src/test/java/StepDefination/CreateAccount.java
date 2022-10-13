package StepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Data;
import com.pojo.Support;
import com.pojo.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class CreateAccount {
	
	String response;
	RequestSpecification request;
	ResponseSpecification res;
	Response apiResponse;
	
	
	@Given("i have baseurl for post")
	public void i_have_baseurl_for_post() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
	   FileInputStream fis  = new FileInputStream(projectPath+"\\testdata\\config.properties");
	   Properties prop = new Properties();
	   prop.load(fis);
	   baseURI = "https://reqres.in/api";
	}

	@Given("i have playload for post")
	public void i_have_playload_for_post() {
		
		List<Data> userdata = new ArrayList<>();
		
		Support support = new Support("http://www.google.com", "dummy text");
		
		Data data = new Data(1, "abc@gmail.com", "abc", "xyz", "https://reqres.in/img/faces/2-image.jpg");
		
		userdata.add(data);
		
		User user = new User(2, 10, 5, 2, userdata, support);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			response = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(response);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://reqres.in/api")
				.setContentType(ContentType.JSON).build();
		 res = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		 request = given().spec(req).body(response);
		
	}

	@When("i have put endpont for post url")
	public void i_have_put_endpont_for_post_url() {
		apiResponse = request.when().post("/users").then().spec(res).extract().response();
	}

	@Then("i need to check status code")
	public void i_need_to_check_status_code() {
		System.out.println(apiResponse.asPrettyString());
		int statusCode = apiResponse.statusCode();
		Assert.assertEquals(201, statusCode);
	}

}
