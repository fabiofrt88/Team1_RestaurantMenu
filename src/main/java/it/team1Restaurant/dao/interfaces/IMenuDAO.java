package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.menu.Menu;

import java.util.List;

public interface IMenuDAO {

    void createTableMenu();
    void insertMenu(Menu menu);
    List<Menu> selectAllMenu();
    Menu selectMenuById(Integer id);


}
