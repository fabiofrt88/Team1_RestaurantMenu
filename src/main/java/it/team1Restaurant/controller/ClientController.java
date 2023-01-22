package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.NotFoundException;
import it.team1Restaurant.service.ClientService;
import it.team1Restaurant.service.ServiceEnum;
import it.team1Restaurant.user.Client;
import spark.Request;
import spark.Response;

import java.util.List;

public class ClientController {

    private ClientService clientService = (ClientService) ServiceDAOFactory.getService(ServiceEnum.CLIENT);

    public String getAllClients(Request request, Response response){
        List<Client> clientList = clientService.selectAllClients();
        return new GsonBuilder().setPrettyPrinting().create().toJson(clientList);
    }

    public String getClientById(Request request, Response response){
        Integer id = Integer.parseInt(request.params(":id"));
        Client client = clientService.selectClientById(id);
        if(client == null) {
            throw new NotFoundException();
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson(client);
    }

}
