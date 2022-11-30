package it.team1Restaurant.menu;

import java.util.ArrayList;

public enum TypeDishClient {

    //TODO

    GENERIC,
    CHILD,
    VEGETARIAN,
    VEGAN,
    CELIAC;


    public ArrayList<TypeDishClient> getOnlyVeg(){
        ArrayList vegList = new ArrayList();

        vegList.add(VEGETARIAN);
        vegList.add(VEGAN);

        return vegList;
    }

}
