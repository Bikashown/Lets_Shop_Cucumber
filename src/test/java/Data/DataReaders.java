package Data;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.*;


public class DataReaders {
	public WebDriver driver;
	public DataReaders(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public static String dataproviders(String Datahelper)
	{
		JsonPath js=new JsonPath(Data.getdata());
		String mydata=js.get(Datahelper).toString();
		return mydata;
	}
}
