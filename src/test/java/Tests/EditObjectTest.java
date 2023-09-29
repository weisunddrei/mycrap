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
    public void editObjectStatus(){
        AuthPageObject Auth = new AuthPageObject(driver);
        ObjectPageObject Object = new ObjectPageObject(driver);


        Auth.authLogin18858(login, password);
        Object.enterCode();
        Object.clickSearchButton();
        Object.clickObjectCard();
        Object.getEditCharacteristicObject();
        Object.clickChangeObjectStatus("Приостановлен");
        Object.clickChangeObjectStatusReason("Отложил продажу");
        Object.editDatePicker(targetDate);
        Object.clickSaveButton();
        Object.assertElementAfterSave();
    }
}
