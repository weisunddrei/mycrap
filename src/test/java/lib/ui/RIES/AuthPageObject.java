package lib.ui.RIES;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthPageObject extends MainPageObject {
    protected static String
            LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]",
            LOGIN_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            PASSWORD_FIELD = "xpath://*[contains(@text,'Пароль')]",
            PASSWORD_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
            LOADER = "id:com.riesapp.debug:id/loader",
            SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']";
    public AuthPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    @Step("Waiting for login button")
    public void waitForLoginButton()
    {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot see Login button", 10);
    }

    @Step("Clicking Log in button")
    public void clickLOGINButton()
    {
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click LOGIN button", 5);
        this.waitForElementNotPresent(LOADER, "Can see Loader", 5);
    }

    @Step("Waiting for loader to disappear")
    public void waitForLoaderToDisappear()
    {
        this.waitForElementNotPresent(LOADER, "Can see Loader", 10);
    }

    @Step("Checking if it's screen correct screen")
    public void assertElementIsPresent()
    {
        this.assertElementIsPresent(SEARCH_BUTTON, " Cannot find SEARCH_BUTTON");
    }

    @Step("Entering login")
    public void enterRIESLogin()
    {
        this.waitForElementPresent(LOGIN_FIELD, "Cannot find search input after clicking search init element",5);
        this.waitForElementAndClick(LOGIN_FIELD, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, "18858", "Cannot see and send login", 5);
    }

    @Step("Entering password")
    public void enterRIESPassword()
    {
        this.waitForElementPresent(PASSWORD_FIELD, "Cannot find search input after clicking search init element", 3);
        this.waitForElementAndClick(PASSWORD_FIELD, "Cannot find and click search init element", 3);
        this.waitForElementPresent(PASSWORD_FIELD_EDIT, "Cannot find search input after clicking search init element", 3);
        this.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, "Test20232", "Cannot see and send login", 3);
    }

    @Step("Entering Login and password")
    public void enterLoginData(String login, String password)
    {
        this.waitForElementPresent(LOGIN_FIELD, "Cannot find login field",3);
        this.waitForElementAndClick(LOGIN_FIELD, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, login, "Cannot find and put Login", 5);
        this.waitForElementPresent(PASSWORD_FIELD, "Cannot find search input after clicking search init element",3);
        this.waitForElementAndClick(PASSWORD_FIELD, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, password, "Cannot find and put password", 5);
    }

    @Step("Entering Login and password")
    public void authLogin18858(String login, String password)
    {
        this.waitForElementPresent(LOGIN_BUTTON, "Cannot see Login button", 10);
        this.waitForElementPresent(LOGIN_FIELD, "Cannot find login field",5);
        this.waitForElementAndClick(LOGIN_FIELD, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(LOGIN_FIELD_EDIT, login, "Cannot find and put Login", 5);
        this.waitForElementPresent(PASSWORD_FIELD, "Cannot find search input after clicking search init element",3);
        this.waitForElementAndClick(PASSWORD_FIELD, "Cannot find and click search init element", 2);
        this.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT, password, "Cannot find and put password", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click LOGIN button", 5);
        this.waitForElementNotPresent(LOADER, "Can see Loader", 10);
//        this.assertElementIsPresent(SEARCH_BUTTON, "Cannot find SEARCH_BUTTON");
    }
}
