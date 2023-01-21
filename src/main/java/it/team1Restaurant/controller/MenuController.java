package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.service.MenuService;
import it.team1Restaurant.service.ServiceEnum;
import spark.Request;
import spark.Response;

import java.util.List;

public class MenuController {

    private MenuService menuService = (MenuService) ServiceDAOFactory.getService(ServiceEnum.MENU);

    public String getAllMenu(Request request, Response response){
        List<Menu> menuList = menuService.selectAllMenu();
        return new GsonBuilder().setPrettyPrinting().create().toJson(menuList);
    }

    public String getMenuById(Request request, Response response){
        Integer id = Integer.parseInt(request.params(":id"));
        Menu menu = menuService.selectMenuById(id);
        menuService.selectFoodsByMenu(menu);
        return new GsonBuilder().setPrettyPrinting().create().toJson(menu);
    }

}
