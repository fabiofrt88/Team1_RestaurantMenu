package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.service.DishService;
import spark.Request;
import spark.Response;

import java.util.List;

public class DishController {

    private static DishService dishService = ServiceDAOFactory.getDishService();

    public static String getAllDishesByView(Request request, Response response){
        String typeCourse = request.params(":type_course");
        TypeCourseEnum typeCourseEnum = TypeCourseEnum.getTypeCourseByName(typeCourse);
        List<Dish> dishList = dishService.selectAllDishesByView(typeCourseEnum);
        return new GsonBuilder().setPrettyPrinting().create().toJson(dishList);
    }

    public static String getAllDishes(Request request, Response response){
        List<Dish> dishList = dishService.selectAllDishes();
        return new GsonBuilder().setPrettyPrinting().create().toJson(dishList);
    }

    public static String getDishById(Request request, Response response){
        Integer id = Integer.parseInt(request.params(":id"));
        Dish dish = dishService.selectDishById(id);
        return new GsonBuilder().setPrettyPrinting().create().toJson(dish);
    }

}
