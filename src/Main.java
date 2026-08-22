import java.util.Scanner;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        Service[] services = { 
			new Service("SSH", "core", 22, 3000),
        
			new Service("Pi-hole HTTP", "core", 80, 3000),
        
			new Service("Pi-Hole HTTPS", "core", 443, 3000),
		};
        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("========================");
            System.out.println("     RICHY HOMELAB");
            System.out.println("========================");
            System.out.println();
            System.out.println("1. Check core");
            System.out.println("2. Exit");
            System.out.println();
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

			if (choice == 1) {

				for (Service service : services) {
					checkService(service);
				}	

			} else if (choice == 2) {

				System.out.println("Goodbye!");
				running = false;

			} else {

				System.out.println("Invalid option.");
			}
		}
        scanner.close();
    
	}
			public static void checkService(Service service) {

				System.out.println();
				System.out.println("Checking " + service.name + "...");

				long responseTime = getConnectionTime(
						service.host,
						service.port,
						service.timeout
				);

				if (responseTime >= 0) {
					System.out.println(service.name + " is ONLINE");
					System.out.println("Host: " + service.host);
					System.out.println("Port: " + service.port);
					System.out.println("Connection time: " + responseTime + " ms");
				} else {
					System.out.println(service.name + " is OFFLINE or unreachable");
			}
	}
		public static long getConnectionTime(String host, int port, int timeout) {

			try {
				Socket socket = new Socket();

				long startTime = System.nanoTime();

				socket.connect(
					new InetSocketAddress(host, port),
					timeout
				);

				long endTime = System.nanoTime();

				socket.close();

				long connectionTime = (endTime - startTime) / 1_000_000;

				return connectionTime;

			} catch (Exception e) {

				return -1;
			}
	}
}

    

