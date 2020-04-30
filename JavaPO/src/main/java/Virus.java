import java.util.Random;

public class Virus {

    public int infection_chance;
    public int duration;
    public int detection;
    public int reproduction;

    public Virus(int infection_chance, int duration, int detection, int reproduction) {
        this.infection_chance = infection_chance;
        this.duration = duration;
        this.detection = detection;
        this.reproduction = reproduction;
    }

    public static int Infect(int population, Human[][] humans, int infected, int chance) {
        Random rand = new Random();
        for (int i = 0; i < population; i++)
            for (int j = 0; j < population; j++)
                humans[i][j].hasBeenAffected = false;

        for (int i = 0; i < population; i++)
            for (int j = 0; j < population; j++) {
                if (humans[i][j].state == HumanState.CHORY && !humans[i][j].hasBeenAffected) { //finding infected
                    for (int k = 1; k < 9; k += 2) {
                        int x = i + k / 3 - 1;
                        int y = j + k % 3 - 1;
                        if ((x + 1) > 0 && (x) < population && (y + 1) > 0 && (y) < population) {
                            if (humans[x][y].state == HumanState.ZDROWY && rand.nextInt(chance) == 1) {
                                humans[x][y].state = HumanState.CHORY;
                                infected++;
                                humans[x][y].hasBeenAffected = true;
                            }
                        }
                    }
                    humans[i][j].hasBeenAffected = true;
                }
            }
        return infected;
    }
}
