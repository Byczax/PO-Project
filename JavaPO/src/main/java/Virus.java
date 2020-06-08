import java.util.Random;

public abstract class Virus {

    private int infectionChance;
    private int detection;
    private int range;


    public void setInfectionChance(int infection_chance) {
        this.infectionChance = infection_chance;
    }

    public void setDetection(int detection) {
        this.detection = detection;
    }

    public void setRange(int range) {
        this.range = range;
    }


    public void infect(Community community, Human[][] humans) {

        resetFlagsInfected(community, humans);
        healOrKillChance(community);
        spreadVirus(community, humans);
        sumUpStatsVirus(community, humans);

    }

    /**
     * reseting flags
     *
     * @param community get community
     * @param humans    get humans
     */
    private void resetFlagsInfected(Community community, Human[][] humans) {
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++)
                humans[i][j].setHasBeenAffected(false);
    }

    private void healOrKillChance(Community community) {
        Random rand = new Random();
        int population = community.getSqrtPopulation();
        for (int i = 0; i < population; i++)
            for (int j = 0; j < population; j++) {
                Location location = new Location(i,j);

                if (community.getHumanByHouse().get(location).getIllnessTime() >= detection &&
                    community.getHumanByHouse().get(location).getState().getState() == humanState.ILL.state) {
                    switch (rand.nextInt(3)) {
                        case 0:
                            community.getHumanByHouse().get(location).getState().setIntState(humanState.CURED.state);
                            break;
                        case 1:
                            community.getHumanByHouse().get(location).getState().setIntState(humanState.REMOVED.state);
                            break;
                        default:
                            break;
                    }
                }
            }
    }

    void spreadVirus(Community community, Human[][] humans) {
        Random rand = new Random();
        for (int i = 0; i < community.getPopulation(); i++) {
            for (int j = 0; j < community.getPopulation(); j++) {
                if (humans[i][j].getState() == humanState.ILL && !humans[i][j].isHasBeenAffected()) { //finding infected
                    humans[i][j].setHasBeenAffected(true);
                    humans[i][j].plusIlnessTime();

                for (int k = -range; k <= range; k++)
                    for (int l = -range; l <= range; l++) {
                        int x = i + k;
                        int y = j + l;
                        if (Math.abs(k) + Math.abs(l) <= range)
                            if ((x + 1) > 0 && (x) < community.getPopulation() && (y + 1) > 0 && (y) < community.getPopulation())
                                if (humans[x][y].getState() == humanState.HEALTHY && (rand.nextInt(10) + 1) >= infectionChance) {
                                    humans[x][y].setState(humanState.ILL);
                                    humans[x][y].setHasBeenAffected(true);
                                    humans[x][y].setIllnessTime(0);
//                                        community.plusInfected();
//                                        community.minusHealthy();
                }
            }

                    }
            }
        }
    }

    void plusIllTime(Community community, Human[][] humans, int i, int j) {
        
    }

    void sumUpStatsVirus(Community community, Human[][] humans) {
        community.setHealthy(0);
        community.setInfected(0);
        community.setHealed(0);
        community.setRemoved(0);
        for (int i = 0; i < community.getPopulation(); i++) {
            for (int j = 0; j < community.getPopulation(); j++) {
                if (humans[i][j].getState() == humanState.HEALTHY)
                    community.plusHealthy();
                else if (humans[i][j].getState() == humanState.ILL)
                    community.plusInfected();
                else if (humans[i][j].getState() == humanState.CURED)
                    community.plusHealed();
                else if (humans[i][j].getState() == humanState.REMOVED)
                    community.plusRemoved();
            }
        }
    }
}


class MyVirus extends Virus {
}
