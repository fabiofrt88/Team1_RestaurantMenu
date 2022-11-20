package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.*;

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

    public void addDrink(String name, double price, EnumSet<TypeDish> typeSet){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, price, typeSet));
    }

    public void addDrink(String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredients, price));
    }

    public void addDrink(String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet){
        foodListsMap.get(TypeFood.DRINK).add(new Drink(name, ingredients, price, typeSet));
    }

    public void addDish(TypeFood typeFood, String name, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, price));
    }

    public void addDish(TypeFood typeFood, String name, double price, EnumSet<TypeDish> typeSet){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, price, typeSet));
    }

    public void addDish(TypeFood typeFood, String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price));
    }

    public void addDish(TypeFood typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price, typeSet));
    }

    public void addFood(TypeFood typeFood, String name, double price){
        if(typeFood.equals(TypeFood.DRINK)){
            foodListsMap.get(TypeFood.DRINK).add(new Drink(name, price));
        }
        else{
            foodListsMap.get(typeFood).add(new Dish(typeFood, name, price));
        }
    }

    public void addFood(TypeFood typeFood, String name, double price, EnumSet<TypeDish> typeSet){
        if(typeFood.equals(TypeFood.DRINK)){
            foodListsMap.get(TypeFood.DRINK).add(new Drink(name, price, typeSet));
        }
        else{
            foodListsMap.get(typeFood).add(new Dish(typeFood, name, price, typeSet));
        }
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

    public void dishFilter(TypeDish typeDishRequired) {
        System.out.println("Foods filtered by type: " + typeDishRequired + "\n");
        Map<TypeFood, FoodList> filteredFoodListsMap = initFoodListsMap();
        for (TypeFood typefood : TypeFood.values()) {
            FoodList<Food> foodList = foodListsMap.get(typefood);
            if(foodList.isEmpty()){
                continue;
            }
            for(Food food : foodList){
                if(food.getTypeSet() != null){
                    if(food.getTypeSet().contains(typeDishRequired) && !filteredFoodListsMap.get(typefood).contains(food)){
                        filteredFoodListsMap.get(typefood).add(food);
                    }
                }
            }
        }
        for (TypeFood typefood : TypeFood.values()) {
            FoodList<Food> filteredFoodList = filteredFoodListsMap.get(typefood);
            if(filteredFoodList.isEmpty()){
                continue;
            }
            System.out.println(typefood.name() + ":\n");
            for(Food filteredFood : filteredFoodList){
                System.out.println(filteredFood.getFoodDetails());
            }
        }
    }

    public void dishFilter(EnumSet<TypeDish> typeDishSetRequired) {
        System.out.println("Foods filtered by type: " + typeDishSetRequired.toString() + "\n");
        Map<TypeFood, FoodList> filteredFoodListsMap = initFoodListsMap();
        for (TypeFood typefood : TypeFood.values()) {
            FoodList<Food> foodList = foodListsMap.get(typefood);
            if(foodList.isEmpty()){
                continue;
            }
            for(Food food : foodList){
                if(food.getTypeSet() != null){
                    for(TypeDish typeDishRequired : typeDishSetRequired) {
                        if (food.getTypeSet().contains(typeDishRequired) && !filteredFoodListsMap.get(typefood).contains(food)) {
                            filteredFoodListsMap.get(typefood).add(food);
                        }
                    }
                }
            }
        }
        for (TypeFood typefood : TypeFood.values()) {
            FoodList<Food> filteredFoodList = filteredFoodListsMap.get(typefood);
            if(filteredFoodList.isEmpty()){
                continue;
            }
            System.out.println(typefood.name() + ":\n");
            for(Food filteredFood : filteredFoodList){
                System.out.println(filteredFood.getFoodDetails());
            }
        }
    }

}
