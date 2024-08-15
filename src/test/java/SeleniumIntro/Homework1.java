package SeleniumIntro;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
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
    public static void main(String[] args) throws InterruptedException {
        /*
        1=Please navigate 3 different websites and use all if those methods above.
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(2500);
        driver.get("https://translate.google.com/?hl=ru&tab=TT&sl=is&tl=uk&op=translate");
        System.out.println(driver.getCurrentUrl())  ;
        System.out.println(driver.getTitle());
        Thread.sleep(2500);
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Thread.sleep(2500);
        driver.navigate().to("https://github.com/");
        Thread.sleep(2500);
        driver.navigate().refresh();
        driver.navigate().to("https://translate.google.com/?hl=ru&tab=TT&sl=is&tl=uk&op=translate");
        driver.navigate().back();
        Thread.sleep(2500);
        System.out.println(driver.getPageSource());
        driver.navigate().forward();
        driver.close();
        driver.quit();


    }
}
