package lib.ui.RIES;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TicketPageObject extends MainPageObject {

    protected static String
            TICKET_TAB = "xpath://*[contains(@text,'Заявки')]",
            CREATE_TICKET_BUTTON = "id:com.riesapp.debug:id/ticketsListCreateTicketButton",
            TICKET_PHONE_FIELD = "xpath://*[contains(@text,'Номер телефона')]",
            TICKET_PHONE_FIELD_EDIT = "xpath://*[contains(@text,'Номер телефона *')]/preceding-sibling::*",
            TICKET_CREATE_SAVE_BUTTON = "id:com.riesapp.debug:id/saveButton",
            TICKET_TYPE_OPERATION = "xpath://*[contains(@text,'Тип операции')]",
            TICKET_TYPE_OPERATION_TPL = "xpath://*[contains(@text,'{ticketTypeOperation}')]",
            TICKET_TYPE_OBJECT_TPL = "xpath://*[contains(@text,'{ticketTypeObject}')]",
            TICKET_TYPE_OBJECT = "xpath://*[contains(@text,'Тип недвижимости')]",
            TICKET_CLASS_OBJECT = "xpath://*[contains(@text,'Класс недвижимости')]",
            TICKET_CLASS_OBJECT_TPL = "xpath://*[contains(@text,'{ticketClassObject}')]",
            TICKET_SOURCE_FILTER = "xpath://*[contains(@text,'Откуда узнали')]";


    @Step("Clicking on ticket tab")
    public void clickTicketTab(){
        this.waitForElementAndClick(TICKET_TAB,"Cannot see and click ticket tab",10);
    }

    @Step("Clicking on create ticket button")
    public void clickCreateTicketButton(){
        this.waitForElementAndClick(CREATE_TICKET_BUTTON,"Cannot see and click create ticket button",10);
    }

    @Step("Enter data and move to next screen")
    public void enterTicketData() {
        this.waitForElementAndClick(TICKET_PHONE_FIELD,"Cannot see and click create ticket button",10);
        this.waitForElementAndSendKeys(TICKET_PHONE_FIELD_EDIT,"89827735883","Cannot see and send key create ticket button",10);
        this.waitForElementAndClick(TICKET_CREATE_SAVE_BUTTON,"Cannot see and click save button",10);
        this.waitForElementPresent(TICKET_SOURCE_FILTER, "Cannot see application source", 10);
    }

    @Step("Clicking on save ticket button")
    public void clickSaveTicketButton() {
        this.waitForElementAndClick(TICKET_CREATE_SAVE_BUTTON,"Cannot see and click create save button",10);
    }

    @Step("Assert correct create ticket")
    public void assertCreateTicket () {
        this.waitForElementPresent(TICKET_SOURCE_FILTER, "Cannot see Application Source", 10);
    }

    @Step("Changing the operation type")
    public void changeTicketTypeOperationXpath(String ticketTypeOperation, String ticketTypeObject, String ticketClassObject) {
        String ticketTypeOperationXpath = getXpathByTicketType(ticketTypeOperation);
        String ticketTypeObjectXpath = getXpathByTicketTypeObject(ticketTypeObject);
        String ticketClassObjectXpath = getXpathByTicketClassObject(ticketClassObject);

        this.waitForElementPresent(TICKET_TYPE_OPERATION, "Cannot see and click type operation", 10);
        if ("Продать".equals(ticketTypeOperation)) {
            this.waitForElementAndClick(TICKET_TYPE_OBJECT, "Cannot see and click type object", 10);
            this.waitForElementPresent(ticketTypeObjectXpath, "Cannot see needed option", 10);
            this.waitForElementAndClick(ticketTypeObjectXpath, "Cannot see and click needed option", 10);
        } else if ("Купить".equals(ticketTypeOperation)) {
            this.waitForElementAndClick(TICKET_TYPE_OPERATION, "Cannot see and click type operation", 10);
        this.waitForElementPresent(ticketTypeOperationXpath, "Cannot see needed option", 10);
        this.waitForElementAndClick(ticketTypeOperationXpath, "Cannot see and click needed option", 10);
        this.waitForElementAndClick(TICKET_CLASS_OBJECT, "Cannot see and click class object", 10);
        this.waitForElementPresent(ticketClassObjectXpath, "Cannot see needed option", 10);
        this.waitForElementAndClick(ticketClassObjectXpath, "Cannot see and click needed option", 10);
        }
    }
    private static String getXpathByTicketType(String ticketTypeOperation) {
        return TICKET_TYPE_OPERATION_TPL.replace("{ticketTypeOperation}", ticketTypeOperation);
    }

    @Step("Changing the object type")
    public void changeTicketTypeObjectXpath(String ticketTypeObject) {
        String ticketTypeObjectXpath = getXpathByTicketTypeObject(ticketTypeObject);

        this.waitForElementAndClick(TICKET_TYPE_OBJECT, "Cannot see and click type object", 10);
        this.waitForElementPresent(ticketTypeObjectXpath, "Cannot see needed option", 10);
        this.waitForElementAndClick(ticketTypeObjectXpath, "Cannot see and click needed option", 10);
    }
    private static String getXpathByTicketTypeObject(String ticketTypeObject) {
        return TICKET_TYPE_OBJECT_TPL.replace("{ticketTypeObject}", ticketTypeObject);
    }

    @Step("Changing the object class")
    public void changeTicketClassObjectXpath(String ticketClassObject) {
        String ticketClassObjectXpath = getXpathByTicketClassObject(ticketClassObject);

        this.waitForElementAndClick(TICKET_CLASS_OBJECT, "Cannot see and click class object", 10);
        this.waitForElementPresent(ticketClassObjectXpath, "Cannot see needed option", 10);
        this.waitForElementAndClick(ticketClassObjectXpath, "Cannot see and click needed option", 10);
    }
    private static String getXpathByTicketClassObject(String ticketClassObject) {
        return TICKET_CLASS_OBJECT_TPL.replace("{ticketClassObject}", ticketClassObject);
    }

    public TicketPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
