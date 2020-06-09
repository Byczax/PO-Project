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

    public Map<Location, Human> getHumanByHouse() {
        return humanByHouse;
    }

    public int getSqrtPopulation() {
        return sqrtPopulation;
    }

    public void setSqrtPopulation(int sqrtPopulation) {
        this.sqrtPopulation = sqrtPopulation;
    }

    public void infectSet(Community community) {
        Random rand = new Random();
        int X = rand.nextInt(community.getSqrtPopulation());
        int Y = rand.nextInt(community.getSqrtPopulation());
        Location location = new Location(X, Y);
        var human = community.getHumanByHouse().get(location);
        human.setState(humanState.ILL);
        community.plusInfected();
        community.setHealthy(community.getPopulation() - 1);
    }

    public static void sumUpStatsVirus(Community community) {

        community.setHealthy(0);
        community.setInfected(0);
        community.setHealed(0);
        community.setRemoved(0);
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            if (human.getState().equals(humanState.HEALTHY)) {
                community.plusHealthy();
            } else if (human.getState().equals(humanState.ILL)) {
                community.plusInfected();
            } else if (human.getState().equals(humanState.CURED)) {
                community.plusHealed();
            } else if (human.getState().equals(humanState.REMOVED)) {
                community.plusRemoved();
            }
        }
    }

    public static void resetFlagsInfected(Community community) {
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            human.setHasBeenAffected(false);
        }
    }

}
