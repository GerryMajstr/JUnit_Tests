package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);
    }
}