package SOLID;

public class OCP_01 {

    /*
     * TASK:
     * How to add a new discount type (customerType) without
     * violating OCP (Open/Closed Principle)?
     */

    // Discount interface
    public interface Discount {
        double calculateDiscount(double amount);
    }

    // Implementations for different discount types
    public static class RegularDiscount implements Discount {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.1;
        }
    }

    public static class PremiumDiscount implements Discount {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.2;
        }
    }

    public static class VIPDiscount implements Discount {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.3;
        }
    }

    // DiscountCalculator uses the Discount interface to calculate discounts
    public static class DiscountCalculator {
        public double calculate(Discount discount, double amount) {
            return discount.calculateDiscount(amount);
        }
    }

    // Main method demonstrating usage
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        Discount regularDiscount = new RegularDiscount();
        Discount premiumDiscount = new PremiumDiscount();
        Discount vipDiscount = new VIPDiscount();

        double regularAmount = calculator.calculate(regularDiscount, 100.0);
        double premiumAmount = calculator.calculate(premiumDiscount, 100.0);
        double vipAmount = calculator.calculate(vipDiscount, 100.0);

        System.out.println("Regular Discount: " + regularAmount);
        System.out.println("Premium Discount: " + premiumAmount);
        System.out.println("VIP Discount: " + vipAmount);
    }
}
