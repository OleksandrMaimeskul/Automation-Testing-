package SeleniumLacators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Oleksandr");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Maimeskul");
        WebElement jobTitle = driver.findElement(By.id("job-title"));
        jobTitle.sendKeys("SDET");

        WebElement highSchool = driver.findElement(By.id("radio-button-1"));
        if (highSchool.isDisplayed() && highSchool.isEnabled() && !highSchool.isSelected()) {
            highSchool.click();
        }
        WebElement college = driver.findElement(By.id("radio-button-2"));
        if (college.isDisplayed() && college.isEnabled() && !college.isSelected()) {
            college.click();
        }
        WebElement gradSchool = driver.findElement(By.id("radio-button-3"));
        if (gradSchool.isDisplayed() && gradSchool.isEnabled() && !gradSchool.isSelected()) {
            gradSchool.click();
        }
        WebElement male = driver.findElement(By.id("checkbox-1"));
        if (male.isDisplayed() && male.isEnabled() && !male.isSelected()) {
            male.click();
        }
        WebElement expirience = driver.findElement(By.id("select-menu"));
        expirience.sendKeys("0-1");

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("08/05/2024");

        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.linkText("Submit"));
        submit.click();

        WebElement formSubmitted = driver.findElement(By.className("alert-success"));
        String actualText = formSubmitted.getText();
        String expectedText = "The form was successfully submitted!";
        System.out.println(actualText.equals(expectedText)? "Header validated" : "Header not validated");
        driver.quit();
    }
}
