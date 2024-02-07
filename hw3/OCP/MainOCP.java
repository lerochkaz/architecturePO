package hw3.OCP;

public class MainOCP {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(200, "Train");
        printVehicle(vehicle);
        vehicle = new Car(100);
        printVehicle(vehicle);
        vehicle = new Bus(60);
        printVehicle(vehicle);
    }

    public static void printVehicle(Vehicle vehicle) {
        System.out.println(vehicle.calculateAllowedSpeed());
    }
}
