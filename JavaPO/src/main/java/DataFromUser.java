import java.util.Scanner;

public class DataFromUser {
    private final static Scanner scanner = new Scanner(System.in);

    /**
     * @param text information for user
     * @return value taken from the user
     * @see SimulationProperties here we have all text informations
     */
    private static int readDataFromUser(String text) {
        System.out.println(text);
        int x = 0;
        boolean error;
        do {
            error = false;
            try {
                x = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                error = true;
                System.out.println("Wrong value, enter your value again");
            }
        } while (error);

        return x;
    }


    /**
     * function that gets values from user
     *
     * @return population, range, chance, delay
     */
    public static SimulationProperties dataFromUser() {

        int population = readDataFromUser("How many people do you want in a simulation (<your value> ^2 [value more than 100 may not fit in screen])");
        int range = readDataFromUser("How big range you want for virus [best value is between 1 and 3]");
        int chance = readDataFromUser("give infection chance [100-100%,50-50%, 10-10%][best value is 50<x<100]");
        int delay = readDataFromUser("Set detection delay [after how many days it will be detected]");

        return new SimulationProperties(population, range, chance, delay);
    }
}
