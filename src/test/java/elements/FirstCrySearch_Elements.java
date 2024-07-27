package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstCrySearch_Elements {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='search_box']") public WebElement firstcrySearchBox;
    @FindBy(xpath = "//div[@class='titleleft']//h1") public  WebElement searchPageHeader;
    //@FindBy(xpath="//div[@class='menu-container']//a") public WebElement homePageHeader;

    public FirstCrySearch_Elements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
