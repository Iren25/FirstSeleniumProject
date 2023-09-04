package DemoWebShop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(text(),'Log out')]"))) {
            click(By.xpath("//a[contains(text(),'Log in')]"));
        }
    }

    @Test
    public void loginPositiveTest() {
        type(By.cssSelector("[id='Email']"), "fanbanan@gmail.com");
        type(By.cssSelector("[id='Password']"), "qwerty12345");
        //click on Login button
        click(By.xpath("//input[@class='button-1 login-button']"));
        //assert Log out button present
        Assert.assertTrue(isElementPresent2(By.xpath("//a[contains(text(),'Log out')]")));
    }


}

   /* @BeforeMethod
    public void ensurePrecondition() {
        if(!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        //click on Login link - a:nth-child(4) -css
        clickOnLoginLink();
} */
