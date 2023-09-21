package Tests;

import io.qameta.allure.*;
import lib.CoreTestCase;
import lib.ui.RIES.AuthPageObject;
import lib.ui.RIES.FeedbackPageObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static Tests.AuthorizationTest.*;

public class FeedbackTest extends CoreTestCase {
    public static final String
            title = "Title",
            description = "Description";

    @Test
    @Features(value = {@Feature(value = "Feedback")})
    @DisplayName("Correct sending feedback")
    @Description("Filling out fields and sending feedback")
    @Step("Starting test ID 2 'testSendingFeedback'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSendingFeedback() throws InterruptedException {
        AuthPageObject Auth = new AuthPageObject(driver);
        FeedbackPageObject Feed = new FeedbackPageObject(driver);
        Auth.authLogin18858(login, password);

        Feed.clickForMenuTab();
        Feed.clickForFeedbackSection();
        Feed.enterFeedbackData(title, description);
        Feed.addAttachmentFeedback();
        Feed.clickButtonForSendingFeedback();
        Feed.waitForLoaderToDisappear();
        Thread.sleep(2000);
        Feed.assertIfSnackBarIsThere();
    }
}
