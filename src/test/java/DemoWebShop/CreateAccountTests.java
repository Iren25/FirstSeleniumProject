package DemoWebShop;

import DemoWebShop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //precondition: if user should be logged out

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isElementPresent(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register"))){
            app.getUser().clickOnLoginButton();
        }
        app.getUser().click(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register"));
        //click on Registration link - div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register

    }

    @Test
    public void newUserRegistrationPositiveTest() {
        //choose a gender - [id='gender-female'] - css
        app.getUser().clickOnGender();
        //enter FirstName - [id='FirstName'] - css
        app.getUser().type(By.cssSelector("[id='FirstName']"), "Peter");
        //enter LastName - [id='LastName'] - css
        app.getUser().type(By.cssSelector("[id='LastName']"), "Johns");
        //enter email - [id='Email'] - css
        app.getUser().fillLoginForm(new User()
                .setEmail("fanbanan@gmail.com")
                .setPassword("qwerty12345"));
        //confirm password - [id='ConfirmPassword'] - css
        app.getUser().type(By.cssSelector("[id='ConfirmPassword']"), "qwerty12345");
        //click on Registration button - [id='register-button'] - css
        app.getUser().clickOnRegisterButton();
        //assert registration title displayed - [class='page registration-result-page']
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[class='page registration-result-page']")));

    }



}
