package lib.ui.RIES;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import lib.Platform;
import lib.ui.RIES.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class AuthPageObject extends MainPageObject
{

    protected static String
            LOGIN_FIELD_EDIT,
            PASSWORD_FIELD_EDIT,
            LOADER,
            LOGIN_BUTTON,
            LOGIN_FIELD,
            MY_OBJECTS_SWITCHER,
            NOTIFICATION_DIALOGUE_ALLOW,
            NOTIFICATION_DIALOGUE_FOLLOW_ACTIVITY_ACCEPT,
            PASSWORD_FILED,
            RIES_LOGO,
            SNACK_BAR,
            SYNC_CATALOGS_SCREEN,
            SYSTEM_ERROR_ALERT,
            TITLE_SEARCH_IN_TOPBAR,
            USER_BLOCKED_DIALOG,
            WRONG_LOGIN_OR_PASSWORD_SNACK_BAR;

    public AuthPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Skipping IOS security dialogues and waiting for login button")
    public void waitForLoginButton() {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot see Login button", 10);
    }

    @Step("Clicking Log in button")
    public void clickLOGINButton() {
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click LOGIN button", 5);
        this.waitForElementNotPresent(LOADER, "Can see Loader", 5);
    }

    @Step("Waiting for loader to disappear")
    public void waitForLoaderToDisappear() {
        this.waitForElementNotPresent(LOADER, "Can see Loader", 10);
        if (Platform.getInstance().isIOS()) {
            this.waitForElementNotPresent(SYNC_CATALOGS_SCREEN, "Synchronization is still going", 5);}
    }

    @Step("Checking if it's screen correct screen")
    public void assertIfBlockIsThere() {
        if (Platform.getInstance().isIOS()) {this.waitForElementPresent(TITLE_SEARCH_IN_TOPBAR, " Cannot see the title Search in the top-bar",10);
        }else {
            this.assertElementIsPresent(MY_OBJECTS_SWITCHER, " Cannot find My objects");}
    }

    @Step("Checking if it's screen correct screen")
    public void assertIfUserBlocked() {
        this.waitForElementPresent(USER_BLOCKED_DIALOG, "Cannot see User is blocked dialogue");
        this.assertElementIsPresent(USER_BLOCKED_DIALOG, "Cannot see User is blocked dialogue");
    }

    @Step("Checking if it's screen correct screen")
    public void assertIfSnackBarIsThere() {
        this.assertElementIsPresent(SNACK_BAR, " Cannot find My objects");
    }

    @Step("Checking if it's screen correct screen")
    public void assertWrongLoginOrPasswordSnackBarIsThere() {
        this.waitForElementPresent(WRONG_LOGIN_OR_PASSWORD_SNACK_BAR, "Cannot see Wrong Login or Password Snack bar",3);
        this.assertElementIsPresent(WRONG_LOGIN_OR_PASSWORD_SNACK_BAR, " Cannot see Wrong Login or Password Snack bar");
    }

    @Step("Checking if it's screen correct screen")
    public void assertIfSnackBarOrAlertIsThere() {
        boolean isSnackBarPresent = true;
        try  {
            this.assertElementIsPresent(SNACK_BAR, "Cannot find My Snack Bar");
        } catch (Exception e) {
            // Handle the exception or log the error if the Snackbar element is not found.
            System.out.println("Snackbar not found: " + e.getMessage());
            isSnackBarPresent = false;
        }

        if (!isSnackBarPresent) {
            try  {
                this.assertElementIsPresent(MY_OBJECTS_SWITCHER, "Cannot find My objects");
            } catch (Exception e) {
                // Handle the exception or log the error if the MY_OBJECTS_SWITCHER element is not found.
                System.out.println("My objects switcher not found: " + e.getMessage());
                throw new AssertionError("Both assertions failed.");
            }
        }
    }

    @Step("Entering Login and password")
    public void enterLoginData(String login, String password) {
        this.waitForElementPresent(LOGIN_FIELD, "Cannot see login field");
        this.waitForElementAndClick(LOGIN_FIELD, "Cannot see and click login filed", 2);
        this.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, login, "Cannot see and send Login", 5);
        this.waitForElementPresent(PASSWORD_FILED, "Cannot see password field");
        this.waitForElementAndClick(PASSWORD_FILED, "Cannot see and click password field", 2);
        this.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, password, "Cannot see and send password", 5);
    }

    @Step("Disabling WiFi for 5 seconds and turning it back on")
    public void disableWiFI() throws InterruptedException {
        this.disableWifi();
        Thread.sleep(5000);
        this.enableWifi();
        Thread.sleep(5000);
    }

    @Step("Entering Login and password")
    public void authLogin130522(String login, String password) {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot see Login button", 10);
        this.waitForElementPresent(LOGIN_FIELD, "Cannot find login field");
        this.waitForElementAndClick(LOGIN_FIELD, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, login, "Cannot find and put Login", 5);
        this.waitForElementPresent(PASSWORD_FILED, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(PASSWORD_FILED, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, password, "Cannot find and put password", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click LOGIN button", 5);
        this.waitForElementNotPresent(LOADER, "Can see Loader", 5);
        this.waitForElementNotPresent(LOADER, "Can see Loader", 10);
        if (Platform.getInstance().isIOS()) {
            this.waitForElementNotPresent(SYNC_CATALOGS_SCREEN, "Synchronization is still going", 5);}
        if (Platform.getInstance().isIOS()) {this.waitForElementPresent(TITLE_SEARCH_IN_TOPBAR, "Cannot see the title Search in the top-bar",10);
        }else {
            this.assertElementIsPresent(MY_OBJECTS_SWITCHER, "Cannot find My objects");}
    }

    @Step("Send mobile app to background")
    public void setAppToBackground(int durationInSeconds) {
        if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).runAppInBackground(Duration.ofSeconds(3));
        } else if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(3));
        } else {
            System.out.println("Method setAppToBackground does nothing for platform " + Platform.getInstance().getPlatformVar());}
    }
}
