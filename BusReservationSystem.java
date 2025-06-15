import java.util.*;

// Main Driver Class
public class BusReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Redbus> buses = new ArrayList<>();
        buses.add(new AcBus(1, 10, Arrays.asList("A", "B", "C")));
        buses.add(new NonAcBus(2, 20, Arrays.asList("D", "E", "F")));
        buses.add(new SleeperBus(3, 15, Arrays.asList("G", "H", "I")));

        System.out.println("Welcome to the Bus Reservation System");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        Passenger passenger = new Passenger(name, email);

        while (true) {
            System.out.println("\n1. View Buses\n2. Book Ticket\n3. Cancel Ticket\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Available Buses:");
                for (Redbus bus : buses) {
                    System.out.println(bus.getBusDetails());
                }
            } else if (choice == 2) {

                System.out.print("Enter Bus Number: ");
                int busNumber = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline

                Redbus temp = null;
                for (Redbus bus : buses) {
                    if (bus.busNumber == busNumber) {
                        temp = bus;
                        break;
                    }
                }

                if (temp == null) {
                    System.out.println("Bus not available, try again!");
                    continue;
                }

                System.out.print("Enter Source: ");
                String source = scanner.nextLine();

                System.out.print("Enter Destination: ");
                String destination = scanner.nextLine();

                System.out.print("Enter Distance (km): ");
                double distance = scanner.nextDouble();
                scanner.nextLine(); // Consume the leftover newline character

                passenger.bookTicket(temp, source, destination, distance);

            } else if (choice == 3) {
                System.out.print("Enter Ticket ID to Cancel: ");
                int ticketID = scanner.nextInt();
                scanner.nextLine();
                passenger.cancelTicket(ticketID);
            } else if (choice == 4) {
                System.out.println("Thank you for using the Bus Reservation System!");
                break;
            }
        }
        scanner.close();
    }
}
