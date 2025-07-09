package qa.implementation;

import java.util.LinkedList;

public class QueueAndWhileLoop {
    private final Queue<Client> clientsQueue = new LinkedList<>();

    public void printClients() {
        System.out.println("queue.printClients");

        if (!clientsQueue.isEmpty()) {
            var iterator = clientsQueue.iterator();
            do {
                Client client = iterator.next();
                System.out.println("Client name: " + client.getClientName() +
                        ", Client country: " + client.getClientCountry() +
                        ", Requests quantity in December: " + client.getRequestsQuantityInDec() +
                        ", Is the client satisfied: " + client.isSatisfied());
            } while (iterator.hasNext());
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public void addClient(Client client) {
        clientsQueue.offer(client);
        System.out.println("queue.addClient(" + client + ")");
        System.out.println("List of clients: " + clientsQueue);
    }

    public void removeClient() {
        Client removedClient = clientsQueue.poll();
        if (removedClient != null) {
            System.out.println("queue.removeGame(" + removedClient + ")");
        } else {
            System.out.println("Queue is empty.");
        }
        System.out.println("Remain clients: " + clientsQueue);
    }

    public void findClient(Client client) {
        System.out.println("queue.findClient(" + client + ")");
        if (clientsQueue.contains(client)) {
            System.out.println("Game found: " + client.getClientName());
        } else {
            System.out.println("Game not found: " + client.getClientName());
        }
    }

}
