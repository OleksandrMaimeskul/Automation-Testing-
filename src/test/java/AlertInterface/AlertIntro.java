package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void AcceprtAndGetText() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick, 'jsAlert')]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        String expectedText = "I am a JS Alert";
        Assert.assertEquals(text, expectedText);

        Thread.sleep(2000);
        alert.accept();

        WebElement result = driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(result));
    }

    @Test
    public void something() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(result));

    }

    @Test
    public void sendKeys() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPromt = driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]"));
        jsPromt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Oleksandr");
        alert.accept();

        WebElement result = driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(result));
    }


}
