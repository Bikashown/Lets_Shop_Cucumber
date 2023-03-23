package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import DemoProject.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {
	
	public static Properties prop;
	public static FileInputStream fis;
    public static  WebDriver driver;
   public static LandingPage lp;
public static  ReusableMethods reusablemethods;
public static  CommonAction commonaction;
public static String browserName;
	@BeforeTest(alwaysRun=true)
	public static void readconf()
	{
		try {
			 fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\DemoProject\\conf.properties");
			 prop=new Properties();
			try {
				prop.load(fis);
				 browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void launchapp() throws IOException
	{
		fis=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\DemoProject\\conf.properties");
		 prop=new Properties();
		 prop.load(fis);
		browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("url"));
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			//driver.set(new EdgeDriver());
			driver=new EdgeDriver();
			driver.get(prop.getProperty("url"));
			//driver.manage().window().maximize();
			
			
		}
		 lp=new LandingPage(driver);
		  reusablemethods=new ReusableMethods(driver);
		   commonaction=new CommonAction(driver);
		
	
	}
	
	@AfterMethod(alwaysRun=true)
	public static void CloseApp(ITestResult result)
	{
		//if(ITestResult.FAILURE==result.getStatus())
		//{
			//commonaction.screenShot(driver, result.getMethod().getMethodName());
		//}
		driver.close();
	}
	
}
