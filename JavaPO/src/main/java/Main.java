import javax.xml.crypto.Data;
import java.util.*;

/**
 * <h1>Virus simulation</h1>
 * This program simulate virus generation and spread
 * for parameters scanned from the user.
 *
 * @author Maciej Byczko
 * @author Michal Maziec
 * @version 2.2
 * @since 18.04.2020
 */

public class Main {

    private static int day;
    private static Set<Location> infectedLocations = new HashSet<>();
    private static final Output consoleOutput = new Output();
    private static final DataFromUser inputData = new DataFromUser();

    private static void dayZero(Community community) {
        day = 0;
        infectFirstHuman(community);
        consoleOutput.day(community, day);
        consoleOutput.drawMapAndStats(community);
        day++;
    }

    private static void simulation(Community community, SimulationProperties myData, Virus virus) {
        CommunityStats stats = new CommunityStats(community);
        while (stats.getInfected() != 0) {// do while virus die
            consoleOutput.day(community, day);
            infection(community, myData, virus);
            consoleOutput.drawMapAndStats(community);
            stats = new CommunityStats(community);
        }
        System.out.println("Virus has died, ending simulation...");
    }

    /**
     * @param community genreated community
     * @param myData    data taken from user
     * @param virus     chosen virus
     *                  while which continues until the virus is alive
     * @see Virus here you have infect function
     * @see Output here you have all drawing functions for map and stats
     */
    static void infection(Community community, SimulationProperties myData, Virus virus) {
        day++;
        infectedLocations = virus.infect(community, myData, infectedLocations);
    }

    public static void infectFirstHuman(Community community) {
        Location firstInfectedLocation = community.getRandomLocation();
        infectedLocations.add(firstInfectedLocation);
        community.setFirstInfected(firstInfectedLocation);
    }

    private static void firstVirus(Community community, SimulationProperties myData) {
        dayZero(community);
        Virus virus = new BodyVirus();
        simulation(community, myData, virus);
    }

    private static void secondVirus(Community community, SimulationProperties myData) {
        dayZero(community);
        Virus virus = new SpiritVirus();
        simulation(community, myData, virus);
    }

    private static Map<Location, Human> generateCommunity(SimulationProperties myData) {
        Map<Location, Human> communityMap = new HashMap<>();

        for (int i = 0; i < myData.getPopulation(); i++) {
            for (int j = 0; j < myData.getPopulation(); j++) {
                communityMap.put(new Location(i, j), new Human());
            }
        }
        return communityMap;
    }

    /**
     * <h1>Main function</h1>
     *
     * @param args -_-
     */
    public static void main(String[] args) {

        SimulationProperties myData = inputData.dataFromUser();
//        SimulationProperties myData = new SimulationProperties(3, 2, 50, 2);

        Community community = new Community(generateCommunity(myData));
        community.setSqrtPopulation(myData.getPopulation());
        firstVirus(community, myData);

        community = new Community(generateCommunity(myData));
        community.setSqrtPopulation(myData.getPopulation());

        secondVirus(community, myData);

    }


}
