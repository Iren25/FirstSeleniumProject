package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeworkLesson3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void findElementByCssTest() {
        driver.findElement(By.cssSelector("#topcartlink"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("#mob-menu-button"));
        driver.findElement(By.cssSelector("[name='description']"));
        driver.findElement(By.cssSelector("[id='poll-voting-progress-1']"));
        driver.findElement(By.cssSelector("[class='poll-vote-error']"));
        driver.findElement(By.cssSelector("[class='poll-display-text']"));
        driver.findElement(By.cssSelector("[class$='logo']"));
        driver.findElement(By.cssSelector("[class*='ajax']"));
        driver.findElement(By.cssSelector("[class^='fly']"));
    }

    @Test
    public void findElementByXpathTest() {
        driver.findElement(By.xpath("//li[@id='topcartlink']"));
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//div[@id='mob-menu-button']"));
        driver.findElement(By.xpath("//head/meta[2]"));
        driver.findElement(By.xpath("//span[@id='poll-voting-progress-1']"));
        driver.findElement(By.xpath("//div[@id='block-poll-vote-error-1']"));
        driver.findElement(By.xpath("//strong[contains(text(),'Do you like nopCommerce?')]"));
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[1]"));
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[3]"));
        driver.findElement(By.xpath("//div[@id='flyout-cart']"));
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
