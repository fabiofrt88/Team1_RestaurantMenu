package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodStorage {

    private static FoodStorage foodStorage = new FoodStorage();
    private Map<TypeFood, FoodList> foodListsMap;

    public FoodStorage(){
        this.foodListsMap = initFoodListsMap();
    }

    public static FoodStorage getInstance(){
        return foodStorage;
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

    public void addDrink(String name, double price){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, price));
    }

    public void addDrink(String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredients, price));
    }

    public void addDrink(String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredients, price, typeSet));
    }

    public void addDish(TypeFood typeFood, String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price));
    }

    public void addDish(TypeFood typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price, typeSet));
    }

    public void addFood(TypeFood typeFood, String name, List<Ingredient> ingredients, double price){
        if(typeFood.equals(TypeFood.DRINK)){
            foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredients, price));
        }
        else{
            foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients,price));
        }
    }

    public void addFood(TypeFood typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet){
        if(typeFood.equals(TypeFood.DRINK)){
            foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredients, price, typeSet));
        }
        else{
            foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients,price, typeSet));
        }
    }

    public String getFoodStorageDetails() {
        String str = String.format("%34s\n\n", "Storage portate ristorante");
        str += "\n\n---------------------------------------------------------\n";
        for (TypeFood typefood : TypeFood.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

}
