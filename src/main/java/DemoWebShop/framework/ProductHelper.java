package DemoWebShop.framework;

import DemoWebShop.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductHelper extends HelperBase{
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton() {
        click(By.xpath("//input[@id='add-to-cart-button-2']"));
    }

    public void fillRequiredField(Product product) {
        type(By.cssSelector("[class='recipient-name']"), product.getName());
        type(By.cssSelector("[class='recipient-email']"), product.getEmail());
        type(By.xpath("//input[@class='qty-input']"), product.getQuantity());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[class='button-2 product-box-add-to-cart-button']"));
    }

    public boolean isProductAdded(String text) {
       List<WebElement> products = driver.findElements(By.cssSelector("[class='attributes']"));
       for(WebElement el: products) {
           if(el.getText().contains(text))
               return true;
       }
       return false;
    }

    public void addProduct() {
        clickOnAddLink();
        fillRequiredField(new Product()
                .setName("Mary")
                .setEmail("mary@gmail.com")
                .setQuantity("1"));
        clickOnAddButton();
        clickOnShoppingCartLink();
    }

    public void removeProduct() {
        clickOnShoppingCartLink();
        click(By.cssSelector("[name='removefromcart']"));
        click(By.cssSelector("[name='updatecart']"));
    }

    public void clickOnShoppingCartLink() {
        click(By.xpath("span[contains(text(),'Shopping cart')]"));
    }
}
