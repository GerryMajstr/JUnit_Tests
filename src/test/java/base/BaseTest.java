package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}