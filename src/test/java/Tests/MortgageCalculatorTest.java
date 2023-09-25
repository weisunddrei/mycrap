package Tests;

import lib.CoreTestCase;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.MenuPageObject;
import org.junit.jupiter.api.Test;

public class MortgageCalculatorTest extends CoreTestCase {

    public static final String
            login = "18858",
            password = "Test20232";

    @Test
    public void changeMortgageTypeObject(){
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Mort = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageObjectTypeNew = "Новостройки";
        String mortgageObjectTypeZagorod = "Дачи";

        Mort.clickForMenuTab();
        Mort.clickForMortgageSection();
        Mort.clickNewHousesObject("Новостройки");
        Mort.clickZagorodObject("Дачи");
        Mort.assertIfTypeObjectChange("Дачи");




    }
}
