package Tests;

import lib.CoreTestCase;
import lib.Halper.DatePickerFormatter;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.ObjectPageObject;
import org.junit.jupiter.api.Test;

public class EditObjectTest extends CoreTestCase {
    public static final String
            login = "18858",
            password = "Test20232",
            targetDate = DatePickerFormatter.formatTomorrowDate();


    @Test
    public void changingStatusOfActiveObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);
        String objectStatus = "Активный";


        Auth.authLogin18858(login, password);
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

    @Test
    public void changingStatusOfSuspendedObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);
        String objectStatus = "Приостановлен";


        Auth.authLogin18858(login, password);
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

    @Test
    public void changingStatusOfPrelistingObject() {
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);
        String objectStatus = "Предлистинг";


        Auth.authLogin18858(login, password);
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
