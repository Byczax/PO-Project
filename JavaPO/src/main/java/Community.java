import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

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

    /**
     * Set first infected on random place
     *
     * @see Random
     */
    public void infectSet(Set<Location> infectedLocations) {
        Random rand = new Random();
        int X = rand.nextInt(sqrtPopulation);
        int Y = rand.nextInt(sqrtPopulation);
        Location location = new Location(X, Y);
        var human = getHumanByHouse().get(location);
        human.setState(humanState.ILL);
        plusInfected();
        setHealthy(getPopulation() - 1);
        infectedLocations.add(location);
    }

    /**
     * Calculate statistics
     *
     * @param community database
     *                  resetting all counters and count all again
     */
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

    /**
     * @param community database
     *                  resets infection flags in all people
     * @see Human
     */
    public static void resetFlagsInfected(Community community) {
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
        }
    }

}
