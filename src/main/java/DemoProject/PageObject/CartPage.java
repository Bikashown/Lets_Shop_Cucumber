package DemoProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utility.Basic;
import Utility.CommonAction;

public class CartPage extends Basic{
	 static WebDriver driver;
	public CartPage(WebDriver driver)
	{
		   this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	static List<WebElement> cartItems;
	
	@FindBy(xpath="//*[text()='Checkout']")
	static WebElement checkout;

	public static Boolean VerifyItemsInCart(String productName)
	{		
		Boolean item=cartItems.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return item;
		
	}
	
	
	public  static CheckOutPage goToCheckOut()
	{
		checkout.click();
		CheckOutPage checkoutpage=new CheckOutPage(driver);
		return checkoutpage;
	}
	
	
}
