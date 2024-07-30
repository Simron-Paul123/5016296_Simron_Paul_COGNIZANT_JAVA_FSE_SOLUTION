public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private int price;

    public Product(int productId, String productName, int quantity, int price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public int getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return productId + "\t" + productName + "\t" + quantity + "\t" + price;
    }
}