package lib.ui.RIES;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.ArrayList;


public class ObjectPageObject extends MainPageObject {
    protected static String
            OBJECT_STATUS_CHANGE_TPL = "xpath://*[contains(@text,'{objectStatus}')]",
            CODE_OBJECTS = "xpath://*[contains(@text,'Коды объектов')]",
            CODE_OBJECTS_INPUT = "xpath://*[@resource-id='com.riesapp.debug:id/textFieldMainContainer']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']",
            SEARCH_BUTTON = "id:com.riesapp.debug:id/searchButton",
            OBJECT_CARD = "id:com.riesapp.debug:id/objectView",
            ACTION_BUTTON = "id:com.riesapp.debug:id/priceBarButton",
            OBJECT_EDIT_BUTTON = "xpath://*[contains(@text,'Редактировать')]",
            OBJECT_CHARACTERISTIC_BUTTON = "xpath://*[contains(@text,'Характеристики')]",
            OBJECT_STATUS_FILTER = "xpath://*[contains(@text,'Статус')]",
            OBJECT_CONFIRM_BUTTON = "xpath://*[contains(@text,'Понятно')]",
            OBJECT_STATUS_CHANGE = "xpath://*[contains(@text,'Приостановлен')]",
            OBJECT_STATUS_CHANGE_REASON_SUSPENDED = "xpath://*[contains(@text,'Причина')]",
            OBJECT_STATUS_CHANGE_REASON_TPL = "xpath://*[contains(@text,'{objectStatusReason}')]",
            OBJECT_CHARACTERISTIC_DATE_PICKER = "id:com.riesapp.debug:id/textFieldRightItemContainer",
            DATE_PICKER_EDIT_FORMAT_INPUT = "id:com.riesapp.debug:id/mtrl_picker_header_toggle",
            DATE_PICKER_EDIT_DATE = "xpath://*[contains(@class,'android.widget.EditText')]",
            DATE_PICKER_CONFIRM_BUTTON = "id:com.riesapp.debug:id/confirm_button",
            SAVE_BUTTON = "id:com.riesapp.debug:id/saveButton",
            LOADER = "id:com.riesapp.debug:id/loader",
            OBJECT_EDIT_SENT_SNACK_BAR = "id:com.riesapp.debug:id/snackbarText";



    @Step
    public void enterCode() {
        this.waitForElementPresent(CODE_OBJECTS, "Cannot see type code object field", 10);
        this.waitForElementAndClick(CODE_OBJECTS, "Cannot see and click code object field", 10);
        this.waitForElementAndSendKeys(CODE_OBJECTS_INPUT, "4621", "Cannot see and send key code object field", 10);
    }

    @Step
    public void clickSearchButton() {
        this.waitForElementAndClick(SEARCH_BUTTON, "Cannot see and click search button", 10);
    }

    @Step
    public void clickObjectCard() {
        this.waitForElementAndClick(OBJECT_CONFIRM_BUTTON, "Cannot see and click confirm button", 10);
        this.waitForElementAndClick(OBJECT_CARD, "Cannot see and click object card", 10);
    }

    @Step
    public void getEditCharacteristicObject() {
        this.waitForElementAndClick(ACTION_BUTTON, "Cannot see and click action button", 10);
        this.waitForElementAndClick(OBJECT_EDIT_BUTTON, "Cannot see and click edit button", 10);
        this.waitForElementAndClick(OBJECT_CHARACTERISTIC_BUTTON, "Cannot see and click characteristic button", 10);
    }

