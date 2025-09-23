package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.BaseTest;
import utilities.FileUtils;
import utilities.WaitUtils;

public class YouTubeHomePage extends BaseTest{
	
	
	private By searchBox = By.name("search_query");
	private By searchButton = By.xpath("//*[@class='ytSearchboxComponentSearchButton ytSearchboxComponentSearchButtonDark']");
	private By videoTitle = By.id("above-the-fold");
	StringBuilder data1 = new StringBuilder();
	String title;
	
	 List<WebElement> videoList ;
	 List<WebElement> channelNames;

	public YouTubeHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
		 this.waitUtils = new WaitUtils(driver,20);
	}
	public void searchvideo(String videoName)
	{
		Type(searchBox,videoName);
		click(searchButton);	
	}
	public void results() throws InterruptedException 
	{
		Thread.sleep(5000);
			    try {
		       videoList = waitUtils.waitForAllVideos(By.xpath("//*[@id='video-title']"));
		      channelNames = waitUtils.waitForAllVideos(By.xpath("//ytd-channel-name[@id='channel-name']//a"));
	     //   System.out.println("Videos found: " + videoList.size());
	    } catch (Exception e) {
	        System.out.println("No results found or timeout");
		    }
	}
	public void playvideos(String target) throws InterruptedException
	{    
		Thread.sleep(5000); 

	    boolean found = false;

	    List<WebElement> videos = driver.findElements(By.xpath("//ytd-video-renderer"));

	    for (WebElement video : videos) {
	        try {
	            WebElement channelElement = video.findElement(By.xpath(".//ytd-channel-name//a"));

	            // Get visible text via JS
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            String channel = (String) js.executeScript("return arguments[0].innerText;", channelElement);
	            channel = channel.trim();
	            System.out.println("Channel: " + channel);

	            if (channel.equalsIgnoreCase(target)) {
	                WebElement titleElement = video.findElement(By.id("video-title"));
	                
	                js.executeScript("arguments[0].scrollIntoView(true);", titleElement);
	                Thread.sleep(1000);
	                js.executeScript("arguments[0].click();", titleElement);
	                
	                String title = titleElement.getAttribute("title");
	                System.out.println("\n========== YouTube Title ==========");
	                System.out.println("Video Title: " + title);
	                System.out.println("===================================");

	                // Write video title to file
	                FileUtils.writeTitle(title);

	                found = true;
	                break;
	            }
	        } catch (Exception e) {
	            continue;
	        }
	    }
	    
	    if (!found) {
	        System.out.println("Target channel not found: " + target);
	    }}
	}