package stepdefinations;
import common.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.YouTubeHomePage;
import pages.YouTubeVideoPage;

public class YouTubeSteps extends BaseTest {
	
	YouTubeHomePage homePage ;
	YouTubeVideoPage videoPage;
	@Given("I launch the browser")
	public void StartBrowser()
	{
		openBrowser();
		homePage = new YouTubeHomePage(driver);
		videoPage = new YouTubeVideoPage(driver);
	}
	@Given("I navigate to the YouTube website")
	public void navigateyoutube()
	{
		navigatetoURL("https://www.youtube.com/");
	}
	@When("I search for the video titled {string}")
	public void searchfor(String videoName)
	{
		homePage.searchvideo(videoName);	
	}
	@Then("I should see the search results")
	public void searchresults() throws InterruptedException
	{
		homePage.results();
	}
	@Then("I play the video from the {string} channel")
	public void playvideo(String target) throws InterruptedException
	{
		homePage.playvideos(target);
	}
	@Then("I skip any YouTube ads if they appear")
	public void skipadd()
	{
		videoPage.skipadd();
	}
	@Then("I mute the YouTube video")
	public void mutevideos()
	{
		videoPage.muteVideo();
	}
//	@Then("I collect all the comments from the video")
	public void comment() throws InterruptedException
	{
		videoPage.videosComment();
	}
	@Then("I close the browser")
	public void stopBrowser()
	{
		closebrowser();
	}
}
