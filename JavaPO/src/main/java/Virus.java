import java.util.Random;
import java.util.Set;

public interface Virus {

    Random rand = new Random();

    void infect(Community community, SimulationProperties myData, Set<Location> infectedLocations);

    void healOrKillChance(Community community, SimulationProperties myData, Set<Location> infectedLocations);

    void spreadVirus(Community community, SimulationProperties myData, Set<Location> infectedLocations);


}

