package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeFoodEnum;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Questa classe rappresenta una lista di portate (foods). È una sottoclasse di {@link java.util.ArrayList}. <br>
 * Mediante l'utilizzo dei generics, può contenere soltanto istanze delle sottoclassi della classe {@link it.team1Restaurant.foods.Food}
 * @param <T> Un'estensione, sottoclasse di {@link it.team1Restaurant.foods.Food}
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class FoodList<T extends Food> extends ArrayList<T> {

    /**
     * La tipologia di portata della lista dei foods. Vedi enum {@link TypeCourseEnum}
     */
    private TypeCourseEnum typeCourse;

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
     * @param typeCourse La tipologia di portata della lista dei foods
     */
    public FoodList(TypeCourseEnum typeCourse) {
        super();
        this.typeCourse = typeCourse;
    }

    /**
     * Metodo getter che restituisce la tipologia di portata della lista dei foods.
     * @return Tipologia di portata della lista dei foods.
     */
    public TypeCourseEnum getTypeCourse() {
        return typeCourse;
    }

    /**
     * Metodo setter che setta la tipologia di portata della lista dei foods.
     * @param typeCourse La tipologia di portata della lista dei foods.
     */
    public void setTypeCourse(TypeCourseEnum typeCourse) {
        this.typeCourse = this.typeCourse;
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

    /**
     * Questo metodo filtra e resituisce un Set generico di foods filtrati per Set di tipologie alimentari
     * {@link TypeFoodEnum} mediante l'utilizzo degli stream
     * @param typeFoodSet Il Set di tipologie alimentari {@link TypeFoodEnum} di filtraggio
     * @return Set di foods filtrati per Set di tipologie alimentari {@link TypeFoodEnum}
     */
    public Set<T> getFoodsByTypeFoodSet (Set<TypeFoodEnum> typeFoodSet) {
        return this.stream().filter(food -> food.getTypeSet().containsAll(typeFoodSet)).collect(Collectors.toSet());
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
        }
        return str;
    }


}
