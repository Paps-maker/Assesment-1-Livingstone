public class tempconvertor {

    public static void main(String[] args) {

        System.out.println("20°C = " + celsiusToFahrenheit(20) + "°F");
        System.out.println("68°F = " + fahrenheitToCelsius(68) + "°C");

        printTemperatureTable();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double celsiusToFahrenheit(int celsius) {
        return (celsius * 9 / 5.0) + 32;
    }
    public static void printTemperatureTable() {
        System.out.println("\nTemperature Conversion Table");
        System.out.println("°C\t°F");

        for (int celsius = 0; celsius <= 100; celsius += 10) {
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%d\t%.1f%n", celsius, fahrenheit);
        }
    }
}
