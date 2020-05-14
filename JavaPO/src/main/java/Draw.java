
public class Draw {


    public static void Day(Community community) {
        for (int i = 0; i <= (community.getPopulation() / 2); i++) {
            System.out.print("  ");
        }
        System.out.println("\033[37;1mDay:" + community.getDay() + "\033[0m");
        community.plusDay();
    }

    public static void DrawMap(Community community, Human[][] humans) {
        for (int i = 0; i < community.getPopulation(); i++) {
            System.out.print("\t");
            for (int j = 0; j < community.getPopulation(); j++) {
                if (humans[i][j].getState() == HumanState.HEALTHY)
                    System.out.print("\033[32;1m@\033[0m ");
                else if (humans[i][j].getState() == HumanState.ILL)
                    System.out.print("\033[31;1m#\033[0m ");
                else if (humans[i][j].getState() == HumanState.REMOVED)
                    System.out.print("\033[37;1mX\033[0m ");
                else if (humans[i][j].getState() == HumanState.CURED)
                    System.out.print("\033[34;1mH\033[0m ");
            }
            System.out.print("\n");
        }
        System.out.println("\033[32;1mHealthy: " + community.getHealthy() + "\033[0m\t \033[31;1mInfected: " + community.getInfected() + "\t\033[34;1mHealed: " + community.getHealed() + "\t\033[37;1m Removed: " + community.getRemoved() + "\033[0m");

//        System.out.println("\033[34;1Cured: "+);
        System.out.println("Press Enter To Continue To The Next Day...");
        new java.util.Scanner(System.in).nextLine();

    }


}