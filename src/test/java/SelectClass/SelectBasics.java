package SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void selectMethods() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //Once you are sure the location of Select then create an object from Select Class
        Select options = new Select(dropdown);
        String actualDefaultOption = options.getFirstSelectedOption().getText().trim();
        String expectedDefaultOption = "Please select an option";
        Assert.assertEquals(actualDefaultOption, expectedDefaultOption);


        options.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        options.selectByValue("2"); // it checks the option based on the value attribute value
        Thread.sleep(2000);
        options.selectByIndex(1); // it checks the option based on the index number of option.

       List<WebElement> allOptions = options.getOptions();
       List<String> expectedOptions = Arrays.asList("Please select an option","Option 1","Option 2");
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertEquals(allOptions.get(i).getText().trim(),expectedOptions.get(i));
        }

    }
}