package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.TicketPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Features(value = {@Feature(value = "Feedback")})
public class CreateTicketTest extends CoreTestCase {

    public static final String
            login = "18858",
            password = "Test20232";



    @Test
    @DisplayName("Correct sending feedback")
    @Description("Filling out fields and sending feedback")
    @Step("Starting test ID 2 'testSendingFeedback'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void createTicketSale() throws InterruptedException {
        AuthPageObject Auth = new AuthPageObject(driver);
        TicketPageObject Ticket = new TicketPageObject(driver);

        Auth.authLogin18858(login, password);

        Ticket.clickTicketTab();
        Ticket.clickCreateTicketButton();
        Ticket.enterTicketData();
//        Ticket.enterNameTicket();
//        Ticket.changeTypeOperation();
//        Ticket.changeTypeObject();
//        Ticket.clickCreateTicketButton();
//        Ticket.asserCreateTicket();





    }
}
