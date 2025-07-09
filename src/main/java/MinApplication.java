import qa.implementation.ListAndForLoop;
import qa.implementation.MapAndForLoop;
import qa.implementation.QueueAndWhileLoop;
import qa.implementation.SetAndIfElseLoop;

public class MinApplication {

    public static void main(String[] args) {

        Client swissport = new Client("Swissport", "Belgium", 23, true);
        Client aviator = new Client("Aviator", "Sweden", 17, true);
        Client dnata = new Client("dnata", "OAE", 39, true);
        Client celebi = new Client("Celebi", "India", 24, false);

        ListAndForLoop listOfClients = new ListAndForLoop();
        // add objects in list
        listOfClients.addClient(swissport);
        listOfClients.addClient(aviator);
        listOfClients.addClient(dnata);
        listOfClients.addClient(celebi);
        // print clients' list
        listOfClients.printClients();
        // check if client "Swissport" in the clients' list
        listOfClients.clientIsInList(swissport);
        // remove client from list
        listOfClients.removeClient(dnata);
        // print clients' list after removing client
        listOfClients.printClients();

        SetAndIfElseLoop setOfClients = new SetAndIfElseLoop();
        // add objects in set
        setOfClients.addClient(swissport);
        setOfClients.addClient(aviator);
        setOfClients.addClient(dnata);
        setOfClients.addClient(celebi);
        // print clients' set
        setOfClients.printClients();
        // remove client from set
        setOfClients.removeClient(celebi);
        // check if client "Celebi" in the clients' set
        setOfClients.findClient(celebi);

        MapAndForLoop clientsMap = new MapAndForLoop();
        // add objects in map
        clientsMap.addClient(swissport);
        clientsMap.addClient(aviator);
        clientsMap.addClient(dnata);
        clientsMap.addClient(celebi);
        // print clients' map
        clientsMap.printClients();
        // remove client from map
        clientsMap.removeClient(aviator);
        // check if client "Celebi" in the clients' map
        clientsMap.findClient(celebi);

        QueueAndWhileLoop clientsQueue = new QueueAndWhileLoop();
        // add objects in queue
        clientsQueue.addClient(swissport);
        clientsQueue.addClient(aviator);
        clientsQueue.addClient(dnata);
        clientsQueue.addClient(celebi);
        // print clients' queue
        clientsQueue.printClients();
        // remove client from queue
        clientsQueue.removeClient();
        // check if client "dnata" in the clients' queue
        clientsQueue.findClient(dnata);
    }

}
