package hw2.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        PizzaShop pizzaShopThick = new FactoryPizzaThick();
        pizzaShopThick.orderPizza(PizzaType.GRIBNAYA);
        pizzaShopThick.orderPizza(PizzaType.PEPPERONY);

        PizzaShop pizzaShopThin = new FactoryPizzaThin();
        pizzaShopThin.orderPizza(PizzaType.MARGARITA);
    }
}
