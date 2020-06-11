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

    /**
     * @param community genreated community
     * @param myData    data taken from user
     * @param virus     chosen virus
     *                  while which continues until the virus is alive
     * @see Virus here you have infect function
     * @see Draw here you have all drawing functions for map and stats
     */
    static void infection(Community community, SimulationProperties myData, Virus virus) {
        while (community.getInfected() != 0) {// do while virus die

            Draw.day(community, day);
            day++;
            community = virus.infect(community, myData, infectedLocations);
            Draw.drawMapAndStats(community);
        }
        System.out.println("None virus left, ending simulation...");

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

        infectedLocations.add(community.infectSet());

        Draw.day(community, day);
        Draw.drawMapAndStats(community);
        day++;

        Virus virus = new BodyVirus();

        infection(community, myData, virus);
    }
}
