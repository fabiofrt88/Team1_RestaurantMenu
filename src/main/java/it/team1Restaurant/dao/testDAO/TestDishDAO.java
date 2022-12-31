package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.DishDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;

public class TestDishDAO {

    public static void main(String[] args) {

        DishDAO dishDAO = new DishDAO();

        dishDAO.createTable();

        dishDAO.insertDish(new Dish(null, "Pasta al sugo", 8, TypeCourseEnum.FIRST));
        dishDAO.insertDish(new Dish(null, "Pasta al pesto", 10, TypeCourseEnum.FIRST));
        dishDAO.insertDish(new Dish(null, "Salsicce e Friarielli", 13, TypeCourseEnum.SECOND));
        dishDAO.insertDish(new Dish(null, "Parmigiana di Melanzane", 15, TypeCourseEnum.SECOND));
        dishDAO.insertDish(new Dish(null, "Tiramisu", 11, TypeCourseEnum.DESSERT));
        dishDAO.insertDish(new Dish(null, "Gelato al cioccolato", 8, TypeCourseEnum.DESSERT));

    }

}
