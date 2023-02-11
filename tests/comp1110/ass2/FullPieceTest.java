package comp1110.ass2;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullPieceTest {
    // Test for the helper method fullPiece()
    // contains pieces of all colours and parities of the row where the top left star is at

    // test for red stars
    @Test
    public void redFullPieceTest() {
        // red star at even rows
        String starRed1 = "r120";
        String[] expectedRed1 = {"r120", "r111", "r121", "r122"};
        String[] getRed1 = IQStars.fullPiece(starRed1);
        assertEquals(Arrays.toString(expectedRed1), Arrays.toString(getRed1),
                "Did not get the correct array of stars for a red star of orientation 1 at an even row");
        // red star at odd rows
        String starRed2 = "r231";
        String[] expectedRed2 = {"r231", "r241", "r232", "r242"};
        String[] getRed2 = IQStars.fullPiece(starRed2);
        assertEquals(Arrays.toString(expectedRed2), Arrays.toString(getRed2),
                "Did not get the correct array of stars for a red star of orientation 2 at an odd row");
    }

    // test for orange stars
    @Test
    public void orangeFullPieceTest() {

        // orange star at even rows
        String starOrange1 = "o340";
        String[] expectedOrange1 = {"o340", "o341", "o351"};
        String[] getOrange1 = IQStars.fullPiece(starOrange1);
        assertEquals(Arrays.toString(expectedOrange1), Arrays.toString(getOrange1),
                "Did not get the correct array of stars for an orange star of orientation 3 at an even row");
        // orange star at odd rows
        String starOrange2 = "o111";
        String[] expectedOrange2 = {"o111", "o122", "o113"};
        String[] getOrange2 = IQStars.fullPiece(starOrange2);
        assertEquals(Arrays.toString(expectedOrange2), Arrays.toString(getOrange2),
                "Did not get the correct array of stars for an orange star of orientation 1 at an odd row");
    }

    // test for yellow stars
    @Test
    public void yellowFullPieceTest() {
        // yellow star at even rows
        String starYellow1 = "y032";
        String[] expectedYellow1 = {"y032", "y042", "y052", "y033"};
        String[] getYellow1 = IQStars.fullPiece(starYellow1);
        assertEquals(Arrays.toString(expectedYellow1), Arrays.toString(getYellow1),
                "Did not get the correct array of stars for a yellow star of orientation 0 at an even row");
        // yellow star at odd rows
        String starYellow2 = "y511";
        String[] expectedYellow2 = {"y511", "y512", "y503", "y513"};
        String[] getYellow2 = IQStars.fullPiece(starYellow2);
        assertEquals(Arrays.toString(expectedYellow2), Arrays.toString(getYellow2),
                "Did not get the correct array of stars for a yellow star of orientation 5 at an odd row");
    }

    // test for green stars
    @Test
    public void greenFullPieceTest() {
        // green star at even rows
        String starGreen1 = "g240";
        String[] expectedGreen1 = {"g240", "g231", "g221", "g211"};
        String[] getGreen1 = IQStars.fullPiece(starGreen1);
        assertEquals(Arrays.toString(expectedGreen1), Arrays.toString(getGreen1),
                "Did not get the correct array of stars for a green star of orientation 2 at an even row");
        // green star at odd rows
        String starGreen2 = "g321";
        String[] expectedGreen2 = {"g321", "g232", "g133", "g143"};
        String[] getGreen2 = IQStars.fullPiece(starGreen2);
        assertEquals(Arrays.toString(expectedGreen2), Arrays.toString(getGreen2),
                "Did not get the correct array of stars for a green star of orientation 3 at an odd row");
    }

    // test for blue stars
    @Test
    public void blueFullPieceTest() {
        // blue star at even rows
        String starBlue1 = "b220";
        String[] expectedBlue1 = {"b220", "b211", "b201", "b212"};
        String[] getBlue1 = IQStars.fullPiece(starBlue1);
        assertEquals(Arrays.toString(expectedBlue1), Arrays.toString(getBlue1),
                "Did not get the correct array of stars for a blue star of orientation 2 at an even row");
        // blue star at odd rows
        String starBlue2 = "b431";
        String[] expectedBlue2 = {"b431", "b441", "b442", "b443"};
        String[] getBlue2 = IQStars.fullPiece(starBlue2);
        assertEquals(Arrays.toString(expectedBlue2), Arrays.toString(getBlue2),
                "Did not get the correct array of stars for a blue star of orientation 4 at an odd row");
    }

    // test for indigo stars
    @Test
    public void indigoFullPieceTest() {
        // indigo star at even rows
        String starIndigo1 = "i130";
        String[] expectedIndigo1 = {"i130", "i131", "i142"};
        String[] getIndigo1 = IQStars.fullPiece(starIndigo1);
        assertEquals(Arrays.toString(expectedIndigo1), Arrays.toString(getIndigo1),
                "Did not get the correct array of stars for an indigo star of orientation 1 at an even row");
        // indigo star at odd rows
        String starIndigo2 = "i251";
        String[] expectedIndigo2 = {"i251", "i252", "i243"};
        String[] getIndigo2 = IQStars.fullPiece(starIndigo2);
        assertEquals(Arrays.toString(expectedIndigo2), Arrays.toString(getIndigo2),
                "Did not get the correct array of stars for an indigo star of orientation 2 at an odd row");
    }

    // test for purple stars
    @Test
    public void purpleFullPieceTest() {
        // purple star at even rows
        String starPurple1 = "p542";
        String[] expectedPurple1 = {"p542", "p552", "p533", "p553"};
        String[] getPurple1 = IQStars.fullPiece(starPurple1);
        assertEquals(Arrays.toString(expectedPurple1), Arrays.toString(getPurple1),
                "Did not get the correct array of stars for a purple star of orientation 5 at an even row");
        // purple star at odd rows
        String starPurple2 = "p421";
        String[] expectedPurple2 = {"p421", "p431", "p422", "p423"};
        String[] getPurple2 = IQStars.fullPiece(starPurple2);
        assertEquals(Arrays.toString(expectedPurple2), Arrays.toString(getPurple2),
                "Did not get the correct array of stars for a purple star of orientation 4 at an odd row");
    }
}
