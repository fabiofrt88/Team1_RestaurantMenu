package it.team1Restaurant.menu;
import it.team1Restaurant.foods.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
     * Etichetta denominazione (label) del menu
     */
    private String label;

    /**
     * La tipologia del menu. Vedi {@link TypeFoodEnum}
     */
    private TypeFoodEnum typeMenu;

    /**
     * Il codice identificativo della tipologia del drink (chiave esterna). Vedi enum {@link TypeFoodEnum}
     */
    private Integer typeMenuId;

    /**
     * La mappa delle portate del menu,
     * con chiave {@link TypeCourseEnum}
     * e valori le liste dei foods {@link it.team1Restaurant.foods.FoodList}
     */
    private Map<String, List<Food>> foodListsMap;

    /**
     * Metodo costruttore della classe {@link Menu}, setta le variabili d'istanza
     * con i relativi parametri passati nel costruttore, viene istanziata la mappa di tutte le portate
     * e le relative liste di foods (inizialmente vuote) mediante il metodo {@link Menu#initFoodListsMap()}
     */
    public Menu(Integer id, String label, TypeFoodEnum typeMenu){
        this.id = id;
        this.label = label;
        this.typeMenu = typeMenu;
        this.typeMenuId = initTypeMenuId(typeMenu);
        this.foodListsMap = initFoodListsMap();
    }

    /**
     * Metodo getter che restituisce l'id del menu
     * @return L'id del menu
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo getter che restituisce il label del menu
     * @return Il tipo (label) del menu
     */
    public String getLabel() {
        return label;
    }

    /**
     * Metodo setter che setta il label del menu
     * @param label label del menu
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Metodo getter che restituisce la tipologia del menu
     * @return La tipologia del menu (enum)
     */
    public TypeFoodEnum getTypeMenu() {
        return typeMenu;
    }

    /**
     * Metodo setter che setta la tipologia del menu
     * @param typeMenu La tipologia del menu (enum)
     */
    public void setTypeMenu(TypeFoodEnum typeMenu) {
        this.typeMenu = typeMenu;
    }

    public Integer getTypeMenuId() {
        return typeMenuId;
    }

    public void setTypeMenuId(Integer typeMenuId) {
        this.typeMenuId = typeMenuId;
    }

    /**
     * Metodo getter che restituisce la mappa delle portate del menu
     * @return Mappa delle portate del menu
     */
    public Map<String, List<Food>> getFoodListsMap() {
        return foodListsMap;
    }

    /**
     * Metodo setter che setta la mappa delle portate del menu
     * @param foodListsMap La mappa delle portate del menu
     */
    public void setFoodListsMap(Map<String, List<Food>> foodListsMap) {
        this.foodListsMap = foodListsMap;
    }

    /**
     * Questo metodo istanzia ed inizializza la mappa delle portate del menu
     * con chiavi {@link TypeCourseEnum}
     * e le relative liste dei foods istanziate {@link it.team1Restaurant.foods.FoodList} (inizialmente vuote)
     * @return Mappa delle portate del menu (con liste dei foods inizialmente vuote)
     */
    public Map<String, List<Food>> initFoodListsMap(){
        //Map<TypeCourseEnum, FoodList> foodListsMap = new HashMap<>();
        Map<String, List<Food>> foodListsMap = new HashMap<>();

        /*foodListsMap.put(TypeCourseEnum.STARTER, new FoodList(TypeCourseEnum.STARTER));
        foodListsMap.put(TypeCourseEnum.DRINK, new FoodList(TypeCourseEnum.DRINK));
        foodListsMap.put(TypeCourseEnum.FIRST, new FoodList(TypeCourseEnum.FIRST));
        foodListsMap.put(TypeCourseEnum.SECOND, new FoodList(TypeCourseEnum.SECOND));
        foodListsMap.put(TypeCourseEnum.SIDE_DISH, new FoodList(TypeCourseEnum.SIDE_DISH));
        foodListsMap.put(TypeCourseEnum.DESSERT, new FoodList(TypeCourseEnum.DESSERT));
        foodListsMap.put(TypeCourseEnum.FRUIT, new FoodList(TypeCourseEnum.FRUIT));*/

        foodListsMap.put(TypeCourseEnum.STARTER.name().toLowerCase(), new ArrayList<>());
        foodListsMap.put(TypeCourseEnum.DRINK.name().toLowerCase(), new ArrayList<>());
        foodListsMap.put(TypeCourseEnum.FIRST.name().toLowerCase(), new ArrayList<>());
        foodListsMap.put(TypeCourseEnum.SECOND.name().toLowerCase(), new ArrayList<>());
        foodListsMap.put(TypeCourseEnum.SIDE_DISH.name().toLowerCase(), new ArrayList<>());
        foodListsMap.put(TypeCourseEnum.DESSERT.name().toLowerCase(), new ArrayList<>());
        foodListsMap.put(TypeCourseEnum.FRUIT.name().toLowerCase(), new ArrayList<>());

        return foodListsMap;
    }

    public Integer initTypeMenuId(TypeFoodEnum typeMenu){
        return (typeMenu != null) ? typeMenu.getId() : null;
    }

    /**
     * Questo metodo aggiunge per aggregazione un drink nella lista dei foods
     * con chiave {@link TypeCourseEnum#DRINK} della mappa delle portate del menu
     * @param drink Istanza di classe {@link it.team1Restaurant.foods.Drink}
     */
    public void addDrink(Drink drink){
        foodListsMap.get(TypeCourseEnum.DRINK.name().toLowerCase()).add(drink);
    }

    /**
     * Questo metodo aggiunge per aggregazione un dish nella lista dei foods
     * con chiave {@link TypeCourseEnum} della mappa delle portate del menu
     * @param typeCourse La tipologia di portata del dish (chiave)
     * @param dish Istanza della classe {@link it.team1Restaurant.foods.Dish}
     */
    public void addDish(TypeCourseEnum typeCourse, Dish dish) {
    //  if(typeFood == TypeFood.DRINK) throw new Exception("Un dish non può essere un Drink");
        foodListsMap.get(typeCourse.name().toLowerCase()).add(dish);
    }

    /**
     * Questo metodo aggiunge un generico food (dish / drink) nella lista dei foods con chiave {@link TypeCourseEnum}
     * della mappa delle portate del menu. Prevede i seguenti controlli: se il food generico è istanza della classe {@link it.team1Restaurant.foods.Drink}
     * e la tipologia di portata è diversa da {@link TypeCourseEnum#DRINK}, si assegnerà di de default
     * {@link TypeCourseEnum#DRINK} alla tipologia, quindi si aggiungerà il food alla lista.
     * Se il food generico dovesse essere un {@link it.team1Restaurant.foods.Dish}, ma la sua tipologia alimentare
     * è {@link TypeCourseEnum#DRINK}, lancia relativa eccezione
     * @param typeCourse La tipologia di portata del food (chiave)
     * @param food Il food generico (dish / drink)
     * @param <T> Tipo generico (sottoclassi di {@link it.team1Restaurant.foods.Food}
     * @throws Exception
     */

    public <T extends Food> void addFood (TypeCourseEnum typeCourse, T food) throws Exception {
        if(food instanceof Drink && typeCourse != TypeCourseEnum.DRINK){
            typeCourse = TypeCourseEnum.DRINK;
        }
        else if(!(food instanceof Drink) && typeCourse == TypeCourseEnum.DRINK){
            throw new Exception("Un dish non è un drink!");
        }
        foodListsMap.get(typeCourse.name().toLowerCase()).add(food);
    }

    /**
     * Questo metodo restituisce i dati del menu e dei foods presenti nelle relative liste della mappa
     * @return Stringa concatenata con i dati del menu e dei foods presenti nelle relative liste della mappa
     */
    public String getMenuDetails() {
        String str = String.format("%35s\n\n", "Team-1 restaurant")
                + String.format("%23s %s", "MENU", label.toUpperCase());
        str += "\n\n---------------------------------------------------------\n";
        for (TypeCourseEnum typeCourse : TypeCourseEnum.values()) {
            //FoodList foodList = foodListsMap.get(typeCourse);
            /*str += "\n" + typeCourse.name() + ":\n" + foodList.getFoodListDetails()
                    + "\n---------------------------------------------------------\n";*/
            List<Food> foodList = foodListsMap.get(typeCourse.name().toLowerCase());
            str += "\n" + typeCourse.getTypeCourseName().toUpperCase() + ":\n";
            for(Food food : foodList) {
                str += "\n" + food.getFoodDetails();
            }
            str += "\n---------------------------------------------------------\n";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", foodListsMap=" + foodListsMap +
                ", typeMenu=" + typeMenu +
                '}';
    }
}
