package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.NotFoundException;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.service.DishService;
import it.team1Restaurant.service.ServiceEnum;
import spark.Request;
import spark.Response;

import java.util.List;

public class DishController {

    private DishService dishService = (DishService) ServiceDAOFactory.getService(ServiceEnum.DISH);

    public String getAllDishesByView(Request request, Response response){
        String typeCourse = request.params(":type_course");
        TypeCourseEnum typeCourseEnum = TypeCourseEnum.getTypeCourseByName(typeCourse);
        List<Dish> dishList = dishService.selectAllDishesByView(typeCourseEnum);
        return new GsonBuilder().setPrettyPrinting().create().toJson(dishList);
    }

    public String getAllDishes(Request request, Response response){
        List<Dish> dishList = dishService.selectAllDishes();
        return new GsonBuilder().setPrettyPrinting().create().toJson(dishList);
    }

    public String getDishById(Request request, Response response){
        Integer id = Integer.parseInt(request.params(":id"));
        Dish dish = dishService.selectDishById(id);
        if(dish == null){
            throw new NotFoundException();
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson(dish);
    }

}
