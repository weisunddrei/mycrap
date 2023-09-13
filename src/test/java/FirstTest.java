import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest extends Platform{
    @Test
    public void goTest () throws InterruptedException {
        Thread.sleep(7000);
        WebElement loginField = driver.findElement(By.xpath("//*[contains(@text,'Логин')]"));
        loginField.click();
        WebElement loginFieldEdit = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/loginTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']"));
        loginFieldEdit.sendKeys("18858");
        WebElement passwordField = driver.findElement(By.xpath("//*[contains(@text,'Пароль')]"));
        passwordField.click();
        WebElement passwordFieldEdit = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/passwordTextInput']//*[@resource-id='com.riesapp.debug:id/textFieldEditText']"));
        passwordFieldEdit.sendKeys("Test20232");
        WebElement enterButton = driver.findElement(By.xpath("//*[contains(@text,'Войти')]"));
        enterButton.click();
        Thread.sleep(8000);

//        WebElement searchButton = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/searchButton']"));
//        searchButton.click();
//        Thread.sleep(7000);
//        WebElement tapOk = driver.findElement(By.xpath("//*[contains(@text,'Понятно')]"));
//        tapOk.click();
//        Thread.sleep(5000);
//        WebElement select = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/objectViewActionFirstButton']"));
//        select.click();
//        Thread.sleep(7000);
//        WebElement actions = driver.findElement(By.xpath("//*[contains(@text,'Действия')]"));
//        actions.click();
//        Thread.sleep(4000);
//        WebElement planShow = driver.findElement(By.xpath("//*[contains(@text,'Запланировать показ')]"));
//        planShow.click();
//        Thread.sleep(8000);
//        WebElement searchIconInPlanShow = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/topBarItemsContainer']"));
//        searchIconInPlanShow.click();
//        Thread.sleep(4000);
//        WebElement nameClientInPlanShow = driver.findElement(By.xpath("//*[contains(@text,'Код, ФИО клиента')]"));
//        nameClientInPlanShow.sendKeys("qwer");
//        Thread.sleep(4000);
//        WebElement selectTicket = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/cellRightSecondItemV2']"));
//        selectTicket.click();
//        Thread.sleep(5000);
//        WebElement planButton = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/submitButton']"));
//        planButton.click();
//        Thread.sleep(7000);

//        WebElement showPlannedSnack = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/snackbarContainer']"));

        WebElement tapShows = driver.findElement(By.xpath("//*[contains(@text,'Показы')]"));
        tapShows.click();
        Thread.sleep(7000);
        WebElement searchIconInLookShow = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/topBarItemsContainer']"));
        searchIconInLookShow.click();
        Thread.sleep(4000);
        WebElement nameClientInLookShow = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/topBarSearchEditText']"));
        nameClientInLookShow.sendKeys("asd");
        Thread.sleep(4000);
        WebElement selectShow = driver.findElement(By.xpath("//*[.='Объект']]"));
        selectShow.click();
        Thread.sleep(4000);
        WebElement theShowTookPlace = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/executedBtn']"));
        theShowTookPlace.click();
        Thread.sleep(4000);
        WebElement reactionToTheShow = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/dislikeBtn']"));
        reactionToTheShow.click();
        Thread.sleep(4000);
        WebElement cancelReason = driver.findElement(By.xpath("//*[contains(@text,'До риэлтора не дозвонились')]"));
        cancelReason.click();
        Thread.sleep(3000);
        WebElement closeShow = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/closeBtn']"));
        cancelReason.click();
        Thread.sleep(7000);
//[contains(.,'Ссылка')]]

//        com.riesapp.debug:id/cellTextFirstV2

//        com.riesapp.debug:id/executedBtn
//
//        До риэлтора не дозвонились
//
//        com.riesapp.debug:id/closeBtn

    }
}
