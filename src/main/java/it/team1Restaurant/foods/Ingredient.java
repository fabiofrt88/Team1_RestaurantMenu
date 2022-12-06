package it.team1Restaurant.foods;

/**
 * Questa classe rappresenta un ingrediente di un food.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Ingredient {

    /**
     * Il nome dell'ingrediente.
     */
    private String name;
    //private List<Allergen> allergensList;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.foods.Ingredient},
     * setta la variabile d'istanza name con il relativo parametro passato nel metodo costruttore.
     * @param name Il nome dell'ingrediente
     */
    public Ingredient(String name){
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
     * Override del metodo {@link Object#toString()}, restituisce i dati dell'ingrediente.
     * @return Stringa con i dati dell'ingrediente.
     */
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                '}';
    }
}
