package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class MoveToElement {
    @Test
    public void practiceMoveTo() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300).perform();

        List<WebElement> allImage = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));

        HashMap<String,String> productsInfo = new HashMap<>();

        for (int i = 0; i < allImage.size(); i++) {
            actions.moveToElement(allImage.get(i)).perform();
            productsInfo.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(productsInfo);


    }
}
