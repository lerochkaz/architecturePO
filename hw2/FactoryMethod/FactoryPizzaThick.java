package hw2.FactoryMethod;

public class FactoryPizzaThick extends PizzaShop {

    public Pizza createPizza(PizzaType type) {
        Pizza pizza = null;

        switch (type) {
            case MARGARITA:
                pizza = new MargaritaThick();
                break;
            case PEPPERONY:
                pizza = new PepperonyThick();
                break;
            case GRIBNAYA:
                pizza = new GribnayaThick();
                break;
        }

        return pizza;
    }
}
