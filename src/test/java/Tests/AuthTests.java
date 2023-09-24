package Tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.RIES.AuthPageObject;
import lib.ui.factories.AuthPageObjectFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthTests extends CoreTestCase {

    private static final String
            login = "130522",
            password = "99679218Aa";

    @Test
    @Features(value = {@Feature(value = "Auth")})
    @DisplayName("Authorization with active 130522 account")
    @Description("Logging in with the 130522 account using login and password")
    @Step("Starting test ID 7950 'testActiveAccount'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testActiveAccount() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertIfBlockIsThere();
    }

    @Test
    @DisplayName("Authorization with the incorrect login")
    @Description("Logging in using the incorrect login and correct password")
    @Step("Starting test ID 7952 'testIncorrectLogin'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testIncorrectLogin() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData("130522incorrect", password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertWrongLoginOrPasswordSnackBarIsThere();
    }

    @Test
    @DisplayName("Authorization with the incorrect password")
    @Description("Logging in using the correct login and incorrect password")
    @Step("Starting test ID 7953 'testIncorrectPassword'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testIncorrectPassword() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, "99679218incorrect");
        Auth.clickLOGINButton();
        Auth.assertIfSnackBarIsThere();
    }

    @Test
    @DisplayName("Authorization with the blocked account")
    @Description("Logging in using the blocked account's login and password")
    @Step("Starting test ID 7951 'testBlockedAccount'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testBlockedAccount() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertIfUserBlocked();
    }

    @Test
    @DisplayName("Blocking the application while authorization")
    @Description("Blocking the application after entering login and password information")
    @Step("Starting test ID 7955 'testBackgroundAfterFillingFields'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testBackgroundAfterFillingFields() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, password);
        Auth.setAppToBackground(3);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertIfBlockIsThere();
    }

    @Test
    @DisplayName("Losing signal during the authorization process")
    @Description("Losing signal after entering login and password information")
    @Step("Starting test ID 7956 'testNoSignalAfterFillingFields'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testNoSignalAfterFillingFields() throws InterruptedException {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, password);
        Auth.disableWiFI();
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertIfBlockIsThere();
    }

    @Test
    @DisplayName("Authorization with space in login")
    @Description("Logging in with space in login and correct password")
    @Step("Starting test ID 7957 'testSpaceInLogin'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSpaceInLogin() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData("13 0522", password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        if (Platform.getInstance().isAndroid()){
            Auth.assertWrongLoginOrPasswordSnackBarIsThere();}
        else {
            Auth.assertWrongLoginOrPasswordSnackBarIsThere();}
    }

    @Test
    @DisplayName("Authorization with Cyrillic in the login")
    @Description("Logging in using a login that contains Cyrillic characters and the correct password")
    @Step("Starting test ID 7959 'testCyrillicInLogin'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCyrillicInLogin() {
        AuthPageObject Auth = AuthPageObjectFactory.get(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData("130522ы", password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        if (Platform.getInstance().isAndroid()){
            Auth.assertWrongLoginOrPasswordSnackBarIsThere();}
        else {
            Auth.assertIfBlockIsThere();}
    }

//    Пока не придумал как
//    @Test
//    @DisplayName("Entering the password from the clipboard")
//    @Description("Logging in using the correct login and password copied from the clipboard.")
//    @Step("Starting test ID 7958 'testInsertPasswordFromClipboard'")
//    @Severity(value = SeverityLevel.CRITICAL)
//    public void testInsertPasswordFromClipboard() {
//        AuthPageObject Auth = AuthPageObjectFactory.get(driver);
//
//        Auth.waitForLoginButton();
//        Auth.enterLoginData(login, password);
//        Auth.clickLOGINButton();
//        Auth.waitForLoaderToDisappear();
//        Auth.assertIfBlockIsThere();
//    }

}
