import java.io.FileWriter;
import java.io.IOException;

class Ticket {
    private static int ticketCounter = 1000;
    private int ticketID;
    private Redbus bus;
    private String passengerName;
    private String source, destination;
    private double fare;

    public Ticket(Redbus bus, String passengerName, String source, String destination, double distance) {
        this.ticketID = ticketCounter++;
        this.bus = bus;
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.fare = bus.calculateFare(distance);
    }

    public int getTicketID() {
        return ticketID;
    }

    public Redbus getBus() {
        return bus;
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("tickets.txt", true)) {
            writer.write(ticketID + " | " + passengerName + " | " + source + " -> " + destination + " | Fare: " + fare
                    + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
