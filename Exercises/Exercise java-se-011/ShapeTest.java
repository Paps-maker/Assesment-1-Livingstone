abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "Shape [color=" + color + ", filled=" + filled + "]";
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", " + super.toString() + "]";
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + ", " + super.toString() + "]";
    }
}

class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(String color, boolean filled, double base, double height) {
        super(color, filled);
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        // assuming equilateral triangle
        return 3 * base;
    }

    @Override
    public String toString() {
        return "Triangle [base=" + base + ", height=" + height + ", " + super.toString() + "]";
    }
}

public class ShapeTest {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle("Red", true, 5),
            new Rectangle("Blue", false, 4, 6),
            new Triangle("Green", true, 3, 4)
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
            
        }
    }
}
