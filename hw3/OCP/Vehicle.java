package hw3.OCP;

public class Vehicle {
    public String type;
    public int maxSpeed;

    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public double calculateAllowedSpeed() {
        return this.maxSpeed;
    }

}
