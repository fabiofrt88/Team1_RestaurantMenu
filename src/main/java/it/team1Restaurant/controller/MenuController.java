package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.service.MenuService;
import spark.Request;
import spark.Response;

import java.util.List;

public class MenuController {

    private static MenuService menuService = ServiceDAOFactory.getMenuService();

    public static String getAllMenu(Request request, Response response){
        List<Menu> menuList = menuService.selectAllMenu();
        return new GsonBuilder().setPrettyPrinting().create().toJson(menuList);
    }

    public static String getMenuById(Request request, Response response) throws NumberFormatException {
        Integer id = Integer.parseInt(request.params(":id"));
        Menu menu = menuService.selectMenuById(id);
        menuService.selectFoodsByMenu(menu);
        return new GsonBuilder().setPrettyPrinting().create().toJson(menu);
    }

}
