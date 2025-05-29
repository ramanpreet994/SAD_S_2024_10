package SOLID;

public class OCP_02 {

    /*
     * TASK:
     * (classical task)
     * How to add other shapes without violating the OCP
     * (Open/Closed Principle)?
     */

    // Abstract shape class with getArea method
    public static abstract class Shape {
        public abstract double getArea();
    }

    // Square class
    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getSide() {
            return side;
        }

        @Override
        public double getArea() {
            return side * side;
        }
    }

    // Circle class
    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    // Rectangle class
    public static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public double getArea() {
            return width * height;
        }
    }

    // AreaCalculator class: uses polymorphism, no instanceof needed
    public static class AreaCalculator {
        public double getArea(Shape shape) {
            return shape.getArea();
        }

        public double totalArea(Shape[] shapes) {
            double total = 0;
            for (Shape shape : shapes) {
                total += shape.getArea();
            }
            return total;
        }
    }

    // Demo main method
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Shape[] shapes = {
            new Square(5),
            new Circle(3),
            new Rectangle(4, 6)
        };

        double totalArea = calculator.totalArea(shapes);
        System.out.println("Total Area: " + totalArea);
    }
}
