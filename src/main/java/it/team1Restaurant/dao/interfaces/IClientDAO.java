package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.user.Client;

import java.util.List;

public interface IClientDAO {

    void createTable();
    void insertClient(Client client);
    List<Client> selectAllClients();
    Client selectClientById(Integer id);

}
