import java.util.List;

class NonAcBus extends Redbus {
    static double farePerKm = 1.5;

    public NonAcBus(int busNumber, int capacity, List<String> route) {
        super(busNumber, "Non-AC", capacity, farePerKm, route);
    }

    public double calculateFare(double distance) {
        return distance * farePerKm;
    }
}
