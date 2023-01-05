package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeFoodEnum;

import java.util.*;
import java.util.ArrayList;
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
     * Il codice identificativo del food (chiave primaria univoca autoincrementale non modificabile).
     */
    private final Integer id;

    /**
     * Il nome del food.
     */
    private String name;

    /**
     * Il prezzo del food.
     */
    private Double price;

    /**
     * EnumSet delle tipologie alimentari del food. Vedi enum {@link TypeFoodEnum}
     */
    private EnumSet<TypeFoodEnum> typeSet;

    /**
     * Lista degli ingredienti del food.
     */
    private List<Ingredient> ingredients;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Food}, destinato all'inserimento delle istanze
     * delle sottoclassi di Food ({@link it.team1Restaurant.foods.Dish}, {@link it.team1Restaurant.foods.Drink})
     * nel database, setta le variabili d'istanza della classe con i parametri passati nel costruttore,
     * l'id sarà inizialmente null, assegnato, gestito e reso autoincrementale dal DBMS.
     * @param id Il codice identificativo del food.
     * @param name Il nome del food
     * @param price Il prezzo del food
     */
    public Food(Integer id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeSet = EnumSet.noneOf(TypeFoodEnum.class);
        this.ingredients = new ArrayList<>();
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Food}, destinato alla lettura
     * e all'acquisizione dei record dalle relative tabelle nel database come istanze delle sottoclassi di Food
     * ({@link it.team1Restaurant.foods.Dish}, {@link it.team1Restaurant.foods.Drink})
     * setta le variabili d'istanza della classe con i parametri passati nel costruttore.
     * @param id Il codice identificativo del food.
     * @param name Il nome del food
     * @param price Il prezzo del food
     * @param ingredients La lista degli ingredienti del food
     * @param typeSet EnumSet delle tipologie alimentari del food
     */
    public Food(Integer id, String name, double price, EnumSet<TypeFoodEnum> typeSet, List<Ingredient> ingredients){
        this.id = id;
        this.name = name;
        this.price = price;
        this.typeSet = initTypeSet(typeSet);
        this.ingredients = initIngredientList(ingredients);
    }

    public Integer getId() {
        return id;
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
     * Metodo getter che restituisce il prezzo del food.
     * @return Prezzo del food.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Metodo setter che setta il prezzo del food.
     * @param price Il prezzo del food.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Metodo getter che restituisce l'EnumSet delle categorie del food.
     * @return EnumSet delle categorie del food.
     */
    public EnumSet<TypeFoodEnum> getTypeSet() {
        return typeSet;
    }

    /**
     * Metodo setter che setta l'EnumSet delle categorie del food.
     * @param typeSet EnumSet delle categorie del food.
     */
    public void setTypeSet(EnumSet<TypeFoodEnum> typeSet) {
        this.typeSet = typeSet;
    }

    /**
     * Metodo getter che restituisce la lista degli ingredienti del food.
     * @return Lista degli ingredienti del food.
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Metodo setter che setta la lista degli ingredienti del food.
     * @param ingredients Lista degli ingredienti del food.
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> initIngredientList(List<Ingredient> ingredients){
        return (ingredients != null) ? new ArrayList<>(ingredients) : new ArrayList<>();
    }

    public EnumSet<TypeFoodEnum> initTypeSet(EnumSet<TypeFoodEnum> typeSet){
        return (typeSet != null) ? typeSet : EnumSet.noneOf(TypeFoodEnum.class);
    }

    /**
     * Questo metodo viene utilizzato per restituire una stringa formattata contenente i dati del food. <br>
     * Nel caso in cui la lista non presenta ingredienti, la stringa degli ingredienti sarà vuota. <br>
     * Questo metodo verrà richiamato nel metodo {@link it.team1Restaurant.foods.FoodList#getFoodListDetails()}
     */
    public String getFoodDetails() {
        String ingredientsPrint = "";
        String ingredientTxt;
        if (!ingredients.isEmpty()) {
            ingredientTxt = "Ingredients: ";
            for (Ingredient ingredient : ingredients) {
                ingredientsPrint += ingredient.getName().toLowerCase() + "  ";}
        }else {
            ingredientTxt = "";
        }
        return String.format("%-50s%-5s €\n\t%s %-5s\n", name, String.format("%.2f", price), ingredientTxt, ingredientsPrint);
    }

    /**
     * Questo metodo filtra i piatti in base alla categoria del food {@link TypeFoodEnum}. <br>
     * Ad ogni iterazione degli elementi della mappa, se un dato food presenta nel proprio EnumSet delle categorie,
     * la categoria passata come parametro nel metodo, stampa il nome dei piatti filtrati
     * @param dishMap La mappa delle portate
     * @param typeDishRequired La categoria del food con la quale avviene il filtraggio dei food
     */
    public static void dishFilter(Map<String, Food> dishMap, TypeFoodEnum typeDishRequired) {
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
        return "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", typeSet = " + typeSet +
                ", ingredients = " + ingredients;
    }
}


