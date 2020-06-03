import java.util.Map;

public class Community {
    private final Map<Location, Human> humanByHouse;

    Community(Map<Location, Human> humanByHouse) {
        this.humanByHouse = humanByHouse;
    }

    public int getPopulation() {
        return humanByHouse.values().size();
    }


    Neighbors getNeighborsFor(Human human) {
        // implement, this may be used by virus somehow
        return Neighbors.empty();
    }


    public int getInfectedCount() {
        int infected = 0;
        for (Human human : humanByHouse.values()) {
            if (human.getState() == HumanState.ILL)
                infected++;
        }
        return infected;
    }

    public int getHealthy() {

        // jw
        return 0;
    }

    public Infection infect(Location location, Virus virus) {
        Human human = humanByHouse.get(location);
        return new Infection(human, virus.daysToDie());
    }

}
