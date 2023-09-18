package DemoWebShop;

import DemoWebShop.models.User;
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

    @DataProvider
    public Iterator<Object[]> newUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"Ronald1", "Smith", "smith007@gmail.com", "qwerty001", "qwerty001"});
        list.add(new Object[] {"Ronald2", "Smith", "smith008@gmail.com", "qwerty002", "qwerty002"});
        list.add(new Object[] {"Ronald3", "Smith", "smith009@gmail.com", "qwerty003", "qwerty003"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newUserWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstname(split[0])
                    .setLastname(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }


    @Test(dataProvider = "newUser")
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
    @Test(dataProvider = "newUserWithCSVFile")
    public void newUserRegistrationPositiveTestFromDataProviderWithCSV(User user) {

        app.getUser().clickOnGender();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("[class='page registration-result-page']")));
    }



}
