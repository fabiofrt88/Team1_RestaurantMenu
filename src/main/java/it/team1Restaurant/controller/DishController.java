package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.service.DishService;
import spark.Request;
import spark.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishController {

    private final DishService dishService = ServiceDAOFactory.getDishService();

    public String getAllDishesByView(Request request, Response response){
        String typeCourse = request.params(":type_course");
        TypeCourseEnum typeCourseEnum = TypeCourseEnum.getTypeCourseByName(typeCourse);
        List<Dish> dishList = dishService.selectAllDishesByView(typeCourseEnum);
        return new GsonBuilder().setPrettyPrinting().create().toJson(dishList);
    }

    public String getAllDishes(Request request, Response response){
        List<Dish> dishList = new ArrayList<>();
        try{
            dishList = dishService.selectAllDishes();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson(dishList);
    }

    public String getDishById(Request request, Response response) throws NumberFormatException {
        Integer id = Integer.parseInt(request.params(":id"));
        Dish dish = null;
        try{
            dish = dishService.selectDishById(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson(dish);
    }

}
