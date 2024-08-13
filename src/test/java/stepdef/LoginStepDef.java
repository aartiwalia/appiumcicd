package stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginStepDef {
	@When("I enter username  as {string}")
	public void iEnterUsernameAs(String username) throws InterruptedException {
	   new LoginPage().enterUserName(username);
	
	}



	@When("I enter password as {string}")
	public void iEnterPasswordAs(String password) {
	    new LoginPage().enterPassword(password);
	    
	}

	@When("click login button")
	public void clickLoginButton() {
	    new LoginPage().pressLoginBtn();
	   
	}

	@Then("login should fail with error {string}")
	public void loginShouldFailWithError(String Error) {
	   //assertTrue(new LoginPage().getErrTxt().equalsIgnoreCase(errtxt));
		assertEquals(new LoginPage().getErrTxt(), Error);
	    
	}

	

	@Then("I should see products page with Title {string}")
	public void iShouldSeeProductsPageWithTitle(String Title) {
	   
	   assertEquals(new ProductsPage().getTitle(), Title);
	}

}
