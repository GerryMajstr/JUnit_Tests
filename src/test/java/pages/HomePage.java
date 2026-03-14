package pages;

import org.openqa.selenium.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    By trackingId = By.name("tracking-id");
    By trackButton = By.cssSelector("button[type='submit']");

    public void enterTrackingId(String id) {
        driver.findElement(trackingId).sendKeys(id);
        System.out.println("Entering tracking ID: " + id);
    }

    public void submitTrackingId() {
        driver.findElement(trackButton).click();
    }

    public void acceptCookies() {

        driver.get("https://www.dhl.com/cz-cs/home.html");

        driver.manage().addCookie(
                new Cookie("OptanonConsent", "isIABGlobal=false")
        );

        driver.manage().addCookie(
                new Cookie("OptanonAlertBoxClosed", "true")
        );

        driver.navigate().refresh();
    }
}