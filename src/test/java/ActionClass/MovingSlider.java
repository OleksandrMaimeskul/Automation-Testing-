package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MovingSlider {

    @Test
    public void slider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input"));
        WebElement range = driver.findElement(By.xpath("//span[@ id ='range']"));

        String expectedRange = "4";
        while(!BrowserUtils.getText(range).equals(expectedRange)){
            slider.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(1000);
        }
        Assert.assertEquals(expectedRange,BrowserUtils.getText(range));
    }
}
