import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
            System.out.println("Checking core...");
        } else if (choice == 2) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }
}
