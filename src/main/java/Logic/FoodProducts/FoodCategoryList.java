package Logic.FoodProducts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 14 March 2017.
 */
public class FoodCategoryList {

    List<FoodList> foodCategoryList = new ArrayList<FoodList>();


    public boolean addFood(String foodName, double price, String foodCategory){
        for (FoodList foodList : foodCategoryList) {
            for(Food food : foodList.foodList){
                if(food.getName().equals(foodName) && foodList.foodListCategory.equals(foodCategory)){
                    return false;
                }
            }
            if(!foodList.foodListCategory.equals(foodCategory)){
                foodCategoryList.add(new FoodList(foodCategory));
                foodCategoryList.get(foodCategory.length()-1).addFoodToList(foodName,price);
                return true;
            }
            if(foodList.foodListCategory.equals(foodCategory)){
                foodList.addFoodToList(foodName,price);
                return true;
            }

        }
        return false;
    }

}
