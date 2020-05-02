import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Random rand = new Random(); //create randomizer
        Community community = new Community(); //create community class
        Scanner scanner = new Scanner(System.in); //create scaner for user input
        System.out.println("How many people do you want in a simulation (<your value> ^2 [value more than 100 not fit in screen])"); //print
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

        Human[][] humans = new Human[(community.getPopulation())][(community.getPopulation())];//create scanner enviroment
//        int[][] humans = new int[(community.getPopulation())][(community.getPopulation())];//create scanner enviroment
        for (int i = 0; i < community.getPopulation(); i++)
            for (int j = 0; j < community.getPopulation(); j++)
                humans[i][j]= new Human();

        /**
         * Create virus class and give information about:
         * Infection chance
         * Duration(unused)
         * Detection(unused)
         * Reproduction(unused)
         */
        Virus virus = new Virus(2, 1, 1, 1);

        /**
         * Generate patient zero
         */
        int X = rand.nextInt(community.getPopulation());
        int Y = rand.nextInt(community.getPopulation());
        humans[X][Y].state = HumanState.CHORY;

        community.setInfected(1);//first infected
        int day = 0;//first generation
        day = Draw.Day(day, community.getPopulation());
        Draw.DrawMap(community.getPopulation(), humans, community.getInfected());


        while (community.getInfected() < (community.getPopulation()) * (community.getPopulation()))//
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Clear console

            /**
             * Function Draw prints information about numer of generation
             */
            day = Draw.Day(day, community.getPopulation());

            /**
             * Chcecking every human, spread virus
             */
            community.setInfected(Virus.Infect(community.getPopulation(), humans, community.getInfected(), virus.infection_chance));

            /**
             * Drawing map with infected people
             */
            Draw.DrawMap(community.getPopulation(), humans, community.getInfected());
        }
        
        scanner.close();
    }
}
