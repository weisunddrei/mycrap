package lib.ui.RIES;

import Tests.MortgageCalculatorTest;
import io.qameta.allure.Step;
import lib.ui.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

import static lib.ui.RIES.AuthPageObject.LOADER;


public class MenuPageObject extends MainPageObject {
    protected static String
            MENU_TAB = "xpath://*[contains(@text,'Меню')]",
            LOADER = "id:com.riesapp.debug:id/loader",
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
            FEEDBACK_SENT_SNACK_BAR = "id:com.riesapp.debug:id/snackbarText",
            MORTGAGE_SECTION_BUTTON = "xpath://*[contains(@text,'Калькулятор ипотеки')]",
            MORTGAGE_TYPE_OBJECT_TPL = "xpath://*[contains(@text,'{objectType}')]",
            MORTGAGE_TYPE_OBJECT_FILTER = "xpath://*[contains(@text,'Тип недвижимости')]",
            MORTGAGE_SHOW_BUTTON = "id:com.riesapp.debug:id/show_programs_button",
            FILTER_BUTTON = "xpath://*[contains(@text,'Фильтр')]";


    public MenuPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    @Step("Wait and click for menu tab")
    public void clickForMenuTab()
    {
        this.waitForElementAndClick(MENU_TAB,"Cannot see and click menu tab",10);
    }


    //   MortgageCalculator


    @Step("Clicking for mortgage section")
    public void clickForMortgageSection() {
        this.waitForElementAndClick(MORTGAGE_SECTION_BUTTON,"Cannot see and click mortgage section",10);
    }

    @Step("Clicking for mortgage object filter")
    public void clickMortgageObjectType(String mortgageObjectType) {
        String mortgageObjectTypeXpath = getXpathByMortgageObjectType(mortgageObjectType);

        this.waitForElementPresent(MORTGAGE_TYPE_OBJECT_FILTER, "Cannot see type object filter", 10);
        this.waitForElementAndClick(MORTGAGE_TYPE_OBJECT_FILTER, "Cannot see and click type object filter", 10);
    }

    @Step("Clicking for mortgage object changes type")
    public void clickChangeObjectType(String mortgageChangeObjectType) {
        String mortgageObjectTypeXpath = getXpathByMortgageObjectType(mortgageChangeObjectType);

        this.waitForElementPresent(mortgageObjectTypeXpath, "Cannot see object changes type", 10);
        this.waitForElementAndClick(mortgageObjectTypeXpath, "Cannot see object Changes Type", 10);
    }

    @Step("Assert for mortgage object changes type")
    public void assertIfTypeObjectChange(String mortgageChangeObjectType){
        String mortgageObjectTypeXpath = getXpathByMortgageObjectType(mortgageChangeObjectType);

        this.waitForElementPresent(mortgageObjectTypeXpath, "Cannot see object changes type", 10);
        this.assertElementIsPresent(mortgageObjectTypeXpath, "Cannot see object Changes Type");
    }

    @Step("Clicking for mortgage object show button")
    public void clickMortgageShowButton() {
        this.waitForElementAndClick(MORTGAGE_SHOW_BUTTON,"Cannot see and click mortgage show button",10);
    }

    @Step("Assert for show loader and filter button")
    public void assertShowFilterButton() {
        this.waitForElementNotPresent(LOADER,"Can see Loader",10);
        this.assertElementIsPresent(FILTER_BUTTON,"Cannot see Filter Button");
    }

    private static String getXpathByMortgageObjectType(String mortgageObjectType) {
        return MORTGAGE_TYPE_OBJECT_TPL.replace("{objectType}", mortgageObjectType);
    }


//    Feedback


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

    @Step("See snack")
    public void assertIfSendButtonIsVisible()
    {
        this.assertElementIsPresent(FEEDBACK_SEND_BUTTON, "Can see Button");
    }


}
