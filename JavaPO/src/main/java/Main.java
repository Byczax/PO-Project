import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

        Random rand = new Random();
        Community community = new Community();
        Scanner population = new Scanner(System.in);
        System.out.println("How many people you want in simulation (<your value> ^2 [value more than 50 not fit in screen])");
        community.population = population.nextInt();
        
        int[][] tablica = new int [(community.population)+2][(community.population)+2];
        Virus virus = new Virus(2, 1, 1, 1);
        for (int[] ints : tablica)
            Arrays.fill(ints, 0);
        int X = rand.nextInt(community.population-2)+1;
        int Y = rand.nextInt(community.population-2)+1;
        tablica[X][Y]=1;
        community.infected = 1;
        int day = 1;
        while (community.infected<(community.population)*(community.population)) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print("\t");
            for(int i=0;i<=(community.population/2);i++)
            System.out.print(" ");
            System.out.println("\033[37;1mDay:"+day+"\033[0m");
            day++;
            for(int i=1;i<community.population+1;i++){
                for(int j=1;j<community.population+1;j++){
                    if(tablica[i][j]==1){

                        for(int k=1;k<=9;k+=2)
                        if(tablica[i + k/3 -1][j + k%3 -1]==0)
                        if (rand.nextInt(virus.infection_chance)==1) {
                            tablica[i + k/3 -1][j + k%3 -1]=1;
                            if(i-1!=0)
                            {
                                community.infected++;
                            }
                        }

                            // if (tablica[i-1][j]==0) {
                            //     if (rand.nextInt(virus.infection_chance)==1) {
                            //         tablica[i-1][j]=1;
                            //         if(i-1!=0)
                            //         {
                            //             community.infected++;
                            //         }
                            //     }
                            // }

                            // if (tablica[i+1][j]==0) {
                            //     if (rand.nextInt(virus.infection_chance)==1) {
                            //         tablica[i+1][j]=1;
                            //         if(i+1!=community.population+1)
                            //         {
                            //             community.infected++;
                            //         }
                            //         }
                            //     }

                            // if (tablica[i][j-1]==0) {
                            //     if (rand.nextInt(virus.infection_chance)==1) {
                            //         tablica[i][j-1]=1;
                            //         if(j-1!=0)
                            //         {
                            //             community.infected++;
                            //         }
                            //     }
                            // }

                            // if (tablica[i][j+1]==0) {
                            //     if (rand.nextInt(virus.infection_chance)==1) {
                            //         tablica[i][j+1]=1;
                            //         if(j+1!=community.population+1)
                            //         {
                            //             community.infected++;
                            //         }
                            //     }
                            // }
                    }
                }        
            }
            for(int i=1;i<community.population+1;i++){
                System.out.print("\t");
                for(int j=1;j<community.population+1;j++){
                    if(tablica[i][j]==1)
                    {
                        System.out.print("\033[31;1m#\033[0m ");
                    }
                    else
                        System.out.print("\033[32;1mO\033[0m ");
                }
                System.out.print("\n");
            }
            System.out.println("Healthy: "+(community.population*community.population-community.infected)+"\t"+"Infected: "+community.infected);
            System.out.println("Press Enter To Continue To The Next Day...");
            new java.util.Scanner(System.in).nextLine();
            // Thread.sleep(1000);
        }
        
        population.close();
    }
}
