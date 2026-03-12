package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        driver.get("https://automationintesting.com/selenium/testpage/");

        LoginPage login = new LoginPage(driver);

        login.enterFirstName("testuser");
        login.enterSurName("password123");
        //login.clickLogin();
    }
}