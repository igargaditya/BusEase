import java.util.List;

class AcBus extends Redbus {
    static double farePerKm = 2.5;

    public AcBus(int busNumber, int capacity, List<String> route) {
        super(busNumber, "AC", capacity, farePerKm, route);
    }

    public double calculateFare(double distance) {
        return distance * farePerKm;
    }
}
