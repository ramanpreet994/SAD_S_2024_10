package SOLID;

public class DIP_02 {

    /*
     * TASK:
     * The class Employee violates the DIP (Dependency Inversion Principle).
     * Fix this!
     */

    // Abstraction
    public interface Notification {
        void doNotify();
    }

    // Low-level module: EmailNotification implementing the abstraction
    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }

    // Low-level module: SMSNotification implementing the abstraction
    public static class SMSNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via SMS!");
        }
    }

    // High-level module depends on abstraction, not on concrete classes
    public static class Employee {
        private Notification notification;

        // Constructor Dependency Injection using abstraction
        public Employee(Notification notification) {
            this.notification = notification;
        }

        public void notifyEmployee() {
            notification.doNotify();
        }
    }

    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();

        Employee employee1 = new Employee(emailNotification);
        employee1.notifyEmployee();  // Output: Sending notification via email!

        Employee employee2 = new Employee(smsNotification);
        employee2.notifyEmployee();  // Output: Sending notification via SMS!
    }
}
