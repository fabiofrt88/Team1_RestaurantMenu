package it.team1Restaurant.foods;

import java.util.ArrayList;

/**
 * Questa classe rappresenta una lista di portate (foods). E' una sottoclasse di {@link java.util.ArrayList}. <br>
 * Mediante l'utilizzo dei generics, può contenere soltanto istanze delle sottoclassi della classe {@link it.team1Restaurant.foods.Food}
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class FoodList<T extends Food> extends ArrayList<T> {

    /**
     * La tipologia di portata della lista dei foods. Vedi enum {@link it.team1Restaurant.foods.TypeFoodEnum}
     */
    private TypeFoodEnum typeFood;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.FoodList}, istanzia una lista di foods
     * mediante il metodo costruttore {@link ArrayList#ArrayList()} della relativa superclasse {@link java.util.ArrayList}.
     */
    public FoodList() {
        super();
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.FoodList}, istanzia una lista di foods
     * mediante il metodo costruttore {@link ArrayList#ArrayList()} della relativa superclasse {@link java.util.ArrayList}.
     * Viene settata la tipologia di portata della lista dei foods con il relativo parametro passato nel costruttore.
     * @param typeFood La tipologia di portata della lista dei foods
     */
    public FoodList(TypeFoodEnum typeFood) {
        super();
        this.typeFood = typeFood;
    }

    /**
     * Metodo getter che restituisce la tipologia di portata della lista dei foods.
     * @return Tipologia di portata della lista dei foods.
     */
    public TypeFoodEnum getTypeFood() {
        return typeFood;
    }

    /**
     * Metodo setter che setta la tipologia di portata della lista dei foods.
     * @param typeFood La tipologia di portata della lista dei foods.
     */
    public void setTypeFood(TypeFoodEnum typeFood) {
        this.typeFood = typeFood;
    }


    /**
     * Questo metodo effettua una ricerca per nome del food nella lista dei foods e restituisce il food trovato.
     * @param name Il nome del food da ricercare nella lista dei foods
     * @return Un oggetto di una delle sottoclassi di {@link it.team1Restaurant.foods.Food}
     */
    public T getFoodByName (String name) {
        T foodFound = null;
        for(T food : this){
            if(food.getName().equals(name))
                foodFound = food;
            break;
        }
        return foodFound;
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
    */

    /**
     * Questo metodo ritorna una stringa contenente i dettagli dei foods presenti nella lista. <br>
     * Ad ogni iterazione della lista dei foods, verrà concatenata una stringa con i dettagli
     * del food corrente restituiti dal metodo {@link Food#getFoodDetails()}
     * @return Stringa contenente i dettagli dei foods presenti nella lista
     */
    public String getFoodListDetails () {
        String str = "";
        for(T food : this) {
            str += "\n" + food.getFoodDetails();
        };
        return str;
    }


}
