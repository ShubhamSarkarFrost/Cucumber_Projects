package actions;

import Steps.CommonSteps;
import elements.FirstCrySearch_Elements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstCrySearch_Actions {

    private WebDriver driver;

    FirstCrySearch_Elements firstCrySearch_elements;
    public FirstCrySearch_Actions(CommonSteps commonSteps){
        this.driver = commonSteps.getDriver();
        firstCrySearch_elements = new FirstCrySearch_Elements(driver);
    }

    public void goToUrl(String url){
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void getCurrentURL(String expectedurl){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,expectedurl);
    }

    public void getPageTitle(String expectedTitle){
        String title = driver.getTitle();
        Assert.assertEquals(title,expectedTitle);
    }

    public void clickGlobalSearch(String searchKey ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(firstCrySearch_elements.firstcrySearchBox));
        searchBox.click();
        searchBox.sendKeys(searchKey);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void checkExpectedElements(String searchResult, String Result ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
        System.out.println(searchResult);
        WebElement Header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='titleleft']//h1")));
        String headerValue = Header.getText();
        Assert.assertEquals(headerValue, Result);
    }

    public void quitWebDriver(){
        driver.quit();
    }
}
