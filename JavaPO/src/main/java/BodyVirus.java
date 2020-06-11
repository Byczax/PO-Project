import java.util.*;

public class BodyVirus implements Virus {

    public Community infect(Community community, SimulationProperties myData, Set<Location> infectedLocations) {

//        Community.resetFlagsInfected(community);
        infectedLocations.addAll(healOrKillChance(community, myData, infectedLocations));
        infectedLocations.addAll(spreadVirus(community, myData, infectedLocations));
        Community.sumUpStatsVirus(community);
        return community;
    }

    public Set<Location> healOrKillChance(Community community, SimulationProperties myData, Set<Location> infectedLocations) {
        var map = community.getHumanByHouse();
        Set<Location> tempInfectedLocations = new HashSet<>(infectedLocations);
        for (var location : infectedLocations) {
            Human human = map.get(location);
            if (human.getIllnessTime() >= myData.getDelay() && human.getState().equals(humanState.ILL)) {
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
                if (community.getHumanByHouse().get(seekLocation).getState().equals(humanState.HEALTHY) &&
                        rand.nextInt(100) + 1 <= myData.getInfectionChance()) {
                    tempInfectedLocations.add(ifInfected(community, tempInfectedLocations, seekLocation));
                }
            }
        }
        return tempInfectedLocations;
    }

    private Location setBorders(int k, int l, int lX, int lY, int sqrtPopulation) {
        Location location;
        int x = Math.max(0, k + lX);
        int y = Math.max(0, l + lY);
        x = Math.min(sqrtPopulation - 1, x);
        y = Math.min(sqrtPopulation - 1, y);
        location = new Location(x, y);
        return location;
    }


    private Location ifInfected(Community community, Set<Location> tempInfectedLocations, Location seekLocation) {

        community.getHumanByHouse().get(seekLocation).setState(humanState.ILL);
        community.getHumanByHouse().get(seekLocation).setIllnessTime(0);
        tempInfectedLocations.add(seekLocation);
        return seekLocation;
    }
}
