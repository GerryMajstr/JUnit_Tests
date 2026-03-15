package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(Exception.class);
    }

    protected void scrollToElement(WebElement element) {
        scrollToElement(element, 0, 0);
    }

    protected void scrollToElement(WebElement element, int yOffset, long pauseMillis) {
        js.executeScript("arguments[0].scrollIntoView({block: 'start', inline: 'nearest'});", element);
        pause(pauseMillis);

        if (yOffset != 0) {
            js.executeScript("window.scrollBy(0, arguments[0]);", yOffset);
            pause(pauseMillis);
        }
    }

    protected WebElement scrollToClickableElement(By locator, int yOffset, long pauseMillis) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollToElement(element, yOffset, pauseMillis);
        return element;
    }

    protected void pause(long millis) {
        if (millis <= 0) {
            return;
        }

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for scroll to settle.", e);
        }
    }
}
