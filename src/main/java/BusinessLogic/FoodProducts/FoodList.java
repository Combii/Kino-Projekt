package BusinessLogic.FoodProducts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 14 March 2017.
 */
public class FoodList {

    List<Food> foodList = new ArrayList<Food>();

    protected String foodListCategory;

    public FoodList(String foodListCategory) {
        this.foodListCategory = foodListCategory;
    }

    public void addFoodToList(String foodName, double price){
        if(foodList.contains(foodName))
            return;

        foodList.add(new Food(foodName, price));

    }
}
