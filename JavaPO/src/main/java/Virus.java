import java.util.Map;
import java.util.Random;

public abstract class Virus {

    Random rand = new Random();

    public void infect(Community community, SimulationProperties myData) {

        Community.resetFlagsInfected(community);
        healOrKillChance(community, myData);
        spreadVirus(community, myData);
        Community.sumUpStatsVirus(community);

    }

    private void healOrKillChance(Community community, SimulationProperties myData) {
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            if (human.getIllnessTime() >= myData.getDelay() && human.getState().equals(humanState.ILL)) {
                switch (rand.nextInt(3)) {
                    case 0:
                        human.setState(humanState.CURED);
                        break;
                    case 1:
                        human.setState(humanState.REMOVED);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void spreadVirus(Community community, SimulationProperties myData) {
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Location location = entry.getKey();
            Human human = entry.getValue();
            if (human.getState().equals(humanState.ILL) && !human.isHasBeenAffected()) {
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
                        }
                    }
                }
            }
        }
    }
}

class MyVirus extends Virus {
}
