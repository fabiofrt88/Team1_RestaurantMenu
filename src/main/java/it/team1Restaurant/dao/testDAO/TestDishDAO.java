package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.DishDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;

import java.util.List;

public class TestDishDAO {

    public static void main(String[] args) throws NoSuchMethodException {

        DishDAO dishDAO = new DishDAO();

        dishDAO.createTable();

        dishDAO.createViewByTypeCourse(TypeCourseEnum.STARTER);
        dishDAO.createViewByTypeCourse(TypeCourseEnum.FIRST);
        dishDAO.createViewByTypeCourse(TypeCourseEnum.SECOND);
        dishDAO.createViewByTypeCourse(TypeCourseEnum.SIDE_DISH);
        dishDAO.createViewByTypeCourse(TypeCourseEnum.DESSERT);
        dishDAO.createViewByTypeCourse(TypeCourseEnum.FRUIT);

        dishDAO.insertDish(new Dish(null, "Pasta al sugo", 8, TypeCourseEnum.FIRST));
        dishDAO.insertDish(new Dish(null, "Pasta al pesto", 10, TypeCourseEnum.FIRST));
        dishDAO.insertDish(new Dish(null, "Salsicce e Friarielli", 13, TypeCourseEnum.SECOND));
        dishDAO.insertDish(new Dish(null, "Parmigiana di Melanzane", 15, TypeCourseEnum.SECOND));
        dishDAO.insertDish(new Dish(null, "Tiramisu", 11, TypeCourseEnum.DESSERT));
        dishDAO.insertDish(new Dish(null, "Gelato al cioccolato", 8, TypeCourseEnum.DESSERT));

        System.out.println("selectAllDishesByView first_dishes\n");
        List<Dish> firstDishes = dishDAO.selectAllDishesByView(TypeCourseEnum.FIRST);
        firstDishes.forEach(System.out::println);

        System.out.println("\nselectAllDishes\n");
        List<Dish> dishList = dishDAO.selectAllDishes();
        dishList.forEach(System.out::println);

        System.out.println("\nselectDishById\n");
        Dish dish = dishDAO.selectDishById(5);
        System.out.println(dish);

    }
}
