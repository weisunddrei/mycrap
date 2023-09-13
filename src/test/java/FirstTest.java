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
        WebElement tabTicket = driver.findElement(By.xpath("//*[contains(@text,'Заявки')]"));
        tabTicket.click();
        Thread.sleep(7000);
        WebElement tapFiltrTickets = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/cellTextFirstV2']"));
        Thread.sleep(3000);
        tapFiltrTickets.click();
        Thread.sleep(3000);
        WebElement inWork = driver.findElement(By.xpath("//*[contains(@text,'В работе')]"));
        inWork.click();
        WebElement preListing = driver.findElement(By.xpath("//*[contains(@text,'Предлистинг')]"));
        preListing.click();
        WebElement suspended = driver.findElement(By.xpath("//*[contains(@text,'Приостановлена')]"));
        suspended.click();
        WebElement ready = driver.findElement(By.xpath("//*[contains(@text,'Готово')]"));
        ready.click();
        Thread.sleep(5000);
        WebElement tabObject = driver.findElement(By.xpath("//*[contains(@text,'Объекты')]"));
        tabObject.click();
        WebElement searchButton = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/searchButton']"));
        searchButton.click();
        Thread.sleep(7000);
        WebElement tapOk = driver.findElement(By.xpath("//*[contains(@text,'Понятно')]"));
        tapOk.click();
        WebElement tapFiltrObjects = driver.findElement(By.xpath("//*[@resource-id='com.riesapp.debug:id/topBarItemsContainer']"));
        tapFiltrObjects.click();
        Thread.sleep(3000);
        WebElement priceMax = driver.findElement(By.xpath("//*[contains(@text,'Цене, сначала дорогие')]"));
        priceMax.click();
        Thread.sleep(7000);

    }
}
