package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id="userid")private WebElement UsID;
	@FindBy(id="password")private WebElement Pass;
	@FindBy(xpath = "//button[@type=\"submit\"]")private WebElement LoginBtn;
	@FindBy(xpath = "//p[@class=\"error text-center\"]")private WebElement ErrorMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserId(String Userid)
	{
		UsID.sendKeys(Userid);
	}
	public void sendPwd(String Pwd)
	{
		Pass.sendKeys(Pwd);
	}
	public void Button()
	{
		LoginBtn.click();
	}
	
	public String getErrorMsg() {
		String ActualMsg = ErrorMsg.getText();
		return ActualMsg;
	}
}
