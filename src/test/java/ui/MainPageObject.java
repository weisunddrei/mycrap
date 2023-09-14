package ui;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Pattern;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) { this.driver = driver; }

    public WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private By getLocatorByString(String locatorWithType) {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        return switch (byType) {
            case "xpath" -> By.xpath(locator);
            case "id" -> By.id(locator);
            case "css" -> By.cssSelector(locator);
            default -> throw new IllegalArgumentException("Cannot get type of locator  " + locatorWithType);
        };
    }

    public void waitForElementAndClick(String locator, String errorMessage, long TimeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, TimeoutInSeconds);
        element.click();
    }

    public void waitForElementAndSendKeys(String locator, String value, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
    }
}