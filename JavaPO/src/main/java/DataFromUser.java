import java.util.Scanner;

enum dataIndex {

    POPULATION(0),
    RANGE(1),
    CHANCE(2),
    DELAY(3);

    int index;

    dataIndex(int myData) {
        this.index = myData;
    }
}
public class DataFromUser {

    /**
     * @param myData table with data
     */
    public static void dataFromUser(int[] myData) {
        Scanner scanner = new Scanner(System.in); //create scanner for user input

        System.out.println("How many people do you want in a simulation (<your value> ^2 [value more than 100 may not fit in screen])"); //print

        boolean error;
        do {
            error = false;
            try {
                myData[dataIndex.POPULATION.index]=Integer.parseInt(scanner.nextLine());
//                community.setPopulation(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
        System.out.println("How big range you want for virus [best value is between 1 and 3]"); //print
        do {
            error = false;
            try {
                myData[dataIndex.RANGE.index]=Integer.parseInt(scanner.nextLine());
//                virus.setRange(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);

        System.out.println("give infection chance [1-100%,5-50%, 10-10%][best value is 5<x<10]"); //print
        /*
         * Get correct value from user
         * @param SetFalse reset boolean
         * @param GetValue Wait for input from user
         * @param Check Check value is correct
         * @retrun print "vrong value" or accept it
         */
        do {
            error = false;
            try {
                myData[dataIndex.CHANCE.index]=Integer.parseInt(scanner.nextLine());
//                virus.setInfectionChance(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
        System.out.println("Set detection delay [after how many days it will be detected]"); //print
        do {
            error = false;
            try {
                myData[dataIndex.DELAY.index]=Integer.parseInt(scanner.nextLine());
//                virus.setDetection(Integer.parseInt(scanner.nextLine()));//get user input
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);
    }
}
