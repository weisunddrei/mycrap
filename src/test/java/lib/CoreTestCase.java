package lib;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsRotation;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

public class CoreTestCase {

    protected RemoteWebDriver driver;

    @BeforeEach
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
    }

    @AfterEach
    @Step("Run Remove and session")
    public void tearDown() {
        driver.quit();
    }
    protected void rotateScreenLandscape() {
        ((SupportsRotation) driver).rotate(ScreenOrientation.LANDSCAPE);
    }
    @Step("Restore Screen Portrait mode")
    protected void rotateScreenPortrait() {
        ((SupportsRotation) driver).rotate(ScreenOrientation.PORTRAIT);
    }

    @Step("Send mobile app to background (this method does nothing for Mobile Web)")
    protected void BackgroundApp(int durationInSeconds) {
        if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).runAppInBackground(Duration.ofSeconds(3));
        } else {
            System.out.println("Method BackgroundApp does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    @Step("Create Allure Property file")
    private void createAllurePropertyFile(){
        String path = System.getProperty("allure.results.directory");
        File directory = new File(path);
        if (!directory.exists()) {
            System.out.printf("Directory '%s' was not found. \n", path);
            directory.mkdir();
            System.out.printf("Created directory '%s'.\n", path);
        }
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://docs.qameta.io/allure/#_environment");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem while writing allure properties file");
            e.printStackTrace();
        }
    }
}
