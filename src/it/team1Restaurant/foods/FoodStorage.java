package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.*;

public class FoodStorage {

    private static FoodStorage foodStorage = new FoodStorage();
    private Map<TypeFoodEnum, FoodList> foodListsMap;

    public FoodStorage(){
        this.foodListsMap = initFoodListsMap();
    }

    public static FoodStorage getInstance(){
        return foodStorage;
    }

    public Map<TypeFoodEnum, FoodList> getFoodListsMap() {
        return foodListsMap;
    }

    public void setFoodListsMap(Map<TypeFoodEnum, FoodList> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    public Map<TypeFoodEnum, FoodList> initFoodListsMap(){
        Map<TypeFoodEnum, FoodList> foodListsMap = new HashMap<>();
        foodListsMap.put(TypeFoodEnum.STARTER, new FoodList(TypeFoodEnum.STARTER));
        foodListsMap.put(TypeFoodEnum.DRINK, new FoodList(TypeFoodEnum.DRINK));
        foodListsMap.put(TypeFoodEnum.FIRST, new FoodList(TypeFoodEnum.FIRST));
        foodListsMap.put(TypeFoodEnum.SECOND, new FoodList(TypeFoodEnum.SECOND));
        foodListsMap.put(TypeFoodEnum.SIDE_DISH, new FoodList(TypeFoodEnum.SIDE_DISH));
        foodListsMap.put(TypeFoodEnum.DESSERT, new FoodList(TypeFoodEnum.DESSERT));
        foodListsMap.put(TypeFoodEnum.FRUIT, new FoodList(TypeFoodEnum.FRUIT));
        return foodListsMap;
    }

    public void addDrink(String name, double price){
        foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, price));
    }

    public void addDrink(String name, double price, EnumSet<TypeDishClientEnum> typeSet){
        foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, price, typeSet))q;
    }

    public void addDrink(String name, List<Ingredient> ingredients, EnumSet<TypeDishClientEnum> typeSet , double price){
        foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, ingredients, price, typeSet));
    }

    public void addDish(TypeFoodEnum typeFood, String name, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, price));
    }

    public void addDish(TypeFoodEnum typeFood, String name, EnumSet<TypeDishClientEnum> typeSet, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, price, typeSet));
    }

    public void addDish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price));
    }

    public void addDish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price, typeSet));
    }


    public void addFood(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet){
        if(typeFood.equals(TypeFoodEnum.DRINK)){
            foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, ingredients, price, typeSet));
        }
        else{
            foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients,price, typeSet));
        }
    }

    public String getFoodStorageDetails() {
        String str = String.format("%34s\n\n", "Storage portate ristorante");
        str += "\n\n---------------------------------------------------------\n";
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

    public Map<TypeFoodEnum, FoodList> dishFilter(TypeDishClientEnum typeDishRequired) {
        EnumSet<TypeDishClientEnum> typeDishSetRequired = EnumSet.of(typeDishRequired);
        return this.dishFilter(typeDishSetRequired);
    }


    //todo scrivere javadoc e commenti, ?? mettere link alla doc degli enum set ??
    public Map<TypeFoodEnum, FoodList> dishFilter(EnumSet<TypeDishClientEnum> typeDishSetRequired) {
        System.out.println("Foods filtered by type: " + typeDishSetRequired.toString() + "\n");
        Map<TypeFoodEnum, FoodList> filteredFoodListsMap = initFoodListsMap();
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) {
            FoodList<Food> foodList = foodListsMap.get(typefood);
            if(foodList.isEmpty()){
                continue;
            }
            for(Food food : foodList){
                if(!food.getTypeSet().isEmpty()){
                    for(TypeDishClientEnum typeDishRequired : typeDishSetRequired) {
                        if (food.getTypeSet().contains(typeDishRequired) && !filteredFoodListsMap.get(typefood).contains(food)) {
                            filteredFoodListsMap.get(typefood).add(food);
                        }
                    }
                }
            }
        }
        this.printFilteredFoodListsMapDetails(filteredFoodListsMap);
        return filteredFoodListsMap;
        /*
        Le righe da 104 a 113 si possono sostituire con qualcosa del genere:
         Set<Food> foodWithRequirements = foodList.getFoodsByTypeDishClient(typeDishSetRequired);
         filteredFoodListsMap.get(typefood).addAll(foodWithRequirements);
        */

    }

    public Map<TypeFoodEnum, FoodList> dishFilterVeg () {
        return dishFilter(EnumSet.of(TypeDishClientEnum.VEGAN, TypeDishClientEnum.VEGETARIAN));
    }



    public void printFilteredFoodListsMapDetails(Map<TypeFoodEnum, FoodList> filteredFoodListsMap){
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) {
            FoodList<Food> filteredFoodList = filteredFoodListsMap.get(typefood);
            System.out.println(typefood.name() + ":\n");
            if(filteredFoodList.isEmpty()) System.out.println("Nessun piatto presente con le caratteristiche richieste");
            for(Food filteredFood : filteredFoodList){
                System.out.println(filteredFood.getFoodDetails());
            }
        }
    }

}
