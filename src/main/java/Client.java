
public class Client {
    private String clientName;
    private String clientCountry;
    private int requestsQuantityInDec;
    private boolean isSatisfied;

    @Override
    public String toString() {
        return "Clients{" +
                "clientName='" + clientName + '\'' +
                ", clientCountry='" + clientCountry + '\'' +
                ", requestsQuantityInDec=" + requestsQuantityInDec +
                ", isSatisfied=" + isSatisfied +
                '}';
    }

    public Client(String clientName, String clientCountry, int requestsQuantityInDec, boolean isSatisfied) {
        this.clientName = clientName;
        this.clientCountry = clientCountry;
        this.requestsQuantityInDec = requestsQuantityInDec;
        this.isSatisfied = isSatisfied;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getClientCountry() {
        return this.clientCountry;
    }

    public int getRequestsQuantityInDec() {
        return this.requestsQuantityInDec;
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

}