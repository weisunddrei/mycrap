package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.RIES.AuthPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AuthorizationTest extends CoreTestCase {
    public static final String
            login = "18858",
            password = "Test20232";

    @Test
    @Features(value = {@Feature(value = "Auth")})
    @DisplayName("Authorization with active 18858 account")
    @Description("Logging in with the 18858 account using login and password")
    @Step("Starting test ID 1 'testActiveAccount'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testActiveAccount() {
        AuthPageObject Auth = new AuthPageObject(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertElementIsPresent();
    }

//    protected static String
//            LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]",
//            LOGIN_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
//            PASSWORD_FIELD = "xpath://*[contains(@text,'Пароль')]",
//            PASSWORD_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
//            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
//            SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']";
//
//    @Test
//    public void authTest(){
//        MainPageObject Main = new MainPageObject(driver);
//
//        Main.waitForElementPresent(LOGIN_FIELD,"Cannot see login field",5);
//        Main.waitForElementAndClick(LOGIN_FIELD,"Cannot see and click login field",3);
//        Main.waitForElementAndSendKeys(LOGIN_FIELD_EDIT,"18858","Cannot see and send key login field",3);
//        Main.waitForElementAndClick(PASSWORD_FIELD,"Cannot see and click pass field",3);
//        Main.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT,"Test20232","Cannot see and send key pass field",5);
//        Main.waitForElementAndClick(LOGIN_BUTTON,"Cannot click login button",3);
//        Main.waitForElementPresent(SEARCH_BUTTON,"I don't see the button",5);
//    }
}

