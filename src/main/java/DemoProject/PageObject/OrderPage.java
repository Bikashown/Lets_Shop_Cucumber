package DemoProject.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Basic;
import Utility.CommonAction;

public class OrderPage  extends Basic{
	
	public static WebDriver driver;
	static CommonAction ca=new CommonAction(driver);
	public OrderPage(WebDriver driver)
	{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	private static List<WebElement> itemsinOrderList;
	
	public static Boolean verifyOrderDisplay(String productname)
	{
		return itemsinOrderList.stream().anyMatch(item->item.getText().equalsIgnoreCase(productname));
	}

}
