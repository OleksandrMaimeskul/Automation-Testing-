package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JSAndHTMLAlert {
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement previewButton1 = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewButton1.click();
        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();


        WebElement previewButton2 = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewButton2.click();
        WebElement txt = driver.findElement(By.xpath("//div[@role='dialog']"));
        System.out.println(BrowserUtils.getText(txt));

        WebElement okButton = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        okButton.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
