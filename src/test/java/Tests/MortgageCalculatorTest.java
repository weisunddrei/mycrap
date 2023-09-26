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
    public void changeMortgageNewHouseObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Mort = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Mort.clickForMenuTab();
        Mort.clickForMortgageSection();
        Mort.clickMortgageObjectType("Тип недвижимости");
        Mort.clickChangeObjectType("Новостройки");
        Mort.assertIfTypeObjectChange("Новостройки");
        Mort.clickMortgageShowButton();
        Mort.assertShowFilterButton();
    }

    @Test
    public void changeMortgageCountryHouseObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Mort = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Mort.clickForMenuTab();
        Mort.clickForMortgageSection();
        Mort.clickMortgageObjectType("Тип недвижимости");
        Mort.clickChangeObjectType("Дачи");
        Mort.assertIfTypeObjectChange("Дачи");
        Mort.clickMortgageShowButton();
        Mort.assertShowFilterButton();
    }

    @Test
    public void changeMortgageLandObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Mort = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Mort.clickForMenuTab();
        Mort.clickForMortgageSection();
        Mort.clickMortgageObjectType("Тип недвижимости");
        Mort.clickChangeObjectType("Земельные участки");
        Mort.assertIfTypeObjectChange("Земельные участки");
        Mort.clickMortgageShowButton();
        Mort.assertShowFilterButton();
    }

    @Test
    public void changeMortgageCottageObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Mort = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Mort.clickForMenuTab();
        Mort.clickForMortgageSection();
        Mort.clickMortgageObjectType("Тип недвижимости");
        Mort.clickChangeObjectType("Частные дома");
        Mort.assertIfTypeObjectChange("Частные дома");
        Mort.clickMortgageShowButton();
        Mort.assertShowFilterButton();
    }
}
