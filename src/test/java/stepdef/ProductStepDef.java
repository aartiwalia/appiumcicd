package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import static org.junit.Assert.*;

public class ProductStepDef {
	@Given("I am logged in")
	public void iAmLoggedIn() throws InterruptedException {
	    new LoginPage().login("standard_user", "secret_sauce");
	    
	    
	}

	@Then("product is listed with Title {string} and Price {string}")
	public void productIsListedWithTitleAndPrice(String Title, String Price) throws Exception {
	   Boolean checkTitle=new ProductsPage().getProductTitle(Title).equalsIgnoreCase(Title);
	   assertEquals(checkTitle, Title);
	  // boolean checkPrice=new ProductsPage().get
	}

	@When("i click on product Title {string}")
	public void iClickOnProductTitle(String Title) throws Exception {
	    new ProductsPage().pressProductTitle(Title);
	}

	@Then("I should be navigated to Product details page with Title {string}, Price {string} and Description {string}")
	public void iShouldBeNavigatedToProductDetailsPageWithTitlePriceAndDesc(String Title, String Price, String Description) throws Exception {
		 ProductDetailsPage productDetailsPage = new ProductDetailsPage();
	        boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(Title);
	        boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(Description);
	        boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(Price);
	        assertEquals(titleCheck,Title);
	        assertEquals(descCheck, Description);
	        assertEquals(priceCheck, Price);
	   
	}




}
