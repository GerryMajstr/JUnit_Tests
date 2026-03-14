package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    By searchResults = By.cssSelector("[class*='tracking-result'][class*='visible']");
    By searchResultId = By.cssSelector("[class*='tracking-result'][class*='code']:not([class*='status']) strong");
    By searchTimer = By.id("sec-ch-ctdn-timer");

    public void waitForPopupToDisappear() {
        try {
            wait.until(d -> {
                List<WebElement> elements = d.findElements(searchTimer);
                return elements.isEmpty() ? null : elements.get(0);
            });

            System.out.println("Popup appeared");

            wait.until(d -> d.findElements(searchTimer).isEmpty());

            System.out.println("Popup disappeared");

        } catch (TimeoutException e) {
            System.out.println("Popup never appeared");
        }
    }
    public String getSearchResultId() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultId)).getText();
    }

    public void verifySearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
    }
}
