package Tests;

import io.qameta.allure.Step;
import lib.CoreTestCase;
import lib.Halper.RandomGenerator;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.TicketPageObject;
import org.junit.jupiter.api.Test;


public class InnerTicketTests extends CoreTestCase {

    private static final String

            login = "130522",
            password = "99679218Aa",
            phoneNumber = RandomGenerator.generateRandomPhoneNumber();

    @Step("Creating refinance inner ticket")
    @Test
    public void testCreateRefinanceInnerTicket(){
        AuthPageObject Auth = new AuthPageObject(driver);
        TicketPageObject Ticket = new TicketPageObject(driver);

        Auth.authLogin18858(login, password);

        Ticket.clickTicketTab();
        Ticket.clickCreateTicketButton();
        Ticket.enterTicketData(phoneNumber);
        Ticket.changeTicketTypeOperationXpath("Купить","","Гараж");
        Ticket.clickSaveTicketButton();

        Ticket.clickInnerTicket();
        Ticket.clickInnerTicketButton();
        Ticket.chooseInnerTicketByType("Рефинансирование");
        Ticket.fillingOwnMoney("2 500 000");
        Ticket.fillingEstatePrice("5 500 001");
        Ticket.chooseUrgencyReason("Да, другая причина");//Да, другая причина
        Ticket.clickCreateInnerTicketButton();
        Ticket.assertIfRefinanceInnerTicketCreated();
    }
}
