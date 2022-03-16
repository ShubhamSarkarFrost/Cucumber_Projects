package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EbayHome_Steps {

    String Base_Url = "https://www.ebay.com/";
    String Base_title = "Electronics, Cars, Fashion, Collectibles & More | eBay";
    WebDriver driver;

    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Shubham\\IdeaProjects\\Cucumber_Projects\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Base_Url);
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(Base_Url,url);
        String title = driver.getTitle();
        Assert.assertEquals(Base_title,title);

    }
    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
      driver.findElement(By.linkText("Advanced")).click();
    }
    @Then("I will Navigate to Advance Search Page")
    public void i_will_navigate_to_advance_search_page() {
       String Expected_url = "https://www.ebay.com/sch/ebayadvsearch";
       String Act_url = driver.getCurrentUrl();
       Assert.assertEquals(Expected_url,Act_url);
       driver.close();
    }
}
