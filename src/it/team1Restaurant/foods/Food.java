package it.team1Restaurant.foods;

import it.team1Restaurant.menu.TypeFood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Food {
    private TypeFood type;
    private String name;

    private List<Ingredient> ingredientList;
    private double price;

    public Food () {};

    public Food(TypeFood typeFood, String name, double price){
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFoodDetails() {
        String ingredientsPrint = "";
        for (Ingredient ingredient : ingredientList) {
            ingredientsPrint += ingredient.getName().toLowerCase() + "  ";
        }

        return String.format("%-50s%-5s €\n\tIngredients: %-5s\n", name, String.format("%.2f", price), ingredientsPrint);
    }
}
