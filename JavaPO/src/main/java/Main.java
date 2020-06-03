import java.util.ArrayList;
import java.util.List;


public class Main {
    private static int duration;
    private static int day = 0;

    private final List<Infection> infections = new ArrayList<>();

    void Infection(Community community, Human[][] humans, Virus virus) {
        while (community.getInfectedCount() != 0) {// do while virus die
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Clear console

            // remove static classes/fields
            Draw.Day(community, day);
            day++;

            InfectedLocations infectedLocations = virus.spread(community); // there even might be multipe viruses
            for (Location location : infectedLocations.getLocations()) {
                Infection infection = community.infect(location, virus); // this way we might even consider multiple Humans at location
                infections.add(infection);
            }

            for (Infection infection : infections) {
                infection.nextDay();
                if (infection.isSevere())
                    infection.getHuman().markAsDead();
            }
            Draw.DrawMap(community, humans);
        }
    }

    // extract
    static void GenerateHumans(Community community, Human[][] humans) {
        /**
         * Creating enviroiment
         * @param create object
         * @param create healty enviroment
         * @return created enviroiment
         */
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++)
                humans[i][j] = new Human();
    }

    public static void main(String[] args) {

        Community community = new Community(null); //create community class
        /**
         * Create virus class and give information about:
         * @param set Infection chance
         * @param set Duration(unused)
         * @param set Detection(unused)
         * @param set Reproduction(unused)
         * @return created virus
         */

        Virus virus; // ... actual vius

//        ArrayList<Human> humans = new ArrayList<Human>(community.getPopulation()*community.getPopulation());
//
////        Functions.GenerateHumans(community, humans);
//        for (int i = 0; i < community.getPopulation(); i++)
//            for (int j = 0; j < community.getPopulation(); j++)
//                humans.add(new Human(i,j));
        GUI.DataFromUser(community, virus); // gui should be class returning actual data object

        // Community/humans creation should be delegated to another class
        Human[][] humans = new Human[(community.getPopulation())][(community.getPopulation())];//create scanner environment

        GenerateHumans(community, humans);
//        for (int i = 0; i < community.getPopulation(); i++)
//            for (int j = 0; j < community.getPopulation(); j++)
//                humans[i][j] = new Human();


        /**
         Generate patient zero
         @param generate number X
          * @param generate number Y
         * @param generate patinent zero
         * @return patient zero
         */
        community.infectset(humans);
        Draw.Day(community,day);
        Draw.DrawMap(community, humans);
        day++;

        Infection(community, humans, concreteVirus);
    }
}
