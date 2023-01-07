package it.team1Restaurant.dao.testDAO;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.MenuDAO;

import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeFoodEnum;

import java.util.List;

public class TestMenuDAO {

    public static void main(String[] args) {

        MenuDAO menuDAO = new MenuDAO();

        menuDAO.createTable();

        menuDAO.insertMenu(new Menu(null, "Generico", TypeFoodEnum.GENERIC));
        menuDAO.insertMenu(new Menu(null, "Carne", TypeFoodEnum.MEAT));
        menuDAO.insertMenu(new Menu(null, "Pesce", TypeFoodEnum.FISH));
        menuDAO.insertMenu(new Menu(null, "Bambini", TypeFoodEnum.CHILD));
        menuDAO.insertMenu(new Menu(null, "Vegano", TypeFoodEnum.VEGAN));
        menuDAO.insertMenu(new Menu(null, "Celiaco", TypeFoodEnum.CELIAC));

        System.out.println("selectAllMenu\n");
        List<Menu> menuList = menuDAO.selectAllMenu();
        menuList.forEach(System.out::println);

        System.out.println("\nselectMenuById\n");
        Menu menu = menuDAO.selectMenuById(1);
        System.out.println(menu + "\n");

        //child menu

        //drinks
        menuDAO.addDrinkToMenu(4, 1);
        menuDAO.addDrinkToMenu(4, 2);
        menuDAO.addDrinkToMenu(4, 6);
        //firsts
        menuDAO.addDishToMenu(4, 25);
        menuDAO.addDishToMenu(4, 26);
        //seconds
        menuDAO.addDishToMenu(4, 8);
        menuDAO.addDishToMenu(4, 15);
        //desserts
        menuDAO.addDishToMenu(4, 12);
        menuDAO.addDishToMenu(4, 13);

        Menu childMenu = menuDAO.selectMenuById(4);

        if(childMenu != null){

            /*List<Drink> drinkList = menuDAO.selectDrinksByMenu(childMenu);
            List<Dish> dishList = menuDAO.selectDishesByMenu(childMenu);

            drinkList.forEach(System.out::println);
            dishList.forEach(System.out::println);

            System.out.println("\n" + childMenu.getMenuDetails());*/

            menuDAO.selectFoodsByMenu(childMenu);
            System.out.println("\n" + childMenu.getMenuDetails());
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(childMenu));

        } else {
            System.out.println("No menu found");
        }


    }

}
