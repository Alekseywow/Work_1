package qa.implementation;


import java.util.HashMap;
import java.util.Map;

public class MapAndForLoop {

    private final Map<Integer, Client> clients = new HashMap<>();
    private int nextKey = 1;

    public void printClients() {
        for (var entry : clients.entrySet()) {
            System.out.println("Key :" + entry.getKey() + ", value: " + entry.getValue().toString());
        }
    }

    public void addClient(Client client) {
        clients.put(nextKey++, client);
        System.out.println("map.addClient(" + client + ")");
        System.out.println("List of clients: " + clients);
    }

    public void removeClient(Client client) {
        System.out.println("map.remove(" + client + ")");
        clients.entrySet().removeIf(entry -> entry.getValue().equals(client));
        System.out.println("Remain clients: " + clients);
    }

    public void findClient(Client client) {
        if (clients.containsValue(client)) {
            System.out.println("Client found: " + client.getClientName);
        } else {
            System.out.println("Client is not found: " + client.getClientName);
        }
        System.out.println("map.findClient(" + client + ")");
    }

}
