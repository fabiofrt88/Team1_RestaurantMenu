package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeClientMenuEnum;

import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un dish (piatto). È una sottoclasse di {@link it.team1Restaurant.foods.Food}.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Dish extends Food {

    /**
     * La tipologia di portata del food. Vedi enum {@link TypeCourseEnum}
     */
    private TypeCourseEnum typeCourse;

    /**
     * Il codice identificativo della tipologia di portata del food (chiave esterna). Vedi enum {@link TypeCourseEnum}
     */
    private Integer typeCourseId;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Dish} destinato all'inserimento di un dish
     * nel database, setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(Integer, String, double)}
     * e quelle di classe, rispettivamente la tipologia di portata e il relativo codice identificativo.
     * @param id Il codice identificativo del dish.
     * @param name Il nome del dish
     * @param price Il prezzo del dish
     * @param typeCourse La tipologia di portata del dish
     */
    public Dish(Integer id, String name, double price, TypeCourseEnum typeCourse){
        super(id, name, price);
        this.typeCourse = typeCourse;
        this.typeCourseId = typeCourse.getId();
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Dish}, destinato alla lettura
     * e all'acquisizione dei record dalla relative tabella nel database come istanze della classe Dish,
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(Integer, String, double, EnumSet, List)}
     * e quelle di classe con i parametri passati nel costruttore.
     * @param id Il codice identificativo del dish.
     * @param name Il nome del dish
     * @param price Il prezzo del dish
     * @param typeCourse La tipologia di portata del dish
     * @param ingredients La lista degli ingredienti del dish
     * @param typeSet EnumSet delle tipologie alimentari del dish
     */
    public Dish(Integer id, String name, double price, TypeCourseEnum typeCourse, EnumSet<TypeClientMenuEnum> typeSet, List<Ingredient> ingredients) {
        super(id, name, price, typeSet, ingredients);
        this.typeCourse = typeCourse;
        this.typeCourseId = typeCourse.getId();
    }

    /**
     * Metodo getter che restituisce la tipologia di portata del food.
     * @return Tipo di portata del food.
     */
    public TypeCourseEnum getTypeCourse() {
        return typeCourse;
    }

    /**
     * Metodo setter che setta il tipo di portata del food.
     * @param typeCourse Il tipo di portata del food.
     */
    public void setTypeCourse(TypeCourseEnum typeCourse) {
        this.typeCourse = typeCourse;
    }

    public Integer getTypeCourseId() {
        return typeCourseId;
    }

    public void setTypeCourseId(Integer typeCourseId) {
        this.typeCourseId = typeCourseId;
    }

    /**
     * Override del metodo {@link Food#toString()}, restituisce i dati del dish.
     * @return Stringa con i dati del dish.
     */
    @Override
    public String toString() {
        return "Dish{" +
                super.toString() +
                "typeCourse = " + typeCourse +
                ", typeCourseId = " + typeCourseId +
                '}';
    }
}
