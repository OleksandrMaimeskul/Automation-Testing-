package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GetAttributesAndLoops {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        WebElement collapseButton = driver.findElement(By.xpath("//button"));
        collapseButton.click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@role = 'checkbox']"));
        for (WebElement checkbox : checkboxes) {
            if(checkbox.getAttribute("aria-checked").equals("false")){
                checkbox.click();
            }
        }
    }
}
