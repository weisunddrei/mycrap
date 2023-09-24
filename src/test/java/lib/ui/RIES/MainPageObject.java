package lib.ui.RIES;

import lib.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
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

    public WebElement waitForElementPresent(String locator, String errorMessage) {
        return waitForElementPresent(locator, errorMessage, 5);
    }

    public void waitForElementAndClick(String locator, String errorMessage, long TimeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, TimeoutInSeconds);
        element.click();
    }

    public void tapByCoordinates(int by_x, int by_y) {
        RemoteWebDriver remoteDriver = driver;
        PerformsTouchActions performsTouchActions = (PerformsTouchActions) remoteDriver;
        TouchAction touchAction = new TouchAction(performsTouchActions);
        touchAction.tap(PointOption.point(by_x, by_y)).perform();
    }

    public void waitForElementAndSendKeys(String locator, String value, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
    }

    public void waitForElementNotPresent(String locator, String errorMessage, long timeoutInSeconds) {
        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

//    public void swipeUp(WebDriver driver) {
//        Dimension size = driver.manage().window().getSize();
//        int x = size.width / 2;
//        int startY = (int) (size.height * 0.8);
//        int endY = (int) (size.height * 0.2);
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.tagName("body")), x, startY)
//                .clickAndHold()
//                .moveByOffset(0, -(startY - endY))
//                .release()
//                .perform();
//    }

    public void swipeUp(int timeOfSwipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int startY = (int) (size.height * 0.8);
            int endY = (int) (size.height * 0.2);
            action.press(PointOption.point(x, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, endY)).release().perform();
        } else {
            System.out.println("Method swipeUp does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void shortSwipeUp(int timeOfSwipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int startY = (int) (size.height * 0.5);
            int endY = (int) (size.height * 0.4);
            action.press(PointOption.point(x, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, endY))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeUp does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

//    public void swipeUp(int timeOfSwipe) {
//        Dimension size = driver.manage().window().getSize();
//        int x = size.width / 2;
//        int startY = (int) (size.height * 0.8);
//        int endY = (int) (size.height * 0.2);
//
//        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//        Sequence sequence = new Sequence(pointerInput, 0);
//
//        PointOption<?> startPoint = PointOption.point(x, startY);
//        PointOption<?> endPoint = PointOption.point(x, endY);
//
//        sequence.addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (Point) startPoint.build()));
//        sequence.addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        sequence.addAction(pointerInput.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), (Point) endPoint.build()));
//        sequence.addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        List<Sequence> sequences = new ArrayList<>();
//        sequences.add(sequence);
//
//        driver.perform(sequences);
//    }

    public void swipeUpQuick() {swipeUp(200);}
    public void shortSwipeUpQuick() {shortSwipeUp(100);}

    public void swipeUpToFindElement(String locator, String errorMessage, int maxSwipes) {
        By by = this.getLocatorByString(locator);
        int alreadySwiped = 0;
        while (driver.findElements(by).isEmpty()) {

            if (alreadySwiped > maxSwipes) {
                waitForElementPresent(locator, "Cannot find element by swiping up. \n" + errorMessage, 0);
                return;
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public void shortSwipeUp(String errorMessage, int timeOfSwipe) {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int startY = (int) (size.height * 0.5);
            int endY = (int) (size.height * 0.4);
            action.press(PointOption.point(x, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, endY))
                    .release()
                    .perform();
        } else {
            System.out.println("Method swipeUp does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void swipeElementToLeft(String locator, String errorMessage) {
        if (driver instanceof AppiumDriver) {
            WebElement element = waitForElementPresent(
                    locator,
                    errorMessage,
                    10);
            int leftX = element.getLocation().getX();
            int rightX = leftX + element.getSize().getWidth();
            int upperY = element.getLocation().getY();
            int lowerY = upperY + element.getSize().getHeight();
            int middleY = (upperY + lowerY) / 2;

            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(rightX, middleY));
            action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                    .moveTo(PointOption.point(leftX, middleY));

            if (Platform.getInstance().isAndroid()) {
                action.moveTo(PointOption.point(leftX, middleY));
            } else {
                int offsetX = (-1 * element.getSize().getWidth());
                action.moveTo(PointOption.point(offsetX, 0));
            }
            action.release();
            action.perform();
        } else {
            System.out.println("Method swipeElementToLeft does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

    public void assertElementNotPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements < 1) {
            String default_message = "An element '" + locator + "' is not there";
            throw new AssertionError(default_message + " " + errorMessage);
        }
    }

    public void assertElementIsPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements == 0) {
            String default_message = "An element '" + locator + "' is not there";
            throw new AssertionError(default_message + " " + errorMessage);
        }
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

    public void swipeUpTillElementAppear(String locator, String errorMessage, int maxSwipes) {
        int alreadySwiped = 0;
        while (!this.isElementLocatedOnTheScreen(locator)) {
            if (alreadySwiped > maxSwipes) {
                Assertions.assertTrue(this.isElementLocatedOnTheScreen(locator), errorMessage);
            }
            swipeUpQuick();
            ++alreadySwiped;
        }
    }

    public boolean isElementLocatedOnTheScreen(String locator) {
        int elementLocatorByY = this.waitForElementPresent(locator, "Cannot find the element by locator", 5).getLocation().getY();
//        if (Platform.getInstance().isMW()) {
//            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
//            Object js_result = JSExecutor.executeScript("return window.pageYOffset");
//            elementLocatorByY -= Integer.parseInt(js_result.toString());
//        }
        int screenSizeByY = driver.manage().window().getSize().getHeight();
        return elementLocatorByY < screenSizeByY;
    }

    public void tapElementAndHold(int holdMsec) {
//        int left_x = element.getLocation().getX();
//        int right_x = left_x + element.getSize().getWidth();
//        int upper_y = element.getLocation().getY();
//        int lower_y = upper_y + element.getSize().getHeight();
//        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.press(PointOption.point(40, 740))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(holdMsec)))
                .release()
                .perform();
    }

    public void clickElementToTheRightUpperCorner(String locator, String errorMessage) {
        if (driver instanceof AppiumDriver) {
            WebElement element = this.waitForElementPresent(locator, errorMessage);
            int rightX = element.getLocation().getX();
            int upperY = element.getLocation().getY();
            int lowerY = upperY + element.getSize().getWidth();
            int middleY = (upperY + lowerY) / 2;
            int width = element.getSize().getWidth();

            int pointToClickX = (rightX + width) - 3;
            int pointToClickY = middleY;

            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.tap(PointOption.point(pointToClickX, pointToClickY)).perform();
        } else {
            System.out.println("Method clickElementToTheRightUpperCorner does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

//    public void scrollWebPageUp() {
//        if (Platform.getInstance().isMW()) {
//            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
//            JSExecutor.executeScript("window.ScrollBy(0,250)");
//        } else {
//            System.out.println("Method scrollWebPageUp does nothing for platform" + Platform.getInstance().getPlatformVar());
//        }
//    }

//    public void scrollWebPageTillElementNotVisible(String locator, String errorMessage, int max_swipes) {
//        int already_swiped = 0;
//
//        WebElement element = this.waitForElementPresent(locator, errorMessage);
//
//        while (!this.isElementLocatedOnTheScreen(locator)) {
//            scrollWebPageUp();
//            ++already_swiped;
//            if (already_swiped > max_swipes) {
//                Assertions.assertTrue(element.isDisplayed(), errorMessage);
//            }
//        }
//    }

    public boolean isElementPresent(String locator) {return getAmountOfElements(locator) > 0;}

    public void tryClickElementWithSeveralAttempts(String locator, String errorMessage, int amount_of_attempts) {
        int current_attempts = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts) {
            try {
                this.waitForElementAndClick(locator, errorMessage, 1);
                need_more_attempts = false;
            } catch (Exception e) {
                if (current_attempts > amount_of_attempts) {
                    this.waitForElementAndClick(locator, errorMessage, 1);
                }
            }
            ++current_attempts;
        }
    }

    public void hideKeyboard() {
        List<WebElement> doneButtons = driver.findElements(By.id("Done"));
        List<WebElement> returnButtons = driver.findElements(By.id("Return"));

        if (!doneButtons.isEmpty()) {
            doneButtons.get(0).click();
        } else if (!returnButtons.isEmpty())
        {
            returnButtons.get(0).click();
        }
    }


//    public void tapByCoordinatesWE(int x, int y) {
//        WebDriver webDriver = (WebDriver) driver;
//
//        try {
//            Thread.sleep(2000); // Add a 2-second delay
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Actions actions = new Actions(webDriver);
//        WebElement body = webDriver.findElement(By.cssSelector("body")); // Find the <body> element using CSS selector
//        actions.moveToElement(body, x, y).click().perform(); // Perform the tap action at the specified coordinates
//    }

    public String takeScreenshot(String name) {
        TakesScreenshot ts = this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\target\\" + name + "_screenshot.png";
        try {
            FileUtils.copyFile(source, new File(path));
            System.out.printf("Screenshot was made: %s%n", path);
        } catch (Exception e) {
            System.out.printf("Error! Cannot make a screenshot due to error: %s%n", e.getMessage());
        }
        return path;
    }

    @Attachment
    public static byte[] screenshot(String path) {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.printf("Error! Cannot get bytes from the screenshot due to error: %s%n", e.getMessage());
        }
        return bytes;
    }

    public void tapOutsideKeyboard() {
        if (driver instanceof PerformsTouchActions) {
            PerformsTouchActions touchDriver = (PerformsTouchActions) driver;
            try {
                WebElement activeElement = driver.switchTo().activeElement();
                int x = activeElement.getLocation().getX();
                int y = activeElement.getLocation().getY();
                TouchAction touchAction = new TouchAction(touchDriver);
                touchAction.tap(PointOption.point(x, y)).perform();
            } catch (NoSuchElementException e) {
                // Handle the case when there is no active element
            }
        }
    }

    public void clickToSystemBack() {driver.navigate().back();}

    public void tapOutside() {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        int topY = driver.manage().window().getSize().height / 9;
        int pressX = driver.manage().window().getSize().width / 2;
        touchAction.tap(new PointOption().withCoordinates(pressX, topY)).perform();
    }

    public void waitForTwoSecond() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void disableWifi() {
        if (Platform.getInstance().isAndroid()) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("adb", "shell", "svc", "wifi", "disable");
                Process process = processBuilder.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();}
        } else {
            System.out.print("This method does nothing on iOS");
        }
    }

    public void enableWifi() {
        if (Platform.getInstance().isAndroid()) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("adb", "shell", "svc", "wifi", "enable");
                Process process = processBuilder.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();}
        } else {System.out.print("This method does nothing on iOS");}
    }
}