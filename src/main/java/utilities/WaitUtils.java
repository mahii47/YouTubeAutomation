package utilities;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private  WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver,int timeoutInSeconds)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutInSeconds));
	}
	public WebElement waitForElementVisible(By locator)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public List<WebElement> waitForAllVideos(By locator) {
	    return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public  WebElement waitForElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public List<WebElement>waitForComments(By locator)
	{
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
}
