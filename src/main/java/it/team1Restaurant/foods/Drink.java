package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeFoodEnum;

import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un drink. È una sottoclasse di {@link it.team1Restaurant.foods.Food}.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Drink extends Food {

    /**
     * La tipologia del drink.
     */
    private TypeDrinkEnum typeDrink;

    /**
     * Il codice identificativo della tipologia del drink (chiave esterna). Vedi enum {@link TypeDrinkEnum}
     */
    private Integer typeDrinkId;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Drink} destinato all'inserimento di un drink
     * nel database, setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(Integer, String, double)}
     * e quelle di classe, rispettivamente la tipologia del drink e il relativo codice identificativo.
     * @param id Il codice identificativo del drink
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     * @param typeDrink La tipologia del drink
     */
    public Drink(Integer id, String name, double price, TypeDrinkEnum typeDrink){
        super(id, name, price);
        this.typeDrink = typeDrink;
        this.typeDrinkId = initTypeDrinkId(typeDrink);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Drink}, destinato alla lettura
     * e all'acquisizione dei record dalla relative tabella nel database come istanze della classe Drink,
     * setta le variabili d'istanza ereditate dalla superclasse {@link it.team1Restaurant.foods.Food}
     * mediante il relativo metodo costruttore {@link it.team1Restaurant.foods.Food#Food(Integer, String, double, EnumSet, List)}
     * e quelle di classe con i parametri passati nel costruttore.
     * @param id Il codice identificativo del drink.
     * @param name Il nome del drink
     * @param price Il prezzo del drink
     * @param typeDrink La tipologia del drink
     * @param ingredients La lista degli ingredienti del drink
     * @param typeSet EnumSet delle tipologie alimentari del drink
     */
    public Drink(Integer id, String name, double price, TypeDrinkEnum typeDrink, EnumSet<TypeFoodEnum> typeSet, List<Ingredient> ingredients) {
        super(id, name, price, typeSet, ingredients);
        this.typeDrink = typeDrink;
        this.typeDrinkId = initTypeDrinkId(typeDrink);
    }

    public TypeDrinkEnum getTypeDrink() {
        return typeDrink;
    }

    public void setTypeDrink(TypeDrinkEnum typeDrink) {
        this.typeDrink = typeDrink;
    }

    public Integer getTypeDrinkId() {
        return typeDrinkId;
    }

    public void setTypeDrinkId(Integer typeDrinkId) {
        this.typeDrinkId = typeDrinkId;
    }

    public Integer initTypeDrinkId(TypeDrinkEnum typeDrink){
        return (typeDrink != null) ? typeDrink.getId() : null;
    }

    /**
     * Override del metodo {@link Food#toString()}, restituisce  dati del drink.
     * @return Stringa con i dati del drink.
     */
    @Override
    public String toString() {
        return "Drink{" +
                super.toString() +
                ", typeDrink = " + typeDrink +
                ", typeDrinkId = " + typeDrinkId +
                '}';
    }

}
