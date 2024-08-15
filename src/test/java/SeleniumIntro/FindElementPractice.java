package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        int counter = 0;
        for (WebElement link : allLinks){
            System.out.println(link.getText().trim());
            counter++;

        }
        System.out.println(allLinks.size());
        System.out.println(counter);

        /*
        Print out link which length is >=12 counter = 30 something
         */
        int counter2=0;
        for(WebElement link: allLinks){
            if(link.getText().length()>=12){
                System.out.println(link.getText());
             counter2++;
            }
            System.out.println(counter2);
        }
    }
}
