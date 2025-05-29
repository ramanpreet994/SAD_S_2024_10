package SOLID;

public class ISP_01 {

    /*
     * TASK:
     * This SimplePrinter is not a multifunction printer but a very simple one.
     * Please fix this to obey the ISP (Interface Segregation Principle)!
     */

    // Interface for print functionality
    public interface Printer {
        void printDocument();
    }

    // Interface for scan functionality
    public interface Scanner {
        void scanDocument();
    }

    // Interface for fax functionality
    public interface Fax {
        void faxDocument();
    }

    // A class that only implements what it supports — good ISP!
    public static class SimplePrinter implements Printer {
        @Override
        public void printDocument() {
            System.out.println("SimplePrinter: Sending document to the printer ...");
        }
    }

    // A multifunction printer that supports all operations
    public static class MultiFunctionPrinter implements Printer, Scanner, Fax {
        @Override
        public void printDocument() {
            System.out.println("MultiFunctionPrinter: Printing document ...");
        }

        @Override
        public void scanDocument() {
            System.out.println("MultiFunctionPrinter: Scanning document ...");
        }

        @Override
        public void faxDocument() {
            System.out.println("MultiFunctionPrinter: Faxing document ...");
        }
    }

    public static void main(String[] args) {
        SimplePrinter printer = new SimplePrinter();
        printer.printDocument();

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.printDocument();
        mfp.scanDocument();
        mfp.faxDocument();
    }
}
