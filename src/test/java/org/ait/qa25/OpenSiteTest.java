package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {

    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        // driver.get("https://www.google.com/"); // открывает сайт без истории
        driver.navigate().to("https://www.google.com/"); // открывает с историей
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    // tests
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown() {
        driver.quit(); // закрывает все вкладки и браузер
        driver.close();// закрывает только одну вкладку, если вкладка всего одна, то закроет весь браузер
    }
}
