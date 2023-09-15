package Tests;

import lib.CoreTestCase;
import org.junit.jupiter.api.Test;
import ui.MainPageObject;

import static Tests.AuthorizationTest.LOGIN_FILED;
import static Tests.AuthorizationTest.LOGIN_FILED_EDIT;

public class FeedbackTest extends CoreTestCase {

    protected static String
            TAB_MENU = "xpath://*[contains(@text,'Меню')]",
            CHAPTER_FEEDBACK = "xpath://*[contains(@text,'Обратная связь')]",
            PASSWORD_FILED = "xpath://*[contains(@text,'Пароль')]",
            PASSWORD_FILED_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            LOGIN_BUTTON = "xpath://*[contains(@text,'Войти')]",
            SEARCH_BUTTON = "xpath://*[@resource-id='com.riesapp.debug:id/searchButton']",
            FIND_CHAPTER_FEEDBACK = "xpath://*[contains(@text,'Обратная связь')]",
            TITLE_FEEDBACK = "xpath://*[contains(@text,'Заголовок *')]",
            DESCRIPTION_FEEDBACK = "xpath://*[contains(@text,'Описание *')]",
            TITLE_FEEDBACK_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/title']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            DESCRIPTION_FEEDBACK_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/description']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            FEEDBACK_BUTTON = "id:com.riesapp.debug:id/button",
            FEEDBACK_SENT = "id:com.riesapp.debug:id/snackbar_text";

    @Test
    public void feedbackTest(){
        MainPageObject Main = new MainPageObject(driver);

//        Авторизация
        Main.waitForElementPresent(LOGIN_FILED,"Cannot see login field",5);
        Main.waitForElementAndClick(LOGIN_FILED,"Cannot see and click login field",3);
        Main.waitForElementAndSendKeys(LOGIN_FILED_EDIT,"18858","Cannot see and send key login field",3);
        Main.waitForElementAndClick(PASSWORD_FILED,"Cannot see and click pass field",3);
        Main.waitForElementAndSendKeys(PASSWORD_FILED_EDIT,"Test20232","Cannot see and send key pass field",5);
        Main.waitForElementAndClick(LOGIN_BUTTON,"Cannot click login button",3);
        Main.waitForElementPresent(SEARCH_BUTTON,"I don't see the button",10);

//        Обратная связь
        Main.waitForElementAndClick(TAB_MENU,"Cannot see and click menu tab",5);
        Main.swipeUpToFindElement(FIND_CHAPTER_FEEDBACK,"Cannot chapter feedback",2);
        Main.waitForElementAndClick(CHAPTER_FEEDBACK,"Cannot see and click chapter feedback",3);
        Main.waitForElementAndClick(TITLE_FEEDBACK,"Cannot see and click feedback title",3);
        Main.waitForElementAndSendKeys(TITLE_FEEDBACK_EDIT,"Привэт, это тест?","Cannot see and send key feedback title",3);
        Main.waitForElementAndClick(DESCRIPTION_FEEDBACK,"Cannot see and click description ",3);
        Main.waitForElementAndSendKeys(DESCRIPTION_FEEDBACK_EDIT,"Дааа, это тест!?","Cannot see and send key feedback description",3);
        Main.waitForElementAndClick(FEEDBACK_BUTTON,"Cannot click feedback button",3);
        Main.waitForElementPresent(FEEDBACK_SENT,"Cannot see the snackbar succsess",10);
    }
}
