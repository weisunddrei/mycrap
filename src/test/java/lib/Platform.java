package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String APPIUM_ANDROID_URL = "http://0.0.0.0:4723";
    private static final String APPIUM_IOS_URL = "http://0.0.0.0:4723";
    private static Platform instance;

    private Platform(){}

    public static Platform getInstance() {
        if(instance==null){
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL_ANDROID = new URL(APPIUM_ANDROID_URL);
        URL URL_IOS = new URL(APPIUM_IOS_URL);
        if (this.isAndroid()){
            return new AndroidDriver(URL_ANDROID, this.getAndroidDesiredCapabilities());
        }else if (this.isIOS()){
            return new IOSDriver(URL_IOS, this.getIOSDesiredCapabilities());
//        }else if (isMW()){
//            return new ChromeDriver(this.getMWChromeOptions());
        }else throw new Exception("Cannot detect type of the driver. Platform value: " + this.getPlatformVar());
    }

    private ChromeDriverService getMWChromeOptions() {
        return null;
    }

    public boolean isAndroid() {return isPlatform(PLATFORM_ANDROID);}
    public boolean isIOS() {return isPlatform(PLATFORM_IOS);}
    public boolean isMW() { return isPlatform(PLATFORM_MOBILE_WEB);}

    private DesiredCapabilities getAndroidDesiredCapabilities() {
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

    private DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("isHeadless", false);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("connectHardwareKeyboard", true);
        capabilities.setCapability("keyboardType", "invisible");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "16.4");
        capabilities.setCapability("deviceName", "iPhone 14 Pro");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", "\"C:\\Users\\rudol\\apks\\ries-ries-debug.apk\"");
        return capabilities;
    }

    private boolean isPlatform(String my_platform) {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
}
