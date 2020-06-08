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
        int population = community.getSqrtPopulation();
        for (int i = 0; i < population; i++) {
            for (int j = 0; j < population; j++) {
                Location location = new Location(i, j);

                if (community.getHumanByHouse().get(location).getIllnessTime() >= myData.getDelay() &&
                        community.getHumanByHouse().get(location).getState().getState() == humanState.ILL.state) {
                    switch (rand.nextInt(3)) {
                        case 0:
                            // todo poprawne przypisanie wartości
                            community.getHumanByHouse().get(location).getState().setIntState(humanState.CURED.state);
                            break;
                        case 1:
                            // todo poprawne przypisanie wartości
                            community.getHumanByHouse().get(location).getState().setIntState(humanState.REMOVED.state);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    void spreadVirus(Community community, SimulationProperties myData) {
        for (int i = 0; i < community.getSqrtPopulation(); i++) {
            for (int j = 0; j < community.getSqrtPopulation(); j++) {
                Location location = new Location(i, j);
                if (community.getHumanByHouse().get(location).getState().getState() == humanState.ILL.state &&
                        !community.getHumanByHouse().get(location).isHasBeenAffected()) { //finding infected
                    community.getHumanByHouse().get(location).setHasBeenAffected(true);
                    community.getHumanByHouse().get(location).plusIlnessTime();
                    int range = myData.getRange();
                    for (int k = -range; k <= range; k++) {
                        for (int l = -range; l <= range; l++) {
                            int x = i + k;
                            int y = j + l;
                            if (Math.abs(k) + Math.abs(l) <= range) {
                                if ((x + 1) > 0 && (x) < community.getSqrtPopulation() && (y + 1) > 0 && (y) < community.getSqrtPopulation()) {
                                    if (community.getHumanByHouse().get(location).getState().equals(humanState.HEALTHY)
//                                            &&
//                                            (rand.nextInt(10) + 1) >= myData.getInfectionChance()
                                    ) {

                                        //todo poprawne przypisanie wartości
                                        Location location2 = new Location(x, y);
                                        community.getHumanByHouse().get(location2).setState(humanState.ILL);
                                        community.getHumanByHouse().get(location2).setHasBeenAffected(true);
                                        community.getHumanByHouse().get(location2).setIllnessTime(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

class MyVirus extends Virus {
}
