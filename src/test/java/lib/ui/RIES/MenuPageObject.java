package lib.ui.RIES;

import io.qameta.allure.Step;
import lib.ui.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

import static lib.ui.RIES.AuthPageObject.LOADER;


public class MenuPageObject extends MainPageObject {
    protected static String
            MENU_TAB = "xpath://*[contains(@text,'Меню')]",
            FEEDBACK_SECTION_BUTTON = "xpath://*[contains(@text,'Обратная связь')]",
            FEEDBACK_TITLE_FIELD = "xpath://*[contains(@text,'Заголовок')]",
            FEEDBACK_DESCRIPTION_FIELD = "xpath://*[contains(@text,'Описание *')]",
            FEEDBACK_TITLE_EDIT_FIELD = "xpath://*[@resource-id='com.riesapp.debug:id/title']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            FEEDBACK_DESCRIPTION_EDIT_FIELD = "xpath://*[@resource-id='com.riesapp.debug:id/description']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            FEEDBACK_ATTACHMENT_BUTTON = "id:com.riesapp.debug:id/addPhotoText",
            FEEDBACK_UPLOAD_FROM_GALLERY = "xpath://*[contains(@text,'Загрузить из галереи')]",
            PERMISSION_ALLOW_BUTTON = "id:com.android.permissioncontroller:id/permission_allow_button", //для теста без допуступа к галерее
            SELECT_PHOTO_TO_UPLOAD = "id:com.google.android.documentsui:id/icon_thumb",
            FEEDBACK_SEND_BUTTON = "id:com.riesapp.debug:id/button",
            FEEDBACK_SENT_SNACK_BAR = "id:com.riesapp.debug:id/snackbarText";

    public MenuPageObject(RemoteWebDriver driver) {
        super(driver);
    }


//    FEEDBACK

    @Step("Wait and click for menu tab")
    public void clickForMenuTab()
    {
        this.waitForElementAndClick(MENU_TAB,"Cannot see and click menu tab",10);
    }

    @Step("Clicking for feedback section")
    public void clickForFeedbackSection()
    {
        this.waitForElementAndClick(FEEDBACK_SECTION_BUTTON,"Cannot see and click feedback section",10);
    }

    @Step("Detecting and filling fields")
    public void enterFeedbackData(String title, String description)
    {
        this.waitForElementAndClick(FEEDBACK_TITLE_FIELD, "Cannot see and click feedback title",10);
        this.waitForElementAndSendKeys(FEEDBACK_TITLE_EDIT_FIELD, title,"Cannot see and send key feedback title",10);
        this.waitForElementAndClick(FEEDBACK_DESCRIPTION_FIELD, "Cannot see and click feedback description",10);
        this.waitForElementAndSendKeys(FEEDBACK_DESCRIPTION_EDIT_FIELD, description,"Cannot see and send key feedback description",10);
    }

    @Step("Adding attachments")
    public void addAttachmentFeedback()
    {
        this.waitForElementAndClick(FEEDBACK_ATTACHMENT_BUTTON,"Cannot see and click attachment button",10);
        this.waitForElementAndClick(FEEDBACK_UPLOAD_FROM_GALLERY,"Cannot see and click download option from gallery",10);
        this.waitForElementAndClick(SELECT_PHOTO_TO_UPLOAD,"Cannot see and click select photo to upload",10);
    }

    @Step("Sending feedback")
    public void clickButtonForSendingFeedback ()
    {
        this.waitForElementAndClick(FEEDBACK_SEND_BUTTON,"Cannot see and click feedback send button",10);
    }

    @Step("Wait passed loader")
    public void waitForLoaderToDisappear()
    {
        this.waitForElementNotPresent(LOADER, "Can see Loader", 10);
        this.waitForElementPresent(MENU_TAB,"Cannot see and click menu tab",10);
    }

    @Step("See snack")
    public void assertIfSnackBarIsThere()
    {
        this.assertElementIsPresent(FEEDBACK_SENT_SNACK_BAR, " Cannot find snackbar succsess");
    }
}
