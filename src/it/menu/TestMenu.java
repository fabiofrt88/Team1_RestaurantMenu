package it.menu;
import it.foods.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;


public class TestMenu {
    public static void main(String[] args) {


        Menu menu = new Menu("Vegano");

        //create the drinks:
        menu.addDrink("Acqua", new Ingredient("Acqua"), 2);
        menu.addDrink("Vino", new Ingredient("Uva"), 15);
        menu.addDrink("Birra", new ArrayList<>(Arrays.asList(new Ingredient("Acqua"),
                new Ingredient("Lievito"), new Ingredient("Luppolo"))), 6);


        //create the First:
        menu.addFood(TypeFood.FIRST, "Insalata di riso e melone", new ArrayList<>(Arrays.asList(
                new Ingredient("Riso"), new Ingredient("melone"))), 11);
        menu.addFood(TypeFood.FIRST, "Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(
                new Ingredient("Carciofi"), new Ingredient("Limone"))), 14);


        //create the Seconds;
        menu.addFood(TypeFood.SECOND, "Polpettone di fagioli e tofu alle erbe",
                new ArrayList<>(Arrays.asList(new Ingredient("Tofu"), new Ingredient("Fagioli"), new Ingredient("Erbe"))), 13);
        menu.addFood(TypeFood.SECOND, "Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(new Ingredient("Zucchine"), new Ingredient("Fagioli Bianchi"))), 14);

        //create the sweets:
        menu.addFood(TypeFood.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti Vegani"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("yougurt di soia"),
                new Ingredient("panna di soya"))), 12);
        menu.addFood(TypeFood.DESSERT, "Ciambellone vegano", new ArrayList<>(Arrays.asList(new Ingredient("Latte Vegetale"),
                new Ingredient("Semi di Girasole"), new Ingredient("Farina 0"), new Ingredient("Lievito"),
                new Ingredient("Cacao Amaro"), new Ingredient("Zucchine"))), 15);


        //print the menu
        System.out.println(menu.printMenuDetails());
    }
}