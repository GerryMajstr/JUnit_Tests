package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingOptionsPage extends BasePage {

    public ShoppingOptionsPage(WebDriver driver) {
        super(driver);
    }

    By expressOption = By.xpath("//a[contains(@href, 'express') and(contains(@class, 'cmp')) and not(contains(@class, 'external'))]");

    public void clickExpressOption() {
    }
}
