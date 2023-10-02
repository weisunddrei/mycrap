package lib.ui.RIES;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TicketPageObject extends MainPageObject {

    protected static String
            TICKET_TAB = "xpath://*[contains(@text,'Заявки')]",
    CREATE_TICKET_BUTTON = "id:com.riesapp.debug:id/ticketsListCreateTicketButton",
    TICKET_PHONE_FIELD = "xpath://*[contains(@text,'Номер телефона')]",
//    TICKET_PHONE_FIELD_EDIT = "xpath://*[contains(@text,'Номер телефона *')]/following-sibling::*";
    TICKET_PHONE_FIELD_EDIT = "xpath://*[contains(@text,'Номер телефона *']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']";


    @Step
    public void clickTicketTab(){
        this.waitForElementAndClick(TICKET_TAB,"Cannot see and click ticket tab",10);
    }

    @Step
    public void clickCreateTicketButton(){
        this.waitForElementAndClick(CREATE_TICKET_BUTTON,"Cannot see and click create ticket button",10);
    }

    @Step
    public void enterTicketData() throws InterruptedException {
        this.waitForElementAndClick(TICKET_PHONE_FIELD,"Cannot see and click create ticket button",10);
        this.waitForElementAndSendKeys(TICKET_PHONE_FIELD_EDIT,"89827735883","Cannot see and send key create ticket button",10);
        Thread.sleep(300);
    }




    public TicketPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
