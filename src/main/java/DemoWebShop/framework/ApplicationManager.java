package DemoWebShop.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    UserHelper user;
    ProductHelper product;
    HomePageHelper homePage;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        product = new ProductHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public ProductHelper getProduct() {
        return product;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void stop() {
        driver.quit();
    }

}
