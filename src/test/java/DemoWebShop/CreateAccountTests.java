package DemoWebShop;

import DemoWebShop.models.User;
import DemoWebShop.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isElementPresent(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register"))){
            app.getUser().clickOnLogoutButton();
        } else {
            app.getUser().clickOnLoginButton();
        }
        app.getUser().click(By.cssSelector("div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register"));
        //click on Registration link - div.master-wrapper-page:nth-child(4) div.master-wrapper-content div.header:nth-child(2) div.header-links-wrapper div.header-links ul:nth-child(1) li:nth-child(1) > a.ico-register

    }

   /* @Test
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
    } */

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnGender();
        app.getUser().fillRegistrationForm(new User().setFirstname("Peter")
                .setLastname("Johns")
                .setEmail("fanbanan@gmail.com")
                .setPassword("qwerty12345"));
        app.getUser().type(By.cssSelector("[id='ConfirmPassword']"), ("qwerty12345"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isErrorPresent(By.cssSelector("[class='validation-summary-errors']")));
    }




    @Test(dataProvider = "newUser", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveTestFromDataProvider(String firstname, String lastname,
                                                                String email, String password,
                                                                String confirmPassword) {

        app.getUser().clickOnGender();
        app.getUser().type(By.cssSelector("[id='FirstName']"), firstname);
        app.getUser().type(By.cssSelector("[id='LastName']"), lastname);
        app.getUser().fillLoginForm(new User()
                .setEmail(email)
                .setPassword(password));
        app.getUser().type(By.cssSelector("[id='ConfirmPassword']"), confirmPassword);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[class='page registration-result-page']")));
    }
    @Test(dataProvider = "newUserWithCSVFile", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveTestFromDataProviderWithCSV(User user) {

        app.getUser().clickOnGender();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[class='page registration-result-page']")));
    }



}
