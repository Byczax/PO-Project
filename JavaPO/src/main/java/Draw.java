
public class Draw {


    public static int Day(int day, int population) {
        for (int i = 0; i <= (population / 2); i++)
            System.out.print("  ");
        System.out.println("\033[37;1mDay:" + day + "\033[0m");
        return ++day;
    }

    public static void DrawMap(int size, Human[][] humans, int infected, int healed, int removed) {
        for (int i = 0; i < size; i++) {
            System.out.print("\t");
            for (int j = 0; j < size; j++) {
                if (humans[i][j].state == HumanState.ZDROWY)
                    System.out.print("\033[32;1mO\033[0m ");
                else if (humans[i][j].state == HumanState.CHORY)
                    System.out.print("\033[31;1m#\033[0m ");
                else if (humans[i][j].state == HumanState.USUNIETY)
                    System.out.print("\033[37;1mX\033[0m ");
                else if (humans[i][j].state == HumanState.WYLECZONY)
                    System.out.print("\033[34;1mH\033[0m ");
            }
            System.out.print("\n");
        }
        System.out.println("\033[32;1mHealthy: " + (size * size - infected) + "\033[0m\t \033[31;1mInfected: " + infected+"\t\033[0mHealed: "+healed+"\t Removed: "+removed);
//        System.out.println("\033[34;1Cured: "+);
        System.out.println("Press Enter To Continue To The Next Day...");
        new java.util.Scanner(System.in).nextLine();

    }


}