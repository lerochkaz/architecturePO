package hw2.FactoryMethod;

public abstract class Pizza {
    private String namePizza;

    public Pizza(String namePizza) {
        this.namePizza = namePizza;
    }

    public void makePizza() {
        System.out.println(namePizza + " ...готовится");
    }

}
