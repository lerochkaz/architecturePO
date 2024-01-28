package hw2.FactoryMethod;

public class FactoryPizzaThin extends PizzaShop {

    public Pizza createPizza(PizzaType type) {
        Pizza pizza = null;

        switch (type) {
            case MARGARITA:
                pizza = new MargaritaThin();
                break;
            case PEPPERONY:
                pizza = new PepperonyThin();
                break;
            case GRIBNAYA:
                pizza = new GribnayaThin();
                break;
        }

        return pizza;
    }
}
