import java.util.Random;

public class Virus {

    public int infection_chance;
    public int duration;
    public int detection;
    public int reproduction;
    public int range;

    public Virus(int infection_chance, int duration, int detection, int reproduction, int range) {
        this.infection_chance = infection_chance;
        this.duration = duration;
        this.detection = detection;
        this.reproduction = reproduction;
        this.range = range;
    }


    public static int Infect(int population, Human[][] humans, int infected, int removed, int healed, int chance, int radius) {
        Random rand = new Random();
        for (int i = 0; i < population; i++)
            for (int j = 0; j < population; j++) {
                humans[i][j].hasBeenAffected = false;

                if (humans[i][j].ilnessTime > 1 && humans[i][j].state == HumanState.CHORY) {
                    switch (rand.nextInt(chance)) {
                        case 0:
                            humans[i][j].state = HumanState.WYLECZONY;
                            infected--;
                            healed++;
                            break;
                        case 1:
                            humans[i][j].state = HumanState.USUNIETY;
                            infected--;
                            removed++;
                            break;
                        case 2:
                        case 3:
                        case 4:
                            break;
                    }
                }

            }
        for (int i = 0; i < population; i++)
            for (int j = 0; j < population; j++)
                if (humans[i][j].state == HumanState.CHORY && !humans[i][j].hasBeenAffected) { //finding infected
                    humans[i][j].hasBeenAffected = true;
                    humans[i][j].ilnessTime++;
                    for (int k = -radius; k <= radius; k++)
                        for (int l = -radius; l <= radius; l++) {
                            int x = i + k;
                            int y = j + l;
                            if (Math.abs(k) + Math.abs(l) <= radius)
                                if ((x + 1) > 0 && (x) < population && (y + 1) > 0 && (y) < population)
                                    if (humans[x][y].state == HumanState.ZDROWY && rand.nextInt(chance) == 1) {
                                        humans[x][y].state = HumanState.CHORY;
                                        humans[x][y].hasBeenAffected = true;
                                        infected++;
                                    }
                        }
                }
        return infected;
    }

    /*public static int RorH(int population, Human[][] humans, int infected, int removed, int healed, int chance) {
        Random rand = new Random();
        for (int i = 0; i < population; i++)
            for (int j = 0; j < population; j++) {
                humans[i][j].hasBeenAffected = false;

                if (humans[i][j].ilnessTime > 1 && humans[i][j].state == HumanState.CHORY) {
                    switch (rand.nextInt(chance)) {
                        case 0:
                            humans[i][j].state = HumanState.WYLECZONY;
                            infected--;
                            healed++;
                            break;
                        case 1:
                            humans[i][j].state = HumanState.USUNIETY;
                            infected--;
                            removed++;
                            break;
                        case 2:
                        case 3:
                        case 4:
                            break;
                    }
                }
            }
        return 0;
    }*/
}
