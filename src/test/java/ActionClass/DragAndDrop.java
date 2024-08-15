package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        acceptCookies.click();

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).perform();

        //Orange Box

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeTextBefore = BrowserUtils.getText(orangeBox);
        String excpectedOrangeTextBefore = "... Or here.";
        Assert.assertEquals(actualOrangeTextBefore, excpectedOrangeTextBefore);

        String actualBackgroudColor = orangeBox.getCssValue("background-color");
        String expectedBackGroundColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualBackgroudColor, expectedBackGroundColor);

        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.dragAndDrop(blueCircle, orangeBox).perform();
        Thread.sleep(2000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeTextAfter = BrowserUtils.getText(orangeBox);
        String expctedOtangeTextAfter = "You did great!";
        Assert.assertEquals(actualOrangeTextAfter, expctedOtangeTextAfter);
    }


    @Test
    public void clickAndHold() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(3000);
        acceptCookies.click();

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300, 300).perform();

        WebElement bluebox = driver.findElement(By.xpath("//div[@class='test1']"));
        WebElement blueCircle = driver.findElement(By.xpath("//div[@id='draggable']"));

        actions.clickAndHold(blueCircle).moveToElement(bluebox).release().perform();
        Thread.sleep(3000);
        bluebox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMsg = BrowserUtils.getText(bluebox);
        String expectedMsg = "You did great!";
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
