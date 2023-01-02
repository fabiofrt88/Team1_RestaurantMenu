package it.team1Restaurant.foods;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Questa classe è un enum che definisce le tipologie di portata dei food.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public enum TypeCourseEnum {

    @SerializedName("Drink")
    DRINK(null, "Drink"),
    @SerializedName("Starter")
    STARTER(1, "Starter"),
    @SerializedName("First")
    FIRST(2, "First"),
    @SerializedName("Second")
    SECOND(3, "Second"),
    @SerializedName("Side dish")
    SIDE_DISH(4, "Side dish"),
    @SerializedName("Dessert")
    DESSERT(5, "Dessert"),
    @SerializedName("Fruit")
    FRUIT(6, "Fruit");

    private final Integer id;
    private final String typeCourse;

    private static final Map<Integer, TypeCourseEnum> typeCourseEnumMap = new HashMap<>();

    static{
        for(TypeCourseEnum typeCourseEnum : TypeCourseEnum.values()){
            typeCourseEnumMap.put(typeCourseEnum.id, typeCourseEnum);
        }
    }

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

    public static TypeCourseEnum getTypeCourseById(Integer id){
        return typeCourseEnumMap.get(id);
    }

    public static TypeCourseEnum getTypeCourseByName(String typeCourse){
        TypeCourseEnum typeCourseEnum = null;
        try {
            typeCourseEnum = TypeCourseEnum.valueOf(typeCourse.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return typeCourseEnum;
    }

}
