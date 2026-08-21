import java.util.Scanner;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

				String host = "core";
				int port = 22;
				int timeout = 3000;

				System.out.println("Checking " + host + "...");

				long connectionTime = getConnectionTime(host, port, timeout);

				if (connectionTime >= 0) {
				System.out.println("core is ONLINE");
				System.out.println("SSH port: 22");
				System.out.println("Connection time: " + connectionTime + " ms");
			} else {
				System.out.println("core is OFFLINE or unreachable");
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
		public static long getConnectionTime(String host, int port, int timeout) {

			System.out.println("Checking core...");

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
