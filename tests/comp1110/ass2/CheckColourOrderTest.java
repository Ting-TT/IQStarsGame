package comp1110.ass2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CheckColourOrderTest {
    @Test
    public void checkColourOrderTest() {
        // Returns false as 'r' should occur BEFORE y.
        assertFalse(IQStars.checkColourOrder("y000r001", 'p'));
        assertFalse(IQStars.checkColourOrder("i221g002", 'p'));
        assertFalse(IQStars.checkColourOrder("roygbip", 'p'));
        assertTrue(IQStars.checkColourOrder("r001g010i013", 'p'));
        assertTrue(IQStars.checkColourOrder("p340", 'p'));
        assertTrue(IQStars.checkColourOrder("y000g011i033", 'p'));
        assertTrue(IQStars.checkColourOrder("b530i000p001", 'p'));
        assertFalse(IQStars.checkColourOrder("p422r202", 'p'));
        assertFalse(IQStars.checkColourOrder("o000g020r250", 'p'));
        assertTrue(IQStars.checkColourOrder("g310b241i003", 'p'));

        assertTrue(IQStars.checkColourOrder("r00r01r02", 'w'));
        assertTrue(IQStars.checkColourOrder("o31o02y53y03g60b21i51p62", 'w'));
        assertTrue(IQStars.checkColourOrder("p00p01p02p51p31p33", 'w'));
        assertTrue(IQStars.checkColourOrder("y20y21", 'w'));
        assertTrue(IQStars.checkColourOrder("b32i11i60i03p21", 'w'));
        assertFalse(IQStars.checkColourOrder("r00r21o32p22y60", 'w'));
        assertFalse(IQStars.checkColourOrder("y03y01r02p13i60", 'w'));
        assertFalse(IQStars.checkColourOrder("r00p21i12b33", 'w'));
        assertFalse(IQStars.checkColourOrder("r33r30y12p00i60", 'w'));

    }

}
