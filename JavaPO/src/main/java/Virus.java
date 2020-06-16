import java.util.Random;
import java.util.Set;

public interface Virus {

    Random rand = new Random();

    Set<Location> infect(Community community, SimulationProperties myData, Set<Location> infectedLocations);

    Set<Location> healedOrKilled(Community community, SimulationProperties myData, Set<Location> infectedLocations);

    Set<Location> spreadVirus(Community community, SimulationProperties myData, Set<Location> infectedLocations);

}

