package Tests;

import lib.CoreTestCase;
import org.junit.jupiter.api.Test;
import lib.ui.MainPageObject;

public class AuthorizationTest extends CoreTestCase {

    protected static String
            LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]",
            LOGIN_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            PASSWORD_FIELD = "xpath://*[contains(@text,'Пароль')]",
            PASSWORD_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
            SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']";

    @Test
    public void authTest(){
        MainPageObject Main = new MainPageObject(driver);

        Main.waitForElementPresent(LOGIN_FIELD,"Cannot see login field",5);
        Main.waitForElementAndClick(LOGIN_FIELD,"Cannot see and click login field",3);
        Main.waitForElementAndSendKeys(LOGIN_FIELD_EDIT,"18858","Cannot see and send key login field",3);
        Main.waitForElementAndClick(PASSWORD_FIELD,"Cannot see and click pass field",3);
        Main.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT,"Test20232","Cannot see and send key pass field",5);
        Main.waitForElementAndClick(LOGIN_BUTTON,"Cannot click login button",3);
        Main.waitForElementPresent(SEARCH_BUTTON,"I don't see the button",5);
    }
}

