package it.user;

import java.util.ArrayList;
import java.util.Arrays;

public class TestUser {
    public static void main(String[] args) {


        Client adult1 = new Client("Pippo","Franco","pippofranco@gmail.com", "389-5264589", false);
        Client adult2 = new Client("Dina","Verdi", false);

        Client child3 = new Client("pino","cchio", true);


        Group group1 = new Group(new ArrayList<>(Arrays.asList(adult1, adult2, child3)));


        System.out.println(group1);
    }

}
