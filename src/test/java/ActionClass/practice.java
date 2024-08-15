package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;

public class practice {
    @Test
    public void drugAndDrop() throws InterruptedException {

        /*
        1-navigate to the website
        2-Validate the box text is "Drop here"
        3-Drag and Drop the "Drag me" Box
        4-Validate the text changed to "Dropped!"
        5-Color changed to navy blue.(rgba(70, 130, 180, 1))
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.scrollByAmount(300, 300).perform();
        WebElement dropBox = driver.findElement(By.xpath("//div[@id= 'simpleDropContainer']//div[@class='drop-box ui-droppable']"));
        String actualMsg = BrowserUtils.getText(dropBox);
        String expectedMsg = "Drop here";
        Assert.assertEquals(actualMsg, expectedMsg);
        Thread.sleep(2000);
        WebElement drag = driver.findElement(By.xpath("//div[@id= 'simpleDropContainer']//div[@class='drag-box mt-4 ui-draggable ui-draggable-handle']"));
        actions.dragAndDrop(drag, dropBox).perform();


        String actualText = BrowserUtils.getText(dropBox);
        String expectedText = "Dropped!";
        Assert.assertEquals(actualText, expectedText);
        String actualColor = dropBox.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);


    }

    @Test
    public void drugAndDrop2() throws InterruptedException {
/*
        1-Navigate to the website
        2-Validate the text is Box text is "Drop here"
        3-Click and Hold Not acceptable box and release into Box
        4-Validate the box text is still "Drop here"
        5-Click and Hold Acceptable box and release into Box
        6-Validate box text is "Dropped!"

         */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.scrollByAmount(300, 300).perform();

        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        actions.click(acceptButton).perform();
        WebElement dropBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));

        Thread.sleep(3000);
        WebElement nonAcceptable = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='notAcceptable']"));
        actions.clickAndHold(nonAcceptable).moveToElement(dropBox).release().perform();
        String actualText = BrowserUtils.getText(dropBox);
        String expectedText = "Drop here";
        Assert.assertEquals(actualText,expectedText);
        WebElement acceptable = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='acceptable']"));
        actions.clickAndHold(acceptable).moveToElement(dropBox).release().perform();


        actualText = BrowserUtils.getText(dropBox);
        expectedText = "Dropped!";
        Assert.assertEquals(actualText,expectedText);




    }
}