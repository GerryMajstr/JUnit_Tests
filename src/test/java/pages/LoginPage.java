package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstname = By.id("firstname");
    By surname = By.id("surname");
    //By loginBtn = By.id("login");

    public void enterFirstName(String user) {
        driver.findElement(firstname).sendKeys(user);
    }

    public void enterSurName(String pass) {
        driver.findElement(surname).sendKeys(pass);
    }

//    public void clickLogin() {
//        driver.findElement(loginBtn).click();
//    }
}