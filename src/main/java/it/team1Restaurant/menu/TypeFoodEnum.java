package it.team1Restaurant.menu;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Questa classe è un enum che definisce le tipologie / categorie alimentari delle portate, dei menu e dei clienti.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public enum TypeFoodEnum {

    @SerializedName("Generic")
    GENERIC(1, "Generic"),
    @SerializedName("Child")
    CHILD(2, "Child"),
    @SerializedName("Meat")
    MEAT(3, "Meat"),
    @SerializedName("Fish")
    FISH(4, "Fish"),
    @SerializedName("Vegan")
    VEGAN(5, "Vegan"),
    @SerializedName("Vegetarian")
    VEGETARIAN(6, "Vegetarian"),
    @SerializedName("Celiac")
    CELIAC(7, "Celiac");

    private final Integer id;
    private final String typeFood;

    private static final Map<Integer, TypeFoodEnum> typeFoodMap = new HashMap<>();

    static{
        for(TypeFoodEnum typeFoodEnum : TypeFoodEnum.values()){
            typeFoodMap.put(typeFoodEnum.id, typeFoodEnum);
        }
    }

    TypeFoodEnum(Integer id, String typeFood){
        this.id = id;
        this.typeFood = typeFood;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeFoodName() {
        return typeFood;
    }

    public static TypeFoodEnum getTypeTypeFoodById(Integer id){
        return typeFoodMap.get(id);
    }

    public static TypeFoodEnum getTypeFoodByName(String typeFood){
        TypeFoodEnum typeFoodEnum = null;
        try {
            typeFoodEnum = TypeFoodEnum.valueOf(typeFood.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return typeFoodEnum;
    }

}
