package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPage 
{
	@FindBy(id="pin") private WebElement Pin;
	@FindBy(xpath = "//button[@type=\"submit\"]")private WebElement Continue;
	
	public PinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendPin(String Ppin)
	{
		Pin.sendKeys(Ppin);
	}
	public void ClickOnContinue() {
		Continue.click();
	}
}
