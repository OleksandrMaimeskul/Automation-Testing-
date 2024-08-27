package TestNGConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.lang.Double.parseDouble;

public class SauceLab {
    //https://www.saucedemo.com/
    //TestName --> ValidateHappyPathLoginFunctionality
    /*
    1-Login Successfully with "standard_user", "secret-sauce"
    2-Validate Title(assert)
    3-Validate URL (ASSERT)
    4-Quit
     */
    @Test
    public void ValidateHappyPathLoginFunctionality() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        String actualTitle = "Swag Labs";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedURL, actualURL);

        driver.quit();

    }

    @Test
    public void negativeLoginFunctionality() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("SECRET_SAUCE");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

        WebElement message = driver.findElement(By.tagName("h3"));
        String actualMSG = message.getText().trim();
        String expectedMSG = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualMSG, expectedMSG);
        Thread.sleep(3000);
        driver.quit();
    }

//    @Test
//    public void validateProductDescription() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.saucedemo.com/");
//
//        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Username']"));
//        login.sendKeys("standard_user");
//        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        password.sendKeys("secret_sauce");
//        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
//        button.click();
//
//        List<WebElement> allProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
//        for (WebElement product : allProducts) {
//            if (product.getText().trim().equals("Sauce Labs Bolt T-Shirt")) {
//                product.click();
//                break;
//            }
//        }
//        WebElement header = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
//        String actualHEader = header.getText().trim();
//        String expectedHeader = "Sauce Labs Bolt T-Shirt";
//        Assert.assertEquals(actualHEader,expectedHeader);
//
//        WebElement text = driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']"));
//        String actualText = text.getText().trim();
//        String expectedText = "Sauce Labs Bolt T-Shirt";
//        Assert.assertTrue(actualText.contains(expectedText));
//
//        WebElement price = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));
//        String actualPrice = price.getText().trim();
//        String expectedPrice = "$15.99";
//        Assert.assertEquals(actualPrice,expectedPrice);
//
//        WebElement cartButton = driver.findElement(By.xpath("//button[@data-test='add-to-cart']"));
//        cartButton.click();
//
//        Thread.sleep(3000);
//        driver.quit();
//    }

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
/*
    1-Click Add to Card button
    2-Click the cart at the top right
    3-Validate the name of the item "Sauce Labs Bolt T-Shirt" header
    4-Click check out button
    5-Provide the information
    6-Add the item total(15.99) and tax(1.28) and validate this number with total(17.27)
    7-Click Finish Button
    8-Validate "Thank you for your order!"
    9-driver.quit()
     */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement login = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        login.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

        List<WebElement> allProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        for (WebElement product : allProducts) {
            if (product.getText().trim().equals("Sauce Labs Bolt T-Shirt")) {
                product.click();
                break;
            }
        }
        WebElement cartButton = driver.findElement(By.xpath("//button[@data-test='add-to-cart']"));
        cartButton.click();
        WebElement cart = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
        cart.click();

        WebElement headerCheckOut = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"));
        String actualHeCheckOut = headerCheckOut.getText().trim();
        String expectedHeCheckOut = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actualHeCheckOut, expectedHeCheckOut);

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']"));
        checkoutButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys("Oleksandr");
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Maimeskul");
        WebElement zipCode = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
        zipCode.sendKeys("77339");

        WebElement continueButton = driver.findElement(By.xpath("//input[@data-test='continue']"));
        continueButton.click();

        WebElement itemPrice = driver.findElement(By.cssSelector(".summary_subtotal_label"));
        Thread.sleep(3000);
//        Double total = parseDouble(totalPrice.getText().trim().substring(13));
        Double item = parseDouble(itemPrice.getText().substring(itemPrice.getText().indexOf("$") + 1));
        WebElement taxPrice = driver.findElement(By.cssSelector(".summary_tax_label"));
        Double tax = parseDouble(taxPrice.getText().substring(taxPrice.getText().indexOf("$") + 1));
//        Double tax = parseDouble(taxPrice.getText().trim().substring(6));

        WebElement totalWithTax = driver.findElement(By.cssSelector(".summary_total_label"));
        Double total = parseDouble(totalWithTax.getText().substring(totalWithTax.getText().indexOf("$") + 1));


//        if(item+tax ==total){
//            System.out.println("Amount the same!");
//        } else {
//            System.out.println("Something went wrong!");
//        }
//        Double totalWithTa = parseDouble(totalWithTax.getText().trim().substring(8));
        Assert.assertEquals(total, (item + tax));
        WebElement finishButton = driver.findElement(By.xpath("//button[@data-test='finish']"));
        finishButton.click();
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Thank you for your order!";
        Assert.assertEquals(actualHeader, expectedHeader);
//        Thread.sleep(3000);
        driver.quit();
    }
}

