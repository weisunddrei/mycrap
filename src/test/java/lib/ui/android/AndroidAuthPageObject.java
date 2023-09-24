package lib.ui.android;

import lib.ui.RIES.AuthPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidAuthPageObject extends AuthPageObject
{
    static {
        LOGIN_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[contains(@class,'android.widget.EditText')]";
        PASSWORD_FIELD_EDIT = "xpath://*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[contains(@class,'android.widget.EditText')]";
        LOADER = "id:com.riesapp.debug:id/loader";
        LOGIN_BUTTON = "id:com.riesapp.debug:id/authButton";
        LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]";
        MY_OBJECTS_SWITCHER = "xpath://*[contains(@text,'Мои объекты')]";
        PASSWORD_FILED = "xpath://*[contains(@text,'Пароль')]";
        RIES_LOGO = "id:com.riesapp.debug:id/logo_view";
        SNACK_BAR = "id:com.riesapp.debug:id/snackbar_text";
        SYSTEM_ERROR_ALERT = "id:com.riesapp.debug:id/alertText";
        USER_BLOCKED_DIALOG = "id:com.riesapp.debug:id/title";
        WRONG_LOGIN_OR_PASSWORD_SNACK_BAR = "xpath://*[contains(@text,'Логин или пароль введены неверно')]";
    }
    public AndroidAuthPageObject(RemoteWebDriver driver) { super(driver); }
}
