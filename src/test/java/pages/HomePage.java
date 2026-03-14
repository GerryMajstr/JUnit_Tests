package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By trackingId = By.name("tracking-id");
    By trackButton = By.cssSelector("button[type='submit']");
    By acceptCookie = By.id("onetrust-accept-btn-handler");

    public void enterTrackingId(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(trackingId)).sendKeys(id);
        System.out.println("Entering tracking ID: " + id);
    }

    public void submitTrackingId() {
        wait.until(ExpectedConditions.elementToBeClickable(trackButton)).click();
    }

    public void acceptCookies() {

        driver.get("https://www.dhl.com/cz-cs/home.html");
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookie)).click();
    }
}