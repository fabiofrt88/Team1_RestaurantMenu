package it.team1Restaurant.menu;
import it.team1Restaurant.bookings.calendar.Booking;

import it.team1Restaurant.foods.*;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static it.team1Restaurant.bookings.calendar.Booking.checkBookingInfo;
import static it.team1Restaurant.foods.Food.dishFilter;
import static it.team1Restaurant.menu.TypeMenu.*;

public class TestMenu {

    /*public static void test(EnumMap<TypeMenu, Menu> menuMap){
        Scanner input = new Scanner(System.in);
        System.out.println("Quale menù vuoi consultare? <1> MENU DI CARNE | <2> MENU DI PESCE | <3> MENU VEGANO | <4> MENU BAMBINI");
        System.out.print("Risposta: ");
        String firstStep = input.nextLine();
        switch (firstStep) {
            case "1":
                System.out.println(menuMap.get(MEAT).getMenuDetails());
                break;
            case "2":
                System.out.println(menuMap.get(FISH).getMenuDetails());
                break;
            case "3":
                System.out.println(menuMap.get(VEGAN).getMenuDetails());
                break;
            case "4":
                System.out.println(menuMap.get(CHILD).getMenuDetails());
                break;
        }*/

    public static void main(String[] args) {

        FoodStorage foodStorage = FoodStorage.getInstance();

        //create the drinks

        foodStorage.addDrink("Acqua", 2);
        foodStorage.addDrink("Vino Rosso", 15);
        foodStorage.addDrink("Vino Bianco", 16);
        foodStorage.addDrink("Birra", 6);
        foodStorage.addDrink("Coca Cola", 3, EnumSet.of(TypeDish.CHILD));
        foodStorage.addDrink("Fanta", 3, EnumSet.of(TypeDish.CHILD));

        //create the firsts

        foodStorage.addDish(TypeFood.FIRST, "Ziti alla genovese", new ArrayList<>(Arrays.asList(
                new Ingredient("Cipolle"), new Ingredient("Girello di manzo"))), 16);
        foodStorage.addDish(TypeFood.FIRST, "Tagliatelle alla bolognese", new ArrayList<>(Arrays.asList(
                new Ingredient("Carne macinata"), new Ingredient("Concentrato di pomodoro"), new Ingredient("Pancetta"))), 15);
        foodStorage.addDish(TypeFood.FIRST, "Linguine allo scoglio", new ArrayList<>(Arrays.asList(
                new Ingredient("Vongole"), new Ingredient("Cozze"), new Ingredient("Scampi"))), 17);
        foodStorage.addDish(TypeFood.FIRST, "Spaghetti alla luciana", new ArrayList<>(Arrays.asList(new Ingredient("Moscardini"),
                new Ingredient("Pomodoro"), new Ingredient("Olive Nere"), new Ingredient("Peperoncino"))), 16);
        foodStorage.addDish(TypeFood.FIRST, "Insalata di riso e melone", new ArrayList<>(Arrays.asList(
                new Ingredient("Riso"), new Ingredient("melone"))), 11);
        foodStorage.addDish(TypeFood.FIRST, "Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(
                new Ingredient("Carciofi"), new Ingredient("Limone"))), 14, EnumSet.of(TypeDish.VEGAN));
        foodStorage.addDish(TypeFood.FIRST, "Pasta al sugo", new ArrayList<>(Arrays.asList(
                new Ingredient("Passato di pomodoro"))), 8, EnumSet.of(TypeDish.CHILD, TypeDish.VEGAN));
        foodStorage.addDish(TypeFood.FIRST, "Pasta al pesto", new ArrayList<>(Arrays.asList(
                new Ingredient("Basilico"), new Ingredient("Parmigiano"))), 10, EnumSet.of(TypeDish.CHILD, TypeDish.VEGAN));

        //create the seconds

        foodStorage.addDish(TypeFood.SECOND, "Salsicce e Friarielli",
                new ArrayList<>(Arrays.asList(new Ingredient("Salsicce"), new Ingredient("Friarielli"))), 13);
        foodStorage.addDish(TypeFood.SECOND, "Polpette al ragù con parmigiana di melanzane",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Passato di pomodoro"),
                        new Ingredient("Melanzane"), new Ingredient("Fiordilatte"))), 14);
        foodStorage.addDish(TypeFood.SECOND, "Insalata di polpo e patate",
                new ArrayList<>(Arrays.asList(new Ingredient("Polpo"), new Ingredient("Patate"), new Ingredient("Limone"))), 15);
        foodStorage.addDish(TypeFood.SECOND, "Fritto misto",
                new ArrayList<>(Arrays.asList(new Ingredient("Triglie"), new Ingredient("Merluzzetti"), new Ingredient("Gamberetti"), new Ingredient("Calamari"))), 15);
        foodStorage.addDish(TypeFood.SECOND, "Polpettone di fagioli e tofu alle erbe",
                new ArrayList<>(Arrays.asList(new Ingredient("Tofu"), new Ingredient("Fagioli"), new Ingredient("Erbe"))), 13);
        foodStorage.addDish(TypeFood.SECOND, "Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(new Ingredient("Zucchine"), new Ingredient("Fagioli Bianchi"))), 14);
        foodStorage.addDish(TypeFood.SECOND, "Cotoletta e Patatine",
                new ArrayList<>(Arrays.asList(new Ingredient("Pollo"), new Ingredient("Patate"))), 12, EnumSet.of(TypeDish.CHILD));
        foodStorage.addDish(TypeFood.SECOND, "Hamburger e insalata",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Insalata"))),13, EnumSet.of(TypeDish.CHILD));

        //create the desserts

        foodStorage.addDish(TypeFood.DESSERT, "Tiramisu'", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt"),
                new Ingredient("Panna"))), 11);
        foodStorage.addDish(TypeFood.DESSERT, "Babà", new ArrayList<>(Arrays.asList(new Ingredient("Farina"),
                new Ingredient("Uova"), new Ingredient("Zucchero"), new Ingredient("Lievito"),
                new Ingredient("Burro"), new Ingredient("Rum"))), 9);
        foodStorage.addDish(TypeFood.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti Vegani"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt di soia"),
                new Ingredient("Panna di soia"))), 12);
        foodStorage.addDish(TypeFood.DESSERT, "Ciambellone vegano", new ArrayList<>(Arrays.asList(new Ingredient("Latte Vegetale"),
                new Ingredient("Farina 0"), new Ingredient("Lievito"),
                new Ingredient("Cacao Amaro"), new Ingredient("Zucchero"))), 15);
        foodStorage.addDish(TypeFood.DESSERT, "Gelato alla fragola", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Fragole"))), 8, EnumSet.of(TypeDish.CHILD));
        foodStorage.addDish(TypeFood.DESSERT, "Gelato alla cioccolato", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Cioccolato"))), 8, EnumSet.of(TypeDish.CHILD));

        //create the meat menu

        Menu meatMenu = new Menu("Carne", MEAT);

        //add drinks to meat menu

        meatMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(0));
        meatMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(1));
        meatMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(3));

        //add firsts to meat menu

        meatMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(0));
        meatMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(1));

        //add seconds to meat menu

        meatMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(0));
        meatMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(1));

        //add desserts to meat menu

        meatMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(0));
        meatMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(1));

        //create the fish menu

        Menu fishMenu = new Menu("Pesce", TypeMenu.FISH);

        //add drinks to fish menu

        fishMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(0));
        fishMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(2));
        fishMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(3));

        //add firsts to fish menu

        fishMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(2));
        fishMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(3));

        //add seconds to fish menu

        fishMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(2));
        fishMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(3));

        //add desserts to fish menu

        fishMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(0));
        fishMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(1));

        //create the vegan menu

        Menu veganMenu = new Menu("Vegano", TypeMenu.VEGAN);

        //add drinks to vegan menu

        veganMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(0));
        veganMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(1));
        veganMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(3));

        //add firsts to vegan menu

        veganMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(4));
        veganMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(5));

        //add seconds to vegan menu

        veganMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(4));
        veganMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(5));

        //add desserts to vegan menu

        veganMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(2));
        veganMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(3));

        //create the child menu

        Menu childMenu = new Menu("Bambino", TypeMenu.CHILD);

        //add drinks to child menu

        childMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(0));
        childMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(4));
        childMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeFood.DRINK).get(5));

        //add firsts to child menu

        childMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(6));
        childMenu.addDish(TypeFood.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeFood.FIRST).get(7));

        //add seconds to child menu

        childMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(6));
        childMenu.addDish(TypeFood.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeFood.SECOND).get(7));

        //add desserts to child menu

        childMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(4));
        childMenu.addDish(TypeFood.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeFood.DESSERT).get(5));

        //--------------------------------------------------------------------------------------------------------------

        EnumMap<TypeMenu, Menu> menuMap = new EnumMap<>(TypeMenu.class);
        menuMap.put(MEAT, meatMenu);
        menuMap.put(FISH, fishMenu);
        menuMap.put(VEGAN, veganMenu);
        menuMap.put(CHILD, childMenu);

        /*Scanner scanner = new Scanner(System.in);
        String exit = "S";

        while(!exit.equalsIgnoreCase("N")){
            test(menuMap);
            System.out.println("Vuoi consultare un altro menù? <S> <N>");
            System.out.print("Risposta: ");
            exit = scanner.nextLine();
        }*/

        System.out.println("-----------------TEST CHECKBOOKINGINFO-------------------\n");

        Client client = new Client("Pippo","Franco","pippofranco@gmail.com", "389-5264589", false);
        Booking booking = new Booking(client, "2022-11-15 21:00:00", LocalDate.of(2022,11,11), LocalTime.of(12,30), 3,1,0,1,0);
        checkBookingInfo(booking, menuMap);

        System.out.println("----------------------DISH FILTER------------------------\n");

        Dish spaghettiAllaNerano = new Dish(TypeFood.FIRST, "Spaghetti alla nerano", new ArrayList<>(Arrays.asList(
                new Ingredient("Zucchine"), new Ingredient("Provolone del Monaco"), new Ingredient("Parmigiano"))), 16, EnumSet.of(TypeDish.VEGETARIAN));

        Dish pastaAlSugo = new Dish(TypeFood.FIRST, "Pasta al sugo", new ArrayList<>(Arrays.asList(
                new Ingredient("Passato di pomodoro"))), 8, EnumSet.of(TypeDish.CHILD));

        Dish ravioliDiVerdure = new Dish(TypeFood.FIRST, "Ravioli di verdure", new ArrayList<>(Arrays.asList(
                new Ingredient("Verza"), new Ingredient("Carote"))), 11, EnumSet.of(TypeDish.VEGAN));

        Dish risottoAlloZafferano = new Dish(TypeFood.FIRST, "Risotto allo zafferano", new ArrayList<>(Arrays.asList(
                new Ingredient("Zafferano"), new Ingredient("Grana Padano"))), 16, EnumSet.of(TypeDish.VEGETARIAN));

        Map<String, Food> dishMap = new HashMap<>();
        dishMap.put(spaghettiAllaNerano.getName(), spaghettiAllaNerano);
        dishMap.put(pastaAlSugo.getName(), pastaAlSugo);
        dishMap.put(ravioliDiVerdure.getName(), ravioliDiVerdure);
        dishMap.put(risottoAlloZafferano.getName(), risottoAlloZafferano);

        dishFilter(dishMap, TypeDish.VEGETARIAN);

        System.out.println("----------------------DISH FILTER------------------------\n");
        foodStorage.dishFilter(TypeDish.CHILD);

        System.out.println("----------------------DISH FILTER------------------------\n");
        foodStorage.dishFilter(EnumSet.of(TypeDish.CHILD, TypeDish.VEGAN));



    }
}
