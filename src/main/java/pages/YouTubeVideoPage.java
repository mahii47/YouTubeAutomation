package pages;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.BaseTest;
import utilities.FileUtils;
import utilities.WaitUtils;

public class YouTubeVideoPage extends BaseTest{
	
	private By skipbutton = By.xpath("//button[contains(@class,'ytp-skip-ad-button')]");
	private By comment = By.id("content-text");
	private By mute = By.xpath("//*[@class='ytp-mute-button ytp-button']");
	StringBuilder data = new StringBuilder();
	String commentText;
	
	private WaitUtils waitUtils = new WaitUtils(driver,10);
	 List<WebElement> commentList ;
	 
	 public  YouTubeVideoPage(WebDriver driver)
	 {
		 this.driver = driver;
		 this.waitUtils = new WaitUtils(driver,20);
	 }
	public void skipadd()
	{
		try {	
		WebElement skbutton = waitUtils.waitForElementClickable(skipbutton);
		skbutton.click();
		System.out.println("Add skipped");
		}
		catch(Exception e)
		{
			System.out.println("No skippable add appeared");
		}
	}
	public void videosComment() throws InterruptedException
	{
		Thread.sleep(5000);	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		 
		 try {
			 Thread.sleep(4000);
		 }catch(InterruptedException e)
		 {
			 e.printStackTrace();
		 }
		commentList = waitUtils.waitForComments(comment);
		 System.out.println("\n========== YouTube Comments ==========");
		
		for(int i=1;i<=commentList.size()-1;i++)
		{
			 commentText = commentList.get(i).getText();
		System.out.println("Comment No:"+i+" "+commentList.get(i).getText());
		 
		}
		 System.out.println("\n========================================");
		 
		 List<String> allComments = new ArrayList<>();
		 for (WebElement c : commentList) {
		     allComments.add(c.getText());
		 }
		 FileUtils.writeComments(allComments); 
	}
	
	public void muteVideo()
	{
		WebElement muteVideo = waitUtils.waitForElementClickable(mute);
		muteVideo.click();
	}
}
