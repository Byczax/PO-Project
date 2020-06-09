import java.util.List;

public class InfectedLocations {

    private final List<Location> locations;

    public InfectedLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Location> getLocations() {
        return locations;
    }
}
