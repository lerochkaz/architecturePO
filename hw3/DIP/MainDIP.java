package hw3.DIP;

public class MainDIP {
    public static void main(String[] args) {
        Car car = new Car(new PetrolEngine());
        car.start();
        car = new Car(new DiselEngine());
        car.start();
    }
}
