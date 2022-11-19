package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeDish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class Food implements IFood {
    private TypeFood type;
    private TypeDish typeDish;
    private String name;

    private List<Ingredient> ingredientList;
    private double price;

    public Food() {}

    public Food(TypeFood typeFood, String name, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
    }

    public Food(TypeFood typeFood, String name, Ingredient ingredient, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = new ArrayList<>(Arrays.asList(ingredient));
    }

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredient, double price) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredient;
    }

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredient, double price, TypeDish typeDish) {
        this.type = typeFood;
        this.name = name;
        this.price = price;
        this.ingredientList = ingredient;
        this.typeDish = typeDish;
    }

    public TypeFood getType() {
        return type;
    }

    public void setType(TypeFood type) {
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

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeDish getTypeDish() {
        return typeDish;
    }

    public void setTypeDish(TypeDish typeDish) {
        this.typeDish = typeDish;
    }


    public String getFoodDetails() {
        String ingredientsPrint = "";
        String ingredientTxt;
        if (ingredientList != null) {
            ingredientTxt = "Ingredient: ";
            for (Ingredient ingredient : ingredientList) {
                ingredientsPrint += ingredient.getName().toLowerCase() + "  ";}
        }else {ingredientTxt = "";}
        return String.format("%-50s%-5s €\n\t%s %-5s\n", name, String.format("%.2f", price), ingredientTxt, ingredientsPrint);
    }

    public static void dishFilter(Map<String, Food> dishMap, TypeDish typeDishRequired) {
        for (Food food : dishMap.values()) {
            if (food.typeDish.equals(typeDishRequired)) {
                System.out.println(food.getName());
            }
        }
    }
}


