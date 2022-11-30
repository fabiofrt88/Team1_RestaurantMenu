package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.*;


// toDo javaDoc
public abstract class Food {

    //todo commentare variabili
    private TypeFoodEnum type;
    private EnumSet<TypeDishClientEnum> typeSet;
    private String name;
    private List<Ingredient> ingredientList;
    private double price;

    public Food(TypeFoodEnum typeFood, String name, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
        this.typeSet = EnumSet.noneOf(TypeDishClientEnum.class);
    }

    public Food(TypeFoodEnum typeFood, String name, double price, EnumSet<TypeDishClientEnum> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
        this.typeSet = typeSet;
    }

    public Food(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
        this.typeSet = EnumSet.noneOf(TypeDishClientEnum.class);
    }

    public Food(TypeFoodEnum typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClientEnum> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
        this.typeSet = typeSet;
    }


    public TypeFoodEnum getType() {
        return type;
    }

    public void setType(TypeFoodEnum type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public EnumSet<TypeDishClientEnum> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(EnumSet<TypeDishClientEnum> typeSet) {
        this.typeSet = typeSet;
    }


    public String getFoodDetails() {
        String ingredientsPrint = "";
        String ingredientTxt;
        if (!ingredientList.isEmpty()) {
            ingredientTxt = "Ingredients: ";
            for (Ingredient ingredient : ingredientList) {
                ingredientsPrint += ingredient.getName().toLowerCase() + "  ";}
        }else {
            ingredientTxt = "";
        }
        return String.format("%-50s%-5s €\n\t%s %-5s\n", name, String.format("%.2f", price), ingredientTxt, ingredientsPrint);
    }


    // todo javadoc Francesco
    public static void dishFilter(Map<String, Food> dishMap, TypeDishClientEnum typeDishRequired) {
        for (Food food : dishMap.values()) {
            if (food.typeSet.contains(typeDishRequired)) {
                System.out.println(food.getName());
            }
        }
    }

    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", typeSet=" + typeSet +
                ", name='" + name + '\'' +
                ", ingredientList=" + ingredientList +
                ", price=" + price +
                '}';
    }
}


