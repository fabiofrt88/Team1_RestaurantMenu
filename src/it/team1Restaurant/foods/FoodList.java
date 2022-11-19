package it.team1Restaurant.foods;
import it.team1Restaurant.foods.Food;
import it.team1Restaurant.foods.TypeFood;

import java.util.ArrayList;


public class FoodList<T extends IFood> extends ArrayList<T> {

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

    public T getFoodByName (String name) {
        for(T food : this){
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

    public String getFoodListDetails () {
        String str = "";
        for(T food : this) {
            str += "\n" + food.getFoodDetails();
        };
        return str;
    }


}
