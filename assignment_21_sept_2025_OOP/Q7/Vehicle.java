package assignment_21_sept_2025_OOP.Q7;

public abstract class Vehicle {
    private final int registrationNumber;
    private final double speed;
    private final double price;

    public Vehicle(int registrationNumber, double speed, double price) {
        this.registrationNumber = registrationNumber;
        this.speed = speed;
        this.price = price;
    }

    public void displayVehicleDetails() {
        System.out.println("Vehicle Type: " + this.getClass().getSimpleName());
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Price: " + price + " RWF");
        System.out.println("----------------------------");
    }
}
