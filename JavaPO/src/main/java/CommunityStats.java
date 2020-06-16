import java.util.Map;

public class CommunityStats {
    private int healthy;
    private int infected;
    private int cured;
    private int removed;

    public CommunityStats(Community community) {
        healthy = 0;
        infected = 0;
        cured = 0;
        removed = 0;
        sumUpStatsVirus(community);
    }
    
    public void sumUpStatsVirus(Community community){
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            if (human.getState().equals(humanState.HEALTHY)) {
                ++healthy;
            } else if (human.getState().equals(humanState.INFECTED)) {
                ++infected;
            } else if (human.getState().equals(humanState.CURED)) {
                ++cured;
            } else if (human.getState().equals(humanState.REMOVED)) {
                ++removed;
            }
        }
    }


    public int getHealthy() {
        return healthy;
    }

    public int getInfected() {
        return infected;
    }

    public int getCured() {
        return cured;
    }

    public int getRemoved() {
        return removed;
    }
    
}
