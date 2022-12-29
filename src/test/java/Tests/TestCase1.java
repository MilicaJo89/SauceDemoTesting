package Tests;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase1 extends MainTestClass {

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

        WebElement productsHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertTrue(productsHeader.isDisplayed());

        // Verify that the shopping cart icon is present
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue(shoppingCart.isDisplayed());

        // Verify that the burger menu is present
        WebElement burgerMenu = driver.findElement(By.className("bm-burger-button"));
        Assert.assertTrue(burgerMenu.isDisplayed());

        // Verify that the Twitter link is present
        WebElement twitterLink = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"));
        Assert.assertTrue(twitterLink.isDisplayed());

        // Verify that the Facebook link is present
        WebElement facebookLink = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a"));
        Assert.assertTrue(facebookLink.isDisplayed());

        WebElement linkedinLink = driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a"));
        Assert.assertTrue(linkedinLink.isDisplayed());


        // Verify that the burger menu is present
        WebElement burgerMenuIcon = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue("Burger menu not found", burgerMenuIcon.isDisplayed());

        // Click on the burger menu to open it
        burgerMenuIcon.click();

        // Verify that the burger element is present
        boolean isLoginVisible = driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
        boolean value = driver.findElement(By.id("logout_sidebar_link")).isEnabled();
        value = driver.findElement(By.id("logout_sidebar_link")).isSelected();


        // Find the logout button in the menu and click it
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        logoutButton.click();

        // Verify that the login form is displayed again, indicating that the logout was successful
        WebElement loginForm = driver.findElement(By.id("login_button_container"));
        Assert.assertTrue(loginForm.isDisplayed());

    }
}

