package it.team1Restaurant.service;


import it.team1Restaurant.dao.MenuDAO;
import it.team1Restaurant.dao.interfaces.IMenuDAO;
import it.team1Restaurant.menu.Menu;


import java.util.List;

public class MenuService {

    private IMenuDAO menuDAO;

    public MenuService(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public void createTableMenu(){
        menuDAO.createTableMenu();
    }

    public void insertMenu(Menu menu){
        menuDAO.insertMenu(menu);
    }

    public List<Menu> selectAllMenu(){
        return menuDAO.selectAllMenu();
    }

    public Menu selectMenuById(Integer id) {
        return menuDAO.selectMenuById(id);
    }




}
