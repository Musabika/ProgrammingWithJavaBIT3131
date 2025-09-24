package assignment_21_sept_2025_OOP.Q7;

public class VehicleManager {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Truck(12345, 45, 4000),
                new Bike(4321, 80, 3000),
                new Car(5678, 40, 20000)
        };
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
        }
    }
}
