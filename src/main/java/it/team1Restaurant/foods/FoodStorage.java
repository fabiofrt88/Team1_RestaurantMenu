package it.team1Restaurant.foods;

import java.util.*;

public abstract class FoodStorage {

    private static final List<Dish> dishList;
    private static final List<Drink> drinkList;
    private static final List<Ingredient> ingredientList;

    static{
        dishList = initDishList();
        drinkList = initDrinkList();
        ingredientList = initIngredientList();
    }

    public static List<Dish> getDishList() {
        return dishList;
    }

    public static List<Drink> getDrinkList() {
        return drinkList;
    }

    public static List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    private static List<Dish> initDishList(){
        List<Dish> dishList = new ArrayList<>();

        dishList.add(new Dish(null, "Spaghetti alla carbonara", 12, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Spaghetti all'amatriciana", 12, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Lasagne alla bolognese", 15, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Ziti alla genovese", 16, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Tagliatelle alla bolognese", 15, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Linguine allo scoglio", 17, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Spaghetti alla luciana", 16, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Insalata di riso e melone", 11, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Spaghetti ai carciofi e limone", 14, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Pasta al sugo", 8, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Pasta al pesto", 10, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Spaghetti Cacio e Pepe", 13, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Crema di Zucca", 10, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Pasta funghi porcini e rucola senza glutine", 13.5, TypeCourseEnum.FIRST));
        dishList.add(new Dish(null, "Lasagne ai carciofi senza glutine", 11.5, TypeCourseEnum.FIRST));

        dishList.add(new Dish(null, "Salsicce e Friarielli", 13, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Polpette al ragù con parmigiana di melanzane", 14, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Insalata di polpo e patate", 15, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Fritto misto", 15, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Polpettone di fagioli e tofu alle erbe", 13, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Zucchine ripiene con crema di fagioli bianchi", 14, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Cotoletta e Patatine", 12, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Hamburger e insalata", 13, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Parmigiana di Melanzane", 15, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Polpette di verdure", 15, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Agnello alla lucana senza glutine", 18.5, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Arista al limone", 20, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Gulasch ungherese", 13, TypeCourseEnum.SECOND));
        dishList.add(new Dish(null, "Filetto di salmone con crema al mascarpone", 15, TypeCourseEnum.SECOND));

        dishList.add(new Dish(null, "Tiramisù", 11, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Babà", 9, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Tiramisù vegano", 12, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Ciambellone vegano", 15, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Gelato alla fragola", 8, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Gelato al cioccolato", 8, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Tiramisù vegetariano", 10, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Torta Tenerina", 9, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Torta caprese", 9, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Migliaccio napoletano", 9, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Cassata siciliana", 15, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Cannolo siciliano", 10, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "New York Cheesecake", 14, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Cheesecake di zucca gialla", 14, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Semifreddo al caffè", 9, TypeCourseEnum.DESSERT));
        dishList.add(new Dish(null, "Parfait alle mandorle", 15, TypeCourseEnum.DESSERT));

        Collections.sort(dishList, (ds1, ds2) -> ds1.getName().compareToIgnoreCase(ds2.getName()));

        return dishList;
    }

    private static List<Drink> initDrinkList(){
        List<Drink> drinkList = new ArrayList<>();

        drinkList.add(new Drink(null, "Acqua", 2, TypeDrinkEnum.SOFT_DRINK));
        drinkList.add(new Drink(null, "Vino Rosso", 15, TypeDrinkEnum.WINE));
        drinkList.add(new Drink(null, "Vino Bianco", 16, TypeDrinkEnum.WINE));
        drinkList.add(new Drink(null, "Spumante", 16, TypeDrinkEnum.WINE));
        drinkList.add(new Drink(null, "Champagne", 16, TypeDrinkEnum.WINE));
        drinkList.add(new Drink(null, "Lambrusco", 18, TypeDrinkEnum.WINE));
        drinkList.add(new Drink(null, "Prosecco", 16, TypeDrinkEnum.WINE));
        drinkList.add(new Drink(null, "Birra", 6, TypeDrinkEnum.BEER));
        drinkList.add(new Drink(null, "Birra senza glutine",7, TypeDrinkEnum.BEER));
        drinkList.add(new Drink(null, "Coca Cola", 3,TypeDrinkEnum.SOFT_DRINK));
        drinkList.add(new Drink(null, "Aranciata", 3, TypeDrinkEnum.SOFT_DRINK));
        drinkList.add(new Drink(null, "Succo alla pera", 2, TypeDrinkEnum.FRUIT_JUICE));
        drinkList.add(new Drink(null, "Succo all'ananas", 2,TypeDrinkEnum.FRUIT_JUICE));
        drinkList.add(new Drink(null, "Cocco drink",6.5, TypeDrinkEnum.COCKTAIL));
        drinkList.add(new Drink(null, "Gin Tonic",12, TypeDrinkEnum.COCKTAIL));
        drinkList.add(new Drink(null, "Martini",12, TypeDrinkEnum.COCKTAIL));
        drinkList.add(new Drink(null, "Margarita",12, TypeDrinkEnum.COCKTAIL));
        drinkList.add(new Drink(null, "Mojito",12, TypeDrinkEnum.COCKTAIL));
        drinkList.add(new Drink(null, "Negroni",12, TypeDrinkEnum.COCKTAIL));
        drinkList.add(new Drink(null, "Spritz",12, TypeDrinkEnum.COCKTAIL));

        Collections.sort(drinkList, (dr1, dr2) -> dr1.getName().compareToIgnoreCase(dr2.getName()));

        return drinkList;
    }

    private static List<Ingredient> initIngredientList(){
        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(new Ingredient("Acqua"));
        ingredientList.add(new Ingredient("Concentrato di pomodoro"));
        ingredientList.add(new Ingredient("Pomodoro"));
        ingredientList.add(new Ingredient("Cipolle"));
        ingredientList.add(new Ingredient("Girello di manzo"));
        ingredientList.add(new Ingredient("Carne macinata"));
        ingredientList.add(new Ingredient("Pancetta"));
        ingredientList.add(new Ingredient("Prosciutto cotto"));
        ingredientList.add(new Ingredient("Prosciutto crudo"));
        ingredientList.add(new Ingredient("Salame"));
        ingredientList.add(new Ingredient("Mortadella"));
        ingredientList.add(new Ingredient("Mozzarella"));
        ingredientList.add(new Ingredient("Mozzarella di bufala"));
        ingredientList.add(new Ingredient("Vongole"));
        ingredientList.add(new Ingredient("Cozze"));
        ingredientList.add(new Ingredient("Scampi"));
        ingredientList.add(new Ingredient("Moscardini"));
        ingredientList.add(new Ingredient("Olive nere"));
        ingredientList.add(new Ingredient("Peperoncino"));
        ingredientList.add(new Ingredient("Riso"));
        ingredientList.add(new Ingredient("Melone"));
        ingredientList.add(new Ingredient("Carciofi"));
        ingredientList.add(new Ingredient("Limone"));
        ingredientList.add(new Ingredient("Passata di pomodoro"));
        ingredientList.add(new Ingredient("Basilico"));
        ingredientList.add(new Ingredient("Parmigiano Reggiano DOP"));
        ingredientList.add(new Ingredient("Grana padano"));
        ingredientList.add(new Ingredient("Pecorino romano"));
        ingredientList.add(new Ingredient("Pepe nero in grani"));
        ingredientList.add(new Ingredient("Brodo vegetale"));
        ingredientList.add(new Ingredient("Cannella in polvere"));
        ingredientList.add(new Ingredient("Pasta"));
        ingredientList.add(new Ingredient("Pasta fresca"));
        ingredientList.add(new Ingredient("Gnocchetti di patate"));
        ingredientList.add(new Ingredient("Pasta senza glutine"));
        ingredientList.add(new Ingredient("Funghi porcini"));
        ingredientList.add(new Ingredient("Pasta fresca per lasagne senza glutine"));
        ingredientList.add(new Ingredient("Besciamella senza glutine"));
        ingredientList.add(new Ingredient("Panna al salmone"));
        ingredientList.add(new Ingredient("Salsicce"));
        ingredientList.add(new Ingredient("Friarelli"));
        ingredientList.add(new Ingredient("Carne di manzo"));
        ingredientList.add(new Ingredient("Melanzane"));
        ingredientList.add(new Ingredient("Peperoni"));
        ingredientList.add(new Ingredient("Fiordilatte"));
        ingredientList.add(new Ingredient("Polpo"));
        ingredientList.add(new Ingredient("Triglie"));
        ingredientList.add(new Ingredient("Merluzzetti"));
        ingredientList.add(new Ingredient("Gamberetti"));
        ingredientList.add(new Ingredient("Calamari"));
        ingredientList.add(new Ingredient("Salmone affumicato"));
        ingredientList.add(new Ingredient("Tofu"));
        ingredientList.add(new Ingredient("Fagioli"));
        ingredientList.add(new Ingredient("Erbe"));
        ingredientList.add(new Ingredient("Zucchine"));
        ingredientList.add(new Ingredient("Fagioli Bianchi"));
        ingredientList.add(new Ingredient("Pollo"));
        ingredientList.add(new Ingredient("Insalata"));
        ingredientList.add(new Ingredient("Lattuga"));
        ingredientList.add(new Ingredient("Melanzane ovali nere"));
        ingredientList.add(new Ingredient("Pisellini"));
        ingredientList.add(new Ingredient("Pomodorini"));
        ingredientList.add(new Ingredient("Vino Bianco"));
        ingredientList.add(new Ingredient("Vino Rosso"));
        ingredientList.add(new Ingredient("Aceto di mele"));
        ingredientList.add(new Ingredient("Brandy"));
        ingredientList.add(new Ingredient("Cognac"));
        ingredientList.add(new Ingredient("Rum"));
        ingredientList.add(new Ingredient("Caffè"));
        ingredientList.add(new Ingredient("Cacao"));
        ingredientList.add(new Ingredient("Yogurt"));
        ingredientList.add(new Ingredient("Yogurt di soia"));
        ingredientList.add(new Ingredient("Panna"));
        ingredientList.add(new Ingredient("Panna di soia"));
        ingredientList.add(new Ingredient("Farina 0"));
        ingredientList.add(new Ingredient("Farina 00"));
        ingredientList.add(new Ingredient("Farina tipo 1"));
        ingredientList.add(new Ingredient("Farina integrale"));
        ingredientList.add(new Ingredient("Farina senza glutine"));
        ingredientList.add(new Ingredient("Farina di riso"));
        ingredientList.add(new Ingredient("Farina di ceci"));
        ingredientList.add(new Ingredient("Lenticchie"));
        ingredientList.add(new Ingredient("Uova"));
        ingredientList.add(new Ingredient("Zucchero"));
        ingredientList.add(new Ingredient("Zucchero di canna"));
        ingredientList.add(new Ingredient("Burro"));
        ingredientList.add(new Ingredient("Biscotti vegani"));
        ingredientList.add(new Ingredient("Latte"));
        ingredientList.add(new Ingredient("Latte vegetale"));
        ingredientList.add(new Ingredient("Fragole"));
        ingredientList.add(new Ingredient("Cioccolato"));
        ingredientList.add(new Ingredient("Cioccolato fondente"));
        ingredientList.add(new Ingredient("Cioccolato bianco"));
        ingredientList.add(new Ingredient("Mascarpone"));
        ingredientList.add(new Ingredient("Savoiardi"));
        ingredientList.add(new Ingredient("Mandorle"));
        ingredientList.add(new Ingredient("Nocciole"));
        ingredientList.add(new Ingredient("Semolino"));
        ingredientList.add(new Ingredient("Sfogliatelle"));
        ingredientList.add(new Ingredient("Crema pasticcera"));
        ingredientList.add(new Ingredient("Crema allo zabaione"));
        ingredientList.add(new Ingredient("Tartufo"));
        ingredientList.add(new Ingredient("Origano"));
        ingredientList.add(new Ingredient("Spezie"));
        ingredientList.add(new Ingredient("Olio extravergine di oliva"));
        ingredientList.add(new Ingredient("Aceto balsamico"));
        ingredientList.add(new Ingredient("Ketchup"));
        ingredientList.add(new Ingredient("Salsa rosa"));
        ingredientList.add(new Ingredient("Arancia"));
        ingredientList.add(new Ingredient("Mele"));
        ingredientList.add(new Ingredient("Pere"));
        ingredientList.add(new Ingredient("Ananas"));
        ingredientList.add(new Ingredient("Anguria"));
        ingredientList.add(new Ingredient("Pesca"));
        ingredientList.add(new Ingredient("Avocado"));
        ingredientList.add(new Ingredient("Asparagi"));
        ingredientList.add(new Ingredient("Broccoletti"));
        ingredientList.add(new Ingredient("Spinaci"));
        ingredientList.add(new Ingredient("Pinoli"));
        ingredientList.add(new Ingredient("Vaniglia"));
        ingredientList.add(new Ingredient("Fecola di patate"));
        ingredientList.add(new Ingredient("Fontina"));
        ingredientList.add(new Ingredient("Gorgonzola"));
        ingredientList.add(new Ingredient("Ghiaccio"));
        ingredientList.add(new Ingredient("Soda"));
        ingredientList.add(new Ingredient("Ricotta"));
        ingredientList.add(new Ingredient("Canditi"));
        ingredientList.add(new Ingredient("Pan di spagna"));
        ingredientList.add(new Ingredient("Patate"));
        ingredientList.add(new Ingredient("Patatine fritte"));

        Collections.sort(ingredientList, (ing1, ing2) -> ing1.getName().compareToIgnoreCase(ing2.getName()));

        return ingredientList;
    }

}
