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
            click(By.xpath("//a[contains(text(),'Log in')]"));
        }
        click(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register"));
        //click on Registration link - div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register

    }

    @Test
    public void newUserRegistrationPositiveTest() {
        //choose a gender - [id='gender-female'] - css
        click(By.cssSelector("[id='gender-male']"));
        //enter FirstName - [id='FirstName'] - css
        type(By.cssSelector("[id='FirstName']"), "Peter");
        //enter LastName - [id='LastName'] - css
        type(By.cssSelector("[id='LastName']"), "Johns");
        //enter email - [id='Email'] - css
        type(By.cssSelector("[id='Email']"), "fanbanan@gmail.com");
        //enter password - [id='Password'] - css
        type(By.cssSelector("[id='Password']"), "qwerty12345");
        //confirm password - [id='ConfirmPassword'] - css
        type(By.cssSelector("[id='ConfirmPassword']"), "qwerty12345");
        //click on Registration button - [id='register-button'] - css
        click(By.cssSelector("[id='register-button']"));
        //assert registration title displayed - [class='page registration-result-page']
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='page registration-result-page']")));



    }


    //continue button displayed - [class='button-1 register-continue-button']


}
