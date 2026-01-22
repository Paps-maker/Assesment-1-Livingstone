public final class Temperature {

   
    private double celsius;

    public Temperature(double celsius) {
        setCelsius(celsius);
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        if (celsius >= -273.15) {
            this.celsius = celsius;
        } else {
            System.out.println("Celsius cannot be below absolute zero (-273.15°C).");
            this.celsius = -273.15;
        }
    }

    public double getFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    public double getKelvin() {
        return celsius + 273.15;
    }

    public double toFahrenheit() {
        return getFahrenheit();
    }

    public double toKelvin() {
        return getKelvin();
    }

    public void displayTemperatures() {
        System.out.println("Celsius: " + celsius + "°C");
        System.out.println("Fahrenheit: " + getFahrenheit() + "°F");
        System.out.println("Kelvin: " + getKelvin() + "K");
        
    }
   
    public static void main(String[] args) {

        Temperature t1 = new Temperature(25);
        t1.displayTemperatures();

        
        Temperature t2 = new Temperature(-300);
        t2.displayTemperatures();

        
        t2.setCelsius(100);
        t2.displayTemperatures();
    }
}
