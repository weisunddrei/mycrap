package Tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.jupiter.api.Test;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.RIES.AuthPageObject;
import lib.ui.MainPageObject;

import static Tests.AuthorizationTest.*;
import static Tests.FeedbackTest.MENU_TAB;

public class PhonebookTest extends CoreTestCase{
    public static final String
            login = "130522",
            password = "99679218Aa",
            PHONEBOOK_SECTION_BUTTON = "xpath://*[contains(@text,'Телефонный справочник')]",
            PHONEBOOK_FIELD = "id:com.riesapp.debug:id/textFieldEditText",
            PHONEBOOK_FIELD_EDIT = "id:com.riesapp.debug:id/topBarSearchEditText",
            PHONEBOOK_FIELD_CLEAR = "id:com.riesapp.debug:id/topBarSearchEditText",
            PHONEBOOK_SPECIALIST_CARD = "xpath://*[contains(@text,'18850')]";
//            PHONEBOOK_SSPECIALIST_OBJECTS_BUTTON =
    @Test
    public void PhonebookTest() throws InterruptedException {
        MainPageObject Main = new MainPageObject(driver);
        AuthorizationTest Auth = new AuthorizationTest();
//        public void authLogin18858(login, password)

//        Авторизация
//        Main.waitForElementPresent(LOGIN_FIELD,"Cannot see login field",10);
//        Main.waitForElementAndClick(LOGIN_FIELD,"Cannot see and click login field",3);
//        Main.waitForElementAndSendKeys(LOGIN_FIELD_EDIT,"18858","Cannot see and send key login field",3);
//        Main.waitForElementAndClick(PASSWORD_FIELD,"Cannot see and click pass field",3);
//        Main.waitForElementAndSendKeys(PASSWORD_FIELD_EDIT,"Test20232","Cannot see and send key pass field",5);
//        Main.waitForElementAndClick(LOGIN_BUTTON,"Cannot click login button",5);

//        Телефонный справочник
        Main.waitForElementAndClick(MENU_TAB,"Cannot see and click menu tab",5);
        Main.waitForElementAndClick(PHONEBOOK_SECTION_BUTTON,"Cannot see and click login field",3);
        Main.waitForElementAndClick(PHONEBOOK_FIELD,"Cannot see and click login field",3);
        Main.waitForElementAndSendKeys(PHONEBOOK_FIELD_EDIT,"2120","Cannot see and send key pass field",5);
        Thread.sleep(4000);
        Main.waitForElementAndClear(PHONEBOOK_FIELD_CLEAR,"dsf",2);
        Main.waitForElementAndSendKeys(PHONEBOOK_FIELD_EDIT,"18858","Cannot see and send key pass field",5);
        Main.waitForElementAndClick(PHONEBOOK_SPECIALIST_CARD,"Cannot see and click login field",3);
//        Main.waitForElementAndClick(PHONEBOOK_SSPECIALIST_OBJECTS_BUTTON,"Cannot see and click login field",3);
//        id:com.riesapp.debug:id/cellLeftItemV2
//                2969
//        com.riesapp.debug:id/topBarNavigationIcon
//
//        Main.swipeUpToFindElement(FEEDBACK_SECTION,"Cannot see feedback section",1);
//

//        Main.waitForElementPresent(PHONEBOOK_CARD_,"Cannot see login field",10);

    }
}
