package lib;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class Platform {
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_ANDROID_URL = "http://0.0.0.0:4723";
    private static Platform instance;
    protected RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL("http://0.0.0.0:4723");
        return new AndroidDriver(URL, getAndroidDesiredCapabilities());
    }

    private static DesiredCapabilities getAndroidDesiredCapabilities() {
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

    private boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar() {
        return System.getenv("PLATFORM");
    }
}
