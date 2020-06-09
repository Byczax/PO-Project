import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CommunityTest {
    Community community;
    Set<Location> infectedLocations = new HashSet<>();
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
    public void setFirstInfectedTest() {
        community.infectSet(infectedLocations);
        int counter = 0;
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            if (human.getState() == humanState.ILL) {
                counter++;
            }
        }
        Assert.assertEquals(1, counter);
    }

}