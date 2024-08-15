package SeleniumLacators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class HealthCarePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com");
        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or .equals XPATH METHOD
10-Validate the header is "Appointment Confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
     */
        WebElement makeAppointmentButton = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();

        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        Thread.sleep(3000);
        WebElement signIn = driver.findElement(By.xpath("//button"));
        signIn.click();

        WebElement facility = driver.findElement(By.xpath("//select[@name='facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        Thread.sleep(2000);
        WebElement admissionBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        Assert.assertTrue(admissionBox.isEnabled()&&admissionBox.isDisplayed()&&!admissionBox.isSelected());
        admissionBox.click();
        Assert.assertTrue(admissionBox.isSelected());
        Thread.sleep(2000);
//        if (admissionBox.isEnabled() && admissionBox.isDisplayed() && !admissionBox.isSelected()) {
//            admissionBox.click();
//        }

        WebElement healthCare = driver.findElement(By.xpath("//input[@value='Medicaid']"));
        healthCare.click();
        Thread.sleep(2000);
        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("07/08/2024");

        WebElement comment = driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("I love Selenium");

        WebElement bookAppointment = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        bookAppointment.click();

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Confirmation')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header PASSED" : "Header FAILED");

        WebElement information = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(information.getText().trim());

        WebElement homePageButton = driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        homePageButton.click();

        System.out.println(driver.getCurrentUrl());

        driver.quit();


    }
}
