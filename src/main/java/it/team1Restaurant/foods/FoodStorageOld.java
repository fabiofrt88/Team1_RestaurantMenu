package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeClientMenuEnum;

import java.util.*;

/**
 * Questa classe singleton viene utilizzata per realizzare lo storage di tutte le portate del ristorante. <br>
 * Presenta una mappa con liste di foods per tipologia di portata, metodi per realizzare il CRUD dei foods. <br>
 * A partire dalla mappa con le liste dei foods, si possono creare dei menu personalizzati per tipologia alimentare
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class FoodStorageOld {

    /**
     * È l'unico oggetto istanziato (con visibilità private) della classe singleton {@link FoodStorageOld}
     */
    private static FoodStorageOld foodStorage = new FoodStorageOld();

    /**
     * La mappa di storage con tutte le portate del ristorante,
     * con chiave {@link TypeCourseEnum}
     * e valori le liste dei foods {@link it.team1Restaurant.foods.FoodList}
     */
    private Map<TypeCourseEnum, FoodList> foodListsMap;

    /**
     * Metodo costruttore della classe {@link FoodStorageOld},
     * viene istanziata la mappa di storage con tutte le portate e le relative liste di foods (inizialmente vuote)
     * mediante il metodo {@link FoodStorageOld#initFoodListsMap()}
     */
    private FoodStorageOld(){
        this.foodListsMap = initFoodListsMap();
    }

    /**
     * Metodo getter che restituisce l'oggetto della classe singleton {@link FoodStorageOld}
     * precedentemente istanziato
     * @return Oggetto classe singleton {@link FoodStorageOld}
     */
    public static FoodStorageOld getInstance(){
        return foodStorage;
    }

    /**
     * Metodo getter che restituisce la mappa di storage con tutte le portate del ristorante
     * @return Mappa di storage con tutte le portate del ristorante
     */
    public Map<TypeCourseEnum, FoodList> getFoodListsMap() {
        return foodListsMap;
    }

    /**
     * Metodo setter che setta la mappa di storage con tutte le portate del ristorante
     * @param foodListsMap La mappa di storage con tutte le portate del ristorante
     */
    public void setFoodListsMap(Map<TypeCourseEnum, FoodList> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    /**
     * Questo metodo istanzia ed inizializza la mappa di storage con tutte le portate del ristorante
     * con chiavi {@link TypeCourseEnum}
     * e le relative liste dei foods istanziate {@link it.team1Restaurant.foods.FoodList} (inizialmente vuote)
     * @return Mappa di storage con tutte le portate del ristorante (con liste dei foods inizialmente vuote)
     */
    public Map<TypeCourseEnum, FoodList> initFoodListsMap(){
        Map<TypeCourseEnum, FoodList> foodListsMap = new HashMap<>();
        foodListsMap.put(TypeCourseEnum.STARTER, new FoodList(TypeCourseEnum.STARTER));
        foodListsMap.put(TypeCourseEnum.DRINK, new FoodList(TypeCourseEnum.DRINK));
        foodListsMap.put(TypeCourseEnum.FIRST, new FoodList(TypeCourseEnum.FIRST));
        foodListsMap.put(TypeCourseEnum.SECOND, new FoodList(TypeCourseEnum.SECOND));
        foodListsMap.put(TypeCourseEnum.SIDE_DISH, new FoodList(TypeCourseEnum.SIDE_DISH));
        foodListsMap.put(TypeCourseEnum.DESSERT, new FoodList(TypeCourseEnum.DESSERT));
        foodListsMap.put(TypeCourseEnum.FRUIT, new FoodList(TypeCourseEnum.FRUIT));
        return foodListsMap;
    }

    /**
     * Questo metodo aggiunge un drink nella lista dei foods con chiave {@link TypeCourseEnum#DRINK} <br>
     * L'oggetto drink con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     */
    public void addDrink(String name, double price, TypeDrinkEnum typeDrink){
        foodListsMap.get(TypeCourseEnum.DRINK).add(new Drink(null, name, price, typeDrink));
    }

    /**
     * Questo metodo aggiunge un drink nella lista dei foods con chiave {@link TypeCourseEnum#DRINK} <br>
     * L'oggetto drink con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     * @param typeSet EnumSet delle tipologie alimentari del drink
     */
    public void addDrink(String name, double price, TypeDrinkEnum typeDrink, EnumSet<TypeClientMenuEnum> typeSet){
        foodListsMap.get(TypeCourseEnum.DRINK).add(new Drink(null, name, price, typeDrink, typeSet, new ArrayList<>()));
    }

    /**
     * Questo metodo aggiunge un drink nella lista dei foods con chiave {@link TypeCourseEnum#DRINK} <br>
     * L'oggetto drink con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param name Il nome del drink
     * @param typeDrink La tipologia del drink
     * @param ingredients La lista degli ingredienti del drink
     * @param typeSet EnumSet delle tipologie alimentari del drink
     * @param price Il prezzo del drink
     */
    public void addDrink(String name, TypeDrinkEnum typeDrink, List<Ingredient> ingredients, EnumSet<TypeClientMenuEnum> typeSet , double price){
        foodListsMap.get(TypeCourseEnum.DRINK).add(new Drink(null, name, price, typeDrink, typeSet, ingredients));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link TypeCourseEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param price Il prezzo del dish
     */
    public void addDish(TypeCourseEnum typeFood, String name, double price){
        foodListsMap.get(typeFood).add(new Dish(null, name, price, typeFood));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link TypeCourseEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param typeSet EnumSet delle tipologie alimentari del dish
     * @param price Il prezzo del dish
     */
    public void addDish(TypeCourseEnum typeFood, String name, EnumSet<TypeClientMenuEnum> typeSet, double price){
        foodListsMap.get(typeFood).add(new Dish(null, name, price, typeFood, typeSet, new ArrayList<>()));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link TypeCourseEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param ingredients La lista degli ingredienti del dish
     * @param price Il prezzo del dish
     */
    public void addDish(TypeCourseEnum typeFood, String name, List<Ingredient> ingredients, double price){
        foodListsMap.get(typeFood).add(new Dish(null, name, price, typeFood, EnumSet.noneOf(TypeClientMenuEnum.class), ingredients));
    }

    /**
     * Questo metodo aggiunge un dish nella lista dei foods con chiave {@link TypeCourseEnum} <br>
     * L'oggetto dish con i relativi parametri passati nel costruttore viene istanziato all'interno della relativa lista
     * della mappa di storage con tutte le portate
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param name Il nome del dish
     * @param ingredients La lista degli ingredienti del dish
     * @param price Il prezzo del dish
     * @param typeSet EnumSet delle tipologie alimentari del dish
     */
    public void addDish(TypeCourseEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeClientMenuEnum> typeSet){
        foodListsMap.get(typeFood).add(new Dish(null, name, price, typeFood, typeSet, ingredients));
    }

    /**
     * Questo metodo restituisce nel dettaglio i dati dei foods presenti nelle liste della mappa di storage
     * @return Stringa concatenata contenente i dati dei foods presenti nelle liste della mappa di storage
     */
    public String getFoodStorageDetails() {
        String str = String.format("%34s\n\n", "Storage portate ristorante");
        str += "\n\n---------------------------------------------------------\n";
        for (TypeCourseEnum typefood : TypeCourseEnum.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

    /**
     * Questo metodo filtra e restituisce una mappa con le relative liste di foods filtrata
     * per tipologia alimentare {@link TypeClientMenuEnum}
     * a partire dalla mappa di storage dei foods {@link FoodStorageOld#foodListsMap}
     * mediante il metodo {@link FoodStorageOld#dishFilter(EnumSet)} invocato al suo interno (riusabilità del codice)
     * @param typeDishRequired La tipologia alimentare con la quale filtrare la mappa dei foods
     * @return Mappa con le relative liste di foods filtrata per enum di {@link TypeClientMenuEnum}
     */
    public Map<TypeCourseEnum, FoodList> dishFilter(TypeClientMenuEnum typeDishRequired) {
        EnumSet<TypeClientMenuEnum> typeDishSetRequired = EnumSet.of(typeDishRequired);
        return this.dishFilter(typeDishSetRequired);
    }


    /**
     * Questo metodo filtra e restituisce una mappa con le relative liste di foods filtrata
     * per EnumSet di {@link TypeClientMenuEnum}
     * a partire dalla mappa di storage dei foods {@link FoodStorageOld#foodListsMap}
     * @param typeDishSetRequired EnumSet delle tipologie alimentari per filtrare la mappa dei foods
     * @return Mappa con le relative liste di foods filtrata per EnumSet di {@link TypeClientMenuEnum}
     */
    public Map<TypeCourseEnum, FoodList> dishFilter(EnumSet<TypeClientMenuEnum> typeDishSetRequired) {
        System.out.println("Foods filtered by type: " + typeDishSetRequired.toString() + "\n"); //stampa EnumSet delle tipologie alimentari
        Map<TypeCourseEnum, FoodList> filteredFoodListsMap = initFoodListsMap(); //istanzia ed inizializzazione mappa e delle relative liste
        for (TypeCourseEnum typefood : TypeCourseEnum.values()) { //foreach delle tipologie di portata (iterazione della mappa di storage)
            FoodList<Food> foodList = foodListsMap.get(typefood); //si ottiene una foodList per tipologia di portata
            if(foodList.isEmpty()){ //se la foodlist è vuota si passa alla successiva iterazione
                continue;
            }
            for(Food food : foodList){ //foreach dei foods della foodList
                if(!food.getTypeSet().isEmpty()){ //se l'EnumSet delle tipologie alimentari del food non è vuoto
                    for(TypeClientMenuEnum typeDishRequired : typeDishSetRequired) { //foreach EnumSet delle tipologie alimentari
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
     * di {@link TypeClientMenuEnum#VEGAN} e {@link TypeClientMenuEnum#VEGETARIAN}
     * mediante il metodo di filtraggio {@link FoodStorageOld#dishFilter(EnumSet)} invocato al suo interno (riusabilità del codice)
     * @return Mappa con le relative liste di foods filtrata per EnumSet
     * di {@link TypeClientMenuEnum#VEGAN} e {@link TypeClientMenuEnum#VEGETARIAN}
     */
    public Map<TypeCourseEnum, FoodList> dishFilterVeg () {
        return dishFilter(EnumSet.of(TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN));
    }

    /**
     * Questo metodo stampa nel dettaglio i dati della mappa con le relative liste di foods
     * filtrate con i metodi di filtraggio {@link FoodStorageOld#dishFilter(TypeClientMenuEnum)}
     * e {@link FoodStorageOld#dishFilter(EnumSet)} per {@link TypeClientMenuEnum}
     * @param filteredFoodListsMap La mappa dei foods precedentemente filtrata
     */
    public void printFilteredFoodListsMapDetails(Map<TypeCourseEnum, FoodList> filteredFoodListsMap){
        for (TypeCourseEnum typefood : TypeCourseEnum.values()) {
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
