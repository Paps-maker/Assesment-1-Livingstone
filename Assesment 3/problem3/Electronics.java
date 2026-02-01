public class Electronics extends Product {

    @SuppressWarnings("unused")
    private final int warrantyPeriod;
    private int powerConsumption;

    public Electronics(String productId, String name, double price, int stock,
                       int warrantyPeriod, int powerConsumption) {
        super(productId, name, price, stock);
        this.warrantyPeriod = warrantyPeriod;
        this.powerConsumption = powerConsumption;
    }

    @SuppressWarnings("override")
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public String getProductType() {
        return "Electronics";
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
