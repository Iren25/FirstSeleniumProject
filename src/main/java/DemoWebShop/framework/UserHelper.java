package DemoWebShop.framework;

import DemoWebShop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.awt.SystemColor.text;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector(".ico-login"));
    }

    public boolean isLogoutButtonPresent() {
        return isElementPresent2(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public void clickOnLogoutButton() {click(By.xpath("//a[contains(text(),'Log out')]")); }

    public void clickOnProveLoginButton() {
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    public void login() {
        fillLoginForm(new User()
                .setEmail("fanbanan@gmail.com")
                .setPassword("qwerty12345"));
        clickOnProveLoginButton();
    }

    public void fillLoginForm(User user) {
        if (text != null) {
            type(By.cssSelector("[id='Email']"), user.getEmail());
            pause(1000);
            type(By.cssSelector("[id='Password']"), user.getPassword());
            pause(1000);
        }
    }

    public void fillRegistrationForm(User user) {
        if (text != null) {
            type(By.cssSelector("[id='FirstName']"), user.getFirstname());
            pause(500);
            type(By.cssSelector("[id='LastName']"), user.getLastname());
            pause(500);
            type(By.cssSelector("[id='Email']"), user.getEmail());
            pause(500);
            type(By.cssSelector("[id='Password']"), user.getPassword());
            pause(500);
            type(By.cssSelector("[id='ConfirmPassword']"), user.getPassword());
        }
    }

    public void clickOnLoginButton() {
        click(By.xpath("//a[contains(text(),'Log in')]"));
    }

    public boolean isLogoutPresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'Log out')]"));
    }

    public void clickOnRegisterButton() {
        click(By.cssSelector("[id='register-button']"));
    }

    public void clickOnGender() {
        click(By.cssSelector("[id='gender-male']"));
    }

    public boolean isErrorPresent() {
        return isElementPresent(By.cssSelector("[class='validation-summary-errors']"));
    }



}
