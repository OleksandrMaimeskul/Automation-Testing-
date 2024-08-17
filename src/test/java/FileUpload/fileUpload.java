package FileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class fileUpload {
    @Test
    public void fileUpload() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("C:\\Users\\mayme\\Flag_of_the_United_States.png");

        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

        WebElement textHeader = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualPng = BrowserUtils.getText(textHeader);
        String expectedPng = "Flag_of_the_United_States.png";
        Assert.assertEquals(actualPng, expectedPng);
    }

    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement chooseButton = driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseButton.sendKeys("C:\\Users\\mayme\\Flag_of_the_United_States.png");

        WebElement checkBox = driver.findElement(By.className("field_check"));
        checkBox.click();

        WebElement submit = driver.findElement(By.cssSelector("#submitbutton"));
        submit.click();
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.xpath("//h3"));
        String actualText = BrowserUtils.getText(text);
        String expectedText = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualText, expectedText);
    }
}
