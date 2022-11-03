package it.team1Restaurant.user;

import java.util.List;
import java.util.stream.Collectors;

public class Group {

    //int id; (da valutare)

    private List<Client> clientList;

    public Group (List<Client> clientList){
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
     return clientList.stream().filter(client -> client.isChild() == false).collect(Collectors.toList()).size(); }

    public String printDetails () {
        String str = "";
        for(Client client:clientList){
            str+= client.toString() + "\n";
        }
        return str;
    }
    @Override
    public String toString() {
        return "Group{" +
                "clientList=" + clientList +
                '}';
    }
}
