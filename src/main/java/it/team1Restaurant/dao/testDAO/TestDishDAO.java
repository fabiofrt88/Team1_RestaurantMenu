package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.DishDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;

public class TestDishDAO {

    public static void main(String[] args) {

        DishDAO dishDAO = new DishDAO();

        dishDAO.createTable();

        dishDAO.insertDish(new Dish("Pasta al sugo", 8, TypeCourseEnum.FIRST.getId()));
        dishDAO.insertDish(new Dish("Pasta al pesto", 10, TypeCourseEnum.FIRST.getId()));
        dishDAO.insertDish(new Dish("Salsicce e Friarielli", 13, TypeCourseEnum.SECOND.getId()));
        dishDAO.insertDish(new Dish("Parmigiana di Melanzane", 15, TypeCourseEnum.SECOND.getId()));
        dishDAO.insertDish(new Dish("Tiramisu", 11, TypeCourseEnum.DESSERT.getId()));
        dishDAO.insertDish(new Dish("Gelato al cioccolato", 8, TypeCourseEnum.DESSERT.getId()));

    }

}
