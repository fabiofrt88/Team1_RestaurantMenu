package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.FoodStorageSql;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.service.DishService;
import it.team1Restaurant.service.ServiceEnum;

import java.sql.SQLException;
import java.util.List;

public class TestDishDAO {

    public static void main(String[] args) throws NoSuchMethodException, SQLException {

        try {

            DishService dishService = (DishService) ServiceDAOFactory.getService(ServiceEnum.DISH);

            dishService.createTable();

            dishService.createViewByTypeCourse(TypeCourseEnum.STARTER);
            dishService.createViewByTypeCourse(TypeCourseEnum.FIRST);
            dishService.createViewByTypeCourse(TypeCourseEnum.SECOND);
            dishService.createViewByTypeCourse(TypeCourseEnum.SIDE_DISH);
            dishService.createViewByTypeCourse(TypeCourseEnum.DESSERT);
            dishService.createViewByTypeCourse(TypeCourseEnum.FRUIT);

            List<Dish> dishList = FoodStorageSql.getDishList();
            dishList.forEach(dishService::insertDish);

            System.out.println("selectAllDishesByView first_dishes\n");
            List<Dish> firstDishes = dishService.selectAllDishesByView(TypeCourseEnum.FIRST);
            firstDishes.forEach(System.out::println);

            System.out.println("\nselectAllDishes\n");
            List<Dish> dishes = dishService.selectAllDishes();
            dishes.forEach(System.out::println);

            System.out.println("\nselectDishById\n");
            Dish dish = dishService.selectDishById(5);
            System.out.println(dish);

        } catch (DataAccessException | ClassCastException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }
}
