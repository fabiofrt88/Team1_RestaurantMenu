package it.team1Restaurant.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {

    //int id; (da valutare)

    private List<Client> clientList;

    public Group (){
        this.clientList = new ArrayList<>();
    }

    public Group (List<Client> clientList){
        this.clientList = clientList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public int getNumberOfChild(){
        int count = 0;
        for(Client client: clientList){
            if(client.isChild()){
                count++;
            }
        }
        return count;
    }

    public int getNumberOfAdult(){
        return clientList.stream().filter(client -> client.isChild() == false).collect(Collectors.toList()).size();
    }

    public void addClient(Client client){
        this.clientList.add(client);
    }

    public String getGroupDetails () {
        String str = "";
        for(Client client:clientList){
            str+= client.toString() + "\n";
        }
        return str;
    }

    public void printDetails(){
        for(Client client:clientList){
            System.out.println(client + "\n");
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "clientList=" + clientList +
                '}';
    }
}
