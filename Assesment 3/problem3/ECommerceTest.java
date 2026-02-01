public class ECommerceTest {
    public static void main(String[] args) {

        try {
            Product laptop = new Electronics(
                    "E001", "Laptop", 120000, 5,
                    24, 65
            );

            laptop.displayProductInfo();
            laptop.sell(1);

        } catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
