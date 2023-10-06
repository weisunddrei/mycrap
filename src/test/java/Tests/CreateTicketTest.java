package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.Halper.RandomGenerator;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.TicketPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Features(value = {@Feature(value = "Create ticket")})
public class CreateTicketTest extends CoreTestCase {

    public static final String
            login = "130522",
            password = "99679218Aa",
            phoneNumber = RandomGenerator.generateRandomPhoneNumber();
    @Test
    @DisplayName("Correct ticket sell create")
    @Description("Creating a sales request")
    @Step("Starting test ID 10 'testCreateTicketSell'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCreateTicketSell() {
        AuthPageObject Auth = new AuthPageObject(driver);
        TicketPageObject Ticket = new TicketPageObject(driver);

        Auth.authLogin18858(login, password);

        Ticket.clickTicketTab();
        Ticket.clickCreateTicketButton();
        Ticket.enterTicketData(phoneNumber);
        Ticket.changeTicketTypeOperationXpath("Продать", "Номер", "Гараж");
        Ticket.clickSaveTicketButton();
        Ticket.assertCreateTicket();
    }

    @Test
    @DisplayName("Correct ticket buy create")
    @Description("Creating a buy request")
    @Step("Starting test ID 11 'testCreateTicketBuy'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCreateTicketBuy() {
        AuthPageObject Auth = new AuthPageObject(driver);
        TicketPageObject Ticket = new TicketPageObject(driver);

        Auth.authLogin18858(login, password);

        Ticket.clickTicketTab();
        Ticket.clickCreateTicketButton();
        Ticket.enterTicketData(phoneNumber);
        Ticket.changeTicketTypeOperationXpath("Купить", "Номер", "Гараж");
        Ticket.clickSaveTicketButton();
        Ticket.assertCreateTicket();
    }
}