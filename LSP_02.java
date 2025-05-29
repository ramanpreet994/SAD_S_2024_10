package SOLID;

public class LSP_02 {

/*
     * TASK:
     * The polymorphic function move expect the same behaviour
     * for all birds, but this isn't the case.
     * Fix this to obey the LSP (Liskov Substitution Principle)!
     */
    public static class Bird {
        public void move() {
            System.out.println("The bird is moving...");
        }
    }

    public static class FlyingBird extends Bird {
        public void fly() {
            System.out.println("The flying bird is flying...");
        }

        @Override
        public void move() {
            fly();
        }
    }

    public static class Sparrow extends FlyingBird {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    public static class Penguin extends Bird {
        @Override
        public void move() {
            System.out.println("The penguin is walking...");
        }
    }

    public static void move(Bird bird) {
        bird.move();
    }

    public static void main(String[] args) {
        move(new Sparrow());  // Outputs: The sparrow is flying...
        move(new Penguin());  // Outputs: The penguin is walking...
    }
}
