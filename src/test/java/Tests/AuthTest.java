package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.RIES.AuthPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AuthTest extends CoreTestCase {
    public static final String
            login = "18858",
            password = "Test20232";

    @Test
    @Features(value = {@Feature(value = "Auth")})
    @DisplayName("Authorization with active 18858 account")
    @Description("Logging in with the 18858 account using login and password")
    @Step("Starting test ID 1 'testActiveAccount'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testActiveAccount() {
        AuthPageObject Auth = new AuthPageObject(driver);

        Auth.waitForLoginButton();
        Auth.enterLoginData(login, password);
        Auth.clickLOGINButton();
        Auth.waitForLoaderToDisappear();
        Auth.assertElementIsPresent();
    }
}

