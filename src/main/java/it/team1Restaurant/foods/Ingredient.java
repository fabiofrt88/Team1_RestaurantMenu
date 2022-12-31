package it.team1Restaurant.foods;

/**
 * Questa classe rappresenta un ingrediente di un food.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Ingredient {

    /**
     * Il codice identificativo dell'ingrediente (chiave primaria univoca autoincrementale non modificabile).
     */
    private final Integer id;

    /**
     * Il nome dell'ingrediente.
     */
    private String name;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Ingredient},
     * destinato all'inserimento degli ingredienti nel database, <br>
     * setta la variabile d'istanza name con il relativo parametro passato nel metodo costruttore,
     * l'id sarà inizialmente null, assegnato, gestito e reso autoincrementale dal DBMS.
     * @param name Il nome dell'ingrediente
     */
    public Ingredient(String name){
        this.id = null;
        this.name = name;
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Ingredient},
     * destinato alla lettura e all'acquisizione dei record dalle relative tabelle nel database come istanze
     * della classe Ingredient, setta le variabili d'istanza con i relativi parametri passati nel metodo costruttore,
     * l'id sarà inizialmente null, assegnato, gestito e reso autoincrementale dal DBMS.
     * @param id Il codice identificativo dell'ingrediente
     * @param name Il nome dell'ingrediente
     */
    public Ingredient(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Metodo getter che restituisce il nome dell'ingrediente.
     * @return Nome dell'ingrediente.
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo setter che setta il nome dell'ingrediente.
     * @param name Il nome dell'ingrediente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo getter che restituisce l'id dell'ingrediente.
     * @return Id dell'ingrediente.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Override del metodo {@link Object#toString()}, restituisce i dati dell'ingrediente.
     * @return Stringa con i dati dell'ingrediente.
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
