package lib.ui.ios;

import lib.ui.RIES.AuthPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSAuthPageObject extends AuthPageObject
{
    static {
        LOGIN_FIELD_EDIT = "xpath:(//XCUIElementTypeOther[@name='Логин'])[2]";
        PASSWORD_FIELD_EDIT = "xpath:(//XCUIElementTypeOther[@name='Пароль'])[2]";
        LOADER = "id:com.riesapp:id/loader";
        LOGIN_BUTTON = "id:Войти";
        LOGIN_FIELD = "xpath:(//XCUIElementTypeOther[@name='Логин'])[2]";
        MY_OBJECTS_SWITCHER = "xpath://*[contains(@name,'Мои объекты')]";
        NOTIFICATION_DIALOGUE_ALLOW = "id:Разрешить";
        NOTIFICATION_DIALOGUE_FOLLOW_ACTIVITY_ACCEPT = "id:Разрешить";
        PASSWORD_FILED = "xpath:(//XCUIElementTypeOther[@name='Пароль'])[2]";
        RIES_LOGO = "id:com.riesapp:id/logo_view";
        SNACK_BAR = "xpath://*[contains(@name,'Осталось попыток')]";
        SYNC_CATALOGS_SCREEN = "id:Cинхронизация каталогов";
        TITLE_SEARCH_IN_TOPBAR = "id:Поиск";
        USER_BLOCKED_DIALOG = "id:Пользователь заблокирован";
        WRONG_LOGIN_OR_PASSWORD_SNACK_BAR = "xpath://*[contains(@name,'Логин или пароль введены неверно')]";
    }
    public IOSAuthPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
