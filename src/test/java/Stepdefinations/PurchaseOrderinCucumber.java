package Stepdefinations;

import java.io.IOException;

import org.testng.Assert;

import DemoProject.PageObject.CartPage;
import DemoProject.PageObject.CatalogPage;
import DemoProject.PageObject.CheckOutPage;
import DemoProject.PageObject.ConfirmationPage;
import Utility.Basic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseOrderinCucumber extends  Basic{
	
	@Given("I landed on Lets Shop page")
	public static void I_landed_on_Lets_Shop_page() throws InterruptedException, IOException
	{
		
		launchapp();
		Thread.sleep(5000);
		
	}
	
	 
	 @Given("^Logged in with username (.+) and password (.+)$")
	 public static void Logged_in_with_username_and_password(String username,String password) throws Exception
	 {
		 lp.logintoapplication(username, password);
	 }
	 
	
	 @When("^I add the product (.+) to cart")	 
	 public static void I_add_the_product_to_cart(String productname) throws Exception
	 {
		    CatalogPage.getproductlist();
			Thread.sleep(5000);
			CatalogPage.getproductbyName(productname);
			
			CatalogPage.addProductToCart(productname);  
	 }
	 
	 
	 @When("^checkout (.+) and submit the order$")
	 public static void checkout_product_and_submit_the_order(String productname) throws Exception
	 {
		 CatalogPage.clickOnKart();
			Boolean match=CartPage.VerifyItemsInCart(productname);
		    Assert.assertTrue(match);
		    CartPage.goToCheckOut();
		   
		    CheckOutPage.selectcountry("India");
		    CheckOutPage.clickOnplaceOrder();
	 }
	 
	
	 @Then("{string} is displayed in the confirmationpage")
	 public static void Message_is_displayed_in_the_confirmationpage(String message) throws InterruptedException
	 {
		 String text=ConfirmationPage.getConfirmationMessage();
		  Assert.assertEquals(text, message);
	 }

}
