package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FirstCrySearch {

    String Base_Url = "https://www.firstcry.com/?gr=false";
    String Base_title = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
    WebDriver driver;

    public FirstCrySearch(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
    }



    @Given("I am on FirstCry Webpage")
    public void i_am_on_ebay_home_page() {
        driver.get(Base_Url);
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(Base_Url, url);
        String title = driver.getTitle();
        Assert.assertEquals(Base_title, title);


    }

    @When("I Enter the {string} keyword in Global Search")
    public void i_enter_the_keyword_in_global_search(String searchKey) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_box']")));
        searchBox.click();
        searchBox.sendKeys(searchKey);
        searchBox.sendKeys(Keys.ENTER);
    }
    @Then("I Verify the {string} keyword is contained in the {string}")
    public void i_verify_the_keyword_is_contained_in_the(String searchResult, String Result) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
        System.out.println(searchResult);
        WebElement Header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='titleleft']//h1")));
        String headerValue = Header.getText();
        Assert.assertEquals(headerValue, Result);

    }




}
