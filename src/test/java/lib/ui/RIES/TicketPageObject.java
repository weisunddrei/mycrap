package lib.ui.RIES;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TicketPageObject extends MainPageObject {

    protected static String
            TICKET_TAB = "xpath://*[contains(@text,'Заявки')]",
            CREATE_TICKET_BUTTON = "id:com.riesapp.debug:id/ticketsListCreateTicketButton",
            CREATE_INNER_TICKET_BUTTON = "id:com.riesapp.debug:id/createTicketButton",
            TICKET_PHONE_FIELD = "xpath://*[contains(@text,'Номер телефона')]",
            TICKET_NAME_FIELD = "xpath://*[contains(@text,'Имя')]",
            TICKET_PHONE_FIELD_EDIT = "xpath://*[contains(@text,'Номер телефона *')]/preceding-sibling::*",
            TICKET_NAME_FIELD_EDIT = "xpath://*[contains(@text,'Имя *')]/preceding-sibling::*",
            TICKET_CREATE_SAVE_BUTTON = "id:com.riesapp.debug:id/saveButton",
            TICKET_DEAL_TYPE = "xpath://*[contains(@text,'Тип операции')]",
            TICKET_OPERATION_TYPE_TPL = "xpath://*[contains(@text,'{ticketTypeOperation}')]",
            TICKET_OBJECT_TYPE_TPL = "xpath://*[contains(@text,'{ticketTypeObject}')]",
            TICKET_OBJECT_TYPE = "xpath://*[contains(@text,'Тип недвижимости')]",
            TICKET_OBJECT_CLASS = "xpath://*[contains(@text,'Класс недвижимости')]",
            TICKET_OBJECT_CLASS_TPL = "xpath://*[contains(@text,'{ticketClassObject}')]",
            TICKET_SOURCE_FILTER = "xpath://*[contains(@text,'Откуда узнали')]",
            INNER_TICKET_TYPE_TPL = "xpath://*[contains(@text,'{innerTicketType}')]",
            INNER_TICKET = "xpath://*[contains(@text,'Внутренние заявки')]",
            CREATE_IN_INNER_TICKET_BUTTON = "id:com.riesapp.debug:id/createButton",
            OWN_MONEY_FIELD = "xpath://*[contains(@text,'Собственные средства')]",
            OWN_MONEY_FIELD_EDIT = "xpath://*[contains(@text,'Собственные средства')]/preceding-sibling::*",
            ESTATE_PRICE_FIELD = "xpath://*[contains(@text,'Стоимость недвижимости')]",
            ESTATE_PRICE_FIELD_EDIT = "xpath://*[contains(@text,'Стоимость недвижимости')]/preceding-sibling::*",
            URGENCY_REASON_FILTER = "xpath://*[contains(@text,'Срочная заявка')]",
            REFINANCE_TICKET_CARD = "xpath://*[contains(@text,'Рефинансирование')]",
            LOADER = "id:com.riesapp.debug:id/loader",
            URGENCY_REASON_TYPE_TPL = "xpath://*[contains(@text,'{urgencyReason}')]";


    //Рефинансирование
    @Step("Clicking inner ticket")
    public void clickInnerTicket() {
        this.waitForElementPresent(INNER_TICKET, "Cannot see inner ticket", 10);
        this.waitForElementAndClick(INNER_TICKET, "Cannot see and click inner ticket", 5);
    }

    @Step("Clicking inner ticket button")
    public void clickInnerTicketButton() {
        this.waitForElementPresent(CREATE_INNER_TICKET_BUTTON, "Cannot see inner ticket button", 10);
        this.waitForElementAndClick(CREATE_INNER_TICKET_BUTTON, "Cannot see and click inner ticket button", 5);
    }

    @Step("Choose inner ticket type")
    public void chooseInnerTicketByType(String innerTicketType) {
        String innerTicketTypeXpath = getXpathByInnerTicketType(innerTicketType);

        this.waitForElementPresent(innerTicketTypeXpath, "Cannot see inner ticket type", 10);
        this.waitForElementAndClick(innerTicketTypeXpath, "Cannot see and click inner ticket type", 5);
    }
    private static String getXpathByInnerTicketType(String innerTicketType) {
        return INNER_TICKET_TYPE_TPL.replace("{innerTicketType}", innerTicketType);
    }

    @Step("Filling own money field")
    public void fillingOwnMoney(String money) {
        this.waitForElementPresent(OWN_MONEY_FIELD, "Cannot see own money field", 10);
        this.waitForElementAndClick(OWN_MONEY_FIELD, "Cannot see and click own money field", 5);
        this.waitForElementAndSendKeys(OWN_MONEY_FIELD_EDIT, money, "Cannot see and send key own money field", 5);
    }

    @Step("Filling estate price field")
    public void fillingEstatePrice(String estatePrice) {
        this.waitForElementAndClick(ESTATE_PRICE_FIELD, "Cannot see estate price field", 5);
        this.waitForElementAndSendKeys(ESTATE_PRICE_FIELD_EDIT, estatePrice, "Cannot see and send key estate price field", 5);
    }

    @Step("Choose urgency reason filter")
    public void chooseUrgencyReason(String urgencyReason) {
        String urgencyReasonTypeXpath = getXpathByUrgencyReasonType(urgencyReason);

        this.waitForElementAndClick(URGENCY_REASON_FILTER, "Cannot see urgency reason filter", 5);
        this.waitForElementAndClick(urgencyReasonTypeXpath, urgencyReason, 5);
    }
    private static String getXpathByUrgencyReasonType(String urgencyReason) {
        return URGENCY_REASON_TYPE_TPL.replace("{urgencyReason}", urgencyReason);
    }

    @Step("Clicking create in inner ticket button")
    public void clickCreateInnerTicketButton() {
        this.waitForElementAndClick(CREATE_IN_INNER_TICKET_BUTTON, "Cannot see and click create in inner ticket button", 5);
    }

    @Step("Assert if refinance inner ticket created")
    public void assertIfRefinanceInnerTicketCreated() {
        this.waitForElementNotPresent(LOADER,"Can see Loader",10);
        this.waitForElementPresent(REFINANCE_TICKET_CARD, "Cannot see refinance ticket card", 10);
        this.assertElementIsPresent(REFINANCE_TICKET_CARD, "Cannot see Refinance Ticket Card");
    }


    //Создание заявки
    @Step("Clicking on ticket tab")
    public void clickTicketTab(){
        this.waitForElementAndClick(TICKET_TAB,"Cannot see and click ticket tab",10);
    }

    @Step("Clicking on create ticket button")
    public void clickCreateTicketButton(){
        this.waitForElementAndClick(CREATE_TICKET_BUTTON,"Cannot see and click create ticket button",10);
    }

    @Step("Filling data and move to next screen")
    public void fillingTicketData(String phoneNumber) {

        this.waitForElementAndClick(TICKET_PHONE_FIELD,"Cannot see and click create ticket button",10);
        this.waitForElementAndSendKeys(TICKET_PHONE_FIELD_EDIT,phoneNumber,"Cannot see and send key create ticket button",10);
        this.waitForElementAndClick(TICKET_NAME_FIELD,"Cannot see and click create ticket button",10);
        this.waitForElementAndSendKeys(TICKET_NAME_FIELD_EDIT,"client","Cannot see and send key create ticket button",10);
        this.waitForElementAndClick(TICKET_CREATE_SAVE_BUTTON,"Cannot see and click save button",10);
        this.waitForElementPresent(TICKET_SOURCE_FILTER, "Cannot see source ticket filter", 10);
    }

    @Step("Clicking on save ticket button")
    public void clickSaveTicketButton() {
        this.waitForElementAndClick(TICKET_CREATE_SAVE_BUTTON,"Cannot see and click create save button",10);
    }

    @Step("Assert if correct create ticket")
    public void assertIfTicketCreated() {
        this.waitForElementPresent(TICKET_SOURCE_FILTER, "Cannot see Source Ticket Filter", 10);
    }

    @Step("Changing ticket deal and object type")
    public void changeTicketDealAndObjectType(String ticketDealType, String ticketObjectType, String ticketObjectClass) {
        String ticketTypeOperationXpath = getXpathByTicketType(ticketDealType);
        String ticketTypeObjectXpath = getXpathByTicketTypeObject(ticketObjectType);
        String ticketClassObjectXpath = getXpathByTicketClassObject(ticketObjectClass);

        this.waitForElementPresent(TICKET_DEAL_TYPE, "Cannot see and click deal type", 10);
        if ("Продать".equals(ticketDealType)) {
            this.waitForElementAndClick(TICKET_DEAL_TYPE, "Cannot see and click deal type", 10);
            this.waitForElementPresent(ticketTypeOperationXpath, "Cannot see needed option", 10);
            this.waitForElementAndClick(ticketTypeOperationXpath, "Cannot see and click needed option", 10);
            this.waitForElementAndClick(TICKET_OBJECT_TYPE, "Cannot see and click object type", 10);
            this.waitForElementPresent(ticketTypeObjectXpath, "Cannot see needed option", 10);
            this.waitForElementAndClick(ticketTypeObjectXpath, "Cannot see and click needed option", 10);
        } else if ("Купить".equals(ticketDealType)) {
            this.waitForElementAndClick(TICKET_DEAL_TYPE, "Cannot see and click deal type", 10);
            this.waitForElementPresent(ticketTypeOperationXpath, "Cannot see needed option", 10);
            this.waitForElementAndClick(ticketTypeOperationXpath, "Cannot see and click needed option", 10);
            this.waitForElementAndClick(TICKET_OBJECT_CLASS, "Cannot see and click object class", 10);
            this.waitForElementPresent(ticketClassObjectXpath, "Cannot see needed option", 10);
            this.waitForElementAndClick(ticketClassObjectXpath, "Cannot see and click needed option", 10);
        }
    }
    private static String getXpathByTicketType(String ticketTypeOperation) {
        return TICKET_OPERATION_TYPE_TPL.replace("{ticketTypeOperation}", ticketTypeOperation);
    }

    @Step("Changing object type")
    public void changeTicketTypeObject(String ticketTypeObject) {
        String ticketTypeObjectXpath = getXpathByTicketTypeObject(ticketTypeObject);

        this.waitForElementAndClick(TICKET_OBJECT_TYPE, "Cannot see and click object type", 10);
        this.waitForElementPresent(ticketTypeObjectXpath, "Cannot see needed option", 10);
        this.waitForElementAndClick(ticketTypeObjectXpath, "Cannot see and click needed option", 10);
    }
    private static String getXpathByTicketTypeObject(String ticketTypeObject) {
        return TICKET_OBJECT_TYPE_TPL.replace("{ticketTypeObject}", ticketTypeObject);
    }

    @Step("Changing object class")
    public void changeTicketClassObject(String ticketClassObject) {
        String ticketClassObjectXpath = getXpathByTicketClassObject(ticketClassObject);

        this.waitForElementAndClick(TICKET_OBJECT_CLASS, "Cannot see and click object class", 10);
        this.waitForElementPresent(ticketClassObjectXpath, "Cannot see needed option", 10);
        this.waitForElementAndClick(ticketClassObjectXpath, "Cannot see and click needed option", 10);
    }
    private static String getXpathByTicketClassObject(String ticketClassObject) {
        return TICKET_OBJECT_CLASS_TPL.replace("{ticketClassObject}", ticketClassObject);
    }

    public TicketPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}