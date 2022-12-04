package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Questa classe astratta rappresenta un food generico.
 * Da questa classe derivano le sottoclassi {@link it.team1Restaurant.foods.Dish}, {@link it.team1Restaurant.foods.Drink}
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public abstract class Food {

    /**
     * La tipologia di portata del food. Vedi enum {@link it.team1Restaurant.foods.TypeFoodEnum}
     */
    private TypeFoodEnum type;

    /**
     * La categoria alimentare del food. Vedi enum {@link it.team1Restaurant.menu.TypeDishClientEnum}
     */
    private TypeDishClientEnum typeDishClientEnum;

    /**
     * Il nome del food.
     */
    private String name;

    /**
     * EnumSet delle categorie del food.
     */
    private EnumSet<TypeDishClientEnum> typeSet;

    /**
     * Lista degli ingredienti del food.
     */
    private List<Ingredient> ingredientList;

    /**
     * Il prezzo del food.
     */
    private double price;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Food}, setta le variabili d'istanza della classe
     * con i parametri passati nel costruttore, vengono istanziate la lista degli ingredienti e l'EnumSet delle categorie,
     * saranno inizialmente vuote.
     * @param typeFood La tipologia della portata del food
     * @param name Il nome del food
     * @param price Il prezzo del food
     */
    public Food(TypeFoodEnum typeFood, String name, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
        this.typeSet = EnumSet.noneOf(TypeDishClientEnum.class);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Food}, setta le variabili d'istanza della classe
     * con i parametri passati nel costruttore, viene istanziata la lista degli ingredienti, sarà inizialmente vuota.
     * @param typeFood La tipologia della portata del food
     * @param name Il nome del food
     * @param price Il prezzo del food
     * @param typeSet L'EnumSet delle categorie del food
     */
    public Food(TypeFoodEnum typeFood, String name, double price, EnumSet<TypeDishClientEnum> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
        this.typeSet = typeSet;
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Food}, setta le variabili d'istanza della classe
     * con i parametri passati nel costruttore, viene istanziato l'EnumSet delle categorie, sarà inizialmente vuoto.
     * @param typeFood La tipologia della portata del food
     * @param name Il nome del food
     * @param ingredients La lista degli ingredienti del food
     * @param price Il prezzo del food
     */
    public Food(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
        this.typeSet = EnumSet.noneOf(TypeDishClientEnum.class);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Food}, setta le variabili d'istanza della classe
     * con i parametri passati nel costruttore, comprese la lista degli ingredienti e l'EnumSet delle categorie.
     * @param typeFood La tipologia della portata del food
     * @param name Il nome del food
     * @param ingredients La lista degli ingredienti del food
     * @param price Il prezzo del food
     * @param typeSet L'EnumSet delle categorie del food
     */
    public Food(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
        this.typeSet = typeSet;
    }

    /**
     * Metodo getter che restituisce la tipologia di portata del food.
     * @return Tipo di portata del food.
     */
    public TypeFoodEnum getType() {
        return type;
    }

    /**
     * Metodo setter che setta il tipo di portata del food.
     * @param type Il tipo di portata del food.
     */
    public void setType(TypeFoodEnum type) {
        this.type = type;
    }

    /**
     * Metodo getter che restituisce il nome del food.
     * @return Nome del food.
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo setter che setta il nome del food.
     * @param name Il nome del food.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo getter che restituisce la lista degli ingredienti del food.
     * @return Lista degli ingredienti del food.
     */
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    /**
     * Metodo setter che setta la lista degli ingredienti del food.
     * @param ingredientList Lista degli ingredienti del food.
     */
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * Metodo getter che restituisce il prezzo del food.
     * @return Prezzo del food.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Metodo setter che setta il prezzo del food.
     * @param price Il prezzo del food.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Metodo getter che restituisce l'EnumSet delle categorie del food.
     * @return EnumSet delle categorie del food.
     */
    public EnumSet<TypeDishClientEnum> getTypeSet() {
        return typeSet;
    }

    /**
     * Metodo setter che setta l'EnumSet delle categorie del food.
     * @param typeSet EnumSet delle categorie del food.
     */
    public void setTypeSet(EnumSet<TypeDishClientEnum> typeSet) {
        this.typeSet = typeSet;
    }

    /**
     * Questo metodo viene utilizzato per restituire una stringa formattata contenente i dati del food. <br>
     * Nel caso in cui la lista non presenta ingredienti, la stringa degli ingredienti sarà vuota. <br>
     * Questo metodo verrà richiamato nel metodo {@link it.team1Restaurant.foods.FoodList#getFoodListDetails()}
     */
    public String getFoodDetails() {
        String ingredientsPrint = "";
        String ingredientTxt;
        if (!ingredientList.isEmpty()) {
            ingredientTxt = "Ingredients: ";
            for (Ingredient ingredient : ingredientList) {
                ingredientsPrint += ingredient.getName().toLowerCase() + "  ";}
        }else {
            ingredientTxt = "";
        }
        return String.format("%-50s%-5s €\n\t%s %-5s\n", name, String.format("%.2f", price), ingredientTxt, ingredientsPrint);
    }

    /**
     * Questo metodo filtra i piatti in base alla categoria del food {@link it.team1Restaurant.menu.TypeDishClientEnum}. <br>
     * Ad ogni iterazione degli elementi della mappa, se un dato food presenta nel proprio EnumSet delle categorie,
     * la categoria passata come parametro nel metodo, stampa il nome dei piatti filtrati
     * @param dishMap La mappa delle portate
     * @param typeDishRequired La categoria del food con la quale avviene il filtraggio dei food
     */
    public static void dishFilter(Map<String, Food> dishMap, TypeDishClientEnum typeDishRequired) {
        for (Food food : dishMap.values()) {
            if (food.typeSet.contains(typeDishRequired)) {
                System.out.println(food.getName());
            }
        }
    }

    /**
     * Override del metodo {@link Object#toString()}, restituisce i dati del food.
     * @return Stringa con i dati del food.
     */
    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", typeSet=" + typeSet +
                ", name='" + name + '\'' +
                ", ingredientList=" + ingredientList +
                ", price=" + price +
                '}';
    }
}


