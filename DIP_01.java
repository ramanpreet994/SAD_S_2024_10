package SOLID;

public class DIP_01 {
/*
     * TASK:
     * The Switch is violating the DIP (Dependency Inversion Principle).
     * Please fix this!
     */
    // Abstraction(interface)
    public interface DeviceOperation {
        void turnOn();
        void turnOff();
    }
//public static class LightBulb {

//}
//Low-level module:lightbulb implementing the interface
    public static class LightBulb implements DeviceOperation {
        public void turnOn() {
            System.out.println("Light is ON!");
        }

        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    // High-level module: switch depending on the abstraction
    public static class Switch {
        private DeviceOperation device;

        //this is" Dependency Injection"(composition style)
        public Switch(DeviceOperation device) {
            this.device = device;
        }

        public void operate() {
            device.turnOn();
            
        }
    }

    public static void main(String[] args) {
        LightBulb lightBulb = new LightBulb();
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate();
    }
}
