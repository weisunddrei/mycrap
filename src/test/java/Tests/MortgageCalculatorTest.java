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
        MenuPageObject Menu = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Menu.clickForMenuTab();
        Menu.clickForMortgageSection();
        Menu.clickMortgageObjectType();
        Menu.clickChangeObjectType("Новостройки");
        Menu.assertIfTypeObjectChange("Новостройки");
        Menu.clickMortgageShowButton();
        Menu.assertShowFilterButton();
    }

    @Test
    public void changeMortgageCountryHouseObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Menu = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Menu.clickForMenuTab();
        Menu.clickForMortgageSection();
        Menu.clickMortgageObjectType();
        Menu.clickChangeObjectType("Дачи");
        Menu.assertIfTypeObjectChange("Дачи");
        Menu.clickMortgageShowButton();
        Menu.assertShowFilterButton();
    }

    @Test
    public void changeMortgageLandObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Menu = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Menu.clickForMenuTab();
        Menu.clickForMortgageSection();
        Menu.clickMortgageObjectType();
        Menu.clickChangeObjectType("Земельные участки");
        Menu.assertIfTypeObjectChange("Земельные участки");
        Menu.clickMortgageShowButton();
        Menu.assertShowFilterButton();
    }

    @Test
    public void changeMortgageCottageObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Menu = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        String mortgageChangeObjectType = "Тип недвижимости";

        Menu.clickForMenuTab();
        Menu.clickForMortgageSection();
        Menu.clickMortgageObjectType();
        Menu.clickChangeObjectType("Частные дома");
        Menu.assertIfTypeObjectChange("Частные дома");
        Menu.clickMortgageShowButton();
        Menu.assertShowFilterButton();
    }
}
