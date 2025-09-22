package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.WaitUtils;

public class BaseTest {

	public static WebDriver driver;
	public static WaitUtils waitUtils;
	
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		waitUtils = new WaitUtils(driver,50);
	}
	public void navigatetoURL(String url)
	{
		driver.get(url);
	}
	public void Type(By locator,String text)
	{
		WebElement element = waitUtils.waitForElementVisible(locator);
		element.clear();
		element.sendKeys(text);
	}
	public void click(By locator)
	{
		WebElement element = waitUtils.waitForElementClickable(locator);
		element.click();
	}
	public void closebrowser()
	{
		if(driver!=null)
		{
			driver.quit();
			driver=null;
		}
	}
}
