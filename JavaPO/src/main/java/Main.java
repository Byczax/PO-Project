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

    private static int day = 0;
    private static final Set<Location> infectedLocations = new HashSet<>();

    private static void dayZero(Community community) {
        infectFirstHuman(community);


        Draw.day(community, day);
        Draw.drawMapAndStats(community);
        day++;
    }

    private static void simulation(Community community, SimulationProperties myData, Virus virus) {
        while (community.getInfected() != 0) {// do while virus die
            Draw.day(community, day);
            infection(community, myData, virus);
            Draw.drawMapAndStats(community);
        }
        System.out.println("None virus left, ending simulation...");
    }

    /**
     * @param community genreated community
     * @param myData    data taken from user
     * @param virus     chosen virus
     *                  while which continues until the virus is alive
     * @see Virus here you have infect function
     * @see Draw here you have all drawing functions for map and stats
     */
    static void infection(Community community, SimulationProperties myData, Virus virus) {
        day++;
        virus.infect(community, myData, infectedLocations);
    }

    public static void infectFirstHuman(Community community) {
        Location firstInfectedLocation = community.getRandomLocation();
        infectedLocations.add(firstInfectedLocation);
        community.setFirstInfected(firstInfectedLocation);
    }


    /**
     * <h1>Main function</h1>
     *
     * @param args -_-
     */
    public static void main(String[] args) {

        SimulationProperties myData = DataFromUser.dataFromUser();
//        SimulationProperties myData = new SimulationProperties(3, 2, 1, 2);
        Map<Location, Human> communityMap = new HashMap<>();
        for (int i = 0; i < myData.getPopulation(); i++) {
            for (int j = 0; j < myData.getPopulation(); j++) {
                communityMap.put(new Location(i, j), new Human());
            }
        }

        Community community = new Community(communityMap);
        community.setSqrtPopulation(myData.getPopulation());

        dayZero(community);

        Virus virus = new BodyVirus();

        simulation(community, myData, virus);
    }


}
