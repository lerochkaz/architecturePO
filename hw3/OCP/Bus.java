package hw3.OCP;

public class Bus extends Vehicle {

    public Bus(int maxSpeed) {
        super(maxSpeed, "Bus");
    }

    @Override
    public double calculateAllowedSpeed() {
        return super.maxSpeed * 0.5;
    }
}
