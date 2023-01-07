package it.team1Restaurant.foods;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public enum TypeDrinkEnum {

    @SerializedName("Wine")
    WINE(1, "Wine"),
    @SerializedName("Fruit Juice")
    FRUIT_JUICE(2, "Fruit Juice"),
    @SerializedName("Soft Drink")
    SOFT_DRINK(3, "Soft Drink"),
    @SerializedName("Cocktail")
    COCKTAIL(4, "Cocktail"),
    @SerializedName("Beer")
    BEER(5, "Beer"),
    @SerializedName("Liquor")
    LIQUOR(6, "Liquor");

    private final Integer id;
    private final String typeDrink;

    private static final Map<Integer, TypeDrinkEnum> typeDrinkEnumMap = new HashMap<>();

    static{
        for(TypeDrinkEnum typeDrinkEnum : TypeDrinkEnum.values()){
            typeDrinkEnumMap.put(typeDrinkEnum.id, typeDrinkEnum);
        }
    }

    TypeDrinkEnum(Integer id, String typeDrink){
        this.id = id;
        this.typeDrink = typeDrink;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeDrinkName() {
        return typeDrink;
    }

    public static TypeDrinkEnum getTypeDrinkById(Integer id){
        return typeDrinkEnumMap.get(id);
    }

    public static TypeDrinkEnum getTypeDrinkByName(String typeDrink){

        TypeDrinkEnum typeDrinkEnum = null;
        typeDrink = typeDrink.replaceAll("\\s+", "_").toUpperCase();

        try {
            typeDrinkEnum = TypeDrinkEnum.valueOf(typeDrink);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return typeDrinkEnum;

    }

}