    @Step
    public void editDatePicker(String targetDate) {
        this.waitForElementAndClick(OBJECT_CHARACTERISTIC_DATE_PICKER, "Cannot see and click object characteristic date picker", 10);
        this.waitForElementAndClick(DATE_PICKER_EDIT_FORMAT_INPUT, "Cannot see and click date picker edit format input", 10);
        this.waitForElementPresent(DATE_PICKER_EDIT_DATE, "Cannot see and click date picker edit date", 10);
        this.waitForElementAndClear(DATE_PICKER_EDIT_DATE, "Cannot see and clear date picker edit date", 10);
        this.waitForElementAndSendKeys(DATE_PICKER_EDIT_DATE, targetDate, "Cannot see and send key date picker edit date", 10);
        this.waitForElementAndClick(DATE_PICKER_CONFIRM_BUTTON, "Cannot see and click  date picker confirm button", 10);
    }

    @Step
    public void clickSaveButton() {
        this.waitForElementAndClick(SAVE_BUTTON, "Cannot see and click save button", 10);
        this.waitForElementNotPresent(LOADER, "Can see Loader", 10);
        this.waitForElementPresent(OBJECT_CHARACTERISTIC_BUTTON, "Cannot see characteristic button", 10);
    }

    @Step
    public void assertElementAfterSave() {
        java.util.List<String> locators = new ArrayList<>();
        locators.add(OBJECT_CHARACTERISTIC_BUTTON);
        locators.add(OBJECT_EDIT_SENT_SNACK_BAR);
        this.getElementsWithDifferentLocators(locators);
    }



    @Step("Change object status")
    public void clickChangeObjectStatus(String objectStatus) {
        String objectStatusXpath = getXpathByObjectStatus(objectStatus);

        this.waitForElementAndClick(OBJECT_STATUS_FILTER, "Cannot see and click object card", 10);
        this.waitForElementPresent(objectStatusXpath, "Cannot see object changes type", 10);
        this.waitForElementAndClick(objectStatusXpath, "Cannot see object Changes Type", 10);
    }

    @Step("Change reason suspended")
    public void clickChangeObjectStatusReason(String objectStatusReason) {
        String objectStatusReasonXpath = getXpathByObjectStatusReason(objectStatusReason);

        this.waitForElementPresent(OBJECT_STATUS_CHANGE_REASON_SUSPENDED, "Cannot see chapter change reason suspended", 10);
        this.waitForElementAndClick(OBJECT_STATUS_CHANGE_REASON_SUSPENDED, "Cannot see and click chapter change reason suspended", 10);
        this.waitForElementPresent(objectStatusReasonXpath, "Cannot see reason suspended", 10);
        this.waitForElementAndClick(objectStatusReasonXpath, "Cannot see and click reason suspended", 10);
    }


    private static String getXpathByObjectStatus(String objectStatus) {
        return OBJECT_STATUS_CHANGE_TPL.replace("{objectStatus}", objectStatus);
    }

    private static String getXpathByObjectStatusReason(String objectStatusReason) {
        return OBJECT_STATUS_CHANGE_REASON_TPL.replace("{objectStatusReason}", objectStatusReason);
    }

    public ObjectPageObject(RemoteWebDriver driver) {super(driver);}

//    public void assertIfBla() {
//        List<String> locators = new ArrayList<>();
//
//        locators.add(OBJECT_TYPE_FILTER);
//        this.getElementsWithDifferentLocators(locators);
//    }

//    f (("Продать".equals(dealsType) || "Сдать".equals(dealsType))
//            && ("Квартира".equals(estateType)
//        || "Пансионат".equals(estateType)
//        || "Малосемейка".equals(estateType)
//        || "Общежитие".equals(estateType)
//        || "Комната".equals(estateType)
//        || "Гостинка".equals(estateType)
//        || "Номер".equals(estateType)
//        || "Апартаменты".equals(estateType)))

//    @Step
//    public String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage, long timeoutInSeconds) {
//        String article_title = waitForElementAndGetAttribute(
//                "xpath://*[contains(@text,'Статус')]",
//                "Активный",
//                "Cannot get current object status",
//                15);
//        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
//        return element.getAttribute(attribute);
//    }

//if ("Активный".equals(article_title)){}
}
