package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class Hooks {
//    @After
//    public void tearDown() {
//        DriverFactory.quitDriver();
//    }

    @After
    public void takeScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot =
                    ((TakesScreenshot) DriverFactory.getDriver())
                            .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        DriverFactory.quitDriver();
    }
}
