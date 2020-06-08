import java.util.Map;
import java.util.Random;

public class Community {


    private int sqrtPopulation;
    private int healthy;
    private int infected;
    private int healed;
    private int removed;

    private final Map<Location, Human> humanByHouse;
    Community(Map<Location, Human> humanByHouse) {
        this.humanByHouse = humanByHouse;
    }
    public int getPopulation() {
        return humanByHouse.values().size();
    }



//    Community() {
//        population = 0;
//    }

//    public void setPopulation(int population) throws Exception {
//        if (population > 0) {
//            this.population = population;
//            this.infected = 0;
//            this.removed = 0;
//            this.healed = 0;
//            this.healthy = population * population;
//        } else throw new Exception(); // todo lepsza nazwa exception
//    }

//    public int getPopulation() {
//        return population;
//    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
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

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
    public void plusHealthy() {
        healthy++;
    }

    public void setHealed(int healed) {
        this.healed = healed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public void infectSet(Community community) {
        Random rand = new Random();
        int X = rand.nextInt(community.getSqrtPopulation());
        int Y = rand.nextInt(community.getSqrtPopulation());
        Location location = new Location(X,Y);
        community.getHumanByHouse().get(location).setState(humanState.ILL);
    }

    public Map<Location, Human> getHumanByHouse() {
        return humanByHouse;
    }

    public int getSqrtPopulation() {
        return sqrtPopulation;
    }

    public void setSqrtPopulation(int sqrtPopulation) {
        this.sqrtPopulation = sqrtPopulation;
    }
}
