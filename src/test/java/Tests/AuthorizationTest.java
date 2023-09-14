package Tests;

import lib.CoreTestCase;
import org.junit.jupiter.api.Test;
import ui.MainPageObject;

public class AuthorizationTest extends CoreTestCase {

    protected static String
            LOGIN_FILED = "xpath://*[contains(@text,'Логин')]",
            LOGIN_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            PASSWORD_FILED = "xpath://*[contains(@text,'Пароль')]",
            PASSWORD_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
            SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']";

    @Test
    public void authTest(){
        MainPageObject Main = new MainPageObject(driver);

        Main.waitForElementPresent(LOGIN_FILED,"Cannot see login field",5);
        Main.waitForElementAndClick(LOGIN_FILED,"Cannot see and click login field",3);
        Main.waitForElementAndSendKeys(LOGIN_FILED_EDIT,"18858","Cannot see and send key login field",3);
        Main.waitForElementAndClick(PASSWORD_FILED,"Cannot see and click pass field",3);
        Main.waitForElementAndSendKeys(PASSWORD_FILED_EDIT,"Test20232","Cannot see and send key pass field",5);
        Main.waitForElementAndClick(LOGIN_BUTTON,"Cannot click login button",3);
        Main.waitForElementPresent(SEARCH_BUTTON,"I don't see the button",5);
    }
}

