import java.util.ArrayList;

public class Passenger extends UserClass {
    private ArrayList<Ticket> bookings = new ArrayList<>();

    public Passenger(String name, String email) {
        super(name, email);
    }

    public void bookTicket(Redbus bus, String source, String destination, double distance) {
        if (!bus.isValidRoute(source, destination)) {
            System.out.println("Invalid route! This bus does not travel from " + source + " to " + destination + ".");
            return;
        }

        if (bus.bookSeat()) {
            Ticket ticket = new Ticket(bus, name, source, destination, distance);
            bookings.add(ticket);
            ticket.saveToFile();
            System.out.println("Ticket Booked Successfully! Ticket ID: " + ticket.getTicketID());
        } else {
            System.out.println("No seats available on this bus.");
        }
    }

    public void cancelTicket(int ticketID) {
        for (Ticket ticket : bookings) {
            if (ticket.getTicketID() == ticketID) {
                ticket.getBus().cancelSeat();
                bookings.remove(ticket);
                System.out.println("Ticket Cancelled Successfully!");
                return;
            }
        }
        System.out.println("Invalid Ticket ID.");
    }
}
