import java.util.*;
public  class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public void updateProduct(int productId, int newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setPrice(newPrice);
        }
    }

    public void updateQuantity(int productId, int newQuantity) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
        }
    }

    public void displayInventory() {
        System.out.println("P_ID\tP_NAME\t\tQUANTITY\tPRICE/ITEM");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
