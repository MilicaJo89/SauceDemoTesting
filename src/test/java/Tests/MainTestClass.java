package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\PC\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        System.out.println(driver.getTitle());

    }
}
