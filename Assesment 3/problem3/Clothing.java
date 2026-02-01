public class Clothing extends Product {

    private String size;
    private String material;
    private String color;

    public Clothing(String productId, String name, double price, int stock,
                    String size, String material, String color) {
        super(productId, name, price, stock);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.15;
    }

    @SuppressWarnings("override")
    public String getProductType() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
