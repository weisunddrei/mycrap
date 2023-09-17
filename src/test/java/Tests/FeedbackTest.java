package Tests;

import lib.CoreTestCase;
import org.junit.jupiter.api.Test;
import ui.MainPageObject;

import static Tests.AuthorizationTest.*;

public class FeedbackTest extends CoreTestCase {

    protected static String
            MENU_TAB = "xpath://*[contains(@text,'Меню')]",
            FEEDBACK_SECTION_BUTTON = "xpath://*[contains(@text,'Обратная связь')]",
            FEEDBACK_SECTION = "xpath://*[contains(@text,'Обратная связь')]",
            FEEDBACK_TITLE = "xpath://*[contains(@text,'Заголовок')]",
            FEEDBACK_DESCRIPTION = "xpath://*[contains(@text,'Описание *')]",
            FEEDBACK_TITLE_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/title']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            FEEDBACK_DESCRIPTION_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/description']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            FEEDBACK_ATTACHMENT_BUTTON = "id:com.riesapp.debug:id/addPhotoText",
            FEEDBACK_DOWNLOAD_FROM_GALARY = "xpath://*[contains(@text,'Загрузить из галереи')]",
            PERMISSION_ALLOW_BUTTON = "id:com.android.permissioncontroller:id/permission_allow_button",
            SELECT_PHOTO_TO_UPLOAD = "id:com.google.android.documentsui:id/icon_thumb",
            FEEDBACK_SEND_BUTTON = "id:com.riesapp.debug:id/button",
            FEEDBACK_SENT_SNACK_BAR = "id:com.riesapp.debug:id/snackbar_text";

    @Test
    public void feedbackTest(){
        MainPageObject Main = new MainPageObject(driver);

//        Авторизация
        Main.waitForElementPresent(LOGIN_FILED,"Cannot see login field",7);
        Main.waitForElementAndClick(LOGIN_FILED,"Cannot see and click login field",3);
        Main.waitForElementAndSendKeys(LOGIN_FILED_EDIT,"18858","Cannot see and send key login field",3);
        Main.waitForElementAndClick(PASSWORD_FILED,"Cannot see and click pass field",3);
        Main.waitForElementAndSendKeys(PASSWORD_FILED_EDIT,"Test20232","Cannot see and send key pass field",5);
        Main.waitForElementAndClick(LOGIN_BUTTON,"Cannot click login button",5);

//        Обратная связь
        Main.waitForElementAndClick(MENU_TAB,"Cannot see and click menu tab",5);
        Main.swipeUpToFindElement(FEEDBACK_SECTION,"Cannot see feedback section",1);
        Main.waitForElementAndClick(FEEDBACK_SECTION_BUTTON,"Cannot see and click feedback section button",3);
        Main.waitForElementAndClick(FEEDBACK_TITLE,"Cannot see and click feedback title",3);
        Main.waitForElementAndSendKeys(FEEDBACK_TITLE_EDIT,"Привэт, это тест?","Cannot see and send key feedback title",3);
        Main.waitForElementAndClick(FEEDBACK_DESCRIPTION,"Cannot see and click feedback description ",3);
        Main.waitForElementAndSendKeys(FEEDBACK_DESCRIPTION_EDIT,"Дааа, это тест!?","Cannot see and send key feedback description",3);
        Main.waitForElementAndClick(FEEDBACK_ATTACHMENT_BUTTON,"Cannot see and click attachment button",3);
        Main.waitForElementAndClick(FEEDBACK_DOWNLOAD_FROM_GALARY,"Cannot see and click download option from gallery",3);
//        Main.waitForElementAndClick(PERMISSION_ALLOW_BUTTON,"Cannot see and click permission_allow_button",3); // если нет разрешения на доступ к медиатеке
        Main.waitForElementAndClick(SELECT_PHOTO_TO_UPLOAD,"Cannot see and click select photo to upload",3);
        Main.waitForElementAndClick(FEEDBACK_SEND_BUTTON,"Cannot see and click feedback send button",5);
        Main.waitForElementPresent(FEEDBACK_SENT_SNACK_BAR,"Cannot see the snackbar succsess",10);
    }
}
