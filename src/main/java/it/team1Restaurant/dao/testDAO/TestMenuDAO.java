package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeFoodEnum;
import it.team1Restaurant.service.MenuService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMenuDAO {

    public static void main(String[] args) throws SQLException {

        try {

            MenuService menuService = ServiceDAOFactory.getMenuService();

            menuService.createTable();

            menuService.insertMenu(new Menu(null, "Generico", TypeFoodEnum.GENERIC));
            menuService.insertMenu(new Menu(null, "Bambini", TypeFoodEnum.CHILD));
            menuService.insertMenu(new Menu(null, "Carne", TypeFoodEnum.MEAT));
            menuService.insertMenu(new Menu(null, "Pesce", TypeFoodEnum.FISH));
            menuService.insertMenu(new Menu(null, "Vegano", TypeFoodEnum.VEGAN));
            menuService.insertMenu(new Menu(null, "Vegetariano", TypeFoodEnum.VEGETARIAN));
            menuService.insertMenu(new Menu(null, "Celiaco", TypeFoodEnum.CELIAC));

            System.out.println("selectAllMenu\n");
            List<Menu> menuList = menuService.selectAllMenu();
            menuList.forEach(System.out::println);

            System.out.println("\nselectMenuById\n");
            Menu menuSelected = menuService.selectMenuById(1);
            System.out.println(menuSelected + "\n");

            //child menu

            //drinks
            menuService.addDrinkToMenu(2, 1);
            menuService.addDrinkToMenu(2, 2);
            menuService.addDrinkToMenu(2, 6);
            //firsts
            menuService.addDishToMenu(2, 25);
            menuService.addDishToMenu(2, 26);
            //seconds
            menuService.addDishToMenu(2, 8);
            menuService.addDishToMenu(2, 15);
            //desserts
            menuService.addDishToMenu(2, 12);
            menuService.addDishToMenu(2, 13);

            //meat menu

            //drinks
            menuService.addDrinkToMenu(3, 1);
            menuService.addDrinkToMenu(3, 3);
            menuService.addDrinkToMenu(3, 20);
            //firsts
            menuService.addDishToMenu(3, 38);
            menuService.addDishToMenu(3, 44);
            //seconds
            menuService.addDishToMenu(3, 28);
            menuService.addDishToMenu(3, 31);
            //desserts
            menuService.addDishToMenu(3, 39);
            menuService.addDishToMenu(3, 3);

            //fish menu

            //drinks
            menuService.addDrinkToMenu(4, 1);
            menuService.addDrinkToMenu(4, 3);
            menuService.addDrinkToMenu(4, 19);
            //firsts
            menuService.addDishToMenu(4, 20);
            menuService.addDishToMenu(4, 36);
            //seconds
            menuService.addDishToMenu(4, 11);
            menuService.addDishToMenu(4, 16);
            //desserts
            menuService.addDishToMenu(4, 5);
            menuService.addDishToMenu(4, 32);

            //vegan menu

            //drinks
            menuService.addDrinkToMenu(5, 1);
            menuService.addDrinkToMenu(5, 4);
            menuService.addDrinkToMenu(5, 20);
            //firsts
            menuService.addDishToMenu(5, 17);
            menuService.addDishToMenu(5, 33);
            //seconds
            menuService.addDishToMenu(5, 30);
            menuService.addDishToMenu(5, 45);
            //desserts
            menuService.addDishToMenu(5, 7);
            menuService.addDishToMenu(5, 40);

            //vegetarian menu

            //drinks
            menuService.addDrinkToMenu(6, 1);
            menuService.addDrinkToMenu(6, 14);
            menuService.addDrinkToMenu(6, 17);
            //firsts
            menuService.addDishToMenu(6, 9);
            menuService.addDishToMenu(6, 18);
            //seconds
            menuService.addDishToMenu(6, 24);
            menuService.addDishToMenu(6, 29);
            //desserts
            menuService.addDishToMenu(6, 13);
            menuService.addDishToMenu(6, 41);

            //celiac menu

            //drinks
            menuService.addDrinkToMenu(7, 1);
            menuService.addDrinkToMenu(7, 4);
            menuService.addDrinkToMenu(7, 14);
            //firsts
            menuService.addDishToMenu(7, 18);
            menuService.addDishToMenu(7, 27);
            //seconds
            menuService.addDishToMenu(7, 1);
            menuService.addDishToMenu(7, 2);
            //desserts
            menuService.addDishToMenu(7, 42);
            menuService.addDishToMenu(7, 21);

            Menu childMenu = menuService.selectMenuById(2);
            Menu meatMenu = menuService.selectMenuById(3);
            Menu fishMenu = menuService.selectMenuById(4);
            Menu veganMenu = menuService.selectMenuById(5);
            Menu vegetarianMenu = menuService.selectMenuById(6);
            Menu celiacMenu = menuService.selectMenuById(7);

            menuList = new ArrayList<>(Arrays.asList(childMenu, meatMenu, fishMenu, veganMenu, vegetarianMenu, celiacMenu));

            for(Menu menu : menuList){
                menuService.selectFoodsByMenu(menu);
            }

            for(Menu menu : menuList){
                System.out.println(menu.getMenuDetails() + "\n");
            }

        } catch (DataAccessException | ClassCastException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

}
