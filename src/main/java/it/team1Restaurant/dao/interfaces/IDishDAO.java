package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;

import java.sql.SQLException;
import java.util.List;

public interface IDishDAO {

    void createTable();
    void insertDish(Dish dish);
    void createViewByTypeCourse(TypeCourseEnum typeCourseEnum);
    List<Dish> selectAllDishesByView(TypeCourseEnum typeCourseEnum);
    List<Dish> selectAllDishes() throws SQLException;
    Dish selectDishById(Integer id) throws SQLException;

}
