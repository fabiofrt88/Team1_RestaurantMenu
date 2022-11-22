package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDishClient;

import java.util.*;

public abstract class Food implements IFood {
    private TypeFood type;
    private EnumSet<TypeDishClient> typeSet;
    private String name;
    private List<Ingredient> ingredientList;
    private double price;

    public Food(TypeFood typeFood, String name, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
        this.typeSet = EnumSet.noneOf(TypeDishClient.class);
    }

    public Food(TypeFood typeFood, String name, double price, EnumSet<TypeDishClient> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>();
        this.typeSet = typeSet;
    }

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredients, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
        this.typeSet = EnumSet.noneOf(TypeDishClient.class);
    }

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDishClient> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
        this.typeSet = typeSet;
    }

    @Override
    public TypeFood getType() {
        return type;
    }

    public void setType(TypeFood type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public EnumSet<TypeDishClient> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(EnumSet<TypeDishClient> typeSet) {
        this.typeSet = typeSet;
    }

    @Override
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

    public static void dishFilter(Map<String, Food> dishMap, TypeDishClient typeDishRequired) {
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


