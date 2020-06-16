import java.util.*;

public class BodyVirus implements Virus {

    public Set<Location> infect(Community community, SimulationProperties myData, Set<Location> infectedLocations) {

        Set<Location> tempInfectedLocations = new HashSet<>(infectedLocations);
        tempInfectedLocations.addAll(healedOrKilled(community, myData, infectedLocations));
        tempInfectedLocations.addAll(spreadVirus(community, myData, infectedLocations));
        return tempInfectedLocations;
    }

    /**
     * if ill long enough, get a random state (ill, cured, removed) and set
     * @param community database
     * @param myData data from user
     * @param infectedLocations set with infected locations
     * @return set with removed infected
     */
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

    /**
     * check ill human neighbours, get a infect chance, if correct, infect.
     * @param community database
     * @param myData data from user
     * @param infectedLocations set with infected locations
     * @return set with infected locations
     */
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

    /**
     * If conditions are fulfilled, add their location to infected list.
     * @param community database
     * @param myData user data
     * @param locationX param X
     * @param locationY param Y
     * @param tempInfectedLocations set with infected locations
     * @return infected that's fulfilled conditions
     */
    private Set<Location> checkNeighbors(Community community, SimulationProperties myData, int locationX, int locationY, Set<Location> tempInfectedLocations) {
        int range = myData.getRange();

        for (int k = -range; k <= range; k++) {
            for (int l = -range; l <= range; l++) {
                if (Math.abs(k) + Math.abs(l) > range) continue;

                Location seekLocation = setBorders(k, l, locationX, locationY, community.getSqrtPopulation());
                if (community.getHumanByHouse().get(seekLocation).getState().equals(humanState.HEALTHY) &&
                        rand.nextInt(100) + 1 <= myData.getInfectionChance()) {
                    tempInfectedLocations.add(ifInfected(community, tempInfectedLocations, seekLocation));
                }
            }
        }
        return tempInfectedLocations;
    }

    /**
     * @param k horizontal range
     * @param l vertical range
     * @param lX actual coordinate X
     * @param lY actual coordinate Y
     * @param sqrtPopulation border length
     * @return conditioned location with restrictions
     */
    private Location setBorders(int k, int l, int lX, int lY, int sqrtPopulation) {
        Location location;
        int x = Math.max(0, k + lX);
        int y = Math.max(0, l + lY);
        x = Math.min(sqrtPopulation - 1, x);
        y = Math.min(sqrtPopulation - 1, y);
        location = new Location(x, y);
        return location;
    }


    /**
     * @param community database
     * @param tempInfectedLocations set with infected locations
     * @param seekLocation infected location
     * @return infected location
     */
    private Location ifInfected(Community community, Set<Location> tempInfectedLocations, Location seekLocation) {

        community.getHumanByHouse().get(seekLocation).setState(humanState.INFECTED);
        community.getHumanByHouse().get(seekLocation).setIllnessTime(0);
        tempInfectedLocations.add(seekLocation);
        return seekLocation;
    }
}
