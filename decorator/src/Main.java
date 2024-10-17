//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
interface FoodItem {
    String getDescription();

    double getPrice();
}

class Pizza implements FoodItem {

    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getPrice() {
        return 50;
    }
}

class Burger implements FoodItem {

    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getPrice() {
        return 25;
    }
}


abstract class Decorator implements FoodItem {
    protected FoodItem foodItem;

    public Decorator(FoodItem item) {
        this.foodItem = item;
    }
}

class ExtraCheeseDecorator extends Decorator {

    private double extraCheesePrice;

    public ExtraCheeseDecorator(FoodItem item, double price) {
        super(item);
        this.extraCheesePrice = price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra cheese";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + extraCheesePrice;
    }
}

class ExtraSauceDecorator extends Decorator {

    private double extraSaucePrice;

    public ExtraSauceDecorator(FoodItem item, double price) {
        super(item);
        this.extraSaucePrice = price;
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with extra Sauce";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + extraSaucePrice;
    }
}

class ExtraToppingsDecorator extends Decorator {
    private double extraToppingsPrice;

    public ExtraToppingsDecorator(FoodItem item, double price) {
        super(item);
        this.extraToppingsPrice = price;
    }

    public String getDescription() {
        return foodItem.getDescription() + " with Extra Toppings";
    }

    public double getPrice() {
        return foodItem.getPrice() + extraToppingsPrice;
    }
}

public class Main {
    public static void main(String[] args) {

        FoodItem pizzaOrder = new Pizza();

        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder, 20);
        pizzaOrder = new ExtraSauceDecorator(pizzaOrder, 30);

        System.out.println("Description of pizza order is " + pizzaOrder.getDescription());
        System.out.println("Price of pizza order is: " + pizzaOrder.getPrice());

        FoodItem burgerOrder = new Burger();
        burgerOrder = new ExtraToppingsDecorator(burgerOrder, 42);
        burgerOrder = new ExtraSauceDecorator(burgerOrder, 87);
        System.out.println("Description of pizza order is " + burgerOrder.getDescription());
        System.out.println("Price of pizza order is: " + burgerOrder.getPrice());


    }
}