package SoftAssertClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class LogicAndPractice {

    public int getSum(int number1,int number2){
        return number1+number2;
    }
    @Test
    public void hardAssert(){
        Assert.assertEquals(getSum(1,3),4);
        System.out.println("test1");
        Assert.assertEquals(getSum(3,6),9);
        System.out.println("test2");
        Assert.assertEquals(getSum(1,2),3);
        System.out.println("test3");
    }
    @Test
    public void softAssert(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getSum(1,2),3);
        System.out.println("test1");
        softAssert.assertEquals(getSum(3,5),8);
        System.out.println("test2");
        softAssert.assertEquals(getSum(6,2),8);
        System.out.println("test3");
        softAssert.assertAll();
    }
    @Test
    public  void  practice(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        actions.scrollByAmount(300,300).perform();

        WebElement acceptButton=driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        actions.click(acceptButton).perform();

        WebElement drop=driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualDrop= BrowserUtils.getText(drop);
        String expectedDrop="Drop heree";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualDrop,expectedDrop);


        WebElement notAcceptable=driver.findElement(By.cssSelector("#notAcceptable"));
        actions.clickAndHold(notAcceptable).moveToElement(drop).release().perform();

        actualDrop=BrowserUtils.getText(drop);
//        expectedDrop="Drop here";
        expectedDrop="Drop here";
//        with error, this is a
        Assert.assertEquals(actualDrop,expectedDrop);

        WebElement acceptable=driver.findElement(By.cssSelector("#acceptable"));
        actions.clickAndHold(acceptable).moveToElement(drop).release().perform();

        actualDrop=BrowserUtils.getText(drop);
        expectedDrop="Dropped!";
        Assert.assertEquals(actualDrop,expectedDrop);
    }
}
