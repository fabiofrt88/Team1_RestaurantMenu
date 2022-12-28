package it.team1Restaurant.foods;

public enum TypeDrinkEnum {

    WINE(1, "Wine"),
    FRUIT_JUICE(2, "Fruit Juice"),
    SOFT_DRINK(3, "Soft Drink"),
    COCKTAIL(4, "Cocktail"),
    LIQUOR(5, "Liquor");

    private final Integer id;
    private final String typeDrink;

    TypeDrinkEnum(Integer id, String typeDrink){
        this.id = id;
        this.typeDrink = typeDrink;
    }

    public Integer getId() {
        return id;
    }

    public String getTypeDrink() {
        return typeDrink;
    }
}
