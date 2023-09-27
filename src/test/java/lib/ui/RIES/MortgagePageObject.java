package lib.ui.RIES;

import org.openqa.selenium.remote.RemoteWebDriver;

public class MortgagePageObject extends MainPageObject {

    public MortgagePageObject(RemoteWebDriver driver) {
        super(driver);
    }

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

}
