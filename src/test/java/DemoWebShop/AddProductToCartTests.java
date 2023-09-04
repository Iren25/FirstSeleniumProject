package DemoWebShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductToCartTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(text(),'Log out')]"))) {
            click(By.xpath("//a[contains(text(),'Log in')]"));
        }
        type(By.cssSelector("[id='Email']"), "fanbanan@gmail.com");
        type(By.cssSelector("[id='Password']"), "qwerty12345");
        click(By.xpath("//input[@class='button-1 login-button']"));
    }

    @Test
    public void addProductToCartPositiveTest() {
        click(By.cssSelector("[class='button-2 product-box-add-to-cart-button']"));
        type(By.cssSelector("[class='recipient-name']"), "Mary");
        type(By.cssSelector("[class='recipient-email']"), "mary@gmail.com");
        type(By.xpath("//input[@class='qty-input']"), "1");
        click(By.xpath("//input[@id='add-to-cart-button-2']"));
        click(By.xpath("//span[@class='cart-label']"));
        Assert.assertTrue(isProductAdded("Mary"));

    }

    public boolean isProductAdded(String text) {
       List<WebElement> products = driver.findElements(By.cssSelector("[class='attributes']"));
       for(WebElement el: products) {
           if(el.getText().contains(text))
               return true;
       }
       return false;
    }
}
