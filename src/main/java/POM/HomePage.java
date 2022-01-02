package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath = "//span[@class=\"user-id\"]")private WebElement Icon;
	@FindBy(xpath = "//a[@target=\"_self\"]")private WebElement Logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	
	public String ValidationIcon()
	{
		String ActualId = Icon.getText();
		return ActualId;
	}
	
	public void ClickOnIcon()
	{Icon.click();
	}
	
	public void ClickOnLogout()
	{Logout.click();
		
	}
	}
