package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {
        //Create a WebDriver for communication between laptop and website
        WebDriver driver = new ChromeDriver();
        //navigate to the website with object (driver)
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        // we need to validate you are on the facebook page
        String actualTitle = driver.getTitle(); // will give you the title of the page
        String expectedTitle = "Facebook – log in or sign up";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title passed");
        } else {
            System.out.println("Title failed");
        }
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/";
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("URL Passed");
        } else {
            System.out.println("URL Failed");
        }
//This is how we close our Chrome
//        driver.close();
    }
}

