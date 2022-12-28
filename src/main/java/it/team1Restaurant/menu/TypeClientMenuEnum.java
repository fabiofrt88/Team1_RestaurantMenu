package it.team1Restaurant.menu;

/**
 * Questa classe è un enum che definisce le categorie alimentari dei clienti e delle portate.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public enum TypeClientMenuEnum {

    GENERIC(1, "Generic"),
    MEAT(2, "Meat"),
    FISH(3, "Fish"),
    CHILD(4, "Child"),
    VEGETARIAN(5, "Vegetarian"),
    VEGAN(6, "Vegan"),
    CELIAC(7, "Celiac");

    private final Integer id;
    private final String typeClientMenu;

    TypeClientMenuEnum(Integer id, String typeClientMenu){
        this.id = id;
        this.typeClientMenu = typeClientMenu;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeClientMenu() {
        return typeClientMenu;
    }
}
