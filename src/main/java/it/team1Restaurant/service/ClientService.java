package it.team1Restaurant.service;

import it.team1Restaurant.dao.interfaces.IClientDAO;
import it.team1Restaurant.service.interfaces.IService;
import it.team1Restaurant.user.Client;

import java.util.List;

public class ClientService implements IService {

    private IClientDAO clientDAO;

    public ClientService(IClientDAO clientDAO){
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
