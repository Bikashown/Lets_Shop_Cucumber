package DemoProject.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utility.Basic;
import Utility.CommonAction;

public class CatalogPage extends Basic{
	 static WebDriver driver;
	public CatalogPage(WebDriver driver)
	{
		   this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".offset-md-0")
	static List<WebElement> product;
	
	@FindBy(css="[routerlink*='cart']")
	static WebElement Cart;
	
	By productlist=By.cssSelector(".offset-md-0");
	
	static By addToCart=By.cssSelector(".card-body button:last-of-type");
	
	static By confirmationMessage=By.xpath("//*[text()='Product Added To Cart']");
	public static List<WebElement> getproductlist()
	{
	
		return product;
		
		
	}
	
	public static WebElement getproductbyName(String productName)
	{
		WebElement prod=getproductlist().stream().filter(item->item.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public static void addProductToCart(String productName) throws Exception
	{
		WebElement prod=getproductbyName(productName);
		WebElement placeOrder = prod.findElement(addToCart);
		CommonAction commonAction = new CommonAction(driver);
		commonAction.JSClick(driver, placeOrder);

	
		
	}

	public static CartPage clickOnKart() throws Exception
	{
		//WaitforElementtoDisappear(confirmationMessage);
		WebElement cart=Cart;
		CommonAction commonAction = new CommonAction(driver);
		commonAction.JSClick(driver, cart);
	    CartPage cartpage=new CartPage(driver);
	    return cartpage;
		
	}
}
