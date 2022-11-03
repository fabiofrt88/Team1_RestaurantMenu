package it.team1Restaurant.menu;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.Food;
import it.team1Restaurant.foods.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static String restaurantName = "Team-1 restaurant";
    private String type;
    private Map<TypeFood,FoodList> foodListsMap;

    public Menu (String type){
        this.type = type;
        this.foodListsMap = new HashMap<>();
        this.foodListsMap.put(TypeFood.STARTER,new FoodList(TypeFood.STARTER));
        this.foodListsMap.put(TypeFood.DRINK,new FoodList(TypeFood.DRINK));
        this.foodListsMap.put(TypeFood.FIRST,new FoodList(TypeFood.FIRST));
        this.foodListsMap.put(TypeFood.SECOND,new FoodList(TypeFood.SECOND));
        this.foodListsMap.put(TypeFood.SIDE_DISH,new FoodList(TypeFood.SIDE_DISH));
        this.foodListsMap.put(TypeFood.DESSERT,new FoodList(TypeFood.DESSERT));
        this.foodListsMap.put(TypeFood.FRUIT,new FoodList(TypeFood.FRUIT));
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String restaurantName) {
        Menu.restaurantName = restaurantName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<TypeFood, FoodList> getFoodListsMap() {
        return foodListsMap;
    }

    public void setFoodListsMap(Map<TypeFood, FoodList> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    //ADD DRINK METHODS:

    public void addDrink (String name, Ingredient ingredient, double price){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredient, price));
    }
    public void addDrink (String name, List<Ingredient> ingredient, double price){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredient, price));

    }


    //ADD FOOD METHODS:

    public void addFood (TypeFood typeFood, String name, Ingredient ingredient, double price){
        foodListsMap.get(typeFood).add(new Food(typeFood, name, ingredient,price));
    }
    public void addFood (TypeFood typeFood, String name, List<Ingredient> ingredient, double price){
        foodListsMap.get(typeFood).add(new Food(typeFood, name, ingredient, price));
    }


    public String printMenuDetails() {
        String str = String.format("%34s\n\n", restaurantName)
                + String.format("%24s %s", "MENU", type.toUpperCase());
        for (FoodList foodList : foodListsMap.values()) {
            str += "\n\n---------------------------------------------------------"
                    + "\n\n" + foodList.getTypeFood().name() + ":\n" + foodList.printDetails()
                    + "\n---------------------------------------------------------";
        }
        return str;
    }



}
