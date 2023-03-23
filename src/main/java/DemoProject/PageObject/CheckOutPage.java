package DemoProject.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Utility.Basic;
import Utility.CommonAction;

public class CheckOutPage extends Basic{
	  static WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
   this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[placeholder='Select Country']")
	static
	 WebElement SelectCountry;
	@FindBy(css="[class='ta-results list-group ng-star-inserted'] button:last-of-type")
	static WebElement SelectCountryname;
	
	@FindBy(xpath="//*[@class='btnn action__submit ng-star-inserted']")
	 static WebElement placeorder;
	
	public static void selectcountry(String countryName) throws InterruptedException
	{
		Thread.sleep(5000);
		SelectCountry.sendKeys(countryName);
		Thread.sleep(5000);
		SelectCountryname.click();
		
	}
	
	public static ConfirmationPage clickOnplaceOrder()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",placeorder );
		ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		return confirmationpage;
		
	}
	

}
