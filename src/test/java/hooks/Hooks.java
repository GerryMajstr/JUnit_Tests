package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;
import utils.VideoRecorder;

import java.io.File;
import java.nio.file.Files;

public class Hooks {

    @Before
    public void startVideo() {
        VideoRecorder.startRecording();
    }

    @After
    public void stopVideo() {
        // stop recording
        String videoPath = VideoRecorder.stopRecording();

        try {

            Allure.addAttachment(
                    "Test Video",
                    Files.newInputStream(new File(videoPath).toPath())
            );

        } catch (Exception e) {
            System.out.println("Video attachment failed");
        }
    }


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
