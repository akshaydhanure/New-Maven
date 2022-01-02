package BASE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base 
{public WebDriver driver;

public void BrowserInitialise() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromed\\chromedriver.exe");
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	driver=new ChromeDriver(opt);
	
	driver.manage().window().maximize();
	driver.get("https://kite.zerodha.com/");
	Thread.sleep(1000);
}
}
