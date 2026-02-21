import java.util.Scanner;

interface Polygon {
    double area();
    double perimeter();
}


class Quadrilateral implements Polygon {

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}


class Rectangle extends Quadrilateral {

    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}


class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }
}

class Triangle implements Polygon {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public double perimeter() {
        return base + height + height;
    }
}

class Pentagon implements Polygon {

    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 1.72 * side * side;
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }
}

class Hexagon implements Polygon {

    private double side;

    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 2.6 * side * side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }
}

class Octagon implements Polygon {

    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 4.8 * side * side;
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }
}

public class PolygonCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Create a polygon:");
        System.out.println("1 Square");
        System.out.println("2 Rectangle");
        System.out.println("3 Triangle");
        System.out.println("4 Pentagon");
        System.out.println("5 Hexagon");
        System.out.println("6 Octagon");

        int choice = scanner.nextInt();

        Polygon shape = null;

        if (choice == 1) {
            System.out.print("Enter side: ");
            double side = scanner.nextDouble();
            shape = new Square(side);
        }

        else if (choice == 2) {
            System.out.print("Enter length: ");
            double length = scanner.nextDouble();
            System.out.print("Enter width: ");
            double width = scanner.nextDouble();
            shape = new Rectangle(length, width);
        }

        else if (choice == 3) {
            System.out.print("Enter base: ");
            double base = scanner.nextDouble();
            System.out.print("Enter height: ");
            double height = scanner.nextDouble();
            shape = new Triangle(base, height);
        }

        else if (choice == 4) {
            System.out.print("Enter side: ");
            double side = scanner.nextDouble();
            shape = new Pentagon(side);
        }

        else if (choice == 5) {
            System.out.print("Enter side: ");
            double side = scanner.nextDouble();
            shape = new Hexagon(side);
        }

        else if (choice == 6) {
            System.out.print("Enter side: ");
            double side = scanner.nextDouble();
            shape = new Octagon(side);
        }

        System.out.println("Area: " + shape.area());
        System.out.println("Perimeter: " + shape.perimeter());

        scanner.close();
    }
}
