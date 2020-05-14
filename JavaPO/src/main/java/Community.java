import java.util.Random;
public class Community {
    private int population;
    private int healthy;
    private int infected;
    private int healed;
    private int removed;
    private int suspect;
    private int isolated;
    private int duration;
    private int day;
    private boolean ready;

    Community() {
        population = 0;
    }

    public void setPopulation(int population) throws Exception {
        if (population > 0) {
            this.population = population;
            this.infected = 0;
            this.removed = 0;
            this.isolated = 0;
            this.duration = 0;
            this.healed = 0;
            this.healthy = population*population;
        } else throw new Exception(); // todo lepsza nazwa exception
    }

    public int getPopulation() {
        return population;
    }

    public int getSuspect() {
        return suspect;
    }

    public void setSuspect(int suspect) {
        this.suspect = suspect;
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

    public void setRemoved(int removed) {
        this.removed = removed;
    }
    public void plusRemoved() {
        removed++;
    }

    public int getIsolated() {
        return isolated;
    }

    public void setIsolated(int isolated) {
        this.isolated = isolated;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getHealed() {
        return healed;
    }

    public void setHealed(int healed) {
        this.healed = healed;
    }
    public void plusHealed() {
        healed++;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
    public void minusHealthy() {
        healthy--;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void plusDay() {
        day++;
    }


    public void infectset(Human[][] humans){
        Random rand = new Random();
        int X = rand.nextInt(population);
        int Y = rand.nextInt(population);
        humans[X][Y].state = HumanState.CHORY;
        minusHealthy();
        setInfected(1);//first infected
        setDay(0);//first generation

    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public boolean getReady() {
        return ready;
    }

}
