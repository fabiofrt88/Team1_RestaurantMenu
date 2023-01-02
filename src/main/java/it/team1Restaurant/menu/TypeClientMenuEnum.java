package it.team1Restaurant.menu;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Questa classe è un enum che definisce le categorie alimentari dei clienti e delle portate.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public enum TypeClientMenuEnum {

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
    private final String typeClientMenu;

    private static final Map<Integer, TypeClientMenuEnum> typeClientMenuMap = new HashMap<>();

    static{
        for(TypeClientMenuEnum typeClientMenuEnum : TypeClientMenuEnum.values()){
            typeClientMenuMap.put(typeClientMenuEnum.id, typeClientMenuEnum);
        }
    }

    TypeClientMenuEnum(Integer id, String typeClientMenu){
        this.id = id;
        this.typeClientMenu = typeClientMenu;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeClientMenuName() {
        return typeClientMenu;
    }

    public static TypeClientMenuEnum getTypeClientMenuById(Integer id){
        return typeClientMenuMap.get(id);
    }

    public static TypeClientMenuEnum getTypeClientMenuByName(String typeClientMenu){
        TypeClientMenuEnum typeClientMenuEnum = null;
        try {
            typeClientMenuEnum = TypeClientMenuEnum.valueOf(typeClientMenu.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return typeClientMenuEnum;
    }

}
