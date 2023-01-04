package it.team1Restaurant.dao.testDAO;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.DishDAO;
import it.team1Restaurant.dao.DrinkDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;

import java.util.List;

public class TestDishDAO {

    public static void main(String[] args) throws NoSuchMethodException {

        DishDAO dishDAO = new DishDAO();

        dishDAO.createTable();

        dishDAO.insertDish(new Dish(null, "Pasta al sugo", 8, TypeCourseEnum.FIRST));
        dishDAO.insertDish(new Dish(null, "Pasta al pesto", 10, TypeCourseEnum.FIRST));
        dishDAO.insertDish(new Dish(null, "Salsicce e Friarielli", 13, TypeCourseEnum.SECOND));
        dishDAO.insertDish(new Dish(null, "Parmigiana di Melanzane", 15, TypeCourseEnum.SECOND));
        dishDAO.insertDish(new Dish(null, "Tiramisu", 11, TypeCourseEnum.DESSERT));
        dishDAO.insertDish(new Dish(null, "Gelato al cioccolato", 8, TypeCourseEnum.DESSERT));

        System.out.println("selectAllDishes\n");
        List<Dish> dishList = dishDAO.selectAllDishes();
        dishList.forEach(System.out::println);

        System.out.println("\nselectDishById\n");
        Dish dish = dishDAO.selectDishById(5);
        System.out.println(dish);

        System.out.println(TypeCourseEnum.FIRST.ordinal());

    }
}
