package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;

import com.myecom.base.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends BaseClass {
	
	@Given("open browser")
	public void open_browser() {
		 loadAppication();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@And("go to application url")
	public void go_to_application_url() {
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().window().maximize();
	}

	@When("^add (.*) and (.*)$")
	public void add_username_and_password(String username, String password) {
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("passwd")).sendKeys(password);
	}

	@And("click on login")
	public void click_on_login() {
	   driver.findElement(By.id("SubmitLogin")).click();
	}

	@Then("user navigates")
	public void user_navigates() {
		driver.findElement(By.xpath("//li[contains(text(),'Auth')]")).getText();
		driver.close();
	}
	
}
