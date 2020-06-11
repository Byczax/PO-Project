import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CommunityTest {
    Community community;
    int size = 3;

    @BeforeEach
    void setUp() {

        Map<Location, Human> communityMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                communityMap.put(new Location(i, j), new Human());
            }
        }
        community = new Community(communityMap);
    }

    @AfterEach
    void tearDown() {
        community = null;
    }

    @Test
    public void sumStatsTest() {
        Community.sumUpStatsVirus(community);
        Assertions.assertTrue(community.getHealthy() != 0);
        assertEquals(0, community.getInfected());
        assertEquals(0, community.getHealed());
        assertEquals(0, community.getRemoved());
    }

    @Test
    public void setFirstInfectedTest() {

        Main.infectFirstHuman(community);

        int counter = 0;
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            if (human.getState() == humanState.ILL) {
                counter++;
            }
        }
        Assertions.assertEquals(1, counter);
    }
}