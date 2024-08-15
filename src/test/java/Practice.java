import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    public void practiceWindow() throws InterruptedException {

        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-scroll down to button 4 and Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful" and color
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and validate "AlertsDemo" then click  the "Click Me" button under prompt box
        7-Proud of yourself
 */
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button4 = driver.findElement(By.xpath("//button[@id='newTabsBtn']"));
        BrowserUtils.scrollWithJS(driver, button4);
        button4.click();
        BrowserUtils.switchWindow(driver, "Basic Controls");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        BrowserUtils.scrollWithJS(driver, firstName);
        firstName.sendKeys("Oleksandr");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Maimeskul");
        WebElement englishCheckBox = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        englishCheckBox.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("abrakadabra@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id='email']"));
        BrowserUtils.scrollWithJS(driver, password);
        password.sendKeys("1234567");

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='registerbtn']"));
        registerButton.click();

        WebElement textMsg = driver.findElement(By.xpath("//label[@style='color:green']"));
        String actualMsg = BrowserUtils.getText(textMsg);
        String expectedMsg = "Registration is Successful";
        Assert.assertEquals(actualMsg, expectedMsg);

        String actualColor = textMsg.getCssValue("color");
        String expectedColor = "rgba(0, 128, 0, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        BrowserUtils.switchWindow(driver, "Window Handles Practice");
        Thread.sleep(1000);
        driver.navigate().refresh();
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeader, expectedHeader);

        BrowserUtils.switchWindow(driver, "AlertsDemo");
        WebElement headerAlerts = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        actualHeader = BrowserUtils.getText(headerAlerts);
        expectedHeader = "AlertsDemo";
        Assert.assertEquals(actualHeader, expectedHeader);
        WebElement clickButton = driver.findElement(By.id("promptBox"));
        clickButton.click();
        Thread.sleep(1000);
        driver.quit();



        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-scroll down to button 4 and Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful" and color
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and validate "AlertsDemo" then click  the "Click Me" button under prompt box
        7-Proud of yourself
 */
    }
}
