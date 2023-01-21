package it.team1Restaurant.service;

import it.team1Restaurant.dao.interfaces.IDishDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;

import java.util.List;

public class DishService {

    private IDishDAO dishDAO;

    public DishService(IDishDAO dishDAO){
        this.dishDAO = dishDAO;
    }

    public void createTable(){
        dishDAO.createTable();
    }

    public void insertDish(Dish dish){
        dishDAO.insertDish(dish);
    }

    public void createViewByTypeCourse(TypeCourseEnum typeCourseEnum){
        dishDAO.createViewByTypeCourse(typeCourseEnum);
    }

    public List<Dish> selectAllDishesByView(TypeCourseEnum typeCourseEnum){
        return dishDAO.selectAllDishesByView(typeCourseEnum);
    }

    public List<Dish> selectAllDishes(){
        return dishDAO.selectAllDishes();
    }

    public Dish selectDishById(Integer id){
        return dishDAO.selectDishById(id);
    }

}
