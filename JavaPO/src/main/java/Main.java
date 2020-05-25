import java.util.ArrayList;


public class Main {
    private static int duration;
    private static int day = 0;

    static void Infection(Community community, Human[][] humans, Virus virus) {
        while (community.getInfected() != 0) {// do while virus die
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Clear console

            /**
             * Function Draw prints information about numer of generation
             * @param Get day
             * @param Get population
             * @return Print enviroiment map
             */
            Draw.Day(community,day);
            day++;

            /**
             * Checking every human, spread virus
             * @param get community
             * @param get humans
             * @return infected and healed
             */
            virus.infect(community, humans);

            /**
             * Drawing map with infected people
             * @param get community
             * @param get humans
             * @return map
             */
            Draw.DrawMap(community, humans);
        }
    }

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

        Community community = new Community(); //create community class
        /**
         * Create virus class and give information about:
         * @param set Infection chance
         * @param set Duration(unused)
         * @param set Detection(unused)
         * @param set Reproduction(unused)
         * @return created virus
         */

        Virus virus = new MyVirus();

//        ArrayList<Human> humans = new ArrayList<Human>(community.getPopulation()*community.getPopulation());
//
////        Functions.GenerateHumans(community, humans);
//        for (int i = 0; i < community.getPopulation(); i++)
//            for (int j = 0; j < community.getPopulation(); j++)
//                humans.add(new Human(i,j));
        GUI.DataFromUser(community, virus);

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

        Infection(community, humans, virus);
    }
}
