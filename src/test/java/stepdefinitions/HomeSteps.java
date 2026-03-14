package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultPage;
import utils.DriverFactory;
import utils.FileReader;
import java.util.List;

public class HomeSteps {

    List<String> trackingIds = FileReader.getTrackingIds();
    HomePage homePage = new HomePage(DriverFactory.getDriver());
    SearchResultPage searchResultPage = new SearchResultPage(DriverFactory.getDriver());

    @Given("user is on home page")
    public void openHomePage() {
        homePage.acceptCookies();
    }

    @When("user enters trackingId {int} and submit")
    public void enterTrackingId(int index) {
        homePage.enterTrackingId(trackingIds.get(index));
        homePage.submitTrackingId();
    }

    @Then("user see search results")
    public void checkSearchResults() {
        searchResultPage.waitForPopupToDisappear();
        searchResultPage.verifySearchResults();
    }

    @Then("tracking id is visible and correct {int}")
    public void getAndCheckTrackingId(int index) {
        String actualId = searchResultPage.getSearchResultId();
        assert actualId.equals(trackingIds.get(index));
        System.out.println("Actual ID: " + actualId + " and Expected ID: " + trackingIds.get(index));
    }
}