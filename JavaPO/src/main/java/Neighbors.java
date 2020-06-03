import java.util.Collections;
import java.util.Map;

public class Neighbors {

    private final Map<NeighborLocation, Human> neighbors;

    public Neighbors(Map<NeighborLocation, Human> neighbors) {
        this.neighbors = neighbors;
    }

    static Neighbors empty() {
        return new Neighbors(Collections.emptyMap());
    }

    enum NeighborLocation {
        LEFT, RIGHT, TOP, BOTTOM
    }
}
