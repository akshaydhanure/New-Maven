package TEST_CLASSES;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BASE.Base;
import POM.HomePage;
import POM.LoginPage;
import POM.PinPage;
import UTILITY.Utility;

public class BaseUtilityKite extends Base 
{
 
	
		LoginPage login;
		PinPage pin;
		HomePage home;

			@BeforeClass
			public void launchBrowser() throws InterruptedException  
			{
				BrowserInitialise();
				
				login = new LoginPage(driver);
				pin = new PinPage(driver);
				home = new HomePage(driver);
			}
			
			
			
			@BeforeMethod
			public void loginToKite() throws EncryptedDocumentException, IOException, InterruptedException
			{Thread.sleep(1000);
				login.sendUserId(Utility.getDataFromExcel(0, 0));
				
				login.sendPwd(Utility.getDataFromExcel(0, 1));
			
				login.Button();
				Thread.sleep(1000);
				
				pin.sendPin(Utility.getDataFromExcel(0, 2));
				pin.ClickOnContinue();
			}
			
			@Test(enabled = false )
			public void errorHandleMsg() throws EncryptedDocumentException, IOException 
			{int TCID =1;
				String ActualMsg = login.getErrorMsg();
				String ExpectedMsg = Utility.getDataFromExcel(1, 3);
				Assert.assertEquals(ActualMsg, ExpectedMsg, "Error msg does not match TC"+TCID+"");
				Reporter.log("Error Msg matching TC"+TCID+"Passed");
			}
			
			
			@Test
		  public void Validation() throws EncryptedDocumentException, IOException, InterruptedException 
			{int TCID=2;
			Thread.sleep(1000);
				String ActualId =home.ValidationIcon();
				String ExpectedId = Utility.getDataFromExcel(0, 0);
				
				Assert.assertEquals(ActualId, ExpectedId,"User Id does not match TestId"+TCID+"failed");
				Reporter.log("User Id Matched TestId"+TCID+"passed",true);
				Thread.sleep(1000);
				Utility.CaptureScreen(driver, TCID);
			}
			
			@AfterMethod
			public void LogOut() throws InterruptedException
			{Thread.sleep(1000);
				home.ClickOnIcon();
				home.ClickOnLogout();
			}

		@AfterClass
		public void closeBrowser()
		{
			driver.close();
		}
}
