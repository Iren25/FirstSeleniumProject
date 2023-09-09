package DemoWebShop.models;

public class Product {
    String name; 
    String email; 
    String quantity;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Product setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public Product setQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }
}