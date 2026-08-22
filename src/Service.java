public class Service {

    private String name;
    private String host;
    private int port;
    private int timeout;

    public Service(String name, String host, int port, int timeout) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }
    
    public String getName() {
		return name;
	}
	
	
	public String getHost() {
		return host;
	}
	
	public int getPort() {
		return port;
	}
	
	public int getTimeout() {
		return timeout;
	}
}
