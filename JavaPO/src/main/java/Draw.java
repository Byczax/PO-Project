
public class Draw {


    public static void day(Community community, int day) {
        for (int i = 0; i <= (community.getPopulation() / 2); i++) {
            System.out.print("  ");
        }
        System.out.println("\033[37;1mDay:" + day + "\033[0m");
    }

    /**
     * <h1>Drawing function</h1>
     * This function get value from humans to draw
     * state corresponding color for every human
     * <p>
     * after drawing map, this function prints all stats about all humans
     *
     * @param community get community values
     * @param humans    get humans
     */
    public static void drawMap(Community community, Human[][] humans) {
        for (int i = 0; i < community.getPopulation(); i++) {
            System.out.print("\t");
            for (int j = 0; j < community.getPopulation(); j++) {
                if (humans[i][j].getState() == humanState.HEALTHY)
                    System.out.print("\033[32;1m@\033[0m ");
                else if (humans[i][j].getState() == humanState.ILL)
                    System.out.print("\033[31;1m#\033[0m ");
                else if (humans[i][j].getState() == humanState.REMOVED)
                    System.out.print("\033[37;1mX\033[0m ");
                else if (humans[i][j].getState() == humanState.CURED)
                    System.out.print("\033[34;1mH\033[0m ");
            }
            System.out.print("\n");
        }
        System.out.println("\033[32;1mHealthy: " + community.getHealthy() + "\033[0m\t \033[31;1mInfected: " + community.getInfected() + "\t\033[34;1mHealed: " + community.getHealed() + "\t\033[37;1m Removed: " + community.getRemoved() + "\033[0m");

        System.out.println("Press Enter To Continue To The Next Day...");
        new java.util.Scanner(System.in).nextLine();
    }

}