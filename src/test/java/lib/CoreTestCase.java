package lib;

import io.appium.java_client.remote.SupportsRotation;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase {

    protected RemoteWebDriver driver;

    @BeforeEach
    @Step("Run driver and session")
    public void setUp() throws Exception {

        driver = Platform.getDriver();
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
}