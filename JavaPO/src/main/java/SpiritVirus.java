import java.util.HashSet;
import java.util.Set;

public class SpiritVirus extends Virus {

    public Set<Location> spreadVirus(Community community, SimulationProperties myData, Set<Location> infectedLocations) {
        var map = community.getHumanByHouse();
        Set<Location> tempInfectedLocations = new HashSet<>(infectedLocations);
        for (var location : infectedLocations) {
            Human human = map.get(location);
            human.plusIllnessTime();

            var neighbours = checkNeighbors(community, myData, location.getX(), location.getY(), tempInfectedLocations);
            tempInfectedLocations.addAll(neighbours);

        }
        return tempInfectedLocations;
    }

    private Set<Location> checkNeighbors(Community community, SimulationProperties myData, int locationX, int locationY, Set<Location> tempInfectedLocations) {
        int range = myData.getRange();

        for (int k = -range; k <= range; k++) {
            for (int l = -range; l <= range; l++) {
                if (Math.abs(k) + Math.abs(l) > range) continue;
                Location seekLocation = setBorders(k, l, locationX, locationY, community.getSqrtPopulation());
                if (community.getHumanByHouse().get(seekLocation).getState().equals(humanState.HEALTHY)) {
                    tempInfectedLocations.add(setInfected(community, tempInfectedLocations, seekLocation));
                }
            }
        }
        return tempInfectedLocations;
    }
}
