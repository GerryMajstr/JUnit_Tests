package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.ShoppingOptionsPage;
import utils.DriverFactory;

public class ShoppingOptionsSteps {
    ShoppingOptionsPage shoppingOptionsPage = new ShoppingOptionsPage(DriverFactory.getDriver());

    @Then("user selects express option")
    public void selectExpressOption() {
        shoppingOptionsPage.clickExpressOption();
    }
}
