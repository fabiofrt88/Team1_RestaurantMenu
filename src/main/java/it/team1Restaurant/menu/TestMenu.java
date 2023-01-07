package it.team1Restaurant.menu;
import it.team1Restaurant.bookings.Booking;

import it.team1Restaurant.foods.*;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static it.team1Restaurant.bookings.Booking.checkBookingMenu;
import static it.team1Restaurant.foods.Food.dishFilter;
import static it.team1Restaurant.menu.TypeFoodEnum.*;

/**
 * Questa classe viene utilizzata per testare la creazione della mappa di storage con le liste delle portate
 * e la creazione dei relativi menu differenziati per tipologia mediante delle associazioni has-a di aggregazione
 * tra le classi {@link it.team1Restaurant.foods.Food} e {@link it.team1Restaurant.menu.Menu},
 * a partire dalla classe di storage {@link FoodStorageOld}, test dei relativi metodi
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class TestMenu {

    /**
     * Metodo main, rappresenta l'entrypoint di esecuzione della classe {@link it.team1Restaurant.menu.TestMenu}
     * @param args Array di argomenti che possono essere digitati nel programma da terminale
     * @throws Exception
     */
    public static void main(String[] args) {

        FoodStorageOld foodStorage = FoodStorageOld.getInstance();

        //create the drinks

        foodStorage.addDrink("Acqua", 2, TypeDrinkEnum.SOFT_DRINK, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN, TypeFoodEnum.VEGETARIAN, TypeFoodEnum.CELIAC, TypeFoodEnum.CHILD));
        foodStorage.addDrink("Vino Rosso", 15, TypeDrinkEnum.WINE,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDrink("Vino Bianco", 16, TypeDrinkEnum.WINE, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDrink("Birra", 6, TypeDrinkEnum.BEER, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDrink("Coca Cola", 3, TypeDrinkEnum.SOFT_DRINK, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD, TypeFoodEnum.VEGAN, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDrink("Aranciata", 3, TypeDrinkEnum.FRUIT_JUICE, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD, TypeFoodEnum.VEGAN, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDrink("Birra senza glutine",7, TypeDrinkEnum.BEER, EnumSet.of(TypeFoodEnum.CELIAC));
        foodStorage.addDrink("Cocco drink",6.5, TypeDrinkEnum.COCKTAIL, EnumSet.of(TypeFoodEnum.CELIAC));

        //create the firsts

        foodStorage.addDish(TypeCourseEnum.FIRST, "Ziti alla genovese", new ArrayList<>(Arrays.asList(
                new Ingredient("Cipolle"), new Ingredient("Girello di manzo"))), 16,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Tagliatelle alla bolognese", new ArrayList<>(Arrays.asList(
                new Ingredient("Carne macinata"), new Ingredient("Concentrato di pomodoro"), new Ingredient("Pancetta"))), 15,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Linguine allo scoglio", new ArrayList<>(Arrays.asList(
                new Ingredient("Vongole"), new Ingredient("Cozze"), new Ingredient("Scampi"))), 17,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Spaghetti alla luciana", new ArrayList<>(Arrays.asList(new Ingredient("Moscardini"),
                new Ingredient("Pomodoro"), new Ingredient("Olive Nere"), new Ingredient("Peperoncino"))), 16,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Insalata di riso e melone", new ArrayList<>(Arrays.asList(
                new Ingredient("Riso"), new Ingredient("melone"))), 11,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Spaghetti ai carciofi e limone", new ArrayList<>(Arrays.asList(
                new Ingredient("Carciofi"), new Ingredient("Limone"))), 14,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Pasta al sugo", new ArrayList<>(Arrays.asList(
                new Ingredient("Passato di pomodoro"))), 8, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.FIRST, "Pasta al pesto", new ArrayList<>(Arrays.asList(
                new Ingredient("Basilico"), new Ingredient("Parmigiano"))), 10, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Spaghetti Cacio e Pepe", new ArrayList<>(Arrays.asList(
                new Ingredient("Pecorino Romano"),new Ingredient("Pepe Nero in Grani"))), 13,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Crema di Zucca", new ArrayList<>(Arrays.asList(
                new Ingredient("Brodo Vegetale"),new Ingredient("Cannella in Polvere"))), 10,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Pasta funghi porcini e rucola senza glutine", new ArrayList<>(Arrays.asList(
                new Ingredient("Pasta Senza Glutine"),new Ingredient("Funghi Porcini"))), 13.5,EnumSet.of(TypeFoodEnum.CELIAC));
        foodStorage.addDish(TypeCourseEnum.FIRST,"Lasagne ai carciofi senza glutine", new ArrayList<>(Arrays.asList(
                new Ingredient("Pasta fresca per lasagne senza glutine"),new Ingredient("Besciamella senza glutine"))), 11.5,EnumSet.of(TypeFoodEnum.CELIAC));

        //create the seconds

        foodStorage.addDish(TypeCourseEnum.SECOND, "Salsicce e Friarielli",
                new ArrayList<>(Arrays.asList(new Ingredient("Salsicce"), new Ingredient("Friarielli"))), 13,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Polpette al ragù con parmigiana di melanzane",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Passato di pomodoro"),
                        new Ingredient("Melanzane"), new Ingredient("Fiordilatte"))), 14,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Insalata di polpo e patate",
                new ArrayList<>(Arrays.asList(new Ingredient("Polpo"), new Ingredient("Patate"), new Ingredient("Limone"))), 15,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Fritto misto",
                new ArrayList<>(Arrays.asList(new Ingredient("Triglie"), new Ingredient("Merluzzetti"), new Ingredient("Gamberetti"), new Ingredient("Calamari"))), 15,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Polpettone di fagioli e tofu alle erbe",
                new ArrayList<>(Arrays.asList(new Ingredient("Tofu"), new Ingredient("Fagioli"), new Ingredient("Erbe"))), 13,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Zucchine ripiene con crema di fagioli bianchi",
                new ArrayList<>(Arrays.asList(new Ingredient("Zucchine"), new Ingredient("Fagioli Bianchi"))), 14,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Cotoletta e Patatine",
                new ArrayList<>(Arrays.asList(new Ingredient("Pollo"), new Ingredient("Patate"))), 12, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Hamburger e insalata",
                new ArrayList<>(Arrays.asList(new Ingredient("Carne di manzo"), new Ingredient("Insalata"))),13, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Parmigiana di Melanzane",
                new ArrayList<>(Arrays.asList(new Ingredient("Melanzane ovali nere"), new Ingredient("Parmigiano Reggiano DOP"))),15, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Polpette di verdure",
                new ArrayList<>(Arrays.asList(new Ingredient("Patate"), new Ingredient("Pisellini"))),15, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Agnello alla lucana senza glutine",
                new ArrayList<>(Arrays.asList(new Ingredient("Patate"), new Ingredient("Pomodorini"))),18.5, EnumSet.of(TypeFoodEnum.CELIAC));
        foodStorage.addDish(TypeCourseEnum.SECOND, "Arista al limone",
                new ArrayList<>(Arrays.asList(new Ingredient("Limoni"), new Ingredient("Vino bianco"))),20, EnumSet.of(TypeFoodEnum.CELIAC));

        //create the desserts

        foodStorage.addDish(TypeCourseEnum.DESSERT, "Tiramisu'", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt"),
                new Ingredient("Panna"))), 11,EnumSet.of(TypeFoodEnum.GENERIC) );
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Babà", new ArrayList<>(Arrays.asList(new Ingredient("Farina"),
                new Ingredient("Uova"), new Ingredient("Zucchero"), new Ingredient("Lievito"),
                new Ingredient("Burro"), new Ingredient("Rum"))), 9,EnumSet.of(TypeFoodEnum.GENERIC));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Tiramisu' vegano", new ArrayList<>(Arrays.asList(new Ingredient("Biscotti Vegani"),
                new Ingredient("Caffè"), new Ingredient("Cacao"), new Ingredient("Yogurt di soia"),
                new Ingredient("Panna di soia"))), 12,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Ciambellone vegano", new ArrayList<>(Arrays.asList(new Ingredient("Latte Vegetale"),
                new Ingredient("Farina 0"), new Ingredient("Lievito"),
                new Ingredient("Cacao Amaro"), new Ingredient("Zucchero"))), 15,EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Gelato alla fragola", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Fragole"))), 8, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Gelato al cioccolato", new ArrayList<>(Arrays.asList(new Ingredient("Latte"),
                new Ingredient("Cioccolato"))), 8, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.CHILD));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Tiramisù vegetariano", new ArrayList<>(Arrays.asList(new Ingredient("Mascarpone"),
                new Ingredient("Savoiardi "))), 10, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Torta Tenerina", new ArrayList<>(Arrays.asList(new Ingredient("Cioccolato fondente"),
                new Ingredient("Farina 00  "))), 9, EnumSet.of(TypeFoodEnum.GENERIC, TypeFoodEnum.VEGETARIAN));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Torta caprese", new ArrayList<>(Arrays.asList(new Ingredient("Mandorle"),
                new Ingredient("Farina di riso  "))), 9, EnumSet.of(TypeFoodEnum.CELIAC));
        foodStorage.addDish(TypeCourseEnum.DESSERT, "Migliaccio napoletano", new ArrayList<>(Arrays.asList(new Ingredient("Semolino"),
                new Ingredient("Sfogliatelle "))), 9, EnumSet.of(TypeFoodEnum.CELIAC));


        //create the meat menu

        Menu meatMenu = new Menu(1,"Carne", MEAT);

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

        Menu fishMenu = new Menu(2, "Pesce", FISH);

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

        Menu veganMenu = new Menu(3, "Vegano", VEGAN);

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

        Menu childMenu = new Menu(4, "Bambino", CHILD);

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

        Menu vegetarianMenu = new Menu(5, "Vegetariano", VEGETARIAN);

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

        Menu celiacMenu = new Menu(6, "Celiaco", CELIAC);

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

        System.out.println("-----------------TEST CHECKBOOKINGINFO-------------------\n");

        EnumMap<TypeFoodEnum, Menu> menuMap = new EnumMap<>(TypeFoodEnum.class);
        menuMap.put(MEAT, meatMenu);
        menuMap.put(FISH, fishMenu);
        menuMap.put(VEGAN, veganMenu);
        menuMap.put(CHILD, childMenu);
        menuMap.put(CELIAC, celiacMenu);
        menuMap.put(VEGETARIAN, vegetarianMenu);

        Client client = new Client(1,"Pippo","Franco","pippofranco@gmail.com", "389-5264589", EnumSet.of(TypeFoodEnum.GENERIC));
        Booking booking = new Booking(1, client, List.of(client), "2022-11-15 21:00:00", LocalDate.of(2022,11,11), LocalTime.of(12,30));
        checkBookingMenu(booking, menuMap);

        System.out.println("----------------------DISH FILTER------------------------\n");

        Dish spaghettiAllaNerano = new Dish(1, "Spaghetti alla nerano", 10.0, TypeCourseEnum.FIRST, EnumSet.of(TypeFoodEnum.VEGETARIAN),
                new ArrayList<>(Arrays.asList(new Ingredient("Zucchine"), new Ingredient("Provolone del Monaco"), new Ingredient("Parmigiano"))));

        Dish pastaAlSugo = new Dish(2, "Pasta al sugo", 5.0, TypeCourseEnum.FIRST, EnumSet.of(TypeFoodEnum.CHILD),
                new ArrayList<>(Arrays.asList(new Ingredient("Passato di pomodoro"))));

        Dish ravioliDiVerdure = new Dish(3, "Ravioli di verdure", 8.0, TypeCourseEnum.FIRST, EnumSet.of(TypeFoodEnum.VEGAN),
                new ArrayList<>(Arrays.asList(new Ingredient("Verza"), new Ingredient("Carote"))));

        Dish risottoAlloZafferano = new Dish(4, "Risotto allo zafferano", 8.0, TypeCourseEnum.FIRST, EnumSet.of(TypeFoodEnum.VEGETARIAN),
                new ArrayList<>(Arrays.asList(new Ingredient("Zafferano"), new Ingredient("Grana Padano"))));

        Map<String, Food> dishMap = new HashMap<>();
        dishMap.put(spaghettiAllaNerano.getName(), spaghettiAllaNerano);
        dishMap.put(pastaAlSugo.getName(), pastaAlSugo);
        dishMap.put(ravioliDiVerdure.getName(), ravioliDiVerdure);
        dishMap.put(risottoAlloZafferano.getName(), risottoAlloZafferano);

        dishFilter(dishMap, TypeFoodEnum.VEGETARIAN);

        System.out.println("\n----------------------DISH FILTER------------------------\n");
        Map<TypeCourseEnum, FoodList> filteredFoodListsMap = foodStorage.dishFilter(TypeFoodEnum.CHILD);
        System.out.println(filteredFoodListsMap.toString());

        System.out.println("\n----------------------DISH FILTER------------------------\n");
        filteredFoodListsMap = foodStorage.dishFilter(EnumSet.of(TypeFoodEnum.CHILD, TypeFoodEnum.VEGAN));
        System.out.println(filteredFoodListsMap.toString());

        System.out.printf("\nPRINT ALL DISHES (%s)\n\n", FoodStorageSql.getDishList().size());
        FoodStorageSql.getDishList().forEach(dish -> System.out.println(dish.getName()));
        System.out.printf("\nPRINT ALL DRINKS (%s)\n\n", FoodStorageSql.getDrinkList().size());
        FoodStorageSql.getDrinkList().forEach(drink -> System.out.println(drink.getName()));
        System.out.printf("\nPRINT ALL INGREDIENTS (%s)\n\n", FoodStorageSql.getIngredientList().size());
        FoodStorageSql.getIngredientList().forEach(ingredient -> System.out.println(ingredient.getName()));

    }
}
