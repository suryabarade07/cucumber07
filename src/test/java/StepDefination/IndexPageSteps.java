package StepDefination;

import com.myecom.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class IndexPageSteps extends BaseClass{
	
	@Given("i am on index page")
	public void i_am_on_index_page() {
	    loadAppication();
	}

	@When("page is loaded")
	public void page_is_loaded() {
	  driver.manage().window().maximize();
	}

	@Then("check title of page")
	public void check_title_of_page() {
	   String pageTitile = driver.getTitle();
	   Assert.assertEquals(pageTitile, "My Store");
	}

}
