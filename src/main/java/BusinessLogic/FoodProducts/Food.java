package BusinessLogic.FoodProducts;

/**
 * Created by David Stovlbaek
 * 14 March 2017.
 */
public class Food {

    private String name;
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
