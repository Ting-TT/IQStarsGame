package comp1110.ass2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntLocationTest {
    // test for the helper method locationInt()
    // contains tests for different possible inputs -- a star piece or a wizard piece

    // test for a gameString of a star piece
    @Test
    public void starLocationIntTest() {
        String gameString1 = "r012";
        int locExpected1 = 14;
        int locGet1 = IQStars.locationInt(gameString1);
        assertEquals(locExpected1,locGet1,"Did not correctly get the location of a star as an int");
    }

    // test for a gameString of a wizard piece
    @Test
    public void wizardLocationIntTest() {
        String gameString2 = "g43";
        int locExpected2 = 24;
        int locGet2 = IQStars.locationInt(gameString2);
        assertEquals(locExpected2,locGet2,"Did not correctly get the location of a wizard as an int");
    }
}
