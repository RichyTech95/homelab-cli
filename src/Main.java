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
                checkCore();

            } else if (choice == 2) {
                System.out.println("Goodbye!");
                running = false;

            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    public static void checkCore() {

        String host = "core";
        int port = 22;
        int timeout = 3000;

        System.out.println("Checking core...");

        try {
            Socket socket = new Socket();

            socket.connect(
                new InetSocketAddress(host, port),
                timeout
            );

            System.out.println("core is ONLINE");

            socket.close();

        } catch (Exception e) {
            System.out.println("core is OFFLINE or unreachable");
        }
    }
}
