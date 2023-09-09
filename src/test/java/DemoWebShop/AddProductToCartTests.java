package DemoWebShop;

import DemoWebShop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToCartTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLogoutPresent()) {
            app.getUser().clickOnLoginButton();
        }
        app.getUser().fillLoginForm(new User()
                .setEmail("fanbanan@gmail.com")
                .setPassword("qwerty12345"));
        app.getUser().clickOnProveLoginButton();
    }

    @Test
    public void addProductToCartPositiveTest() {
        app.getProduct().addProduct();
        Assert.assertTrue(app.getProduct().isProductAdded("Mary"));

    }

    @AfterMethod
    public void postCondition(){
        app.getProduct().removeProduct();
    }
}
