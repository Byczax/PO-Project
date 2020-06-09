import java.util.*;

public class BodyVirus implements Virus {

    public void infect(Community community, SimulationProperties myData, Set<Location> infectedLocations) {

        Community.resetFlagsInfected(community);
        healOrKillChance(community, myData, infectedLocations);
        spreadVirus(community, myData, infectedLocations);
        Community.sumUpStatsVirus(community);
    }

    public void healOrKillChance(Community community, SimulationProperties myData, Set<Location> infectedLocations) {
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
        infectedLocations.addAll(tempInfectedLocations);
    }

    public void spreadVirus(Community community, SimulationProperties myData, Set<Location> infectedLocations) {
        var map = community.getHumanByHouse();
        Set<Location> tempInfectedLocations = new HashSet<>(infectedLocations);
        for (var location : infectedLocations) {
            Human human = map.get(location);

            if (!human.isHasBeenAffected()) {
                human.setHasBeenAffected(true);
                human.plusIlnessTime();
                int range = myData.getRange();
                for (int k = -range; k <= range; k++) {
                    for (int l = -range; l <= range; l++) {
                        if (Math.abs(k) + Math.abs(l) > range) continue;
                        int x = Math.max(0, k + location.getX());
                        int y = Math.max(0, l + location.getY());
                        x = Math.min(community.getSqrtPopulation() - 1, x);
                        y = Math.min(community.getSqrtPopulation() - 1, y);
                        Location seekLocation = new Location(x, y);
                        if (community.getHumanByHouse().get(seekLocation).getState().equals(humanState.HEALTHY) &&
                                rand.nextInt(100) + 1 >= myData.getInfectionChance()) {
                            community.getHumanByHouse().get(seekLocation).setState(humanState.ILL);
                            community.getHumanByHouse().get(seekLocation).setHasBeenAffected(true);
                            community.getHumanByHouse().get(seekLocation).setIllnessTime(0);
                            tempInfectedLocations.add(seekLocation);
                        }
                    }
                }
            }
        }
        infectedLocations.addAll(tempInfectedLocations);
    }
}
