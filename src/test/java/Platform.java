import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.SupportsRotation;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.constant.Constable;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class Platform {
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_ANDROID_URL = "http://0.0.0.0:4723";
    private static Platform instance;
    protected RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL("http://0.0.0.0:4723");
        return new AndroidDriver(URL, getAndroidDesiredCapabilities());
    }

    private static DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Api33");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.riesapp.debug");
        capabilities.setCapability("appActivity", "com.riesapp.features.root.RootActivity");
        capabilities.setCapability("app", "C:\\Users\\rudol\\apks\\ries-ries-debug.apk");
        return capabilities;
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }
    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

    @BeforeEach
    public void setUp() throws Exception { driver = getDriver(); }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void goTest () throws InterruptedException {
//        Thread.sleep(10000);
//        WebElement loginField = driver.findElement(By.xpath("//*[contains(@text,'Логин')]"));
//        loginField.click();
//        WebElement loginFieldEdit = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']"));
//        loginFieldEdit.sendKeys("18858");
//        WebElement passwordField = driver.findElement(By.xpath("//*[contains(@text,'Пароль')]"));
//        passwordField.click();
//        WebElement passwordFieldEdit = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']"));
//        passwordFieldEdit.sendKeys("Test20232");
//        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@text,'Войти')]"));
//        enterButton.click();
//        Thread.sleep(5000);
//        WebElement tabTicket = driver.findElement(By.xpath("//*[contains(@text,'Заявки')]"));
//        tabTicket.click();
//        WebElement tapFiltr = driver.findElement(By.xpath("//*com.riesapp.debug:id/cellTextFirstV2"));

    }
}
