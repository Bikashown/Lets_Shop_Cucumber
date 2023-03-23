package Regression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Data.DataReaders;
import DemoProject.PageObject.CartPage;
import DemoProject.PageObject.CatalogPage;
import DemoProject.PageObject.CheckOutPage;
import DemoProject.PageObject.ConfirmationPage;
import DemoProject.PageObject.LandingPage;
import DemoProject.PageObject.OrderPage;
import Utility.Basic;
import Utility.CommonAction;
import Utility.ReusableMethods;

public class StandAloneTest extends Basic {

	@Test
	public static void tcc01() throws Exception
	{
		
		launchapp();
		Thread.sleep(5000);
	
	
		lp.logintoapplication("78bikash.hyd@gmail.com", "Hyderabad@2023");
		CatalogPage.getproductlist();
		Thread.sleep(5000);
		CatalogPage.getproductbyName("zara coat 3");
		
		CatalogPage.addProductToCart("zara coat 3");
		CatalogPage.clickOnKart();
		Boolean match=CartPage.VerifyItemsInCart("zara coat 3");
	    Assert.assertTrue(match);
	    CartPage.goToCheckOut();
	   
	    CheckOutPage.selectcountry("India");
	    CheckOutPage.clickOnplaceOrder();
	  String text=ConfirmationPage.getConfirmationMessage();
	  Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
	    
	}
	
	@Test(dependsOnMethods= {"tcc01"})
	public static void verifyorder() throws Exception
	{
		launchapp();
		lp.logintoapplication("78bikash.hyd@gmail.com", "Hyderabad@2023");
		Thread.sleep(2000);
		ReusableMethods.clickOnOrder();
		Thread.sleep(2000);
		Assert.assertTrue(OrderPage.verifyOrderDisplay("zara coat 3"));
	}
}
