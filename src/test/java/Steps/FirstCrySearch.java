package Steps;

import actions.FirstCrySearch_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class FirstCrySearch {

    FirstCrySearch_Actions firstCrySearch_actions;
    String Base_Url = "https://www.firstcry.com/?gr=false";
    String Base_title = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";


    public FirstCrySearch(FirstCrySearch_Actions firstCrySearch_actions){
        this.firstCrySearch_actions = firstCrySearch_actions;
    }

    @Given("I am on FirstCry Webpage")
    public void i_am_on_ebay_home_page() {
       firstCrySearch_actions.goToUrl(Base_Url);
       firstCrySearch_actions.getCurrentURL(Base_Url);
       firstCrySearch_actions.getPageTitle(Base_title);
    }

    @When("I Enter the {string} keyword in Global Search")
    public void i_enter_the_keyword_in_global_search(String searchKey) {
       firstCrySearch_actions.clickGlobalSearch(searchKey);
    }
    @Then("I Verify the {string} keyword is contained in the {string}")
    public void i_verify_the_keyword_is_contained_in_the(String searchResult, String Result) {
      firstCrySearch_actions.checkExpectedElements(searchResult,Result);

    }




}
