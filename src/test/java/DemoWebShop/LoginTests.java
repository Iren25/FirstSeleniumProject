package DemoWebShop;

import DemoWebShop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLogoutPresent()) {
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().login();
        //assert Log out button present
        Assert.assertTrue(app.getUser().isLogoutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().fillLoginForm(new User().setPassword("qwerty12345"));
        app.getUser().clickOnProveLoginButton();
        //assert Log out button present
        Assert.assertTrue(app.getUser().isLogoutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutPasswordTest() {
        app.getUser().fillLoginForm(new User().setEmail("fanbanan@gmail.com"));
        app.getUser().clickOnProveLoginButton();
        //assert Log out button present
        Assert.assertTrue(app.getUser().isErrorPresent());
    }


}

