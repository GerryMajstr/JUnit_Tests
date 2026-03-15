package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookOnlinePage extends BasePage{

    public BookOnlinePage(WebDriver driver) {
        super(driver);
    }

    By destinationCountry = By.id("destinationCountry");
    By continueButton = By.cssSelector("button[type='submit']");
    By withDocuments = By.xpath("//input[@id='shipmentType-documents']");
    By withoutDocuments = By.xpath("//input[@id='shipmentType-non-documents']");
    By weight = By.id("weight-0");
    By length = By.id("length-0");
    By width = By.id("width-0");
    By height = By.id("height-0");
    By quantity = By.id("quantity-0");
    By addItem = By.name("addItem");

    public void selectDestinationCountry() {
        wait.until(ExpectedConditions.elementToBeClickable(destinationCountry)).sendKeys("Ceska Republika");
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void sendWithDocuments(boolean document) {
        By locator = document ? withDocuments : withoutDocuments;

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        js.executeScript("arguments[0].click();", element);
    }

    public void fillParcelDetails(String value, By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(selector)).sendKeys(value);
    }

    public void inputParcelDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(weight));
        fillParcelDetails("200", weight);
        fillParcelDetails("150", length);
        fillParcelDetails("100", height);
        fillParcelDetails("50", width);
        fillParcelDetails("5", quantity);
    }

    public void addNewParcel(int numberOfParcels) {
        for (int i = 1; i <= numberOfParcels; i++) {
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(addItem));
            scrollToElement(button, -200, 300);
            button.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weight-" + i)));
        }
    }
}
