package Tests;

import lib.CoreTestCase;
import lib.Halper.DatePickerFormatter;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.ObjectPageObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EditObjectTest extends CoreTestCase {
    public static final String
            login = "18858",
            password = "Test20232",
            targetDate = DatePickerFormatter.formatTomorrowDate();

    @Order(1)
    @Test
    public void changingStatusOfActiveObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);
        String objectStatus = "Активный";


        Auth.authLogin130522(login, password);
        Object.enterCode();
        Object.clickSearchButton();
        Object.clickObjectCard();
        Object.getEditCharacteristicObject();
        if ("Активный".equals(objectStatus)) {
            Object.clickChangeObjectStatus("Приостановлен");
            Object.clickChangeObjectStatusReason("Отложил продажу");
            Object.editDatePicker(targetDate);
        } else {
            Object.clickChangeObjectStatus("Предлистинг");
        }
        Object.clickSaveButton();
        Object.assertElementAfterSave();
    }
    @Order(2)
    @Test
    public void changingStatusOfSuspendedObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);
        String objectStatus = "Приостановлен";


        Auth.authLogin130522(login, password);
        Object.enterCode();
        Object.clickSearchButton();
        Object.clickObjectCard();
        Object.getEditCharacteristicObject();
        if ("Активный".equals(objectStatus)) {
            Object.clickChangeObjectStatus("Приостановлен");
            Object.clickChangeObjectStatusReason("Отложил продажу");
            Object.editDatePicker(targetDate);
        } else {
            Object.clickChangeObjectStatus("Предлистинг");
        }
        Object.clickSaveButton();
        Object.assertElementAfterSave();
    }
    @Order(3)
    @Test
    public void changingStatusOfPrelistingObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);
        String objectStatus = "Предлистинг";


        Auth.authLogin130522(login, password);
        Object.enterCode();
        Object.clickSearchButton();
        Object.clickObjectCard();
        Object.getEditCharacteristicObject();
        if ("Активный".equals(objectStatus)) {
            Object.clickChangeObjectStatus("Приостановлен");
            Object.clickChangeObjectStatusReason("Отложил продажу");
            Object.editDatePicker(targetDate);
        } else {
            Object.clickChangeObjectStatus("Активный");
        }
        Object.clickSaveButton();
        Object.assertElementAfterSave();
    }
}
