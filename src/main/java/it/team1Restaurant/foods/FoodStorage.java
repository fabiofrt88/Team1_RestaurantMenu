package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.*;

/**
 * Questa classe singleton viene utilizzata per realizzare lo storage di tutte le portate del ristorante. <br>
 * Presenta una mappa con liste di foods per tipologia di portata, metodi per realizzare il CRUD dei foods. <br>
 * A partire dalla mappa con le liste dei foods, si possono creare dei menu personalizzati per tipologia alimentare
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class FoodStorage {

    /**
     * È l'unico oggetto istanziato (con visibilità private) della classe singleton {@link it.team1Restaurant.foods.FoodStorage}
     */
    private static FoodStorage foodStorage = new FoodStorage();

    /**
     * La mappa di storage con tutte le portate del ristorante,
     * con chiave {@link it.team1Restaurant.foods.TypeFoodEnum}
     * e valori le liste dei foods {@link it.team1Restaurant.foods.FoodList}
     */
    private Map<TypeFoodEnum, FoodList> foodListsMap;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.FoodStorage},
     * viene istanziata la mappa di storage con tutte le portate e le relative liste di foods (inizialmente vuote)
     * mediante il metodo {@link FoodStorage#initFoodListsMap()}
     */
    private FoodStorage(){
        this.foodListsMap = initFoodListsMap();
    }

    /**
     * Metodo getter che restituisce l'oggetto della classe singleton {@link it.team1Restaurant.foods.FoodStorage}
     * precedentemente istanziato
     * @return Oggetto classe singleton {@link it.team1Restaurant.foods.FoodStorage}
     */
    public static FoodStorage getInstance(){
        return foodStorage;
    }

    /**
     * Metodo getter che restituisce la mappa di storage con tutte le portate del ristorante
     * @return Mappa di storage con tutte le portate del ristorante
     */
    public Map<TypeFoodEnum, FoodList> getFoodListsMap() {
        return foodListsMap;
    }

    /**
     * Metodo setter che setta la mappa di storage con tutte le portate del ristorante
     * @param foodListsMap La mappa di storage con tutte le portate del ristorante
     */
    public void setFoodListsMap(Map<TypeFoodEnum, FoodList> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    /**
     * Questo metodo istanzia ed inizializza la mappa di storage con tutte le portate del ristorante
     * con chiavi {@link it.team1Restaurant.foods.TypeFoodEnum}
     * e le relative liste dei foods istanziate {@link it.team1Restaurant.foods.FoodList} (inizialmente vuote)
     * @return Mappa di storage con tutte le portate del ristorante (con liste dei foods inizialmente vuote)
     */
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

    /**
     * Questo metodo aggiunge un drink nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum#DRINK} <br>
     * L'oggetto drink con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     */
    public void addDrink(String name, double price){
        foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, price));
    }

    /**
     * Questo metodo aggiunge un drink nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum#DRINK} <br>
     * L'oggetto drink con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     * @param typeSet EnumSet delle tipologie alimentari del drink
     */
    public void addDrink(String name, double price, EnumSet<TypeDishClientEnum> typeSet){
        foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, price, typeSet));
    }

    /**
     * Questo metodo aggiunge un drink nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum#DRINK} <br>
     * L'oggetto drink con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param name Il nome del drink
     * @param ingredients La lista degli ingredienti del drink
     * @param typeSet EnumSet delle tipologie alimentari del drink
     * @param price Il prezzo del drink
     */
    public void addDrink(String name, List<Ingredient> ingredients, EnumSet<TypeDishClientEnum> typeSet , double price){
        foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, ingredients, price, typeSet));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param price Il prezzo del dish
     */
    public void addDish(TypeFoodEnum typeFood, String name, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, price));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param typeSet EnumSet delle tipologie alimentari del dish
     * @param price Il prezzo del dish
     */
    public void addDish(TypeFoodEnum typeFood, String name, EnumSet<TypeDishClientEnum> typeSet, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, price, typeSet));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param ingredients La lista degli ingredienti del dish
     * @param price Il prezzo del dish
     */
    public void addDish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param ingredients La lista degli ingredienti del dish
     * @param price Il prezzo del dish
     * @param typeSet EnumSet delle tipologie alimentari del dish
     */
    public void addDish(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet){
        foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients, price, typeSet));
    }

    /**
     * Questo metodo aggiunge un food (dish / drink) nella lista dei foods con chiave {@link it.team1Restaurant.foods.TypeFoodEnum} <br>
     * L'oggetto (dish / drink) con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di tutte le portate. In base alla tipologia di portata {@link it.team1Restaurant.foods.TypeFoodEnum}, verrà invocato
     * opportunamente il costruttore di Drink {@link it.team1Restaurant.foods.Drink#Drink(String, List, double, EnumSet)}
     * piuttosto che quello di Dish {@link it.team1Restaurant.foods.Dish#Dish(TypeFoodEnum, String, List, double, EnumSet)}
     * @param typeFood La tipologia di portata del food (chiave)
     * @param name Il nome del food
     * @param ingredients La lista degli ingredienti del dish
     * @param price Il prezzo del dish
     * @param typeSet EnumSet delle tipologie alimentari del dish
     */
    public void addFood(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet){
        if(typeFood.equals(TypeFoodEnum.DRINK)){
            foodListsMap.get(TypeFoodEnum.DRINK).add(new Drink(name, ingredients, price, typeSet));
        }
        else{
            foodListsMap.get(typeFood).add(new Dish(typeFood, name, ingredients,price, typeSet));
        }
    }

    /**
     * Questo metodo restituisce nel dettaglio i dati dei foods presenti nelle liste della mappa di storage
     * @return Stringa concatenata contenente i dati dei foods presenti nelle liste della mappa di storage
     */
    public String getFoodStorageDetails() {
        String str = String.format("%34s\n\n", "Storage portate ristorante");
        str += "\n\n---------------------------------------------------------\n";
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

    /**
     * Questo metodo filtra e restituisce una mappa con le relative liste di foods filtrata
     * per tipologia alimentare {@link it.team1Restaurant.menu.TypeDishClientEnum}
     * a partire dalla mappa di storage dei foods {@link FoodStorage#foodListsMap}
     * mediante il metodo {@link FoodStorage#dishFilter(EnumSet)} invocato al suo interno (riusabilità del codice)
     * @param typeDishRequired La tipologia alimentare con la quale filtrare la mappa dei foods
     * @return Mappa con le relative liste di foods filtrata per enum di {@link it.team1Restaurant.menu.TypeDishClientEnum}
     */
    public Map<TypeFoodEnum, FoodList> dishFilter(TypeDishClientEnum typeDishRequired) {
        EnumSet<TypeDishClientEnum> typeDishSetRequired = EnumSet.of(typeDishRequired);
        return this.dishFilter(typeDishSetRequired);
    }


    /**
     * Questo metodo filtra e restituisce una mappa con le relative liste di foods filtrata
     * per EnumSet di {@link it.team1Restaurant.menu.TypeDishClientEnum}
     * a partire dalla mappa di storage dei foods {@link FoodStorage#foodListsMap}
     * @param typeDishSetRequired EnumSet delle tipologie alimentari per filtrare la mappa dei foods
     * @return Mappa con le relative liste di foods filtrata per EnumSet di {@link it.team1Restaurant.menu.TypeDishClientEnum}
     */
    public Map<TypeFoodEnum, FoodList> dishFilter(EnumSet<TypeDishClientEnum> typeDishSetRequired) {
        System.out.println("Foods filtered by type: " + typeDishSetRequired.toString() + "\n"); //stampa EnumSet delle tipologie alimentari
        Map<TypeFoodEnum, FoodList> filteredFoodListsMap = initFoodListsMap(); //istanzia ed inizializzazione mappa e delle relative liste
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) { //foreach delle tipologie di portata (iterazione della mappa di storage)
            FoodList<Food> foodList = foodListsMap.get(typefood); //si ottiene una foodList per tipologia di portata
            if(foodList.isEmpty()){ //se la foodlist è vuota si passa alla successiva iterazione
                continue;
            }
            for(Food food : foodList){ //foreach dei foods della foodList
                if(!food.getTypeSet().isEmpty()){ //se l'EnumSet delle tipologie alimentari del food non è vuoto
                    for(TypeDishClientEnum typeDishRequired : typeDishSetRequired) { //foreach EnumSet delle tipologie alimentari
                        //se il food presenta la tipologia alimentare di filtraggio e la mappa filtrata non contiene il food (onde evitare duplicati)
                        if (food.getTypeSet().contains(typeDishRequired) && !filteredFoodListsMap.get(typefood).contains(food)) {
                            filteredFoodListsMap.get(typefood).add(food); //aggiunge il food alla lista per portata della mappa filtrata dei foods
                        }
                    }
                }
            }
        }
        this.printFilteredFoodListsMapDetails(filteredFoodListsMap); //stampa della mappa filtrata dei foods
        return filteredFoodListsMap; //return della mappa filtrata
        /*
        Le righe da 104 a 113 si possono sostituire con qualcosa del genere:
         Set<Food> foodWithRequirements = foodList.getFoodsByTypeDishClient(typeDishSetRequired);
         filteredFoodListsMap.get(typefood).addAll(foodWithRequirements);
        */
    }

    /**
     * Questo metodo filtra e restituisce una mappa con le relative liste di foods filtrata per EnumSet
     * di {@link it.team1Restaurant.menu.TypeDishClientEnum#VEGAN} e {@link it.team1Restaurant.menu.TypeDishClientEnum#VEGETARIAN}
     * mediante il metodo di filtraggio {@link FoodStorage#dishFilter(EnumSet)} invocato al suo interno (riusabilità del codice)
     * @return Mappa con le relative liste di foods filtrata per EnumSet
     * di {@link it.team1Restaurant.menu.TypeDishClientEnum#VEGAN} e {@link it.team1Restaurant.menu.TypeDishClientEnum#VEGETARIAN}
     */
    public Map<TypeFoodEnum, FoodList> dishFilterVeg () {
        return dishFilter(EnumSet.of(TypeDishClientEnum.VEGAN, TypeDishClientEnum.VEGETARIAN));
    }

    /**
     * Questo metodo stampa nel dettaglio i dati della mappa con le relative liste di foods
     * filtrate con i metodi di filtraggio {@link FoodStorage#dishFilter(TypeDishClientEnum)}
     * e {@link FoodStorage#dishFilter(EnumSet)} per {@link it.team1Restaurant.menu.TypeDishClientEnum}
     * @param filteredFoodListsMap La mappa dei foods precedentemente filtrata
     */
    public void printFilteredFoodListsMapDetails(Map<TypeFoodEnum, FoodList> filteredFoodListsMap){
        for (TypeFoodEnum typefood : TypeFoodEnum.values()) {
            FoodList<Food> filteredFoodList = filteredFoodListsMap.get(typefood);
            System.out.println(typefood.name() + ":\n");
            if(filteredFoodList.isEmpty()) {
                System.out.println("Nessun piatto presente con le caratteristiche richieste");
            }
            for(Food filteredFood : filteredFoodList){
                System.out.println(filteredFood.getFoodDetails());
            }
        }
    }

}
