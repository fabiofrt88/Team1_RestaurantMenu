package it.team1Restaurant.dao.testDAO;

import com.google.gson.annotations.SerializedName;
import it.team1Restaurant.dao.TypeClientMenuDAO;
import it.team1Restaurant.menu.TypeClientMenuEnum;

public class TestTypeClientMenuDAO {

    public static void main(String[] args) {

        TypeClientMenuDAO typeClientMenuDAO = new TypeClientMenuDAO();

        typeClientMenuDAO.createTable();

        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.GENERIC);
        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.CHILD);
        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.MEAT);
        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.FISH);
        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.VEGAN);
        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.VEGETARIAN);
        typeClientMenuDAO.insertTypeClientMenu(TypeClientMenuEnum.CELIAC);

    }

}
