package comp1110.ass2;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *  AUTHORSHIP: This class was authored by Benjamin Pope.
 */

/**
 *
 *
 * Public class for the storage and manipulation of the 7
 * unique game pieces
 * Pieces contain the following properties:
 * - Shape (determined by the piece colour)
 * - Orientation (In 60 degree increments)
 * - Primary Location (Determined by top left-most star)
 * - Secondary locations (remaining 2 or 3 stars, determined by
 * shape and orientation.)
 */
public class Piece {

    public IQStars.ROYGBIP colour;
    public int ornt;
    public int xyPrime = -1;
    public ImageView pieceIV;
    public Group draggableGroup = new Group();

    /**
     * Constructor for Piece Objects. Forms a Piece Object from given game piece String.
     * @param pieceString Can be either 2 char string (colour and ornt) or 4 char string
     *                   (colour, ornt and xyPrime)
     */
    public Piece(String pieceString) {

        //Constructor for 2 char String: default Piece state
        if (pieceString.length() == 2) {
            char pieceChar = pieceString.charAt(0);
            colour = IQStars.ROYGBIP.getROYGBIP(pieceChar);
            ornt = Character.getNumericValue(pieceString.charAt(1));
        }

        //Constructor for 4 char string
        if (IQStars.isGameStringWellFormed(pieceString)) {
            char pieceChar = pieceString.charAt(0);

            colour = IQStars.ROYGBIP.getROYGBIP(pieceChar);
            ornt = Character.getNumericValue(pieceString.charAt(1));
            if (!IQStars.isOverhangingPos(pieceString)) {
                xyPrime = Integer.parseInt(pieceString.substring(2));
            }
        }
        formImageView();
        formClickEvent();
    }

