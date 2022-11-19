package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.*;

public abstract class Food implements IFood {
    private TypeFood type;
    private EnumSet<TypeDish> typeSet;
    private String name;
    private List<Ingredient> ingredientList;
    private double price;

    public Food(TypeFood typeFood, String name, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
    }

    public Food(TypeFood typeFood, String name, double price, EnumSet<TypeDish> typeSet) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.typeSet = typeSet;
    }

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredients, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredients;
    }

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredients, double price, EnumSet<TypeDish> typeSet) {
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
    public EnumSet<TypeDish> getTypeSet() {
        return typeSet;
    }

    public void setTypeSet(EnumSet<TypeDish> typeSet) {
        this.typeSet = typeSet;
    }

    @Override
    public String getFoodDetails() {
        String ingredientsPrint = "";
        String ingredientTxt;
        if (ingredientList != null) {
            ingredientTxt = "Ingredients: ";
            for (Ingredient ingredient : ingredientList) {
                ingredientsPrint += ingredient.getName().toLowerCase() + "  ";}
        }else {
            ingredientTxt = "";
        }
        return String.format("%-50s%-5s €\n\t%s %-5s\n", name, String.format("%.2f", price), ingredientTxt, ingredientsPrint);
    }

    public static void dishFilter(Map<String, Food> dishMap, TypeDish typeDishRequired) {
        for (Food food : dishMap.values()) {
            if (food.typeSet.contains(typeDishRequired)) {
                System.out.println(food.getName());
            }
        }
    }
}


