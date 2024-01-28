package hw2.FactoryMethod;

public abstract class PizzaShop {

    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = createPizza(type);

        pizza.makePizza();

        System.out.println("Вот ваша пицца! Спасибо, приходите еще!");

        return pizza;
    }

    protected abstract Pizza createPizza(PizzaType type);
}
