package DemoProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utility.Basic;
import Utility.CommonAction;

public class ConfirmationPage extends Basic{
    static WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@class='hero-primary']")
	static WebElement Confirmationmessage;
	
	public static String  getConfirmationMessage() throws InterruptedException
	{
		Thread.sleep(5000);
		return Confirmationmessage.getText();
		
		
	}

}
