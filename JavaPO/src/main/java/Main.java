import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

        Random rand = new Random(); //create randomizer
        Community community = new Community(0); //create community class
        Scanner population = new Scanner(System.in); //create scaner for user input
        System.out.println("How many people you want in simulation (<your value> ^2 [value more than 50 not fit in screen])"); //print
        while(community.population<1)
        {
            community.population = population.nextInt();//get user input
            if(community.population<1)
            System.out.println("Wrong value, enter your value again");
        }

        int[][] tablica = new int [(community.population)][(community.population)];//create population enviroment

        /**
         * Create virus class and give information about:
         * Infection chance
         * Duration(unused)
         * Detection(unused)
         * Reproduction(unused)
         */
        Virus virus = new Virus(2, 1, 1, 1);

        for (int[] ints : tablica)//clear enviroment
            Arrays.fill(ints, 0); 

        /** 
         * Generate patient zero
        */
        int X = rand.nextInt(community.population);
        int Y = rand.nextInt(community.population);
        tablica[X][Y]=1;

        community.infected = 1;//first infected
        int day = 1;//first generation

        while (community.infected<(community.population)*(community.population))// 
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Clear console

            /**
             * Function Draw prints information about numer of generation
             */
            day=Draw.Day(day, community.population);

            /**
             * Chcecking every human, spread virus
             */
            community.infected = Virus.Infect(community.population, tablica, community.infected,virus.infection_chance);

            /**
             * Drawing map with infected people
             */
            Draw.DrawMap(community.population, tablica,community.infected);
        }
        
        population.close();
    }
}
