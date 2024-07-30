public class ECommerceSearch {
    public Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product binarySearch(Product[] products, String productName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareTo(productName);
            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}