package it.team1Restaurant.foods;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeDish;
import it.team1Restaurant.menu.TypeFood;
import it.team1Restaurant.menu.TypeMenu;

import java.util.*;

public class Food {
    private TypeFood type;
    private TypeDish typeDish;
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

    public Food(TypeFood typeFood, String name, List<Ingredient> ingredient, double price, TypeDish typeDish) {
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

    public TypeDish getTypeDish() {return typeDish; }

    public void setTypeDish(TypeDish typeDish) { this.typeDish = typeDish; }

    public String getFoodDetails() {
        String ingredientsPrint = "";
        for(Ingredient ingredient : ingredientList){
            ingredientsPrint +=ingredient.getName().toLowerCase() + "  ";
        }

        return String.format("%-50s%-5s €\n\tIngredients: %-5s\n", name, String.format("%.2f", price), ingredientsPrint);
    }

/*
    public static void dishFilter(Map<String , Food> dishMap) {
        for (Food food : dishMap.values()) {
            if (food.getTypeDish().equals(TypeDish.VEGETARIAN)) {
                System.out.println(food);
                }
            }
        }*/

}


