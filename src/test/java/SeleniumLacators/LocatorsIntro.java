package SeleniumLacators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/mayme/Downloads/Techtorialwebsite.html");

        //locator ID

        WebElement header = driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.id("details2"));
        System.out.println(p.getText());

        //Locator Name:
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Oleksandr");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Maimeskul");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("345678902");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("testemail@gmail.com");

        WebElement adress = driver.findElement(By.name("address1"));
        adress.sendKeys("2345 Bens Branch Drive");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Houston");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("TX");

        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("77339");

        //CLASS LOCATOR (ATTRIBUTE)

        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        String actualText = allTools.getText();
        String expectedText = "All Tools";
        if (actualText.equals(expectedText)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        System.out.println(actualText.equals(expectedText) ? "Passed" : "Failed");

        WebElement javaBox = driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isSelected());
        if (javaBox.isDisplayed() && javaBox.isEnabled() && !javaBox.isSelected()) {
            javaBox.click();
        }
        System.out.println(javaBox.isSelected());
        WebElement testNg = driver.findElement(By.id("cond3"));
        if (testNg.isDisplayed() && !testNg.isSelected() & testNg.isEnabled()) {
            testNg.click();
        }
        WebElement cucumber = driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed() && cucumber.isEnabled() && !cucumber.isSelected()) {
            cucumber.click();
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
