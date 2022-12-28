package it.team1Restaurant.foods;

/**
 * Questa classe è un enum che definisce le tipologie di portata dei food.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public enum TypeCourseEnum {

    DRINK(null, "Drink"),
    STARTER(1, "Starter"),
    FIRST(2, "First"),
    SECOND(3, "Second"),
    SIDE_DISH(4, "Side dish"),
    DESSERT(5, "Dessert"),
    FRUIT(6, "Fruit");

    private final Integer id;
    private final String typeCourse;

    TypeCourseEnum(Integer id, String typeCourse){
        this.id = id;
        this.typeCourse = typeCourse;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeCourse() {
        return typeCourse;
    }

}
