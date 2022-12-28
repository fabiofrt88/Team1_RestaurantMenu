package it.team1Restaurant.menu;
import it.team1Restaurant.bookings.calendar.Booking;

import it.team1Restaurant.foods.*;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static it.team1Restaurant.bookings.calendar.Booking.checkBookingInfo;
import static it.team1Restaurant.foods.Food.dishFilter;
import static it.team1Restaurant.menu.TypeClientMenuEnum.*;

/**
 * Questa classe viene utilizzata per testare la creazione della mappa di storage con le liste delle portate
 * e la creazione dei relativi menu differenziati per tipologia mediante delle associazioni has-a di aggregazione
 * tra le classi {@link it.team1Restaurant.foods.Food} e {@link it.team1Restaurant.menu.Menu},
 * a partire dalla classe di storage {@link it.team1Restaurant.foods.FoodStorage}, test dei relativi metodi
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
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

    /**
     * Metodo main, rappresenta l'entrypoint di esecuzione della classe {@link it.team1Restaurant.menu.TestMenu}
     * @param args Array di argomenti che possono essere digitati nel programma da terminale
     * @throws Exception
     */
    public static void main(String[] args) {

        FoodStorage foodStorage = FoodStorage.getInstance();

        //create the drinks

        foodStorage.addDrink("Acqua", 2,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN, TypeClientMenuEnum.CELIAC, TypeClientMenuEnum.CHILD));
        foodStorage.addDrink("Vino Rosso", 15,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDrink("Vino Bianco", 16,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDrink("Birra", 6,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDrink("Coca Cola", 3,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD, TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDrink("Fanta", 3, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD, TypeClientMenuEnum.VEGAN, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDrink("Birra Lager senza glutine",7,EnumSet.of(TypeClientMenuEnum.CELIAC));
        foodStorage.addDrink("Cocco drink",6.5,EnumSet.of(TypeClientMenuEnum.CELIAC));

        //create the firsts

        foodStorage.addDish(TypeCourseEnum.FIRST, "Ziti alla genovese", new ArrayList<>(Arrays.asList(
                new Ingredient("Cipolle"), new Ingredient("Girello di manzo"))), 16,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Tagliatelle alla bolognese", new ArrayList<>(Arrays.asList(
                new Ingredient("Carne macinata"), new Ingredient("Concentrato di pomodoro"), new Ingredient("Pancetta"))), 15,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Linguine allo scoglio", new ArrayList<>(Arrays.asList(
                new Ingredient("Vongole"), new Ingredient("Cozze"), new Ingredient("Scampi"))), 17,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Spaghetti alla luciana", new ArrayList<>(Arrays.asList(new Ingredient("Moscardini"),
                new Ingredient("Pomodoro"), new Ingredient("Olive Nere"), new Ingredient("Peperoncino"))), 16,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Insalata di riso e melone", new ArrayList<>(Arrays.asList(
                new Ingredient("Riso"), new Ingredient("melone"))), 11,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(
                new Ingredient("Carciofi"), new Ingredient("Limone"))), 14,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Pasta al sugo", new ArrayList<>(Arrays.asList(
                new Ingredient("Passato di pomodoro"))), 8, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Pasta al pesto", new ArrayList<>(Arrays.asList(
                new Ingredient("Basilico"), new Ingredient("Parmigiano"))), 10, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Spaghetti Cacio e Pepe", new ArrayList<>(Arrays.asList(
                new Ingredient("Pecorino Romano"),new Ingredient("Pepe Nero in Grani"))), 13,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Crema di Zucca", new ArrayList<>(Arrays.asList(
                new Ingredient("Brodo Vegetale"),new Ingredient("Cannella in Polvere"))), 10,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Pasta funghi porcini e rucola senza glutine", new ArrayList<>(Arrays.asList(
                new Ingredient("Pasta Senza Glutine"),new Ingredient("Funghi Porcini"))), 13.5,EnumSet.of(TypeClientMenuEnum.CELIAC));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Lasagne ai carciofi senza glutine", new ArrayList<>(Arrays.asList(
                new Ingredient("Pasta fresca per lasagne senza glutine"),new Ingredient("Besciamella senza glutine"))), 11.5,EnumSet.of(TypeClientMenuEnum.CELIAC));

        //create the seconds

        foodStorage.addDish(TypeCourseEnum.SECOND, "Salsicce e Friarielli",
                new ArrayList<>(Arrays.asList(new Ingredient("Salsicce"), new Ingredient("Friarielli"))), 13,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Polpette al ragù con parmigiana di melanzane",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Passato di pomodoro"),
                        new Ingredient("Melanzane"), new Ingredient("Fiordilatte"))), 14,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Insalata di polpo e patate",
                new ArrayList<>(Arrays.asList(new Ingredient("Polpo"), new Ingredient("Patate"), new Ingredient("Limone"))), 15,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Fritto misto",
                new ArrayList<>(Arrays.asList(new Ingredient("Triglie"), new Ingredient("Merluzzetti"), new Ingredient("Gamberetti"), new Ingredient("Calamari"))), 15,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Polpettone di fagioli e tofu alle erbe",
                new ArrayList<>(Arrays.asList(new Ingredient("Tofu"), new Ingredient("Fagioli"), new Ingredient("Erbe"))), 13,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(new Ingredient("Zucchine"), new Ingredient("Fagioli Bianchi"))), 14,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Cotoletta e Patatine",
                new ArrayList<>(Arrays.asList(new Ingredient("Pollo"), new Ingredient("Patate"))), 12, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Hamburger e insalata",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Insalata"))),13, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Parmigiana di Melanzane",
                new ArrayList<>(Arrays.asList(new Ingredient("Melanzane ovali nere"), new Ingredient("Parmigiano Reggiano DOP"))),15, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Polpette di verdure",
                new ArrayList<>(Arrays.asList(new Ingredient("Patate"), new Ingredient("Pisellini"))),15, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Agnello alla lucana senza glutine",
                new ArrayList<>(Arrays.asList(new Ingredient("Patate"), new Ingredient("Pomodorini"))),18.5, EnumSet.of(TypeClientMenuEnum.CELIAC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Arista al limone",
                new ArrayList<>(Arrays.asList(new Ingredient("Limoni"), new Ingredient("Vino bianco"))),20, EnumSet.of(TypeClientMenuEnum.CELIAC));

        //create the desserts

        foodStorage.addDish(TypeCourseEnum.DESSERT, "Tiramisu'", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt"),
                new Ingredient("Panna"))), 11,EnumSet.of(TypeClientMenuEnum.GENERIC) );
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Babà", new ArrayList<>(Arrays.asList(new Ingredient("Farina"),
                new Ingredient("Uova"), new Ingredient("Zucchero"), new Ingredient("Lievito"),
                new Ingredient("Burro"), new Ingredient("Rum"))), 9,EnumSet.of(TypeClientMenuEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti Vegani"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt di soia"),
                new Ingredient("Panna di soia"))), 12,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Ciambellone vegano", new ArrayList<>(Arrays.asList(new Ingredient("Latte Vegetale"),
                new Ingredient("Farina 0"), new Ingredient("Lievito"),
                new Ingredient("Cacao Amaro"), new Ingredient("Zucchero"))), 15,EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Gelato alla fragola", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Fragole"))), 8, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Gelato al cioccolato", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Cioccolato"))), 8, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Tiramisù vegetariano", new ArrayList<>(Arrays.asList(new Ingredient("Mascarpone"),
                new Ingredient("Savoiardi "))), 10, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Torta Tenerina", new ArrayList<>(Arrays.asList(new Ingredient("Cioccolato fondente"),
                new Ingredient("Farina 00  "))), 9, EnumSet.of(TypeClientMenuEnum.GENERIC, TypeClientMenuEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Torta caprese", new ArrayList<>(Arrays.asList(new Ingredient("Mandorle"),
                new Ingredient("Farina di riso  "))), 9, EnumSet.of(TypeClientMenuEnum.CELIAC));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Migliaccio napoletano", new ArrayList<>(Arrays.asList(new Ingredient("Semolino"),
                new Ingredient("Sfogliatelle "))), 9, EnumSet.of(TypeClientMenuEnum.CELIAC));


        //create the meat menu

        Menu meatMenu = new Menu("Carne", MEAT);

        //add drinks to meat menu

        meatMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(0));
        meatMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(1));
        meatMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(3));

        //add firsts to meat menu

        meatMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(0));
        meatMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(1));

        //add seconds to meat menu

        meatMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(0));
        meatMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(1));

        //add desserts to meat menu

        meatMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(0));
        meatMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(1));

        //create the fish menu

        Menu fishMenu = new Menu("Pesce", FISH);

        //add drinks to fish menu

        fishMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(0));
        fishMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(2));
        fishMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(3));

        //add firsts to fish menu

        fishMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(2));
        fishMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(3));

        //add seconds to fish menu

        fishMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(2));
        fishMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(3));

        //add desserts to fish menu

        fishMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(0));
        fishMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(1));

        //create the vegan menu

        Menu veganMenu = new Menu("Vegano", VEGAN);

        //add drinks to vegan menu

        veganMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(0));
        veganMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(1));
        veganMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(3));

        //add firsts to vegan menu

        veganMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(4));
        veganMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(5));

        //add seconds to vegan menu

        veganMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(4));
        veganMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(5));

        //add desserts to vegan menu

        veganMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(2));
        veganMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(3));

        //create the child menu

        Menu childMenu = new Menu("Bambino", CHILD);

        //add drinks to child menu

        childMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(0));
        childMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(4));
        childMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(5));

        //add firsts to child menu

        childMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(6));
        childMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(7));

        //add seconds to child menu

        childMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(6));
        childMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(7));

        //add desserts to child menu

        childMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(4));
        childMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(5));

        //create the vegetarian menu

        Menu vegetarianMenu = new Menu("Vegetariano", VEGETARIAN);

        //add drinks to vegetarian menu

        vegetarianMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(0));
        vegetarianMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(1));
        vegetarianMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(2));

        //add firsts to vegetarian menu

        vegetarianMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(8));
        vegetarianMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(9));

        //add seconds to vegetarian menu

        vegetarianMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(8));
        vegetarianMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(9));

        //add desserts to vegetarian menu

        vegetarianMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(6));
        vegetarianMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(7));

        //--------------------------------------------------------------------------------------------------------------

        // create to menu celiac

        Menu celiacMenu = new Menu("Celiaco", CELIAC);

        // add to drinks to celiacMenu

        celiacMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(0));
        celiacMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(6));
        celiacMenu.addDrink((Drink) foodStorage.getFoodListsMap().get(TypeCourseEnum.DRINK).get(7));

        // add firts to celiacMenu

        celiacMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(10));
        celiacMenu.addDish(TypeCourseEnum.FIRST, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.FIRST).get(11));

        // add seconds to celiacMenu

        celiacMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(10));
        celiacMenu.addDish(TypeCourseEnum.SECOND, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.SECOND).get(11));

        // add desserts to celiacMenu

        celiacMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(8));
        celiacMenu.addDish(TypeCourseEnum.DESSERT, (Dish) foodStorage.getFoodListsMap().get(TypeCourseEnum.DESSERT).get(9));



        EnumMap<TypeClientMenuEnum, Menu> menuMap = new EnumMap<>(TypeClientMenuEnum.class);
        menuMap.put(MEAT, meatMenu);
        menuMap.put(FISH, fishMenu);
        menuMap.put(VEGAN, veganMenu);
        menuMap.put(CHILD, childMenu);
        menuMap.put(CELIAC, celiacMenu);
        menuMap.put(VEGETARIAN, vegetarianMenu);

        /*Scanner scanner = new Scanner(System.in);
        String exit = "S";

        while(!exit.equalsIgnoreCase("N")){
            test(menuMap);
            System.out.println("Vuoi consultare un altro menù? <S> <N>");
            System.out.print("Risposta: ");
            exit = scanner.nextLine();
        }*/

        System.out.println("-----------------TEST CHECKBOOKINGINFO-------------------\n");


        Client client = new Client(EnumSet.of(TypeClientMenuEnum.GENERIC),"Pippo","Franco","pippofranco@gmail.com", "389-5264589");

        Booking booking = new Booking(client,List.of(client), "2022-11-15 21:00:00", LocalDate.of(2022,11,11), LocalTime.of(12,30));
        checkBookingInfo(booking, menuMap);

        System.out.println("----------------------DISH FILTER------------------------\n");

        Dish spaghettiAllaNerano = new Dish(TypeCourseEnum.FIRST, "Spaghetti alla nerano", new ArrayList<>(Arrays.asList(
                new Ingredient("Zucchine"), new Ingredient("Provolone del Monaco"), new Ingredient("Parmigiano"))), 16, EnumSet.of(TypeClientMenuEnum.VEGETARIAN));

        Dish pastaAlSugo = new Dish(TypeCourseEnum.FIRST, "Pasta al sugo", new ArrayList<>(Arrays.asList(
                new Ingredient("Passato di pomodoro"))), 8, EnumSet.of(TypeClientMenuEnum.CHILD));

        Dish ravioliDiVerdure = new Dish(TypeCourseEnum.FIRST, "Ravioli di verdure", new ArrayList<>(Arrays.asList(
                new Ingredient("Verza"), new Ingredient("Carote"))), 11, EnumSet.of(TypeClientMenuEnum.VEGAN));

        Dish risottoAlloZafferano = new Dish(TypeCourseEnum.FIRST, "Risotto allo zafferano", new ArrayList<>(Arrays.asList(
                new Ingredient("Zafferano"), new Ingredient("Grana Padano"))), 16, EnumSet.of(TypeClientMenuEnum.VEGETARIAN));

        Map<String, Food> dishMap = new HashMap<>();
        dishMap.put(spaghettiAllaNerano.getName(), spaghettiAllaNerano);
        dishMap.put(pastaAlSugo.getName(), pastaAlSugo);
        dishMap.put(ravioliDiVerdure.getName(), ravioliDiVerdure);
        dishMap.put(risottoAlloZafferano.getName(), risottoAlloZafferano);

        dishFilter(dishMap, TypeClientMenuEnum.VEGETARIAN);

        System.out.println("\n----------------------DISH FILTER------------------------\n");
        Map<TypeCourseEnum, FoodList> filteredFoodListsMap = foodStorage.dishFilter(TypeClientMenuEnum.CHILD);
        System.out.println(filteredFoodListsMap.toString());

        System.out.println("\n----------------------DISH FILTER------------------------\n");
        filteredFoodListsMap = foodStorage.dishFilter(EnumSet.of(TypeClientMenuEnum.CHILD, TypeClientMenuEnum.VEGAN));
        System.out.println(filteredFoodListsMap.toString());

    }
}
