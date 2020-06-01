import java.util.Random;

public class Community {
    private int population;
    private int healthy;
    private int infected;
    private int healed;
    private int removed;

    Community() {
        population = 0;
    }

    public void setPopulation(int population) throws Exception {
        if (population > 0) {
            this.population = population;
            this.infected = 0;
            this.removed = 0;
            this.healed = 0;
            this.healthy = population * population;
        } else throw new Exception(); // todo lepsza nazwa exception
    }

    public int getPopulation() {
        return population;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public void minusInfected() {
        infected--;
    }

    public void plusInfected() {
        infected++;
    }

    public int getRemoved() {
        return removed;
    }

    public void plusRemoved() {
        removed++;
    }

    public int getHealed() {
        return healed;
    }

    public void plusHealed() {
        healed++;
    }

    public int getHealthy() {
        return healthy;
    }

    public void minusHealthy() {
        healthy--;
    }


    public void infectset(Human[][] humans) {
        Random rand = new Random();
        int X = rand.nextInt(population);
        int Y = rand.nextInt(population);
        humans[X][Y].setState(HumanState.ILL);
        minusHealthy();
        setInfected(1);//first infected
    }


}
