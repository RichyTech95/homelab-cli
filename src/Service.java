public class Service {

    String name;
    String host;
    int port;
    int timeout;

    public Service(String name, String host, int port, int timeout) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }
}
