package Utility;
import org.testng.asserts.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DemoProject.PageObject.OrderPage;

public class ReusableMethods extends Basic{
	
	public static WebDriver driver;
	static CommonAction ca=new CommonAction(driver);
	public ReusableMethods(WebDriver driver)
	{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@routerlink='/dashboard/myorders']")
	static WebElement order;
	
	public static OrderPage clickOnOrder()
	{
	   ca.JSClick(driver, order);
	   OrderPage op=new OrderPage(driver);
	   return op;
			   
	}
	
	public static void dataproviders()
	{
		
	}

}
