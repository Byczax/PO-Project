import java.util.HashSet;
import java.util.Set;

public class BodyVirus extends Virus {

    public Set<Location> healedOrKilled(Community community, SimulationProperties myData, Set<Location> infectedLocations) {
        var map = community.getHumanByHouse();
        Set<Location> tempInfectedLocations = new HashSet<>(infectedLocations);
        for (var location : infectedLocations) {
            Human human = map.get(location);
            if (human.getIllnessTime() >= myData.getDelay() && human.getState().equals(humanState.INFECTED)) {
                switch (rand.nextInt(3)) {
                    case 0:
                        human.setState(humanState.CURED);
                        tempInfectedLocations.remove(location);
                        break;
                    case 1:
                        human.setState(humanState.REMOVED);
                        tempInfectedLocations.remove(location);
                        break;
                    default:
                        break;
                }
            }
        }
        return tempInfectedLocations;
    }
}
