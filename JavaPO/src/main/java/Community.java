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


    public void infectSet(Community community) {
        Random rand = new Random();
        int X = rand.nextInt(community.getSqrtPopulation());
        int Y = rand.nextInt(community.getSqrtPopulation());
        Location location = new Location(X, Y);
        // todo poprawne przypisanie wartości
        System.out.println(community.getHumanByHouse().keySet());
        System.out.println(location);
        var human = community.getHumanByHouse().get(location);
        human.setState(humanState.ILL);
        community.plusInfected();
        community.setHealthy(community.getPopulation() - 1);
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

    public static void sumUpStatsVirus(Community community) {
        community.setHealthy(0);
        community.setInfected(0);
        community.setHealed(0);
        community.setRemoved(0);

        for (int i = 0; i < community.getSqrtPopulation(); i++) {
            for (int j = 0; j < community.getSqrtPopulation(); j++) {
                Location location = new Location(i, j);
                if (community.getHumanByHouse().get(location).getState().getState() == humanState.HEALTHY.state)
                    community.plusHealthy();
                else if (community.getHumanByHouse().get(location).getState().getState() == humanState.ILL.state)
                    community.plusInfected();
                else if (community.getHumanByHouse().get(location).getState().getState() == humanState.CURED.state)
                    community.plusHealed();
                else if (community.getHumanByHouse().get(location).getState().getState() == humanState.REMOVED.state)
                    community.plusRemoved();
            }
        }
    }

    public static void resetFlagsInfected(Community community) {
        for (int i = 0; i < community.getSqrtPopulation(); i++) {
            for (int j = 0; j < community.getSqrtPopulation(); j++) {
                Location location = new Location(i, j);
                var human = community.getHumanByHouse().get(location);
                human.setHasBeenAffected(false);
            }
        }
    }

}
