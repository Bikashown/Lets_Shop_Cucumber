package DemoProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utility.Basic;
import Utility.CommonAction;

public class LandingPage  extends Basic{
	static WebDriver driver;
	static CommonAction commonAction = new CommonAction(driver);
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='userEmail']")
	private static WebElement username;
	

	
	@FindBy(id="userPassword")
	private static WebElement passwsord;
	
	@FindBy(id="login")
	private static WebElement login;
	
	@FindBy(xpath="//*[text()=' Incorrect email or password. ']")
	private static WebElement errormessage;
	
	
	public static String geterrormessage()
	{
		commonAction.waitForElementToAppear(errormessage);
		return errormessage.getText();
		 
	}
	
	public static CatalogPage logintoapplication(String uname,String pwd) throws Exception
	{
		
		//driver=launchapp();
		commonAction.type(username, uname);
		commonAction.type(passwsord, pwd);
		commonAction.JSClick(driver,login);
		CatalogPage cp=new CatalogPage(driver);
		return cp;
	}
	
	
	
	
	
	
}
