package lib.ui.mobile.web;

import lib.ui.RIES.AuthPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWAuthPageObject extends AuthPageObject {
    private static final String
            LOGIN_FIELD = "xpath://*[contains(@text,'Логин')]",
            PASSWORD_FILED = "xpath://*[contains(@text,'Пароль')]",
            RIES_LOGO = "id:com.riesapp:id/logo_view",
            EDIT_LOGIN_FIELD = "xpath://*[@resource-id='com.riesapp:id/loginTextInput']//*[@resource-id='com.riesapp:id/textFieldEditText']",
            EDIT_PASSWORD_FIELD = "xpath://*[@resource-id='com.riesapp:id/passwordTextInput']//*[@resource-id='com.riesapp:id/textFieldEditText']",
            RECOMMENDATION_BUTTON = "xpath://*[contains(@text,'Рекомендации')]",
            LOADER = "id:com.riesapp:id/loader",
            LOGIN_BUTTON = "id:com.riesapp:id/authButton";

    public MWAuthPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
