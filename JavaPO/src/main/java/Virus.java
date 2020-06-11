import java.util.Random;
import java.util.Set;

public interface Virus {

    Random rand = new Random();

    Community infect(Community community, SimulationProperties myData, Set<Location> infectedLocations);

    Set<Location> healOrKillChance(Community community, SimulationProperties myData, Set<Location> infectedLocations);

    Set<Location> spreadVirus(Community community, SimulationProperties myData, Set<Location> infectedLocations);


}

