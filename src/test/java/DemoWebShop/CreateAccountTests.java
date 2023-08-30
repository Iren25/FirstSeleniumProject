package DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //precondition: if user should be logged out

    @BeforeMethod
    public void ensurePrecondition() {
        if(!isElementPresent(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register"))){
            driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        }
        driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register")).click();
        //click on Registration link - div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register

    }

    @Test
    public void newUserRegistrationPositiveTest() {
        //choose a gender - [id='gender-female'] - css
        driver.findElement(By.cssSelector("[id='gender-male']")).click();
        //enter FirstName - [id='FirstName'] - css
        driver.findElement(By.cssSelector("[id='FirstName']")).click();
        driver.findElement(By.cssSelector("[id='FirstName']")).clear();
        driver.findElement(By.cssSelector("[id='FirstName']")).sendKeys("Peter");
        //enter LastName - [id='LastName'] - css
        driver.findElement(By.cssSelector("[id='LastName']")).click();
        driver.findElement(By.cssSelector("[id='LastName']")).clear();
        driver.findElement(By.cssSelector("[id='LastName']")).sendKeys("Johns");
        //enter email - [id='Email'] - css
        driver.findElement(By.cssSelector("[id='Email']")).click();
        driver.findElement(By.cssSelector("[id='Email']")).clear();
        driver.findElement(By.cssSelector("[id='Email']")).sendKeys("fanbanan@gmail.com");
        //enter password - [id='Password'] - css
        driver.findElement(By.cssSelector("[id='Password']")).click();
        driver.findElement(By.cssSelector("[id='Password']")).clear();
        driver.findElement(By.cssSelector("[id='Password']")).sendKeys("qwerty12345");
        //confirm password - [id='ConfirmPassword'] - css
        driver.findElement(By.cssSelector("[id='ConfirmPassword']")).click();
        driver.findElement(By.cssSelector("[id='ConfirmPassword']")).clear();
        driver.findElement(By.cssSelector("[id='ConfirmPassword']")).sendKeys("qwerty12345");
        //click on Registration button - [id='register-button'] - css
        driver.findElement(By.cssSelector("[id='register-button']")).click();
        //assert registration title displayed - [class='page registration-result-page']
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='page registration-result-page']")));



    }


    //continue button displayed - [class='button-1 register-continue-button']


}
