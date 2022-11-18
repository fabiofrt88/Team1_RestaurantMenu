package it.team1Restaurant.menu;
import it.team1Restaurant.foods.*;

import java.util.HashMap;
import java.util.Map;

public class MenuB {
    private static String restaurantName = "Team-1 restaurant";
    private String type;
    private Map<TypeFood, FoodList> foodListsMap;

    private TypeMenu typeMenu;

    public MenuB (String type, TypeMenu typeMenu){
        this.typeMenu = typeMenu;
        this.type = type;
        this.foodListsMap = initFoodListsMap();
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String restaurantName) {
        MenuB.restaurantName = restaurantName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TypeMenu getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(TypeMenu typeMenu) {
        this.typeMenu = typeMenu;
    }

    public Map<TypeFood, FoodList> getFoodListsMap() {
        return foodListsMap;
    }

    public void setFoodListsMap(Map<TypeFood, FoodList> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    public Map<TypeFood, FoodList> initFoodListsMap(){
        Map<TypeFood, FoodList> foodListsMap = new HashMap<>();
        foodListsMap.put(TypeFood.STARTER, new FoodList(TypeFood.STARTER));
        foodListsMap.put(TypeFood.DRINK, new FoodList(TypeFood.DRINK));
        foodListsMap.put(TypeFood.FIRST, new FoodList(TypeFood.FIRST));
        foodListsMap.put(TypeFood.SECOND, new FoodList(TypeFood.SECOND));
        foodListsMap.put(TypeFood.SIDE_DISH, new FoodList(TypeFood.SIDE_DISH));
        foodListsMap.put(TypeFood.DESSERT, new FoodList(TypeFood.DESSERT));
        foodListsMap.put(TypeFood.FRUIT, new FoodList(TypeFood.FRUIT));
        return foodListsMap;
    }

    public void addDrink(Drink drink){
        foodListsMap.get(TypeFood.DRINK).add(drink);
    }

    public void addDrink(TypeFood typeFood, Drink drink){
        if(!typeFood.equals(TypeFood.DRINK)){
            typeFood = TypeFood.DRINK;
        }
        foodListsMap.get(typeFood).add(drink);
    }

    public void addDish(TypeFood typeFood, Dish dish){
        foodListsMap.get(typeFood).add(dish);
    }

    public <T extends Food> void addFood(TypeFood typeFood, T food){
        foodListsMap.get(typeFood).add(food);
    }

    public String getMenuDetails() {
        String str = String.format("%34s\n\n", restaurantName)
                + String.format("%24s %s", "MENU", type.toUpperCase());
        str += "\n\n---------------------------------------------------------\n";
        for (TypeFood typefood : TypeFood.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

}
