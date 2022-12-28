package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeClientMenuEnum;

import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un drink. È una sottoclasse di {@link it.team1Restaurant.foods.Food}.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Drink extends Food {

    /**
     * La percentuale alcolica del drink
     */
    private double alcoholPercentage;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Drink},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeCourseEnum, String, double)}. <br>
     * Tipologia di portata passata come {@link TypeCourseEnum#DRINK} di default
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     */
    public Drink(String name, double price) {
        super(TypeCourseEnum.DRINK, name, price);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Drink},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeCourseEnum, String, double, EnumSet)}. <br>
     * Tipologia di portata passata come {@link TypeCourseEnum#DRINK} di default
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     * @param typeSet EnumSet delle categorie del drink
     */
    public Drink(String name, double price, EnumSet<TypeClientMenuEnum> typeSet) {
        super(TypeCourseEnum.DRINK, name, price, typeSet);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Drink},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeCourseEnum, String, List, double)}. <br>
     * Tipologia di portata passata come {@link TypeCourseEnum#DRINK} di default
     * @param name Il nome del drink
     * @param ingredients Lista degli ingredienti del drink
     * @param price Il prezzo del drink
     */
    public Drink (String name, List<Ingredient> ingredients, double price) {
        super(TypeCourseEnum.DRINK, name, ingredients, price);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Drink},
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(TypeCourseEnum, String, List, double, EnumSet)}. <br>
     * Tipologia di portata passata come {@link TypeCourseEnum#DRINK} di default
     * @param name Il nome del drink
     * @param ingredients Lista degli ingredienti del drink
     * @param price Il prezzo del drink
     * @param typeSet EnumSet delle categorie del drink
     */
    public Drink (String name, List<Ingredient> ingredients, double price, EnumSet<TypeClientMenuEnum> typeSet) {
        super(TypeCourseEnum.DRINK, name, ingredients, price, typeSet);
    }

    /**
     * Metodo getter che restituisce la percentuale alcolica del drink.
     * @return Percentuale alcolica del drink.
     */
    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    /**
     * Metodo setter che setta la percentuale alcolica del drink.
     * @param alcoholPercentage La percentuale alcolica del drink.
     */
    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    /**
     * Override del metodo {@link Food#toString()}, restituisce  dati del drink.
     * @return Stringa con i dati del drink.
     */
    @Override
    public String toString() {
        return "Drink" + super.toString();
    }

}
