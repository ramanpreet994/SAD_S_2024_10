package SOLID;

public class ISP_02 {

    /*
     * TASK:
     * Fix the design to obey the ISP (Interface Segregation Principle).
     */

    // Interface for work behavior
    public interface Worker {
        void work();
    }

    // Interface for rest behavior
    public interface Restable {
        void rest();
    }

    // Developer implements both working and resting
    public static class Developer implements Worker, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding ...");
        }

        @Override
        public void rest() {
            System.out.println("Developer is making a break!");
        }
    }

    // Robot only implements working (no rest)
    public static class Robot implements Worker {
        @Override
        public void work() {
            System.out.println("Robot is working hard ...");
        }
    }

    // Method to perform work
    public static void performWork(Worker worker) {
        worker.work();
    }

    // Method to perform rest
    public static void performRest(Restable restable) {
        restable.rest();
    }

    public static void main(String[] args) {
        Developer developer = new Developer();
        Robot robot = new Robot();

        performWork(developer);
        performRest(developer);

        performWork(robot);
        // Robot does not rest, so no call to performRest(robot)
    }
}
