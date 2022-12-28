package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.TypeCourseDAO;
import it.team1Restaurant.foods.TypeCourseEnum;

public class TestTypeCourseDAO {

    public static void main(String[] args) {

        TypeCourseDAO typeCourseDAO = new TypeCourseDAO();

        typeCourseDAO.createTable();

        typeCourseDAO.insertTypeCourse(TypeCourseEnum.STARTER);
        typeCourseDAO.insertTypeCourse(TypeCourseEnum.FIRST);
        typeCourseDAO.insertTypeCourse(TypeCourseEnum.SECOND);
        typeCourseDAO.insertTypeCourse(TypeCourseEnum.SIDE_DISH);
        typeCourseDAO.insertTypeCourse(TypeCourseEnum.DESSERT);
        typeCourseDAO.insertTypeCourse(TypeCourseEnum.FRUIT);

    }

}
