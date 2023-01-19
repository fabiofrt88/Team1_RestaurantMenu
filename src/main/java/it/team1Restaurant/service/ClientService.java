package it.team1Restaurant.service;

import it.team1Restaurant.dao.ClientDAO;
import it.team1Restaurant.dao.interfaces.IClientDAO;
import it.team1Restaurant.user.Client;

import java.util.List;

public class ClientService {

    private IClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }

    public void createTable() {
        clientDAO.createTable();
    }

    public void insertClient(Client client) {
        clientDAO.insertClient(client);
    }

    public List<Client> selectAllClients() {
        return clientDAO.selectAllClients();
    }

    public Client selectClientById(Integer id) {
        return clientDAO.selectClientById(id);
    }

}
