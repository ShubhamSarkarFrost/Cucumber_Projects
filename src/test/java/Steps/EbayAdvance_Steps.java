package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;

import java.util.concurrent.TimeUnit;

public class EbayAdvance_Steps {

    String Baseurl = "https://www.ebay.com/";
    String WebdriverPath ="C:\\Users\\Lenovo\\IdeaProjects\\Cucumber_Projects\\webdrivers\\geckodriver.exe";
    WebDriver driver;
    String ExpCategory = "Antiques";

    @Given("I am on Ebay Advance Search Page")
    public void i_am_on_ebay_advance_search_page() {
         System.setProperty("webdriver.gecko.driver",WebdriverPath);
         driver = new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.get(Baseurl);
         driver.manage().window().maximize();
         driver.findElement(By.linkText("Advanced")).click();
         String Expected_url = "https://www.ebay.com/sch/ebayadvsearch";
         String Act_url = driver.getCurrentUrl();
         Assert.assertEquals(Expected_url, Act_url);
    }
    @When("I am Choosing Antiques in the Category dropdown and clicking on Search button")
    public void i_am_choosing_antiques_in_the_category_dropdown_and_clicking_on_search_button() {
        WebElement CategoryDropdown = driver.findElement(By.id("e1-1"));
        Select dropdown = new Select(CategoryDropdown);
        dropdown.selectByVisibleText("Antiques");
        String SelDrop = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Antiques",SelDrop);
        WebElement SearchButton = driver.findElement(By.xpath(".//div[starts-with(@class,'adv-s')]//button[text()='Search']"));
        SearchButton.click();

    }
    @Then("I am Navigated to Search By Category Page")
    public void i_am_navigated_to_search_by_category_page() {
        String Category = driver.findElement(By.xpath(".//span[@class='b-pageheader__text']")).getText();
         Assert.assertEquals(ExpCategory,Category);
         driver.close();
    }
}