    /**
     * Forms the ImageView for a PieceObject
     */
    public void formImageView() {
        FileInputStream pieceIS = null;
        try {
            pieceIS = new FileInputStream("assets/"
            +colour.getColour()+"Piece.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (pieceIS != null) {
            int crntOrnt = this.ornt;
            Image pieceImage = new Image(pieceIS);
            pieceIV = new ImageView(pieceImage);
            pieceIV.setPreserveRatio(true);
            switch (colour) {
                case RED, ORANGE, PINK -> {
                    pieceIV.setFitWidth(200);
                }
                default -> {
                    pieceIV.setFitWidth(240);
                }
            }
            updateLocation(coorderToOrder(xyPrime));
            for (int i = 0; i < crntOrnt; i++) {
                this.rotate();
            }
            draggableGroup.getChildren().add(pieceIV);
        }
    }

    /**
     * Place the 7 unique game pieces in their default positions
     */
    public void defaultPosition() {
        switch (colour) {
            case RED -> {
                pieceIV.setLayoutX(1);
                pieceIV.setLayoutY(350);
            }
            case ORANGE -> {
                pieceIV.setLayoutX(108);
                pieceIV.setLayoutY(525);
            }
            case YELLOW -> {
                pieceIV.setLayoutX(218);
                pieceIV.setLayoutY(350);
            }
            case GREEN -> {
                pieceIV.setLayoutX(325);
                pieceIV.setLayoutY(525);
            }
            case BLUE -> {
                pieceIV.setLayoutX(475);
                pieceIV.setLayoutY(350);
            }
            case INDIGO -> {
                pieceIV.setLayoutX(582);
                pieceIV.setLayoutY(525);
            }
            case PINK -> {
                pieceIV.setLayoutX(732);
                pieceIV.setLayoutY(350);
            }
        }
        xyPrime = -1;
    }

    //Enables handler for mouse click events
    public void formClickEvent() {
        pieceIV.setOnMouseClicked(e -> {
            rotate();
            updateLocation(coorderToOrder(xyPrime));
        });
    }

    /**
     * Rotates Piece
     */
    public void rotate() {
        if (pieceIV != null) {
            if (colour == IQStars.ROYGBIP.RED ||
                    colour == IQStars.ROYGBIP.INDIGO){
                if (ornt == 2) {
                    ornt = 0;
                } else {
                    ornt++;
                }
            } else if (ornt == 5) {
                ornt = 0;
            } else {
                ornt++;
            }
            pieceIV.setRotate(60 * ornt);
            updateLocation(coorderToOrder(xyPrime));
        }
    }

    /** updates a pieces xyPrime field.
     *
     * @param location Star position as int (0-25) starting from topLeft
     **/
    public void updateLocation(int location){
        pieceIV.setRotate(60 * ornt);
        double adjustmentX;
        double adjustmentY;
        int rtnXY = -1;
        if (location == -1) {
            this.defaultPosition();
            rtnXY = -1;
        } else {
            if (location < 7) {
                adjustmentX = 186 + ((80) * location);
                adjustmentY = 24;
                rtnXY = location;
            } else if (location < 13) {
                location = location - 7;
                adjustmentX = 226 + ((80) * location);
                adjustmentY = 94;
                rtnXY = (location * 10) + 1;
            } else if (location < 20) {
                location = location - 13;
                adjustmentX = 186 + ((80) * location);
                adjustmentY = 164;
                rtnXY = (location * 10) + 2;
            } else {
                location = location - 20;
                adjustmentX = 226 + ((80) * location);
                adjustmentY = 234;
                rtnXY = (location * 10) + 3;
            }

            this.xyPrime = rtnXY;

            double orntAdjustX = layoutAdjustX();
            double orntAdjustY = layoutAdjustY();

            pieceIV.setLayoutX(adjustmentX + orntAdjustX);
            pieceIV.setLayoutY(adjustmentY + orntAdjustY);
        }
    }

    /**
     * Get Piece Object ImageView
     * @return given Piece Object's ImageView value.
     */
    public ImageView getPieceIV() {
        return pieceIV;
    }

    /**
     * get Piece Object's draggableGroup
     * @return given Piece Object's draggableGroup value.
     */
    public Group getDraggableGroup() {
        return draggableGroup;
    }

    /**
     * Adjusts layoutX for each unique Piece for all its rotations
     * @return LayoutX Adjustments for Piece Object based on its orientation
     */
    public double layoutAdjustX() {
        switch (colour) {
            case RED -> {
                switch (ornt) {
                    case 1 -> { return -60;}
                    case 2 -> { return -40;}
                }
            }
            case ORANGE -> {
                switch (ornt) {
                    case 1 -> { return -60;}
                    case 2 -> { return -120;}
                    case 4 -> { return -60;}
                    case 5 -> { return -40;}
                }
            }
            case YELLOW -> {
                switch (ornt) {
                    case 1 -> { return -68;}
                    case 2 -> { return -70;}
                    case 3 -> { return -120;}
                    case 4 -> { return -9;}
                    case 5 -> { return -89;}
                }
            }
            case GREEN -> {
                switch (ornt) {
                    case 1 -> { return -100;}
                    case 2 -> { return -178;}
                    case 3 -> { return 3;}
                    case 4 -> { return -100;}
                    case 5 -> { return -20;}
                }
            }
            case BLUE -> {
                switch (ornt) {
                    case 1 -> { return -70;}
                    case 2 -> { return -151;}
                    case 3 -> { return -40;}
                    case 4 -> { return -10;}
                    case 5 -> { return -90;}
                }
            }
            case INDIGO -> {
                switch (ornt) {
                    case 1 -> { return -40;}
                    case 2 -> { return -120;}
                }
            }
            case PINK -> {
                switch (ornt) {
                    case 1 -> { return -90;}
                    case 2 -> { return 10;}
                    case 3 -> { return -40;}
                    case 4 -> { return -30;}
                    case 5 -> { return -10;}
                }
            }

        }
        return 0;
    }

    /**
     * Adjusts layoutY for each unique Piece for all its rotations
     * @return LayoutY Adjustments for Piece Object based on its orientation
     */
    public double layoutAdjustY() {
        switch (colour) {
            case RED -> {
                switch (ornt) {
                    case 1 -> { return 35;}
                }
            }
            case ORANGE -> {
                switch (ornt) {
                    case 1 -> { return 35;}
                    case 4 -> { return 35;}
                }
            }
            case YELLOW -> {
                switch (ornt) {
                    case 1 -> { return 52.5;}
                    case 2 -> { return 18;}
                    case 4 -> { return 17.5;}
                    case 5 -> { return 52.5;}
                }
            }
            case GREEN -> {
                switch (ornt) {
                    case 1 -> { return 35;}
                    case 2 -> { return -35;}
                    case 4 -> { return 35;}
                    case 5 -> { return -35;}
                }
            }
            case BLUE -> {
                switch (ornt) {
                    case 1 -> { return 52.5;}
                    case 2 -> { return 17.5;}
                    case 3 -> { return -1;}
                    case 4 -> { return 18;}
                    case 5 -> { return 52.5;}
                }
            }
            case INDIGO -> {
                switch (ornt) {
                    case 1 -> { return 70;}
                    case 2 -> { return 70;}
                }
            }
            case PINK -> {
                switch (ornt) {
                    case 1 -> { return 15;}
                    case 2 -> { return -52.5;}
                    case 4 -> { return -17.5;}
                    case 5 -> { return -17.5;}
                }
            }
        }
        return 0;
    }

    /**Returns the (X,Y) coordinate of star position from a (0-25) integer
     *
     * @param orderedPos Ordinal position of the star
     * @return (X,Y) position of star as two digit int
     */
    public static int orderToCoorder(int orderedPos) {
        if (orderedPos < 7) {
            return orderedPos;
        } else if (orderedPos < 13) {
            return 10 + (orderedPos - 7);
        } else if (orderedPos < 20) {
            return 20 + (orderedPos - 13);
        } else {
            return 30 + (orderedPos - 20);
        }
    }

    /**Returns the Ordinal value of the star position from a given (X,Y) coord
     *
     * @param xyPos (X,Y) coordinated as a two digit int
     * @return int [-1 : 25], where -1 is "unplaced"
     */
    public static int coorderToOrder(int xyPos) {
        if (xyPos == -1) {return -1;}
        int col = xyPos / 10;
        int row = xyPos % 10;
        int rtn = 0;
        switch (row) {
            case 0 -> { rtn = 0;}
            case 1 -> { rtn = 7;}
            case 2 -> { rtn = 13;}
            case 3 -> { rtn = 20;}
        }
        rtn = rtn + col;
        return rtn;
    }

    @Override
    public String toString() {
        if (this.xyPrime > -1 && this.xyPrime < 10){
            return "" + colour + ornt +
                    "0" + this.xyPrime;
        } else {
            return "" + colour +
                    ornt + this.xyPrime;
        }
    }
}
