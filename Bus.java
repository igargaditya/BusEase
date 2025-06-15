import java.util.List;

abstract class Redbus {
    protected int busNumber;
    protected String busType;
    protected int capacity;
    protected double farePerKm;
    protected int availableSeats;
    protected List<String> route;

    public Bus(int busNumber, String busType, int capacity, double farePerKm, List<String> route) {
        this.busNumber = busNumber;
        this.busType = busType;
        this.capacity = capacity;
        this.availableSeats = capacity;
        this.farePerKm = farePerKm;
        this.route = route;
    }

    public abstract double calculateFare(double distance);

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < capacity) {
            availableSeats++;
        }
    }

    public boolean isValidRoute(String source, String destination) {
        return route.contains(source) && route.contains(destination)
                && route.indexOf(source) < route.indexOf(destination);
    }

    public String getBusDetails() {
        return busNumber + " | " + busType + " | Seats: " + availableSeats + "/" + capacity + " | Route: "
                + String.join(" -> ", route);
    }
}
