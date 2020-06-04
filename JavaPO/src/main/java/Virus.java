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
        healOrKillChance(community, humans);
        spreadVirus(community, humans);

    }

    /** reseting flags
     * @param community get community
     * @param humans get humans
     */
    private void resetFlagsInfected(Community community, Human[][] humans) {
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++)
                humans[i][j].setHasBeenAffected(false);
    }

    private void healOrKillChance(Community community, Human[][] humans) {
        Random rand = new Random();
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++) {
                if (humans[i][j].getIllnessTime() >= detection && humans[i][j].getState() == humanState.ILL) {
                    switch (rand.nextInt(3)) {
                        case 0:
                            humans[i][j].setState(humanState.CURED);
                            community.minusInfected();
                            community.plusHealed();
                            break;
                        case 1:
                            humans[i][j].setState(humanState.REMOVED);
                            community.minusInfected();
                            community.plusRemoved();
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
            for (int j = 0; j < community.getPopulation(); j++)
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
                                        community.plusInfected();
                                        community.minusHealthy();
                                    }

                        }
                }
        }
    }
}

class MyVirus extends Virus {
}
