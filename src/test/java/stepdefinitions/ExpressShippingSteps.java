package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ExpressShippingPage;
import utils.DriverFactory;

public class ExpressShippingSteps {
    ExpressShippingPage expressShippingPage = new ExpressShippingPage(DriverFactory.getDriver());

    @Given("user clicks callback button")
    public void clickCallback() {
        expressShippingPage.clickCallback();
    }

    @Then("user can fill callback form with {int} user")
    public void fillCallbackForm(int userIndex) {
        expressShippingPage.fillCallbackForm(userIndex);
    }

}
