import java.util.Random;

public class Virus {

    private int infection_chance;
    private int duration;
    private int detection;
    private int reproduction;
    private int range;

//    public Virus(int infection_chance, int duration, int detection, int reproduction, int range) {
//        this.infection_chance = infection_chance;
//        this.duration = duration;
//        this.detection = detection;
//        this.reproduction = reproduction;
//        this.range = range;
//    }


    public int getInfection_chance() {
        return infection_chance;
    }

    public void setInfection_chance(int infection_chance) {
        this.infection_chance = infection_chance;
    }

    public void setDetection(int detection) {
        this.detection = detection;
    }

    public int getDetection() {
        return detection;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void infect(Community community, Human[][] humans) {
        Random rand = new Random();

        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++) {
                humans[i][j].hasBeenAffected = false;

                if (humans[i][j].ilnessTime >= detection && humans[i][j].state == HumanState.CHORY) {
                    switch (rand.nextInt(infection_chance+1)) {
                        case 0:
                            humans[i][j].state = HumanState.WYLECZONY;
                            community.minusInfected();
                            community.plusHealed();
                            break;
                        case 1:
                            humans[i][j].state = HumanState.USUNIETY;
                            community.minusInfected();
                            community.plusRemoved();
                            break;
                        case 2:
                        case 3:
                        case 4:
                            break;
                    }
                }

            }
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++)
                if (humans[i][j].state == HumanState.CHORY && !humans[i][j].hasBeenAffected) { //finding infected
                    humans[i][j].hasBeenAffected = true;
                    humans[i][j].ilnessTime++;
                    for (int k = -range; k <= range; k++)
                        for (int l = -range; l <= range; l++) {
                            int x = i + k;
                            int y = j + l;
                            if (Math.abs(k) + Math.abs(l) <= range)
                                if ((x + 1) > 0 && (x) < community.getPopulation() && (y + 1) > 0 && (y) < community.getPopulation())
                                    if (humans[x][y].state == HumanState.ZDROWY && (rand.nextInt(10)+1) >= infection_chance) {
                                        humans[x][y].state = HumanState.CHORY;
                                        humans[x][y].hasBeenAffected = true;
                                        community.plusInfected();
                                        community.minusHealthy();
                                    }
                        }
                }
    }
}
