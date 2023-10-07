package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.Halper.RandomGenerator;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.TicketPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@Features(value = {@Feature(value = "Create inner ticket refinance")})
public class InnerTicketTests extends CoreTestCase {

    private static final String

            login = "130522",
            password = "99679218Aa",
            phoneNumber = RandomGenerator.generateRandomPhoneNumber();


    @Test
    @DisplayName("Correct create inner ticket refinance")
    @Description("Creating inner ticket refinance")
    @Step("Creating refinance inner ticket")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCreateRefinanceInnerTicket(){
        AuthPageObject Auth = new AuthPageObject(driver);
        TicketPageObject Ticket = new TicketPageObject(driver);

        Auth.authLogin130522(login, password);

        Ticket.clickTicketTab();
        Ticket.clickCreateTicketButton();
        Ticket.fillingTicketData(phoneNumber);
        Ticket.changeTicketDealAndObjectType(
                "Купить",
                "Номер",
                "Гараж");
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
