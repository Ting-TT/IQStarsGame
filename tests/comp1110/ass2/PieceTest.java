package comp1110.ass2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    Piece redPiece = new Piece("r000");
    Piece orangePiece = new Piece("o000");
    Piece yellowPiece = new Piece("y000");
    Piece greenPiece = new Piece("g000");
    Piece bluePiece = new Piece("b000");
    Piece indigoPiece = new Piece("i000");
    Piece pinkPiece = new Piece("p000");

    Piece redPiece0 = new Piece("r0");
    Piece orangePiece0 = new Piece("o0");
    Piece yellowPiece0 = new Piece("y0");
    Piece greenPiece0 = new Piece("g0");
    Piece bluePiece0 = new Piece("b0");
    Piece indigoPiece0 = new Piece("i0");
    Piece pinkPiece0 = new Piece("p0");

    @Test
    public void colourAssignmentTest() {
        assertEquals(IQStars.ROYGBIP.RED,redPiece.colour);
        assertEquals(IQStars.ROYGBIP.ORANGE,orangePiece.colour);
        assertEquals(IQStars.ROYGBIP.YELLOW,yellowPiece.colour);
        assertEquals(IQStars.ROYGBIP.GREEN,greenPiece.colour);
        assertEquals(IQStars.ROYGBIP.BLUE,bluePiece.colour);
        assertEquals(IQStars.ROYGBIP.INDIGO,indigoPiece.colour);
        assertEquals(IQStars.ROYGBIP.PINK,pinkPiece.colour);

        assertEquals(IQStars.ROYGBIP.RED,redPiece0.colour);
        assertEquals(IQStars.ROYGBIP.ORANGE,orangePiece0.colour);
        assertEquals(IQStars.ROYGBIP.YELLOW,yellowPiece0.colour);
        assertEquals(IQStars.ROYGBIP.GREEN,greenPiece0.colour);
        assertEquals(IQStars.ROYGBIP.BLUE,bluePiece0.colour);
        assertEquals(IQStars.ROYGBIP.INDIGO,indigoPiece0.colour);
        assertEquals(IQStars.ROYGBIP.PINK,pinkPiece0.colour);
    }

    @Test
    public void xyPrimeAssignmentTest(){
        assertEquals(00,redPiece.xyPrime);
        assertEquals(00,orangePiece.xyPrime);
        assertEquals(00,yellowPiece.xyPrime);
        assertEquals(00,greenPiece.xyPrime);
        assertEquals(00,bluePiece.xyPrime);
        assertEquals(00,indigoPiece.xyPrime);
        assertEquals(00,pinkPiece.xyPrime);

    }

    @Test
    public void toStringTest(){
        assertEquals("r000", redPiece.toString());
        assertEquals("o000", orangePiece.toString());
    }
}
