package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un dish (piatto). È una sottoclasse di {@link it.team1Restaurant.foods.Food}.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Dish extends Food {

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Dish},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeFoodEnum, String, double)}.
     * @param typeFood La tipologia di portata del dish
     * @param name Il nome del dish
     * @param price Il prezzo del dish
     */
    public Dish(TypeFoodEnum typeFood, String name, double price) {
        super(typeFood, name, price);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Dish},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeFoodEnum, String, double, EnumSet)}.
     * @param typeFood La tipologia di portata del dish
     * @param name Il nome del dish
     * @param price Il prezzo del dish
     * @param typeSet EnumSet delle categorie del dish
     */
    public Dish(TypeFoodEnum typeFood, String name, double price, EnumSet<TypeDishClientEnum> typeSet) {
        super(typeFood, name, price, typeSet);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Dish},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeFoodEnum, String, List, double)}.
     * @param typeFood La tipologia di portata del dish
     * @param name Il nome del dish
     * @param ingredients Lista degli ingredienti del dish
     * @param price Il prezzo del dish
     */
    public Dish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price) {
        super(typeFood, name, ingredients, price);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Dish},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeFoodEnum, String, List, double, EnumSet)}.
     * @param typeFood La tipologia di portata del dish
     * @param name Il nome del dish
     * @param ingredients Lista degli ingredienti del dish
     * @param price Il prezzo del dish
     * @param typeSet EnumSet delle categorie del dish
     */
    public Dish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet) {
        super(typeFood, name, ingredients, price, typeSet);
    }

    /**
     * Override del metodo {@link Food#toString()}, restituisce i dati del dish.
     * @return Stringa con i dati del dish.
     */
    @Override
    public String toString() {
        return "Dish" + super.toString();
    }

}
