package SeleniumLacators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class XPathPractice {
    public static void main(String[] args) {
        /*
    1-Navigate to the http://tutorialsninja.com/demo/index.php?route=account/register
    2-Provide all the information
    3-Check the privacy box is displayed, not selected and enabled then click'
    4-Click Continue Button
    5-Validate the message "Your Account Has Been Created!"
    6-Click Continue Button
    7-Validate the current Url "https://tutorialsninja.com/demo/index.php?route=account/account"
    8-driver.quit()
    NOTE:Please use all XPATH Locator
         */

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Oleksandr");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Maimeskul");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("dfddddfffsfddddfsfdfd@gmail.com");
        WebElement tel = driver.findElement(By.xpath("//input[@type='tel']"));
        tel.sendKeys("123456899");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("2335454565");
        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordConfirm.sendKeys("2335454565");

        WebElement box = driver.findElement(By.xpath("//input[@name='agree']"));
        if (box.isDisplayed() && box.isEnabled() && !box.isSelected()) {
            box.click();
        }
        WebElement continueButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Created')]"));
        String actualHeader = header.getText().trim();
        String exptectedHeader = "Your Account Has Been Created!";
        System.out.println(actualHeader.equals(exptectedHeader) ? "Passed" : "Failed");
        driver.quit();
        WebElement continueButton2 = driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton2.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";

        System.out.println(actualUrl.equals(expectedUrl)? "Passed" : "Failed");
        driver.quit();


    }
}
