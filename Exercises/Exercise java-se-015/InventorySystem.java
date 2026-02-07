import java.util.*;


class Product {

    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @SuppressWarnings("override")
    public String toString() {
        return "ID: " + id +
                " ,Name: " + name +
                " ,Price: ksh" + price +
                " ,Quantity: " + quantity;
    }
}




public class InventorySystem {

   
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Product> productArray = new ArrayList<>();

    
    @SuppressWarnings("FieldMayBeFinal")
    private LinkedList<Product> productLinked = new LinkedList<>();


    
    public void addProduct(Product product) {

        if (findProduct(product.getId()) != null) {
            System.out.println("Product with this ID already exists");
            return;
        }

        productArray.add(product);     
        productLinked.addLast(product); 

        System.out.println("Product added successfully.");
    }


    
    public void removeProduct(int id) {

        Product product = findProduct(id);

        if (product != null) {
            productArray.remove(product);
            productLinked.remove(product);
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }


    
    public Product findProduct(int id) {

        for (Product p : productArray) { // searching via ArrayList
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    
    public void updateStock(int id, int newQuantity) {

        Product product = findProduct(id);

        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Stock updated.");
        } else {
            System.out.println(" Product not found.");
        }
    }


   
    public void searchByName(String keyword) {

        boolean found = false;

        for (Product p : productLinked) { 
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching products.");
        }
    }


    
    public void sortByPrice() {

        Collections.sort(productArray, Comparator.comparingDouble(Product::getPrice));

        System.out.println("sorted by price.");

        displayProducts(productArray);
    }


    
    public void sortByName() {

        Collections.sort(productArray, Comparator.comparing(Product::getName));

        System.out.println("sorted by name.");

        displayProducts(productArray);
    }


    // Display Products
    public void displayProducts(List<Product> products) {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n INVENTORY");

        for (Product p : products) {
            System.out.println(p);
        }

        
        System.out.println("Total Products: " + products.size());
    }



    // MAIN METHOD
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InventorySystem manager = new InventorySystem();

        int choice;

        do {
            System.out.println("\n INVENTORY MANAGEMENT ");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Search by Name");
            System.out.println("6. Sort by Price");
            System.out.println("7. Sort by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();

                    manager.addProduct(new Product(id, name, price, qty));
                }

                case 2 -> {
                    System.out.print("Enter Product ID to remove: ");
                    manager.removeProduct(scanner.nextInt());
                }

                case 3 -> {
                    System.out.print("Enter Product ID to find: ");
                    Product found = manager.findProduct(scanner.nextInt());

                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("Product not found.");
                }

                case 4 -> {
                    System.out.print("Enter Product ID: ");
                    int pid = scanner.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();

                    manager.updateStock(pid, newQty);
                }

                case 5 -> {
                    System.out.print("Enter name keyword: ");
                    String keyword = scanner.nextLine();

                    manager.searchByName(keyword);
                }

                case 6 -> manager.sortByPrice();

                case 7 -> manager.sortByName();

                case 8 -> manager.displayProducts(manager.productArray);

                case 9 -> System.out.println("Exiting");

                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
