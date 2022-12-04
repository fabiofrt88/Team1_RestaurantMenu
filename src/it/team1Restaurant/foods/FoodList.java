package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;


/**
 *This class is an ArraysList that may contain any extension of {@link it.team1Restaurant.foods.Food}.
 * @param <T> An extension of {@link it.team1Restaurant.foods.Food}.
 */
public class FoodList<T extends Food> extends ArrayList<T> {

    TypeFoodEnum typeFood;

    public FoodList() {
        super();
    }

    public FoodList(TypeFoodEnum typeFood) {
        super();
        this.typeFood = typeFood;
    }

    public TypeFoodEnum getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(TypeFoodEnum typeFood) {
        this.typeFood = typeFood;
    }

    public T getFoodByName (String name) {
        T foodFound = null;
        for(T food : this){
            if(food.getName().equals(name))
                foodFound = food;
            break;
        }
        return foodFound;
    }


    public Set<T> getFoodsByTypeDishClient (Set<TypeDishClientEnum> typeDishClientSet) {
        return this.stream().filter(food -> food.getTypeSet().containsAll(typeDishClientSet)).collect(Collectors.toSet());
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
