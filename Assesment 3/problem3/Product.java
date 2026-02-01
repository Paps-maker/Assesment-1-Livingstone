public abstract class Product {

    protected String productId;
    protected String name;
    protected double price;
    protected int stock;

    public Product(String productId, String name, double price, int stock) {
        if (productId == null || productId.isEmpty() || price <= 0) {
            throw new InvalidProductException("Invalid product data");
        }
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public abstract double calculateDiscount();
    public abstract String getProductType();

    public double applyTax() {
        return price * 0.16;
    }

    public void sell(int quantity) throws OutOfStockException {
        if (quantity <= 0) {
            throw new InvalidProductException("Invalid quantity");
        }
        if (quantity > stock) {
            throw new OutOfStockException("Out of stock");
        }
        stock -= quantity;
    }

    public void displayProductInfo() {
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Type: " + getProductType());
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + applyTax());
        System.out.println("Stock: " + stock);
    }
}
