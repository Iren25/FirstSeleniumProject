package DemoWebShop;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveProductTest extends TestBase{

     @BeforeMethod
    public void ensurePrecondition() {
          if (app.getUser().isLogoutPresent()) {
              app.getUser().clickOnLogoutButton();
        }
          app.getUser().clickOnLoginButton();
        app.getUser().login();
        app.getProduct().addProduct();
     }

    @Test
    public void removeProductPositiveTest() {
        removeProduct();
    }

    public void removeProduct() {
        app.getProduct().removeProduct();
    }
}
