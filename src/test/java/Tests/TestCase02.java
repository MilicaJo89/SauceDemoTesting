package Tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase02 extends MainTestClass {

    @Test
    public void TestCase() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        String title = driver.getTitle();
        assertEquals("Swag Labs", title);

        // Find the login form elements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Enter valid login credentials
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Click the login button
        loginButton.click();

        // Click on the "Sauce Labs Backpack" item
        driver.findElement(By.cssSelector("#item_4_title_link")).click();

        // Verify the title, description, and price of this item
        title = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(title, "Sauce Labs Backpack");

        String description = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]")).getText();
        Assert.assertTrue(description.contains("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."));

        String price = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]")).getText();
        Assert.assertEquals(price, "$29.99");

        // Click on the "ADD TO CART" button
        driver.findElement(By.cssSelector(".btn_primary.btn_inventory")).click();

        // Click on the "BACK TO PRODUCTS" button
        driver.findElement(By.cssSelector(".btn_secondary.btn_inventory")).click();

        // From the product home page, click on the "ADD TO CART" button for the "Sauce Labs Fleece Jacket" item
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Click on the "Shopping Cart" button to open the Shopping Cart page
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // Click on the "Checkout" button to continue with the order
        driver.findElement(By.id("checkout")).click();

        // Enter Firstname, Lastname, Zipcode and click on the "Finish" button
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Firstname");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Lastname");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("Zipcode");
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

        // Click on the "Finish" button
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        // Verify "THANK YOU FOR YOUR ORDER" is displayed
        String confirmationMessage = driver.findElement(By.cssSelector("h2")).getText();
        Assert.assertEquals(confirmationMessage, "THANK YOU FOR YOUR ORDER");


        // Verify that the burger menu is present
        WebElement burgerMenuIcon = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue("Burger menu not found", burgerMenuIcon.isDisplayed());

        // Click on the burger menu to open it
        burgerMenuIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
        logOut.click();
        }
    }

