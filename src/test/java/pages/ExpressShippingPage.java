package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.FileReader;
import utils.User;

import java.util.List;

public class ExpressShippingPage extends BasePage{

    public ExpressShippingPage(WebDriver driver) {
        super(driver);
    }
    List<User> users = FileReader.getUsers();

    By shipNow = By.xpath("//a[@data-testid= 'btn-ship-now']");
    By openAccount = By.xpath("//a[@data-testid= 'btn-open-an-account']");
    By callback = By.xpath("//button[@data-testid= 'btn-schedule-callback']");
    By callbackCompany = By.xpath("//input[@data-testid= 'company']");
    By callbackAddress = By.xpath("//input[@data-testid= 'address']");
    By callbackZip = By.xpath("//input[@data-testid= 'zip']");
    By callbackCity = By.xpath("//input[@data-testid= 'city']");
    By callbackPhone = By.xpath("//input[@data-testid= 'phoneNumber']");
    By callbackEmail = By.xpath("//input[@data-testid= 'email']");
    By callbackFirstName = By.xpath("//input[@data-testid= 'firstName']");
    By callbackLastName = By.xpath("//input[@data-testid= 'lastName']");
    By callbackComments = By.xpath("//textarea[@data-testid= 'comments']");
    By requirements = By.xpath("//div[@data-testid= 'required-instructions']");

    public void verifyMainLinks() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shipNow)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(openAccount)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(callback)).isDisplayed();
    }

    public void clickShipNow() {
        wait.until(ExpectedConditions.elementToBeClickable(shipNow)).click();
    }

    public void clickOpenAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(openAccount)).click();
    }

    public void clickCallback() {
        WebElement callbackElement = wait.until(ExpectedConditions.elementToBeClickable(callback));
        scrollToElement(callbackElement, -300, 500);
        callbackElement.click();
    }

    public void fillCallbackForm(int userIndex) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(requirements));
        wait.until(ExpectedConditions.elementToBeClickable(callbackCompany)).sendKeys(users.get(userIndex).getCompany());
        wait.until(ExpectedConditions.elementToBeClickable(callbackAddress)).sendKeys(users.get(userIndex).getAddress());
        wait.until(ExpectedConditions.elementToBeClickable(callbackCity)).sendKeys(users.get(userIndex).getCity());
        wait.until(ExpectedConditions.elementToBeClickable(callbackPhone)).sendKeys(users.get(userIndex).getPhone());
        wait.until(ExpectedConditions.elementToBeClickable(callbackEmail)).sendKeys(users.get(userIndex).getEmail());
        wait.until(ExpectedConditions.elementToBeClickable(callbackFirstName)).sendKeys(users.get(userIndex).getFirstName());
        wait.until(ExpectedConditions.elementToBeClickable(callbackLastName)).sendKeys(users.get(userIndex).getLastName());
        wait.until(ExpectedConditions.elementToBeClickable(callbackComments)).sendKeys(users.get(userIndex).getComments());
        wait.until(ExpectedConditions.elementToBeClickable(callbackZip)).sendKeys(users.get(userIndex).getZip());
    }
}
