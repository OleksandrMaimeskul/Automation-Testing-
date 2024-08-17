package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void practice() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(" https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement buttonAlertBox = driver.findElement(By.xpath("//button[@id='alertBox']"));
        buttonAlertBox.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(BrowserUtils.getText(result));
        driver.navigate().refresh();
        WebElement buttonClickBox = driver.findElement(By.xpath("//button[contains(@onclick,'confirmFunction')]"));
        BrowserUtils.scrollWithJS(driver,buttonClickBox);
        buttonClickBox.click();
        alert.dismiss();
        result = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(BrowserUtils.getText(result));
        WebElement buttonPromtBox = driver.findElement(By.xpath("//button[contains(@onclick,'promptFunction')]"));
        buttonPromtBox.click();
        alert.sendKeys("Oleksandr Maimeskul");
        alert.accept();
        result = driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(BrowserUtils.getText(result));

        driver.quit();

    }
}
