package Regression;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DemoProject.PageObject.CartPage;
import DemoProject.PageObject.CatalogPage;
import DemoProject.PageObject.LandingPage;
import Utility.Basic;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyItemNamesInCartTest extends Basic{
   
	@Test(groups="smoke",dataProvider="getdata")
	public static void VerifyItemWithCorrectName(HashMap<String,String> inputdata) throws Exception
	{
	launchapp();
	Thread.sleep(5000);
	//LandingPage lp=new LandingPage(driver);
	lp.logintoapplication(inputdata.get("email"),inputdata.get("password"));
	CatalogPage.getproductlist();
	Thread.sleep(5000);
	CatalogPage.getproductbyName(inputdata.get("product"));
	
	CatalogPage.addProductToCart(inputdata.get("product"));
	CatalogPage.clickOnKart();
	Thread.sleep(3000);
	Boolean match=CartPage.VerifyItemsInCart(inputdata.get("product"));
    Assert.assertTrue(match);
	}
	
	
  
	@Test(groups="smoke",dataProvider="getdata")
	public static void VerifyItemWithInCorrectName(HashMap<String,String> inputdata) throws Exception
	{
	launchapp();
	Thread.sleep(5000);
	//LandingPage lp=new LandingPage(driver);
	lp.logintoapplication(inputdata.get("email"),inputdata.get("password"));
	CatalogPage.getproductlist();
	Thread.sleep(5000);
	CatalogPage.getproductbyName(inputdata.get("product"));
	
	CatalogPage.addProductToCart(inputdata.get("product"));
	CatalogPage.clickOnKart();
	Boolean match=CartPage.VerifyItemsInCart("zara coat 35");
    Assert.assertFalse(match);
	}
    
    
	@DataProvider()
	public static Object[][] getdata()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "78bikash.hyd@gmail.com");
		map.put("password", "Hyderabad@2023");
		map.put("product", "zara coat 3");
		
		return new Object[][] {{map}};
	}
		
	}
	

