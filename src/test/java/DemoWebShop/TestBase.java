package DemoWebShop;

import DemoWebShop.framework.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void SetUp() {
        app.init();
    }


    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
