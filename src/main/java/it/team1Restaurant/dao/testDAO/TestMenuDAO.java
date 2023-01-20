package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.MenuDAO;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeFoodEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMenuDAO {

    public static void main(String[] args) {

        MenuDAO menuDAO = new MenuDAO();

        menuDAO.createTableMenu();

        menuDAO.insertMenu(new Menu(null, "Generico", TypeFoodEnum.GENERIC));
        menuDAO.insertMenu(new Menu(null, "Bambini", TypeFoodEnum.CHILD));
        menuDAO.insertMenu(new Menu(null, "Carne", TypeFoodEnum.MEAT));
        menuDAO.insertMenu(new Menu(null, "Pesce", TypeFoodEnum.FISH));
        menuDAO.insertMenu(new Menu(null, "Vegano", TypeFoodEnum.VEGAN));
        menuDAO.insertMenu(new Menu(null, "Vegetariano", TypeFoodEnum.VEGETARIAN));
        menuDAO.insertMenu(new Menu(null, "Celiaco", TypeFoodEnum.CELIAC));

        System.out.println("selectAllMenu\n");
        List<Menu> menuList = menuDAO.selectAllMenu();
        menuList.forEach(System.out::println);

        System.out.println("\nselectMenuById\n");
        Menu menuSelected = menuDAO.selectMenuById(1);
        System.out.println(menuSelected + "\n");

        //child menu

        //drinks
        menuDAO.addDrinkToMenu(2, 1);
        menuDAO.addDrinkToMenu(2, 2);
        menuDAO.addDrinkToMenu(2, 6);
        //firsts
        menuDAO.addDishToMenu(2, 25);
        menuDAO.addDishToMenu(2, 26);
        //seconds
        menuDAO.addDishToMenu(2, 8);
        menuDAO.addDishToMenu(2, 15);
        //desserts
        menuDAO.addDishToMenu(2, 12);
        menuDAO.addDishToMenu(2, 13);

        //meat menu

        //drinks
        menuDAO.addDrinkToMenu(3, 1);
        menuDAO.addDrinkToMenu(3, 3);
        menuDAO.addDrinkToMenu(3, 20);
        //firsts
        menuDAO.addDishToMenu(3, 38);
        menuDAO.addDishToMenu(3, 44);
        //seconds
        menuDAO.addDishToMenu(3, 28);
        menuDAO.addDishToMenu(3, 31);
        //desserts
        menuDAO.addDishToMenu(3, 39);
        menuDAO.addDishToMenu(3, 3);

        //fish menu

        //drinks
        menuDAO.addDrinkToMenu(4, 1);
        menuDAO.addDrinkToMenu(4, 3);
        menuDAO.addDrinkToMenu(4, 19);
        //firsts
        menuDAO.addDishToMenu(4, 20);
        menuDAO.addDishToMenu(4, 36);
        //seconds
        menuDAO.addDishToMenu(4, 11);
        menuDAO.addDishToMenu(4, 16);
        //desserts
        menuDAO.addDishToMenu(4, 5);
        menuDAO.addDishToMenu(4, 32);

        //vegan menu

        //drinks
        menuDAO.addDrinkToMenu(5, 1);
        menuDAO.addDrinkToMenu(5, 4);
        menuDAO.addDrinkToMenu(5, 20);
        //firsts
        menuDAO.addDishToMenu(5, 17);
        menuDAO.addDishToMenu(5, 33);
        //seconds
        menuDAO.addDishToMenu(5, 30);
        menuDAO.addDishToMenu(5, 45);
        //desserts
        menuDAO.addDishToMenu(5, 7);
        menuDAO.addDishToMenu(5, 40);

        //vegetarian menu

        //drinks
        menuDAO.addDrinkToMenu(6, 1);
        menuDAO.addDrinkToMenu(6, 14);
        menuDAO.addDrinkToMenu(6, 17);
        //firsts
        menuDAO.addDishToMenu(6, 9);
        menuDAO.addDishToMenu(6, 18);
        //seconds
        menuDAO.addDishToMenu(6, 24);
        menuDAO.addDishToMenu(6, 29);
        //desserts
        menuDAO.addDishToMenu(6, 13);
        menuDAO.addDishToMenu(6, 41);

        //celiac menu

        //drinks
        menuDAO.addDrinkToMenu(7, 1);
        menuDAO.addDrinkToMenu(7, 4);
        menuDAO.addDrinkToMenu(7, 14);
        //firsts
        menuDAO.addDishToMenu(7, 18);
        menuDAO.addDishToMenu(7, 27);
        //seconds
        menuDAO.addDishToMenu(7, 1);
        menuDAO.addDishToMenu(7, 2);
        //desserts
        menuDAO.addDishToMenu(7, 42);
        menuDAO.addDishToMenu(7, 21);

        Menu childMenu = menuDAO.selectMenuById(2);
        Menu meatMenu = menuDAO.selectMenuById(3);
        Menu fishMenu = menuDAO.selectMenuById(4);
        Menu veganMenu = menuDAO.selectMenuById(5);
        Menu vegetarianMenu = menuDAO.selectMenuById(6);
        Menu celiacMenu = menuDAO.selectMenuById(7);

        menuList = new ArrayList<>(Arrays.asList(childMenu, meatMenu, fishMenu, veganMenu, vegetarianMenu, celiacMenu));

        for(Menu menu : menuList){
            try{
                menuDAO.selectFoodsByMenu(menu);
            }catch (NullPointerException e){
                System.out.println("No menu's data found");
            }
        }

        for(Menu menu : menuList){
            try{
                System.out.println(menu.getMenuDetails() + "\n");
            }catch (NullPointerException e){
                System.out.println("No menu's data found");
            }
        }

    }

}
