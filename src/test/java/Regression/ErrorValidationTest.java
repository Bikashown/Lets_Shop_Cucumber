package Regression;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.DataReaders;
import DemoProject.PageObject.LandingPage;
import Data.DataReaders;
import Utility.Basic;

public class ErrorValidationTest extends Basic{
	@Test
	public static void verifyerrorlog() throws Exception
	{
		//DataReaders dr=new DataReaders(driver);
		launchapp();
		Thread.sleep(5000);
	
		lp.logintoapplication(DataReaders.dataproviders("Login.email"), DataReaders.dataproviders("Login.wrongpassword"));
		String Text=LandingPage.geterrormessage();
		Assert.assertEquals(Text, "Incorrect email or passwordsss.");
		
		
		
	}

}
