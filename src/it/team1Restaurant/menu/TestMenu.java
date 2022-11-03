package it.team1Restaurant.menu;
import it.team1Restaurant.foods.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TestMenu {

    public static void test(List<Menu> menuList){
        Scanner input = new Scanner(System.in);
        System.out.println("Quale menù vuoi consultare? <1> MENU DI CARNE | <2> MENU DI PESCE | <3> MENU VEGANO | <4> MENU BAMBINI");
        String firstStep = input.nextLine();
        switch (firstStep) {
            case "1":
                System.out.println(menuList.get(0).printMenuDetails());
                break;
            case "2":
                System.out.println(menuList.get(1).printMenuDetails());
                break;
            case "3":
                System.out.println(menuList.get(2).printMenuDetails());
                break;
            case "4":
                System.out.println(menuList.get(3).printMenuDetails());
                break;
        }
    }
    public static void main(String[] args) {


        Menu meatMenu = new Menu("Carne");

        //create the drinks:
        meatMenu.addDrink("Acqua", new Ingredient("Acqua"), 2);
        meatMenu.addDrink("Vino Rosso", new Ingredient("Uva"), 15);
        meatMenu.addDrink("Birra", new ArrayList<>(Arrays.asList(new Ingredient("Acqua"),
                new Ingredient("Lievito"), new Ingredient("Luppolo"))), 6);


        //create the First:
        meatMenu.addFood(TypeFood.FIRST, "Ziti alla genovese", new ArrayList<>(Arrays.asList(
                new Ingredient("Cipolle"), new Ingredient("Girello di manzo"))), 16);
        meatMenu.addFood(TypeFood.FIRST, "Tagliatelle alla bolognese", new ArrayList<>(Arrays.asList(
                new Ingredient("Carne macinata"), new Ingredient("Concentrato di pomodoro"), new Ingredient("Pancetta"))), 15);


        //create the Seconds:
        meatMenu.addFood(TypeFood.SECOND, "Salsicce e Friarielli",
                new ArrayList<>(Arrays.asList(new Ingredient("Salsicce"), new Ingredient("Friarielli"))), 13);
        meatMenu.addFood(TypeFood.SECOND, "Polpette al ragù con parmigiana di melanzane",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Passato di pomodoro"), new Ingredient("Melanzane"), new Ingredient("Fiordilatte"))), 14);

        //create the Desserts:
        meatMenu.addFood(TypeFood.DESSERT, "Tiramisu'", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt"),
                new Ingredient("Panna"))), 11);
        meatMenu.addFood(TypeFood.DESSERT, "Babà", new ArrayList<>(Arrays.asList(new Ingredient("Farina"),
                new Ingredient("Uova"), new Ingredient("Zucchero"), new Ingredient("Lievito"),
                new Ingredient("Burro"), new Ingredient("Rum"))), 9);



        //--------------------------------------------------------------------------------------------------------------

        Menu fishMenu = new Menu("Pesce");

        //create the drinks:
        fishMenu.addDrink("Acqua", new Ingredient("Acqua"), 2);
        fishMenu.addDrink("Vino Bianco", new Ingredient("Uva"), 16);
        fishMenu.addDrink("Birra", new ArrayList<>(Arrays.asList(new Ingredient("Acqua"),
                new Ingredient("Lievito"), new Ingredient("Luppolo"))), 6);


        //create the First:
        fishMenu.addFood(TypeFood.FIRST, "Linguine allo scoglio", new ArrayList<>(Arrays.asList(
                new Ingredient("Vongole"), new Ingredient("Cozze"), new Ingredient("Scampi"))), 17);
        fishMenu.addFood(TypeFood.FIRST, "Spaghetti alla luciana", new ArrayList<>(Arrays.asList(
                new Ingredient("Moscardini"), new Ingredient("Pomodoro"), new Ingredient("Olive Nere"), new Ingredient("Peperoncino"))), 16);


        //create the Seconds:
        fishMenu.addFood(TypeFood.SECOND, "Insalata di polpo e patate",
                new ArrayList<>(Arrays.asList(new Ingredient("Polpo"), new Ingredient("Patate"), new Ingredient("Limone"))), 15);
        fishMenu.addFood(TypeFood.SECOND, "Fritto misto",
                new ArrayList<>(Arrays.asList(new Ingredient("Triglie"), new Ingredient("Merluzzetti"), new Ingredient("Gamberetti"), new Ingredient("Calamari"))), 15);

        //create the Desserts:
        fishMenu.addFood(TypeFood.DESSERT, "Tiramisu'", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt"),
                new Ingredient("Panna"))), 11);
        fishMenu.addFood(TypeFood.DESSERT, "Babà", new ArrayList<>(Arrays.asList(new Ingredient("Farina"),
                new Ingredient("Uova"), new Ingredient("Zucchero"), new Ingredient("Lievito"),
                new Ingredient("Burro"), new Ingredient("Rum"))), 9);


        //--------------------------------------------------------------------------------------------------------------

        Menu veganMenu = new Menu("Vegano");

        //create the drinks:
        veganMenu.addDrink("Acqua", new Ingredient("Acqua"), 2);
        veganMenu.addDrink("Vino Rosso", new Ingredient("Uva"), 15);
        veganMenu.addDrink("Birra", new ArrayList<>(Arrays.asList(new Ingredient("Acqua"),
                new Ingredient("Lievito"), new Ingredient("Luppolo"))), 6);


        //create the First:
        veganMenu.addFood(TypeFood.FIRST, "Insalata di riso e melone", new ArrayList<>(Arrays.asList(
                new Ingredient("Riso"), new Ingredient("melone"))), 11);
        veganMenu.addFood(TypeFood.FIRST, "Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(
                new Ingredient("Carciofi"), new Ingredient("Limone"))), 14);


        //create the Seconds:
        veganMenu.addFood(TypeFood.SECOND, "Polpettone di fagioli e tofu alle erbe",
                new ArrayList<>(Arrays.asList(new Ingredient("Tofu"), new Ingredient("Fagioli"), new Ingredient("Erbe"))), 13);
        veganMenu.addFood(TypeFood.SECOND, "Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(new Ingredient("Zucchine"), new Ingredient("Fagioli Bianchi"))), 14);

        //create the Desserts:
        veganMenu.addFood(TypeFood.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti Vegani"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt di soia"),
                new Ingredient("Panna di soia"))), 12);
        veganMenu.addFood(TypeFood.DESSERT, "Ciambellone vegano", new ArrayList<>(Arrays.asList(new Ingredient("Latte Vegetale"),
                new Ingredient("Farina 0"), new Ingredient("Lievito"),
                new Ingredient("Cacao Amaro"), new Ingredient("Zucchero"))), 15);

        //--------------------------------------------------------------------------------------------------------------

        Menu childMenu = new Menu("Bambino");

        //create the drinks:
        childMenu.addDrink("Acqua", new Ingredient("Acqua"), 2);
        childMenu.addDrink("Coca Cola", new ArrayList<>(Arrays.asList(new Ingredient("Acqua")
                , new Ingredient("Zucchero"))), 3);
        childMenu.addDrink("Fanta", new ArrayList<>(Arrays.asList(new Ingredient("Acqua"),
                new Ingredient("Arance"), new Ingredient("Zucchero"))), 3);


        //create the First:
        childMenu.addFood(TypeFood.FIRST, "Pasta al sugo", new ArrayList<>(Arrays.asList(
                new Ingredient("Passato di pomodoro"))), 8);
        childMenu.addFood(TypeFood.FIRST, "Pasta al pesto", new ArrayList<>(Arrays.asList(
                new Ingredient("Basilico"), new Ingredient("Parmigiano"))), 10);


        //create the Seconds:
        childMenu.addFood(TypeFood.SECOND, "Cotoletta e Patatine",
                new ArrayList<>(Arrays.asList(new Ingredient("Pollo"), new Ingredient("Patate"))), 12);
        childMenu.addFood(TypeFood.SECOND, "Hamburger e insalata",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Insalata"))),13);

        //create the Desserts:
        childMenu.addFood(TypeFood.DESSERT, "Gelato alla fragola", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Fragole"))), 8);
        childMenu.addFood(TypeFood.DESSERT, "Gelato alla cioccolato", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Cioccolato"))), 8);

        //--------------------------------------------------------------------------------------------------------------

        List<Menu> menuList = new ArrayList<>(Arrays.asList(meatMenu, fishMenu, veganMenu, childMenu));

        Scanner scanner = new Scanner(System.in);
        String exit = "S";

        while(!exit.equals("N")){
            test(menuList);
            System.out.println("Vuoi consultare un altro menù? <S> <N>");
            exit = scanner.nextLine();
        }
    }
}
