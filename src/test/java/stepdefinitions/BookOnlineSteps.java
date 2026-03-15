package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookOnlinePage;
import utils.DriverFactory;

public class BookOnlineSteps {
    BookOnlinePage bookOnlinePage = new BookOnlinePage(DriverFactory.getDriver());

    @Given("user select destination country")
    public void fillDestinationCountry() {
        bookOnlinePage.selectDestinationCountry();
    }

    @Then("user wants to send with documents {string}")
    public void selectDocumentOption(String documents) {
        boolean sendDocuments = Boolean.parseBoolean(documents);
        bookOnlinePage.sendWithDocuments(sendDocuments);
    }

    @Then("user wants to fill details for parcel")
    public void fillValuesForParcel() {
        bookOnlinePage.inputParcelDetails();
    }

    @When("user clicks add {int} new parcel")
    public void addNewParcels(int numberOfParcels) {
        bookOnlinePage.addNewParcel(numberOfParcels);
    }
}
