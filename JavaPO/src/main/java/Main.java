import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Random rand = new Random(); //create randomizer
        Community community = new Community(); //create community class
        Scanner scanner = new Scanner(System.in); //create scanner for user input
        System.out.println("How many people do you want in a simulation (<your value> ^2 [value more than 100 may not fit in screen])"); //print
        /**
         * Get correct value from user
         * @param SetFalse reset boolean
         * @param GetValue Wait for input from user
         * @param Check Check value is correct
         * @retrun print "vrong value" or accept it
         */
        boolean error;
        do {
            error = false;
            try {
                community.setPopulation(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
        /**
         * Creating enviroiment
         * @param create object
         * @param create healty enviroment
         * @return created enviroiment
         */
        Human[][] humans = new Human[(community.getPopulation())][(community.getPopulation())];//create scanner environment
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++)
                humans[i][j] = new Human();

        /**
         * Create virus class and give information about:
         * @param set Infection chance
         * @param set Duration(unused)
         * @param set Detection(unused)
         * @param set Reproduction(unused)
         * @return created virus
         */
        Virus virus = new Virus(2, 1, 1, 1,2);

        /**
         * Generate patient zero
         * @param generate number X
         * @param generate number Y
         * @param generate patinent zero
         * @return patient zero
         */
        int X = rand.nextInt(community.getPopulation());
        int Y = rand.nextInt(community.getPopulation());
        humans[X][Y].state = HumanState.CHORY;
        community.minusHealthy();
        community.setInfected(1);//first infected
        int day = 0;//first generation
        day = Draw.Day(day, community.getPopulation());
        Draw.DrawMap(community, humans);


        while (community.getInfected()!=0){// do while virus die
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Clear console

            /**
             * Function Draw prints information about numer of generation
             * @param Get day
             * @param Get population
             * @return Print enviroiment map
             */
            day = Draw.Day(day, community.getPopulation());

            /**
             * Checking every human, spread virus
             */
            virus.infect(community, humans);

            /**
             * Drawing map with infected people
             */
            Draw.DrawMap(community, humans);
        }

        scanner.close();
    }
}
