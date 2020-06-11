import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BodyVirusTest {

    SimulationProperties myData;
    Community community;
    Virus myVirus;
    Set<Location> infectedLocations = new HashSet<>();

    @BeforeEach
    void setUp() {
        myData = new SimulationProperties(3, 1, 100, 2);
        Map<Location, Human> communityMap = new HashMap<>();
        for (int i = 0; i < myData.getPopulation(); i++) {
            for (int j = 0; j < myData.getPopulation(); j++) {
                communityMap.put(new Location(i, j), new Human());
            }
        }
        community = new Community(communityMap);
        infectedLocations.add(community.infectSet());
        myVirus = new BodyVirus();
    }

    @AfterEach
    void tearDown() {
        community = null;
        myData = null;
    }

    @Test
    void spreadVirusBodyVirus() {
        int counter = 0;
        myVirus.spreadVirus(community, myData, infectedLocations);
        for (Map.Entry<Location, Human> entry : community.getHumanByHouse().entrySet()) {
            Human human = entry.getValue();
            if (human.getState() == humanState.ILL) {
                counter++;
            }
        }
        Assertions.assertTrue(counter > 1);
    }
}