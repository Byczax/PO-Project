
public class Output {


    /**
     * <h1>Centered day value</h1>
     * get community size and actual day to draw.
     *
     * @param community get community values
     * @param day       get actual day
     */
    public void day(Community community, int day) {
        for (int i = 0; i <= (community.getSqrtPopulation() / 2); i++) {
            System.out.print("  ");
        }
        System.out.println("\033[37;1mDay:" + day + "\033[0m");
    }

    /**
     * <h1>Drawing function</h1>
     * This function get value from humans to draw
     * state corresponding color for every human
     * after drawing map, this function prints all stats about all humans
     *
     * @param community get community values
     */
    public void drawMapAndStats(Community community) {
        int population = community.getSqrtPopulation();
        int[][] map = new int[population][population];
        for (var location : community.getHumanByHouse().keySet()) {
            map[location.getX()][location.getY()] = community.getHumanByHouse().get(location).getState().getState();
        }
        for (int i = 0; i < population; i++) {
            System.out.print("\t");
            for (int j = 0; j < population; j++) {
                if (map[i][j] == humanState.HEALTHY.state)
                    System.out.print("\033[32;1m@\033[0m ");
                else if (map[i][j] == humanState.INFECTED.state)
                    System.out.print("\033[31;1m#\033[0m ");
                else if (map[i][j] == humanState.REMOVED.state)
                    System.out.print("\033[37;1mX\033[0m ");
                else if (map[i][j] == humanState.CURED.state)
                    System.out.print("\033[34;1mH\033[0m ");
            }
            System.out.print("\n");
        }
        CommunityStats stats = new CommunityStats(community);
        System.out.println("\033[32;1mHealthy: " + stats.getHealthy() + "\033[0m\t \033[31;1mInfected: " + stats.getInfected() + "\t\033[34;1mHealed: " + stats.getCured() + "\t\033[37;1m Removed: " + stats.getRemoved() + "\033[0m");

        System.out.println("Press Enter To Continue To The Next Day...");
        new java.util.Scanner(System.in).nextLine();
    }

}