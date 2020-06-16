import java.util.Map;
import java.util.Random;

public class Community {

    private int sqrtPopulation;


    private final Map<Location, Human> humanByHouse;

    Community(Map<Location, Human> humanByHouse) {
        this.humanByHouse = humanByHouse;
        sqrtPopulation = (int) Math.sqrt(humanByHouse.values().size());
    }

//    public int getPopulation() {
//        return humanByHouse.values().size();
//    }



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
     * @return infected location
     * @see Random
     */
    public Location getRandomLocation() {
        Random rand = new Random();
        int X = rand.nextInt(sqrtPopulation);
        int Y = rand.nextInt(sqrtPopulation);
        return new Location(X, Y);
    }

    /**
     * setting first infected
     * @param location generated location
     */
    public void setFirstInfected(Location location) {
        var human = getHumanByHouse().get(location);
        human.setState(humanState.INFECTED);
    }

}
