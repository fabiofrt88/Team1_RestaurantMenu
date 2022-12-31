package it.team1Restaurant.menu;
import it.team1Restaurant.foods.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Questa classe rappresenta un menu del ristorante. <br>
 * Presenta una mappa con liste di foods per tipologia di portata, metodi per realizzare il CRUD dei foods. <br>
 * A partire dalla mappa di storage con le liste dei foods della classe {@link FoodStorageOld},
 * si possono creare dei menu personalizzati per tipologia alimentare mediante delle associazioni ha-a di aggregazione
 * tra le classi {@link Menu} e {@link Food} da poter consultare e modificare in seguito.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Menu {

    /**
     * Il codice identificativo del menu (chiave primaria univoca autoincrementale non modificabile).
     */
    private final Integer id;

    /**
     * Il nome del ristorante (inizializzato di default)
     */
    private static String restaurantName = "Team-1 restaurant";

    /**
     * Il tipo del menu (label)
     */
    private String type;

    /**
     * La tipologia del menu. Vedi {@link TypeClientMenuEnum}
     */
    private TypeClientMenuEnum typeMenu;

    /**
     * Il codice identificativo della tipologia del drink (chiave esterna). Vedi enum {@link TypeClientMenuEnum}
     */
    private Integer typeClientMenuId;

    /**
     * La mappa delle portate del menu,
     * con chiave {@link TypeCourseEnum}
     * e valori le liste dei foods {@link it.team1Restaurant.foods.FoodList}
     */
    private Map<TypeCourseEnum, FoodList> foodListsMap;

    /**
     * Metodo costruttore della classe {@link Menu}, setta le variabili d'istanza
     * con i relativi parametri passati nel costruttore, viene istanziata la mappa di tutte le portate
     * e le relative liste di foods (inizialmente vuote) mediante il metodo {@link Menu#initFoodListsMap()}
     */
    public Menu(Integer id, String type, TypeClientMenuEnum typeMenu){
        this.id = id;
        this.type = type;
        this.typeMenu = typeMenu;
        this.typeClientMenuId = typeMenu.getId();
        this.foodListsMap = initFoodListsMap();
    }

    public Integer getId() {
        return id;
    }

    /**
     * Metodo getter che restituisce il nome del ristorante
     * @return Nome del ristorante
     */
    public static String getRestaurantName() {
        return restaurantName;
    }

    /**
     * Metodo setter che setta il nome del ristorante
     * @param restaurantName Il nome del ristorante
     */
    public static void setRestaurantName(String restaurantName) {
        Menu.restaurantName = restaurantName;
    }

    /**
     * Metodo getter che restituisce il tipo (label) del menu
     * @return Il tipo (label) del menu
     */
    public String getType() {
        return type;
    }

    /**
     * Metodo setter che setta il tipo (label) del menu
     * @param type Il tipo (label) del menu
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Metodo getter che restituisce la tipologia del menu
     * @return La tipologia del menu (enum)
     */
    public TypeClientMenuEnum getTypeMenu() {
        return typeMenu;
    }

    /**
     * Metodo setter che setta la tipologia del menu
     * @param typeMenu La tipologia del menu (enum)
     */
    public void setTypeMenu(TypeClientMenuEnum typeMenu) {
        this.typeMenu = typeMenu;
    }

    public Integer getTypeClientMenuId() {
        return typeClientMenuId;
    }

    public void setTypeClientMenuId(Integer typeClientMenuId) {
        this.typeClientMenuId = typeClientMenuId;
    }

    /**
     * Metodo getter che restituisce la mappa delle portate del menu
     * @return Mappa delle portate del menu
     */
    public Map<TypeCourseEnum, FoodList> getFoodListsMap() {
        return foodListsMap;
    }

    /**
     * Metodo setter che setta la mappa delle portate del menu
     * @param foodListsMap La mappa delle portate del menu
     */
    public void setFoodListsMap(Map<TypeCourseEnum, FoodList> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    /**
     * Questo metodo istanzia ed inizializza la mappa delle portate del menu
     * con chiavi {@link TypeCourseEnum}
     * e le relative liste dei foods istanziate {@link it.team1Restaurant.foods.FoodList} (inizialmente vuote)
     * @return Mappa delle portate del menu (con liste dei foods inizialmente vuote)
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
     * Questo metodo aggiunge per aggregazione un drink nella lista dei foods
     * con chiave {@link TypeCourseEnum#DRINK} della mappa delle portate del menu
     * @param drink Istanza di classe {@link it.team1Restaurant.foods.Drink}
     */
    public void addDrink(Drink drink){
        foodListsMap.get(TypeCourseEnum.DRINK).add(drink);
    }

    /**
     * Questo metodo aggiunge per aggregazione un dish nella lista dei foods
     * con chiave {@link TypeCourseEnum} della mappa delle portate del menu
     * @param typeFood La tipologia di portata del dish (chiave)
     * @param dish Istanza della classe {@link it.team1Restaurant.foods.Dish}
     */
    public void addDish(TypeCourseEnum typeFood, Dish dish) {
    //  if(typeFood == TypeFood.DRINK) throw new Exception("Un dish non può essere un Drink");
        foodListsMap.get(typeFood).add(dish);
    }

    /**
     * Questo metodo aggiunge un generico food (dish / drink) nella lista dei foods con chiave {@link TypeCourseEnum}
     * della mappa delle portate del menu. Prevede i seguenti controlli: se il food generico è istanza della classe {@link it.team1Restaurant.foods.Drink}
     * e la tipologia di portata è diversa da {@link TypeCourseEnum#DRINK}, si assegnerà di de default
     * {@link TypeCourseEnum#DRINK} alla tipologia, quindi si aggiungerà il food alla lista.
     * Se il food generico dovesse essere un {@link it.team1Restaurant.foods.Dish}, ma la sua tipologia alimentare
     * è {@link TypeCourseEnum#DRINK}, lancia relativa eccezione
     * @param typeFood La tipologia di portata del food (chiave)
     * @param food Il food generico (dish / drink)
     * @param <T> Tipo generico (sottoclassi di {@link it.team1Restaurant.foods.Food}
     * @throws Exception
     */

    public <T extends Food> void addFood (TypeCourseEnum typeFood, T food) throws Exception {
        if(food instanceof Drink && typeFood != TypeCourseEnum.DRINK){
            typeFood = TypeCourseEnum.DRINK;
        }
        else if(!(food instanceof Drink) && typeFood == TypeCourseEnum.DRINK){
            throw new Exception("Un dish non è un drink!");
        }
        foodListsMap.get(typeFood).add(food);
    }

    /**
     * Questo metodo restituisce i dati del menu e dei foods presenti nelle relative liste della mappa
     * @return Stringa concatenata con i dati del menu e dei foods presenti nelle relative liste della mappa
     */
    public String getMenuDetails() {
        String str = String.format("%34s\n\n", restaurantName)
                + String.format("%24s %s", "MENU", type.toUpperCase());
        str += "\n\n---------------------------------------------------------\n";
        for (TypeCourseEnum typefood : TypeCourseEnum.values()) {
            FoodList foodList = foodListsMap.get(typefood);
            str += "\n" + typefood.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", foodListsMap=" + foodListsMap +
                ", typeMenu=" + typeMenu +
                '}';
    }
}
