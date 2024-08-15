package SeleniumIntro;

import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        // driver,get()
        // driver.getTitle()
        //driver,getCurrentURL()
        //driver.close()
        //driver.manage.window.maximize()
        // driver.navigate.to{} --> same thing like get but little bit different
        // driver.navigate.refresh()
        //driver.navigate.back()
        //driver.navigate.forward()
        //driver,getPageSource()
        //driver.quit()
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000); // is a way to pause the system
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward();
        System.out.println(driver.getTitle()); //<<--- Facebook
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println(driver.getPageSource()); // it will take HTML structure of the page
        Thread.sleep(2000);
        driver.quit();
    }
}
