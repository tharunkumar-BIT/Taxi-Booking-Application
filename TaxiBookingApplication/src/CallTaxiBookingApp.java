import java.util.Scanner;

public class CallTaxiBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxiService service = new TaxiService(4);

        while (true) {
            System.out.println("\n--- Call taxi Booking---");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = sc.nextInt();
                    System.out.print("Enter Pickup point(A-F): ");
                    char from = sc.next().toUpperCase().charAt(0);
                    System.out.print("Enter dropping point(A-F): ");
                    char to = sc.next().toUpperCase().charAt(0);
                    System.out.print("Enter pickup time: ");
                    int pickupTime = sc.nextInt();

                    if (from == to || from < 'A' || from > 'F' || to < 'A' || to > 'F') {
                        System.out.println("Invalid pickup/drop points.");
                        break;
                    }

                    service.bookTaxi(customerId, from, to, pickupTime);
                    break;

                case 2:
                    service.displayTaxiDetails();
                    break;

                case 3:
                    System.out.println("Thank you for using the Call Taxi Booking App!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}