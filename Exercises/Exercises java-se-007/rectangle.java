public class rectangle {

   
    private double width;
    public void setWidth(double width) {
        this.width = width;
    }

    private double height;

    
    public rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    
    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    
    public rectangle(double size) {
        this.width = size;
        this.height = size;
    }

    
    public double calculateArea() {
        return width * height;
    }

    
    public void displayInfo() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + calculateArea());
    }

    public static void main(String[] args) {

        rectangle r1 = new rectangle();
        System.out.println("Default Rectangle:");
        r1.displayInfo();
        System.out.println();
        rectangle r2 = new rectangle(5, 10);
        System.out.println("Rectangle 5x10:");
        r2.displayInfo();
        System.out.println();

        rectangle r3 = new rectangle(7);
        System.out.println("Square 7x7:");
        r3.displayInfo();
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
