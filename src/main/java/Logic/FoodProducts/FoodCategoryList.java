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

        //Tjek om foodName og foodCategory findes hvis den gør return false
        for (FoodList foodList : foodCategoryList) {
            for(Food food : foodList.foodList){
                if(food.getName().equals(foodName) && foodList.foodListCategory.equals(foodCategory)){
                    return false;
                }
            }
            //Hvis foodCategory ikke findes, tilføj FoodList instance til foodCategoryList og tilføj foodName & price
            if(!foodList.foodListCategory.equals(foodCategory)){
                foodCategoryList.add(new FoodList(foodCategory));
                foodCategoryList.get(foodCategory.length()-1).addFoodToList(foodName,price);
                return true;
            }
            //Hvis foodCategory findes, tilføj foodName og price
            if(foodList.foodListCategory.equals(foodCategory)){
                foodList.addFoodToList(foodName,price);
                return true;
            }

        }
        return false;
    }

}
