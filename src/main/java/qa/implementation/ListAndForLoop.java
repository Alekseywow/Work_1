package qa.implementation;

import java.util.ArrayList;
import java.util.List;

public class ListAndForLoop {

    private final List<Client> clientList = new ArrayList<>();

    public void printClients() {
        for (int i = 0; i < clientList.size(); i++) {
            Client clients = clientList.get(i);
            System.out.println(clients.toString());
        }
    }

    public void addClient(Client client) {
        clientList.add(client);
        System.out.println("list.addClient(" + client + ")");
        System.out.println("List of clients: " + clientList);
    }

    public void removeClient(Client client) {
        clientList.remove(client);
        System.out.println("list.removeClient(" + client + ")");
        System.out.println("Remain clients: " + clientList);
    }

    public void clientIsInList(Client client) {
        System.out.println("list.ClientIsInList(" + client + ")");
        System.out.println("Client " + client + "is in te last: " + clientList.contains(client));
    }
}
