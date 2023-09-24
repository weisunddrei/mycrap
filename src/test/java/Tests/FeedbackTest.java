package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.MenuPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FeedbackTest extends CoreTestCase {
    public static final String
            login = "18858",
            password = "Test20232",
            title = "Title",
            description = "Description";

    @Test
    @Features(value = {@Feature(value = "Feedback")})
    @DisplayName("Correct sending feedback")
    @Description("Filling out fields and sending feedback")
    @Step("Starting test ID 2 'testSendingFeedback'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSendingFeedback() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Feed = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        Feed.clickForMenuTab();
        Feed.clickForFeedbackSection();
        Feed.enterFeedbackData(title, description);
        Feed.addAttachmentFeedback();
        Feed.clickButtonForSendingFeedback();
        Feed.waitForLoaderToDisappear();
        Feed.assertIfSnackBarIsThere();
    }

    @Test
    @Features(value = {@Feature(value = "Feedback")})
    @DisplayName("Check required fields")
    @Description("Send verification without required fields")
    @Step("Starting test ID 3 'testSendingFeedback'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testRequiredFeilds() {
        AuthPageObject Auth = new AuthPageObject(driver);
        MenuPageObject Feed = new MenuPageObject(driver);

        Auth.authLogin18858(login, password);

        Feed.clickForMenuTab();
        Feed.clickForFeedbackSection();
        Feed.clickButtonForSendingFeedback();
        Feed.assertIfSendButtonIsVisible();
    }
}