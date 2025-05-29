package SOLID;

public class SRP_02 {

    /*
     * TASK:
     * Just make this class obeying the SRP (Single Responsibility Principle)!
     * The method bodies are empty by purpose and there is no main provided.
     */

    // Represents an Employee entity with its data only
    public static class Employee {
        private int employeeID;
        private String name;
        private String designation;

        public Employee(int employeeID, String name, String designation) {
            this.employeeID = employeeID;
            this.name = name;
            this.designation = designation;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public String getName() {
            return name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }
    }

    // Responsible for data fetching and updating salary (data operations)
    public static class EmployeeDataService {
        public String fetchDesignation(int employeeID) {
            System.out.println("Fetching designation for Employee ID: " + employeeID + " from database...");
            if (employeeID == 101) return "Software Engineer";
            if (employeeID == 102) return "Project Manager";
            return "Unknown";
        }

        public void updateSalary(int employeeID, double newSalary) {
            System.out.println("Updating salary for Employee ID: " + employeeID + " to " + newSalary + " in database...");
        }
    }

    // Handles sending notifications (email, SMS, etc.)
    public static class NotificationService {
        public void sendEmail(String recipientEmail, String subject, String body) {
            System.out.println("Sending email to " + recipientEmail + " with subject: '" + subject + "'");
            System.out.println("Body: " + body);
        }

        public void sendSMS(String phoneNumber, String message) {
            System.out.println("Sending SMS to " + phoneNumber + " with message: '" + message + "'");
        }
    }

    // Contains business logic operations on Employee
    public static class EmployeeService {
        private final EmployeeDataService employeeDataService;
        private final NotificationService notificationService;

        public EmployeeService(EmployeeDataService employeeDataService, NotificationService notificationService) {
            this.employeeDataService = employeeDataService;
            this.notificationService = notificationService;
        }

        public void promoteEmployee(Employee employee, String newDesignation) {
            employee.setDesignation(newDesignation);
            employeeDataService.updateSalary(employee.getEmployeeID(), 100000);
            notificationService.sendEmail(employee.getName() + "@company.com", 
                "Promotion", "Congratulations on your promotion to " + newDesignation + "!");
        }
    }
}
