package it.menu;
import it.foods.Food;

import java.util.ArrayList;


public class FoodList<T extends Food> extends ArrayList<Food> {

    TypeFood typeFood;

    public FoodList() {
        super();
    }

    public FoodList(TypeFood typeFood) {
        super();
        this.typeFood = typeFood;
    }

    public TypeFood getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }

    public Food getFoodByName (String name) {
        for(Food food : this){
            if(food.getName().equals(name)) return food;
        }
        return null;
    }

    /*
    public Set<Dish> getDishesWithAllergen (Allergen allergen ) {
        Set<Dish> dishes = new HashSet<>();
        for(Dish dish : this) {
            if(dish.ingredients.ALLERGENS.contains(allergen)){
                dishes.add(dish);
            }
        }
        return dishes;
    }

    /*
    public Set<Drink> getAlcoholicDrinks () {
        if(!this.getClass().getName().equals("Drink")) return null;
        Set<Drink> dishes = new HashSet<>();
        for(Drink (Drink)drink : this) {

        }
    }*/

    public String printDetails () {
        String str = "";
        for(Food food : this) {
            str += "\n" + food.printDetails();
        };
        return str;
    }


}
