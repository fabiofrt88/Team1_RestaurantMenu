package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.ClientDAO;
import it.team1Restaurant.menu.TypeFoodEnum;
import it.team1Restaurant.user.Client;

import java.util.EnumSet;
import java.util.List;

public class TestClientDAO {

    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();

        clientDAO.createTable();

        clientDAO.insertClient(new Client(null, "Mario","Rossi","mariorossi@gmail.com", "380-6578900", EnumSet.of(TypeFoodEnum.GENERIC)));
        clientDAO.insertClient(new Client(null, "Pietro","Gallina","pietrogallina@gmail.com", "380-6578904", EnumSet.of(TypeFoodEnum.GENERIC)));
        clientDAO.insertClient(new Client(null, "Fabio","Frattarelli","fabiofrattarelli@gmail.com", "380-6578910", EnumSet.of(TypeFoodEnum.GENERIC)));
        clientDAO.insertClient(new Client(null, "Dino","Petrucci","dinopetrucci@gmail.com", "380-6578924", EnumSet.of(TypeFoodEnum.GENERIC)));
        clientDAO.insertClient(new Client(null, "Christian","Carollo","christiancarollo@gmail.com", "380-6578932", EnumSet.of(TypeFoodEnum.GENERIC)));

        System.out.println("selectAllClients\n");
        List<Client> clientList = clientDAO.selectAllClients();
        clientList.forEach(System.out::println);
        //clientList.forEach(Client::printDetails);

        System.out.println("\nselectClientById\n");
        Client client = clientDAO.selectClientById(1);
        System.out.println(client);

    }

}
