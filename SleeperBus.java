import java.util.List;

public class SleeperBus extends Redbus {
    static double farePerKm = 3.0;

    public SleeperBus(int busNumber, int capacity, List<String> route) {
        super(busNumber, "Sleeper", capacity, farePerKm, route);
    }

    public double calculateFare(double distance) {
        return distance * farePerKm;
    }
}
