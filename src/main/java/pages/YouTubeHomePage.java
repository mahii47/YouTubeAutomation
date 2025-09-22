package pages;
import java.util.List;
import org.openqa.selenium.By;
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
	        for (int i=0;i<videoList.size();i++)
	        {
	        	String channel = channelNames.get(i).getText();
	        	System.out.println(channel);
	        	if(channel.equalsIgnoreCase(target.trim()))
	        	{
	        		WebElement video = videoList.get(i);	
	        		video.click();
	        		break;
	        	}  
	        }
	         title = waitUtils.waitForElementVisible(videoTitle).getText();
	        System.out.println("\n========== YouTube Title ==========");
	        System.out.println("Video Title: "+title);
	        System.out.println("\n===================================");
	        
	        FileUtils.writeTitle(title);
	        
	       
	 }
}
