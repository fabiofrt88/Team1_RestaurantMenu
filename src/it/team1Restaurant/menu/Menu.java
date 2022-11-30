package it.team1Restaurant.menu;
import it.team1Restaurant.foods.*;

import java.util.HashMap;
import java.util.Map;


// todo javadoc Pietro
public class Menu {
    private static String restaurantName = "Team-1 restaurant";
    private String type;
    private Map<TypeFoodEnum, FoodList> foodListsMap;
    private TypeMenuEnum typeMenu;

    public Menu(String type, TypeMenuEnum typeMenu){
        this.typeMenu = typeMenu;
        this.type = type;
        this.foodListsMap = initFoodListsMap();
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

    public TypeMenuEnum getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(TypeMenuEnum typeMenu) {
        this.typeMenu = typeMenu;
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

    public void addDrink(Drink drink){
        foodListsMap.get(TypeFoodEnum.DRINK).add(drink);
    }

    //toDo aggiungere eccezione?
    public void addDish(TypeFoodEnum typeFood, Dish dish) {
    //  if(typeFood == TypeFood.DRINK) throw new Exception("Un dish non può essere un Drink");
        foodListsMap.get(typeFood).add(dish);
    }

    //toDo mettere dei check per evitare di passare un Drink come Dish e viceversa?
    public <T extends Food> void addFood (TypeFoodEnum typeFood, T food) throws Exception {
        if(food instanceof Drink && typeFood != TypeFoodEnum.DRINK) typeFood = TypeFoodEnum.DRINK;
        else if(!(food instanceof Drink) && typeFood == TypeFoodEnum.DRINK) throw new Exception("Un dish non è un drink!");
        foodListsMap.get(typeFood).add(food);
    }


    public String getMenuDetails() {
        String str = String.format("%34s\n\n", restaurantName)
                + String.format("%24s %s", "MENU", type.toUpperCase());
        str += "\n\n---------------------------------------------------------\n";
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

}
