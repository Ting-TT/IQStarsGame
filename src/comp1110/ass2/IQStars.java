package comp1110.ass2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IQStars {


    /*
    The methods in this class contains contributions from Shafin Kamal, Ben Pope and Ting Tang.
     */


    /**
     * AUTHORSHIP: Ben Pope with contributions from Shafin Kamal and Ting Tang
     *
     *
     * Determine whether a game string describing either a wizard or a piece
     * is well-formed according to the following criteria:
     * - It consists of exactly three or four characters
     * - If it consists of three characters, it is a well-formed wizard string:
     * - the first character is a valid colour character (r,o,y,g,b,i,p)
     * - the second character is a valid column number
     * - (0 .. 6) if the row number is 0 or 2
     * - (0 .. 5) otherwise
     * - the third character is a valid row number (0 .. 3)
     * - If it consists of four characters, it is a well-formed piece string:
     * - the first character is a valid colour character (r,o,y,g,b,i,p)
     * - the second character is a valid rotation value
     * - (0 .. 2) if the colour is r or i
     * - (0 .. 5) otherwise
     * - the third character is a valid column number
     * - (0 .. 6) if the row number is 0 or 2
     * - (0 .. 5) otherwise
     * - the fourth character is a valid row number (0 .. 3)
     *
     * @param gameString A string describing either a piece or a wizard
     * @return True if the string is well-formed
     */
    public static boolean isGameStringWellFormed(String gameString) {
        // Defines valid char for pieces i.e - R O Y G B I P
        char[] validPieceColours = new char[]{'r', 'o', 'y', 'g', 'b', 'i', 'p'};

        if (gameString == null // check gameString length
                || (gameString.length() != 3 && gameString.length() != 4)) {
            return false;
        } else {
            int stringLength = gameString.length();
            char pieceChar = gameString.charAt(0); // Isolate Character

            boolean returnBool = false; // Initialise return boolean to false
            boolean pieceColourOk = false; // Initialise shared boolean values
            boolean pieceLocOk = false;

            for (char validPC : validPieceColours) { // Verify colour
                if (validPC == pieceChar) {
                    pieceColourOk = true;
                    break;
                }
            }
            switch (stringLength) {
                // Verifies valid Wizard string
                case 3 -> {

                    char wizardCol = gameString.charAt(1); // Isolate Column
                    char wizardRow = gameString.charAt(2); // Isolate Row
                    int wizardColInt = Character.getNumericValue(wizardCol);
                    int wizardRowInt = Character.getNumericValue(wizardRow);

                    if (!Character.isDigit(wizardCol)) { return false; }
                    if (!Character.isDigit(wizardRow)) { return false; }

                    if (wizardRowInt > 3 || wizardRowInt < 0) { return false; }

                    if (wizardRow == '0' || wizardRow == '2') {
                        pieceLocOk = wizardColInt >= 0 && wizardColInt <= 6;
                    } else {
                        pieceLocOk = wizardColInt >= 0 && wizardColInt <= 5;
                    }
                    returnBool = pieceColourOk && pieceLocOk;
                }
                // Verifies valid Piece string
                case 4 -> {
                    char pieceOrient = gameString.charAt(1); // Isolate orntn.
                    char pieceCol = gameString.charAt(2); // Isolate column
                    char pieceRow = gameString.charAt(3); // Isolate row
                    int pieceColInt = Character.getNumericValue(pieceCol);
                    int pieceRowInt = Character.getNumericValue(pieceRow);
                    int pieceOrientInt = Character.getNumericValue(pieceOrient);
                    boolean pieceOrientOk = false; // Initialise as false

                    if (!Character.isDigit(pieceOrient)) { return false; }
                    if (!Character.isDigit(pieceCol)) { return false; }
                    if (!Character.isDigit(pieceRow)) { return false; }

                    if (pieceRowInt > 3 || pieceRowInt < 0) { return false; }

                    if (pieceChar == 'r' || pieceChar == 'i') {
                        pieceOrientOk = pieceOrientInt >= 0 && pieceOrientInt <= 2;
                    } else {
                        pieceOrientOk = pieceOrientInt >= 0 && pieceOrientInt <= 5;
                    }

                    if (pieceRow == '0' || pieceRow == '2') {
                        pieceLocOk = pieceColInt >= 0 && pieceColInt <= 6;
                    } else {
                        pieceLocOk = pieceColInt >= 0 && pieceColInt <= 5;
                    }
                    returnBool = pieceColourOk && pieceOrientOk && pieceLocOk;

                }
            }
            return returnBool;
        }
    }

    /*AUTHORSHIP: Ben Pope with contributions from Shafin Kamal and Ting Tang
     *
    Determines if piece is in an "Overhanging" position.
     * An Overhanging position is defined as any that have stars that lie off the
     * board, using the assignment specifications for piece positioning (top left
     * most star).
     */
    public static boolean isOverhangingPos (String gameString) {
        char pieceShape = gameString.charAt(0);
        int pieceOrient = Character.getNumericValue(gameString.charAt(1));
        int pieceLoc = Integer.parseInt(gameString.substring(2));
        int pieceX = Character.getNumericValue(gameString.charAt(2));
        int pieceY = Character.getNumericValue(gameString.charAt(3));
        int[] oHArray = new int[]{};//Stores overhanging positions

        boolean isPresent = false;

        // Checks whole rows/columns, Switches for piece shape and orientation
        switch (pieceShape) {
            case 'r':
                if (pieceOrient == 1) {
                    if (pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                if (pieceY == 3) {
                    return true;
                }
                break;
            case 'o':
                if (pieceOrient == 1 || pieceOrient == 4) {
                    if (pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                if (pieceY == 3) {
                    return true;
                }
                break;
            case 'y':
            case 'b':
                if (pieceOrient == 1 || pieceOrient == 2 || pieceOrient == 4 || pieceOrient == 5){
                    if (pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                if (pieceY == 3 ) {
                    return true;
                }
                break;
            case 'g':
                if (pieceOrient == 1 || pieceOrient == 4) {
                    if (pieceY == 1 || pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                if (pieceOrient == 0 || pieceOrient == 3) {
                    if (pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                if (pieceY == 3) {
                    return true;
                }
                break;
            case 'i':
                if (pieceOrient == 1 || pieceOrient == 2) {
                    if (pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                break;
            case 'p':
                if (pieceOrient == 0 || pieceOrient == 1 || pieceOrient == 3 || pieceOrient == 4) {
                    if (pieceY == 2 || pieceY == 3) {
                        return true;
                    }
                }
                if (pieceY == 3) {
                    return true;
                }
        }

        // Generates array of overhang posts, Switches for piece shape and orientation
        switch (pieceShape) {
            case 'r':
                switch (pieceOrient) {
                    case 0 -> oHArray = new int[]{50,60,51,52,62};
                    case 1 -> oHArray = new int[]{0,60};
                    case 2 -> oHArray = new int[]{0,60,51,2,62};
                }
                break;
            case 'o':
                switch (pieceOrient) {
                    case 0,3 -> oHArray = new int[]{50,60,51,52,62};
                    case 1 -> oHArray = new int[]{60};
                    case 2 -> oHArray = new int[]{0,10,1,2,12};
                    case 4 -> oHArray = new int[]{0};
                    case 5 -> oHArray = new int[]{0,60,51,2,62};
                }
                break;
            case 'y':
                switch (pieceOrient) {
                    case 0 -> oHArray = new int[]{50,60,41,51,52,62};
                    case 1 -> oHArray = new int[]{0,60,51};
                    case 2 -> oHArray = new int[]{60,51};
                    case 3 -> oHArray = new int[]{0,10,60,1,2,12,62};
                    case 4 -> oHArray = new int[]{50,60,51};
                    case 5 -> oHArray = new int[]{0,1};
                }
                break;
            case 'g':
                switch (pieceOrient) {
                    case 0 -> oHArray = new int[]{50,60,41,51};
                    case 1 -> oHArray = new int[]{0,60};
                    case 2 -> oHArray = new int[]{0,10,20,1,11,2,12,22};
                    case 3 -> oHArray = new int[]{50,60,41,51};
                    case 4 -> oHArray = new int[]{0};
                    case 5 -> oHArray = new int[]{0,50,60,41,51,2,52,62};
                }
                break;
            case 'b':
                switch (pieceOrient) {
                    case 0 -> oHArray = new int[]{50,60,41,51,52,62};
                    case 1 -> oHArray = new int[]{60,51};
                    case 2 -> oHArray = new int[]{0,10,1};
                    case 3 -> oHArray = new int[]{0,50,60,51,2,52,62};
                    case 4 -> oHArray = new int[]{60,51};
                    case 5 -> oHArray = new int[]{0,60,1};
                }
                break;
            case 'i':
                switch (pieceOrient) {
                    case 0 -> oHArray = new int[]{50,60,41,51,52,62,43,53};
                    case 1 -> oHArray = new int[]{60, 51};
                    case 2 -> oHArray = new int[]{0,1};
                }
                break;
            case 'p':
                switch (pieceOrient) {
                    case 0 -> oHArray = new int[]{50,60,41,51};
                    case 1 -> oHArray = new int[]{0,60,1};
                    case 2 -> oHArray = new int[]{50,60,41,51,52,62};
                    case 3, 4-> oHArray = new int[]{0,60,51};
                    case 5 -> oHArray = new int[]{0,50,60,51,2,50,60};
                }
                break;
        }
        for (int oHPos : oHArray) {
            if (oHPos == pieceLoc) {
                return true;
            }
        }
        return false;
    }

    //Checks to see if a character is ROYGBIP
    public static boolean isROYGBIP (char givenChar) {
        char[] validCharacters = new char[]{'r', 'o', 'y', 'g', 'b', 'i', 'p'};
        for (char validChar : validCharacters) {
            if (validChar == givenChar) {
                return true;
            }
        }
        return false;
    }


    /**
     * AUTHORSHIP: Shafin Kamal
     *
     * Determine whether a game state string is well-formed:
     * - The string is of the form [piecePlacement]W[wizardPlacement],
     *      where [piecePlacement] and [wizardPlacement] are replaced by the
     *      corresponding strings below
     * - [piecePlacement] string specification:
     *      - it consists of exactly n four-character piece strings (where n = 0 .. 7);
     *      - each piece string is well-formed
     *      - no piece appears more than once in the string
     *      - the pieces are ordered correctly within the string (r,o,y,g,b,i,p)
     * - [wizardPlacement] string specification:
     *      - it consists of exactly n three-character wizard strings (where n is some non-negative integer)
     *      - each wizard string is well-formed
     *      - the strings are ordered correctly within the string (r,o,y,g,b,i,p)
     *      - if there is more than one wizard of a single colour these wizards are ordered first by
     *          row and then by column in ascending order (note that this does not prevent two
     *          wizards of the same colour being placed in the same location - we will check for this
     *          in a later task).
     * @param gameStateString A string describing a game state
     * @return True if the game state string is well-formed
     */

    public static boolean isGameStateStringWellFormed(String gameStateString) {
        // All game state strings must contain "W", even if there are no piece or wizard placements in the state.
        if (!gameStateString.contains("W")) return false;

        // CHECKING PIECE PLACEMENT && WIZARD PLACEMENT

        if (!checkPiecePlacement(gameStateString) || !checkWizardPlacement(gameStateString)) {
            return false;
        }

        return true;
    }


    /**
     * AUTHORSHIP: Shafin Kamal with contributions Ting Tang and Ben Pope
     *
     * This method checks the validity of the piecePlacement section of the
     * gameStateString by calling on isGameStringWellFormed from Task 3 and
     * the helper method 'pieceColourOrder'.
     * @param gameStateString
     * @return True if the piecePlacement is well formed, else return False.
     */
    public static boolean checkPiecePlacement(String gameStateString) {
        // CHECKING PIECE PLACEMENT

        // If piece placement is empty but contains the W character
        if (gameStateString.indexOf('W') == 0) {return true;}

        // If the piece placement is non-empty
        if (gameStateString.indexOf('W') != 0) {
            //Isolate the piece placement string
            String piecePlacement = gameStateString.substring(0, gameStateString.indexOf('W'));

            // If length == 0; return true as it is valid to have no pieces in a beginning game state.
            if (piecePlacement.length() == 0) {return true;}

            // If the length of the piece placement doesn't have 0 .. 7 (inclusive) piece strings, then return false.
            if (!(piecePlacement.length() == 4) && !(piecePlacement.length() == 8) && !(piecePlacement.length() == 12)
                    && !(piecePlacement.length() == 16) && !(piecePlacement.length() == 20) && !(piecePlacement.length()
                    == 24)
                    && !(piecePlacement.length() == 28)) {return false;}

            // check if each piece string is well-formed
            for (int i = 0; i < piecePlacement.length(); i+=4) {
                String piece = piecePlacement.substring(i,i+4);
                if (!isGameStringWellFormed(piece)) {return false;}
            }

            // Check if the first character at each piece string within the piece placement is a valid colour
            // (r,o,y,g,b,i,p).
            int r = 0;
            int o = 0;
            int y = 0;
            int g = 0;
            int b = 0;
            int indigo = 0;
            int p = 0;

            for (int i = 0; i < piecePlacement.length(); i+=4) {
                char thisChar = piecePlacement.charAt(i);
                if (thisChar != 'r' && thisChar != 'o' && thisChar != 'y' && thisChar != 'g' && thisChar != 'b'
                        &&thisChar != 'i' && thisChar != 'p') {
                    return false;
                }

                if (thisChar == 'r') {
                    if (r == 1) {
                        return false;
                    }
                    else
                        r++;
                }
                else
                if (thisChar == 'o') {
                    if (o == 1) {
                        return false;
                    }
                    else
                        o++;
                }
                else
                if (thisChar == 'y') {
                    if (y == 1) {
                        return false;
                    }
                    else
                        y++;
                }
                else
                if (thisChar == 'g') {
                    if (g == 1) {
                        return false;
                    }
                    else
                        g++;
                }
                else
                if (thisChar == 'b') {
                    if (b == 1) {
                        return false;
                    }
                    else
                        b++;
                }
                else
                if (thisChar == 'i') {
                    if (indigo == 1) {
                        return false;
                    }
                    else
                        indigo++;
                }
                else
                if (thisChar == 'p') {
                    if (p == 1) {
                        return false;
                    }
                    else
                        p++;
                }
            }

            // check if pieces are in roygbip order.
            if (!checkColourOrder(piecePlacement, 'p')) {return false;}
        }
        return true;
    }

    /**
     * AUTHORSHIP: Shafin Kamal with contributions Ben Pope and Ting Tang
     *
     * Helper method that takes in the piecePlacement substring from the gameStateString
     * (substring 0, indexOf("W")) and uses a switch statement to pattern match against
     * each colour character and checks order of every subsequent colour character.
     * The order is r -> o -> y -> g -> b -> i -> p
     * @param piecePlacement
     * @return True if the colours of the piecePlacement are in correct.
     */
    public static boolean checkColourOrder (String piecePlacement, char classifier) {
        int increment = 0;
        if (classifier == 'p') {
            increment = 4;
        }
        if (classifier == 'w') {
            increment = 3;
        }

        int condition = 0;
        if (increment == 4) {
            condition = piecePlacement.length();
        }
        if (increment == 3) {
            condition = piecePlacement.length() - 3;
        }

        // check each colour character
        for (int i = 0; i < condition; i+=increment) {
            char thisChar = piecePlacement.charAt(i);

            // Look at the substring from this colour onwards, dismissing the characters before
            // thisChar.
            String tail = piecePlacement.substring(i+1);

            // Switch statement to pattern match the colour character
            switch (thisChar) {
                // If this char is 'r'.
                case 'r':
                    // If it is a wizard piece
                    if (classifier == 'w') {
                        if (tail.contains("r") && piecePlacement.charAt(i+increment) != 'r') {
                            return false;
                        }
                        else
                            continue;
                    }
                    // If o exists after finding the r character and its not the immediate piece, then false.
                    if (!tail.contains("r") && tail.contains("o") && piecePlacement.charAt(i + increment) != 'o') {
                        return false;
                    }
                    else
                        // If the tail doesnt contain o but contains y and y isnt the next piece, then false
                        if (!tail.contains("r") && !tail.contains("o") && tail.contains("y") &&
                                piecePlacement.charAt(i + increment) != 'y') {
                            return false;
                        }
                        else
                            // if the tail doesnt contain o and it doesnt contain y but it contains g but g isnt the
                            // next piece, then false.
                            if (!tail.contains("r") && !tail.contains("o") && !tail.contains("y") && tail.contains("g")
                                    && piecePlacement.charAt(i + increment) != 'g') {
                                return false;
                            }
                            else
                                // if o, y, g doesnt exist but i does but it isnt the next piece, return false.
                                if (!tail.contains("r") && !tail.contains("o") && !tail.contains("y")
                                        && !tail.contains("g") && tail.contains("b") &&
                                        piecePlacement.charAt(i + increment) != 'b') {
                                    return false;
                                }
                                else
                                    // o, y, g, b, i doesnt exists but p does but it isnt the next piece, return false
                                    if (!tail.contains("r") && !tail.contains("o") && !tail.contains("y")
                                            && !tail.contains("g") && !tail.contains("b") && tail.contains("i") &&
                                            piecePlacement.charAt(i + increment) != 'i') {
                                        return false;
                                    }
                                    else
                                    if (!tail.contains("r") && !tail.contains("o") && !tail.contains("y") &&
                                            !tail.contains("g") && !tail.contains("b") && !tail.contains("i")
                                            && tail.contains("p") && piecePlacement.charAt(i + increment) != 'p') {
                                        return false;
                                    }
                    break;
                case 'o':
                    // an r should never appear after an o
                    if (tail.contains("r")) {
                        return false;
                    }

                    if (classifier == 'w') {
                        if (tail.contains("o") && piecePlacement.charAt(i + increment) != 'o') {
                            return false;
                        }
                        else
                            continue;
                    }

                    if (!tail.contains("o") && tail.contains("y") && piecePlacement.charAt(i + increment) != 'y') {
                        return false;
                    }
                    else
                    if (!tail.contains("o") && !tail.contains("y") && tail.contains("g") &&
                            piecePlacement.charAt(i + increment) != 'g') {
                        return false;
                    }
                    else
                    if (!tail.contains("o") && !tail.contains("y") && !tail.contains("g") && tail.contains("b") &&
                            piecePlacement.charAt(i + increment) != 'b') {
                        return false;
                    }
                    else
                    if (!tail.contains("o") && !tail.contains("y") && !tail.contains("g") && !tail.contains("b") &&
                            tail.contains("i") && piecePlacement.charAt(i + increment) != 'i') {
                        return false;
                    }
                    else
                    if (!tail.contains("o") && !tail.contains("y") && !tail.contains("g") && !tail.contains("b")
                            && !tail.contains("i") && tail.contains("p") &&
                            piecePlacement.charAt(i + increment) != 'p') {
                        return false;
                    }
                    break;
                case 'y':
                    // r & o should never exist after the appearance of y.
                    if (tail.contains("r") || tail.contains("o")) {
                        return false;
                    }

                    if (classifier == 'w') {
                        if (tail.contains("y") && piecePlacement.charAt(i + increment) != 'y') {
                            return false;
                        }
                        else
                            continue;
                    }

                    if (!tail.contains("y") && tail.contains("g") && piecePlacement.charAt(i+increment) != 'g') {
                        return false;
                    }
                    else
                    if (!tail.contains("y") && !tail.contains("g") && tail.contains("b") &&
                            piecePlacement.charAt(i+increment) != 'b') {
                        return false;
                    }
                    else
                    if (!tail.contains("y") && !tail.contains("g") && !tail.contains("b") && tail.contains("i") &&
                            piecePlacement.charAt(i+increment) != 'i') {
                        return false;
                    }
                    else
                    if (!tail.contains("y") && !tail.contains("g") && !tail.contains("b") && !tail.contains("i") &&
                            tail.contains("p") && piecePlacement.charAt(i+increment) != 'p') {
                        return false;
                    }
                    break;
                case 'g':
                    // r, o, y should never exists after g
                    if (tail.contains("r") || tail.contains("o") || tail.contains("y")) {return false;}
                    if (tail.contains("b") && piecePlacement.charAt(i+increment)!='b') {
                        return false;
                    }

                    if (classifier == 'w') {
                        if (tail.contains("g") && piecePlacement.charAt(i + increment) != 'g') {
                            return false;
                        }
                        else
                            continue;
                    }

                    if (!tail.contains("g") && !tail.contains("b") && tail.contains("i") &&
                            piecePlacement.charAt(i+increment) != 'i') {
                        return false;
                    }
                    else
                    if (!tail.contains("g") && !tail.contains("b") && !tail.contains("i") && tail.contains("p") &&
                            piecePlacement.charAt(i+increment) != 'p') {
                        return false;
                    }
                    break;
                case 'b':
                    //royg should never exist after b
                    if (tail.contains("r") || tail.contains("o") || tail.contains("y") || tail.contains("g")) {
                        return false;
                    }

                    if (classifier == 'w') {
                        if (tail.contains("b") && piecePlacement.charAt(i + increment) != 'b') {
                            return false;
                        }
                        else
                            continue;
                    }

                    if (!tail.contains("b") && tail.contains("i") && piecePlacement.charAt(i+increment) != 'i') {
                        return false;
                    }
                    else
                    if (!tail.contains("b") && !tail.contains("i") && tail.contains("p") &&
                            piecePlacement.charAt(i+increment) != 'p') {
                        return false;
                    }
                    break;
                case 'i':
                    // r, o, y, g, b should never exist after i
                    if (tail.contains("r") || tail.contains("o") || tail.contains("y") || tail.contains("g") ||
                            tail.contains("b")) {
                        return false;
                    }

                    if (classifier == 'w') {
                        if (tail.contains("i") && piecePlacement.charAt(i + increment) != 'i') {
                            return false;
                        }
                        else
                            continue;
                    }

                    if (!tail.contains("i") && tail.contains("p") && piecePlacement.charAt(i+increment) != 'p') {
                        return false;
                    }
                    break;
                case 'p':
                    if (tail.contains("r") || tail.contains("o") || tail.contains("y") ||
                            tail.contains("g") || tail.contains("b") || tail.contains("i")) {
                        return false;
                    }

                    if (classifier == 'w') {
                        if (tail.contains("p") && piecePlacement.charAt(i + increment) != 'p') {
                            return false;
                        }
                        else
                            continue;
                    }

                    // p should always be the last piece
                    for (int k = 1; k < tail.length(); k++) {
                        // every character after p should be a digit. (column and row)
                        if (Character.isLetter(tail.charAt(k))) {
                            return false;
                        }
                    }
                    break;
            }
        }
        return true;
    }

    /**
     * AUTHORSHIP: Shafin Kamal with contributions from Ben Pope and Ting Tang
     *
     * This method takes a substring of two wizard strings with the same
     * wizard colour and compares the column and row numbers of them to see
     * if they are in the appropriate position
     *
     * Two simple if statements check whether the wizard string columns and rows are
     * correct.
     *
     * SPECIFICATION:
     *
     * The row of the first piece should be greater than the row of the second piece.
     * If the row of the first piece == the row of the second piece;
     *      then the column of the first piece must be greater than the column of the
     *      second piece.
     *
     * @param wizardPlacement
     * @return True if the specification above is met, else return False.
     */
    public static boolean wizardRowColOrder (String wizardPlacement) {
        for (int i = 0; i < wizardPlacement.length()-3; i+=3) {
            String wizard = wizardPlacement.substring(i,i+6);
            if (wizard.charAt(0) == wizard.charAt(3)) {
                int column1 = Character.getNumericValue(wizard.charAt(1));
                int row1 = Character.getNumericValue(wizard.charAt(2));
                int column2 = Character.getNumericValue(wizard.charAt(4));
                int row2 = Character.getNumericValue(wizard.charAt(5));

                if (row1 > row2) {
                    return false;
                }
                if (row1 == row2) {
                    if (column1 > column2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }




    /**
     * AUTHORSHIP: Shafin Kamal with contributions from Ben Pope and Ting Tang
     *
     * Similar to checkPiecePlacement, this method takes the substring of the
     * gameStateString relating to the wizardPlacement (substring indexOf("W").
     *
     * It then calls on the following helper methods to check the validity of the
     * wizard placement.
     *
     * Helper Methods:
     *      - isGameStringWellFormed (Task 3)
     *      - wizardCheckColourOrder (Helper method)
     *      - wizardRowColOrder (Helper method)
     * @param gameStateString
     * @return True if wizard placement is valid, else return False.
     */
    public static boolean checkWizardPlacement(String gameStateString) {
        // Isolate the wizard placement string from the entire game state string
        String wizardPlacement = gameStateString.substring(gameStateString.indexOf("W") + 1);

        // it consists of exactly n three-character wizard strings (where n is some non-negative integer)
        // therefore, string length % 3 == 0 to be true.

        if (wizardPlacement.length() % 3 != 0) {return false;}

        // check if wizard string is well formed
        for (int i = 0; i < wizardPlacement.length(); i+=3) {
            String wizard = wizardPlacement.substring(i,i+3);
            if (!isGameStringWellFormed(wizard)) {return false;}
        }

        // check if wizard colours are in order.
        if (!checkColourOrder(wizardPlacement, 'w')) {return false;}

        // Since repeated wizard's are allowed, this method checks if repeated wizards are in correct order.
        if (!wizardRowColOrder(wizardPlacement)) {return false;}


        return true;
    }


    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Determine whether a game state is valid.
     *
     * To be valid, the game state must satisfy the following requirements:
     * - string must be well-formed
     * - pieces must be entirely on the board
     * - pieces must not overlap each other
     * - wizards must be on the board
     * - each location may have at most one wizard
     * - each piece must cover all wizards of the same colour
     * - each piece must not cover any wizards of a different colour
     *
     * @param gameStateString A game state string
     * @return True if the game state represented by the string is valid
     */
    public static boolean isGameStateValid(String gameStateString) {
        // check if string is well-formed
        if (!isGameStateStringWellFormed(gameStateString)) {return false;}

        // get piece strings
        int indexForW = -1;
        for (int i = 0; i < gameStateString.length(); i++) {
            if (gameStateString.charAt(i) == 'W') {indexForW = i;}
        }
        String starString = gameStateString.substring(0,indexForW);

        // check if all stars in starString have its entire piece on the board
        if (starString.length() != 0) {
            for (int i = 0; i < starString.length(); i = i + 4) {
                String star = starString.substring(i,i+4); // the string for one star
                String[] piece = fullPiece(star); // array of strings of all the stars in this entire piece
                for (String s: piece) {
                    if (!(isGameStringWellFormed(s))) {return false;}
                } // check if each star is on the board
            }
        }

        // check if star pieces overlap each other
        // create an array with all zeros to initiate the no. of stars on that location(index of array) of the board
        int[] boardStar = new int[26];
        if (starString.length() != 0) {
            for (int i = 0; i < starString.length(); i = i + 4) {
                String star = starString.substring(i,i+4); // the string for one star
                String[] piece = fullPiece(star); // array of strings of all the stars in this entire piece
                for (String s: piece) {
                    int occupiedLocation = locationInt(s);
                    boardStar[occupiedLocation]++;
                } // if a location is occupied by a star, add 1 to its location
            }
        }
        for (int n: boardStar) {
            if (n > 1) {return false;}
        }

        // get wizard strings
        String wizardString = gameStateString.substring(indexForW+1);

        // check if all wizard pieces in wizardString are on the board
        // check if wizard pieces overlap each other
        // create an array with all zeros to initiate the no. of wizard pieces on that location of the board
        int[] boardWizard = new int[26];
        if (wizardString.length() != 0) {
            for (int i = 0; i < wizardString.length(); i = i + 3) {
                String wizard = wizardString.substring(i,i+3); // the string for one wizard piece
                if (!(isGameStringWellFormed(wizard))) {return false;} // check if this wizard piece is on the board
                int occupiedLocation = locationInt(wizard);
                boardWizard[occupiedLocation]++; // if a location is occupied by a wizard piece, add 1 to its location
            }
        }
        for (int n: boardWizard) {
            if (n > 1) {return false;}
        }

        // check if each piece covers all wizards of the same colour or covers any wizards of a different colour
        if (starString.length() != 0) {
            for (int i = 0; i < starString.length(); i = i + 4) {
                String star = starString.substring(i,i+4); // the string for one star
                String[] pieces = fullPiece(star); // array of strings of all the stars in this entire piece
                char starColour = star.charAt(0);
                int[] starLocations = new int[pieces.length];
                for (int n = 0; n < pieces.length; n++) {
                    starLocations[n] = locationInt(pieces[n]);
                } // array of location numbers of all the stars with this colour


                // check if each piece covers all wizards of the same colour
                if (wizardString.length() != 0) {
                    for (int x = 0; x < wizardString.length(); x = x + 3) {
                        String wizard = wizardString.substring(x, x + 3); // the string for one wizard piece
                        // check if the location of a wizard piece of the same colour exits in
                        // the array of locations of stars
                        if (wizard.charAt(0) == starColour) {
                            int wizardLocation = locationInt(wizard);
                            boolean found = false;
                            for (int l : starLocations) {
                                if (l == wizardLocation) {
                                    found = true;
                                }
                            }
                            if (found == false) {return false;};
                        }
                    }
                }

                // check if each piece covers any wizards of a different colour
                if (wizardString.length() != 0) {
                    for (int x = 0; x < wizardString.length(); x = x + 3) {
                        String wizard = wizardString.substring(x, x + 3); // the string for one wizard piece
                        int wizardLocation = locationInt(wizard); // location of this wizard piece
                        char wizardColour = wizard.charAt(0); // colour of this wizard piece
                        // check if there is any star on this location of the wizard piece
                        boolean found = false;
                        for (int y = 0; y < starLocations.length; y++) {
                            if (starLocations[y] == wizardLocation) {
                                found = true;
                            }
                        }
                        // if there is a star on the same location of a wizard piece,
                        // check if their colours are the same
                        if (found == true) {
                            if (starColour != wizardColour) {return false;}
                        }
                    }
                }
            }
        }
        // if the game state string passes all the if statements above, it is valid
        return true;
    }


    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given a string of a piece/wizard, return an int which expresses the input piece/wizard's
     * location with an int (0-25) instead of a string with column and row number
     * @param gameString A piece string or a wizard string
     * @return An int which is the location of the input piece/wizard
     */
    public static int locationInt(String gameString) {
        int column = (gameString.length() == 4)? Integer.parseInt(String.valueOf(gameString.charAt(2))) :
                Integer.parseInt(String.valueOf(gameString.charAt(1)));
        int row = (gameString.length() == 4)? Integer.parseInt(String.valueOf(gameString.charAt(3))) :
                Integer.parseInt(String.valueOf(gameString.charAt(2)));
        int location = 0;
        if (row == 0) {location = column + row;}
        else if (row == 1) {location = column + row + 6;}
        else if (row == 2) {location = column + row + 11;}
        else if (row == 3) {location = column + row + 17;}
        return location;
    }

    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given an int which expresses the location on the board, return a string of two characters represent the same
     * location, the first character is the column number, and the second character is the row number.
     *
     * @param locationNo An int which represent the location on board
     * @return A string which represents the column and row number of the given location
     */
    public static String locationString(int locationNo) {
        StringBuilder locString = new StringBuilder();
        int columnNo = 0;
        int rowNo = 0;
        if (locationNo >= 0 && locationNo < 7) {rowNo = 0; columnNo = locationNo;}
        else if (locationNo >= 7 && locationNo < 13) {rowNo = 1; columnNo = locationNo - 7;}
        else if (locationNo >= 13 && locationNo < 20) {rowNo = 2; columnNo = locationNo - 13;}
        else if (locationNo >= 20 && locationNo < 26) {rowNo = 3; columnNo = locationNo - 20;}
        locString.append("" + columnNo + rowNo);
        return locString.toString();
    }


    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given a piece string, return an array of piece strings of all the stars of the input piece bases on
     * input piece's orientation and location.
     *
     * @param star A piece string.
     * @return An array of piece strings of all the stars of the given piece.
     */
    public static String[] fullPiece(String star) {
        char colour = star.charAt(0);
        int orientation = Integer.parseInt(String.valueOf(star.charAt(1)));
        int column = Integer.parseInt(String.valueOf(star.charAt(2)));
        int row = Integer.parseInt(String.valueOf(star.charAt(3)));

        // create a new array which is used to contain all stars of that piece
        String[] wholePiece = (colour == 'o' || colour == 'i')? new String[3] : new String[4];

        // the first element of the array is the input star for all cases
        wholePiece[0] = star;

        // all cases for red piece:
        if (colour == 'r' && orientation == 0) {
            wholePiece[1] = "r0" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "r0" + (column) + (row+1) : "r0" + (column+1) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "r0" + (column+1) + (row+1) : "r0" + (column+2) + (row+1);
        }
        if (colour == 'r' && orientation == 1) {
            wholePiece[1] = (row % 2 == 0)? "r1" + (column-1) + (row+1) : "r1" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "r1" + (column) + (row+1) : "r1" + (column+1) + (row+1);
            wholePiece[3] = "r1" + (column) + (row+2);
        }
        if (colour == 'r' && orientation == 2) {
            wholePiece[1] = "r2" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "r2" + (column-1) + (row+1) : "r2" + (column) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "r2" + (column) + (row+1) : "r2" + (column+1) + (row+1);
        }
        // all cases for orange piece:
        if (colour == 'o' && orientation == 0) {
            wholePiece[1] = "o0" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "o0" + (column+1) + (row+1) : "o0" + (column+2) + (row+1);
        }
        if (colour == 'o' && orientation == 1) {
            wholePiece[0] = star;
            wholePiece[1] = (row % 2 == 0)? "o1" + (column) + (row+1) : "o1" + (column+1) + (row+1);
            wholePiece[2] = "o1" + (column) + (row+2);
        }
        if (colour == 'o' && orientation == 2) {
            wholePiece[1] = (row % 2 == 0)? "o2" + (column-1) + (row+1) : "o2" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "o2" + (column-2) + (row+1) : "o2" + (column-1) + (row+1);
        }
        if (colour == 'o' && orientation == 3) {
            wholePiece[1] = (row % 2 == 0)? "o3" + (column) + (row+1) : "o3" + (column+1) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "o3" + (column+1) + (row+1) : "o3" + (column+2) + (row+1);
        }
        if (colour == 'o' && orientation == 4) {
            wholePiece[1] = (row % 2 == 0)? "o4" + (column-1) + (row+1) : "o4" + (column) + (row+1);
            wholePiece[2] = "o4" + (column) + (row+2);
        }
        if (colour == 'o' && orientation == 5) {
            wholePiece[1] = "o5" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "o5" + (column-1) + (row+1) : "o5" + (column) + (row+1);
        }
        // all cases for yellow piece:
        if (colour == 'y' && orientation == 0) {
            wholePiece[1] = "y0" + (column+1) + (row);
            wholePiece[2] = "y0" + (column+2) + (row);
            wholePiece[3] = (row % 2 == 0)? "y0" + (column) + (row+1) : "y0" + (column+1) + (row+1);
        }
        if (colour == 'y' && orientation == 1) {
            wholePiece[1] = (row % 2 == 0)? "y1" + (column-1) + (row+1) : "y1" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "y1" + (column) + (row+1) : "y1" + (column+1) + (row+1);
            wholePiece[3] = "y1" + (column+1) + (row+2);
        }
        if (colour == 'y' && orientation == 2) {
            wholePiece[1] = "y2" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "y2" + (column) + (row+1) : "y2" + (column+1) + (row+1);
            wholePiece[3] = "y2" + (column) + (row+2);
        }
        if (colour == 'y' && orientation == 3) {
            wholePiece[1] = (row % 2 == 0)? "y3" + (column) + (row+1) : "y3" + (column+1) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "y3" + (column-1) + (row+1) : "y3" + (column) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "y3" + (column-2) + (row+1) : "y3" + (column-1) + (row+1);
        }
        if (colour == 'y' && orientation == 4) {
            wholePiece[1] = (row % 2 == 0)? "y4" + (column) + (row+1) : "y4" + (column+1) + (row+1);
            wholePiece[2] = "y4" + (column+1) + (row+2);
            wholePiece[3] = (row % 2 == 0)? "y4" + (column+1) + (row+1) : "y4" + (column+2) + (row+1);
        }
        if (colour == 'y' && orientation == 5) {
            wholePiece[1] = (row % 2 == 0)? "y5" + (column-1) + (row+1) : "y5" + (column) + (row+1);
            wholePiece[2] = "y5" + (column-1) + (row+2);
            wholePiece[3] = "y5" + (column) + (row+2);
        }
        // all cases for green piece:
        if (colour == 'g' && orientation == 0) {
            wholePiece[1] = "g0" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "g0" + (column+1) + (row+1) : "g0" + (column+2) + (row+1);
            wholePiece[3] = "g0" + (column+2) + (row+2);
        }
        if (colour == 'g' && orientation == 1) {
            wholePiece[1] = (row % 2 == 0)? "g1" + (column) + (row+1) : "g1" + (column+1) + (row+1);
            wholePiece[2] = "g1" + (column) + (row+2);
            wholePiece[3] = (row % 2 == 0)? "g1" + (column-1) + (row+3) : "g1" + (column) + (row+3);
        }
        if (colour == 'g' && orientation == 2) {
            wholePiece[1] = (row % 2 == 0)? "g2" + (column-1) + (row+1) : "g2" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "g2" + (column-2) + (row+1) : "g2" + (column-1) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "g2" + (column-3) + (row+1) : "g2" + (column-2) + (row+1);
        }
        if (colour == 'g' && orientation == 3) {
            wholePiece[1] = (row % 2 == 0)? "g2" + (column) + (row+1) : "g2" + (column+1) + (row+1);
            wholePiece[2] = "g1" + (column+1) + (row+2);
            wholePiece[3] = "g1" + (column+2) + (row+2);
        }
        if (colour == 'g' && orientation == 4) {
            wholePiece[1] = (row % 2 == 0)? "g4" + (column-1) + (row+1) : "g4" + (column) + (row+1);
            wholePiece[2] = "g4" + (column-1) + (row+2);
            wholePiece[3] = (row % 2 == 0)? "g4" + (column-1) + (row+3) : "g4" + (column) + (row+3);
        }
        if (colour == 'g' && orientation == 5) {
            wholePiece[1] = (row % 2 == 0)? "g5" + (column-1) + (row+1) : "g5" + (column) + (row+1);
            wholePiece[2] = "g5" + (column+1) + (row);
            wholePiece[3] = "g5" + (column+2) + (row);
        }
        // all cases for blue piece:
        if (colour == 'b' && orientation == 0) {
            wholePiece[1] = "b0" + (column+1) + (row);
            wholePiece[2] = "b0" + (column+2) + (row);
            wholePiece[3] = (row % 2 == 0)? "b0" + (column+1) + (row+1) : "b0" + (column+2) + (row+1);
        }
        if (colour == 'b' && orientation == 1) {
            wholePiece[1] = (row % 2 == 0)? "b1" + (column) + (row+1) : "b1" + (column+1) + (row+1);
            wholePiece[2] = "b1" + (column+1) + (row+2);
            wholePiece[3] = "b1" + (column) + (row+2);
        }
        if (colour == 'b' && orientation == 2) {
            wholePiece[1] = (row % 2 == 0)? "b2" + (column-1) + (row+1) : "b2" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "b2" + (column-2) + (row+1) : "b2" + (column-1) + (row+1);
            wholePiece[3] = "b2" + (column-1) + (row+2);
        }
        if (colour == 'b' && orientation == 3) {
            wholePiece[1] = (row % 2 == 0)? "b3" + (column-1) + (row+1) : "b3" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "b3" + (column) + (row+1) : "b3" + (column+1) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "b3" + (column+1) + (row+1) : "b3" + (column+2) + (row+1);
        }
        if (colour == 'b' && orientation == 4) {
            wholePiece[1] = "b4" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "b4" + (column) + (row+1) : "b4" + (column+1) + (row+1);
            wholePiece[3] = "b4" + (column+1) + (row+2);
        }
        if (colour == 'b' && orientation == 5) {
            wholePiece[1] = (row % 2 == 0)? "b5" + (column-1) + (row+1) : "b5" + (column) + (row+1);
            wholePiece[2] = (row % 2 == 0)? "b5" + (column) + (row+1) : "b5" + (column+1) + (row+1);
            wholePiece[3] = "b5" + (column-1) + (row+2);
        }
        // all cases for indigo piece:
        if (colour == 'i' && orientation == 0) {
            wholePiece[1] = "i0" + (column+1) + (row);
            wholePiece[2] = "i0" + (column+2) + (row);
        }
        if (colour == 'i' && orientation == 1) {
            wholePiece[1] = (row % 2 == 0)? "i1" + (column) + (row+1) : "i1" + (column+1) + (row+1);
            wholePiece[2] = "i1" + (column+1) + (row+2);
        }
        if (colour == 'i' && orientation == 2) {
            wholePiece[1] = (row % 2 == 0)? "i2" + (column-1) + (row+1) : "i2" + (column) + (row+1);
            wholePiece[2] = "i2" + (column-1) + (row+2);
        }
        // all cases for pink piece:
        if (colour == 'p' && orientation == 0) {
            wholePiece[1] = "p0" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "p0" + (column+1) + (row+1) : "p0" + (column+2) + (row+1);
            wholePiece[3] = "p0" + (column+1) + (row+2);
        }
        if (colour == 'p' && orientation == 1) {
            wholePiece[1] = (row % 2 == 0)? "p1" + (column) + (row+1) : "p1" + (column+1) + (row+1);
            wholePiece[2] = "p1" + (column) + (row+2);
            wholePiece[3] = "p1" + (column-1) + (row+2);
        }
        if (colour == 'p' && orientation == 2) {
            wholePiece[1] = "p2" + (column+2) + (row);
            wholePiece[2] = (row % 2 == 0)? "p2" + (column) + (row+1) : "p2" + (column+1) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "p2" + (column+1) + (row+1) : "p2" + (column+2) + (row+1);
        }
        if (colour == 'p' && orientation == 3) {
            wholePiece[1] = (row % 2 == 0)? "p3" + (column-1) + (row+1) : "p3" + (column) + (row+1);
            wholePiece[2] = "p3" + (column) + (row+2);
            wholePiece[3] = "p3" + (column+1) + (row+2);
        }
        if (colour == 'p' && orientation == 4) {
            wholePiece[1] = "p4" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "p4" + (column-1) + (row+1) : "p4" + (column) + (row+1);
            wholePiece[3] = "p4" + (column) + (row+2);
        }
        if (colour == 'p' && orientation == 5) {
            wholePiece[1] = "p5" + (column+1) + (row);
            wholePiece[2] = (row % 2 == 0)? "p5" + (column-1) + (row+1) : "p5" + (column) + (row+1);
            wholePiece[3] = (row % 2 == 0)? "p5" + (column+1) + (row+1) : "p5" + (column+2) + (row+1);
        }
        return wholePiece;
    }

    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given a string describing a game state, and a location
     * that must be covered by the next move, return a set of all
     * possible viable piece strings which cover the location.
     *
     * For a piece string to be viable it must:
     *  - be a well formed piece string
     *  - be a piece that is not already placed
     *  - not overlap a piece that is already placed
     *  - cover the given location
     *  - cover all wizards of the same colour
     *  - not cover any wizards of a different colour
     *
     * @param gameStateString A starting game state string
     * @param col      The location's column.
     * @param row      The location's row.
     * @return A set of all viable piece strings, or null if there are none.
     */
    static Set<String> getViablePieceStrings(String gameStateString, int col, int row) {
        // get piece placement and wizard placement
        int indexForW = -1;
        for (int i = 0; i < gameStateString.length(); i++) {
            if (gameStateString.charAt(i) == 'W') {indexForW = i;break;}
        }
        String piecePlacement = gameStateString.substring(0,indexForW);
        String wizardPlacement = gameStateString.substring(indexForW+1);
        // create an array of wizard strings from the wizard placement
        String[] allWizards = new String[wizardPlacement.length()/3];
        int wizardIndex = 0;
        for (int x = 0; x < wizardPlacement.length(); x = x + 3) {
            String wizardString = wizardPlacement.substring(x,x+3);
            allWizards[wizardIndex] = wizardString;
            wizardIndex++;
        }

        // get all occupied locations and colours
        boolean[] boardStar = occupiedLocation(gameStateString);
        Set<String> usedColours = occupiedColour(piecePlacement);

        // location need to be covered
        Integer neededLocation = locationInt("a"+ col + row);

        // create all possible piece strings
        char[] colours = {'r', 'o', 'y', 'g', 'b', 'i', 'p'};
        Set<String> viablePieceStrings = new HashSet<>();

        for (int tryColourNo = 0; tryColourNo < 7; tryColourNo++) {
            String tryColour = Character.toString(colours[tryColourNo]);
            if (!usedColours.contains(tryColour)) {
                for (int tryOri = 0; tryOri < 6; tryOri++) {
                    for (int tryCol = 0; tryCol < 7; tryCol++) {
                        for (int tryRow = 0; tryRow < 4; tryRow++) {
                            // create a piece string
                            String tryPiece = tryColour + tryOri + tryCol + tryRow;

                            // check if the created piece string is well formed
                            boolean wellFormed = isGameStringWellFormed(tryPiece);
                            if (!wellFormed) {continue;}

                            // check if the whole piece of this created piece is on the board
                            boolean onBoard = isPieceOnBoard(tryPiece);
                            if (!onBoard) {continue;}


                            // check if this created piece and its other stars overlap a piece that is already placed
                            boolean notOverlap = true;
                            String[] tryWholePieces = fullPiece(tryPiece);
                            // use a set to contain these pieces' locations
                            Set<Integer> tryWholePiecesLocations = new HashSet<>();
                            for (String piece : tryWholePieces) {
                                if (!notOverlapWithPieces(boardStar, piece)) {notOverlap = false;}
                                Integer tryPieceLocation = locationInt(piece);
                                tryWholePiecesLocations.add(tryPieceLocation);
                            }
                            if (!notOverlap) {continue;}

                            // check if this created piece with its other stars cover the needed location
                            boolean locationCovered = tryWholePiecesLocations.contains(neededLocation);
                            if (!locationCovered) {continue;}

                            // check if all stars of this created piece cover all wizards of the same colour
                            // and not cover any wizards of a different colour
                            boolean wizardCover =
                                    wizardsCorrectlyCover(allWizards, tryWholePieces, tryWholePiecesLocations);
                            if (!wizardCover) {continue;}

                            // if this created piece passes all criteria, then it can be en element of the output set
                            viablePieceStrings.add(tryPiece);
                        }
                    }
                }
            }
        }
        if (viablePieceStrings.isEmpty()) return null;
        return viablePieceStrings;
    }


    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * This method will take in a piece string
     * and check whether all of its stars is on the board
     *
     * @param pieceString A piece string of the piece to be checked
     * @return A boolean value which states whether this piece is on the board or not, true if all stars are on board
     */
    public static boolean isPieceOnBoard(String pieceString) {
        String[] piece = fullPiece(pieceString); // get an array of strings of all the stars in this entire piece
        for (String p : piece) {
            if (!(isGameStringWellFormed(p))) {
                return false;
            }
        }
        return true;
    }

    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * This method will take in a game string of the current board state and a piece string
     * and check whether this piece overlaps with other existed pieces on the board
     *
     * @param boardStar A boolean array which records if a location is occupied already or not
     * @param pieceString The piece to be checked
     * @return A boolean value which states whether this piece overlaps with other existed piece on the board,
     * true if it does not overlap with others
     */
    public static boolean notOverlapWithPieces(boolean[] boardStar, String pieceString) {
        int newLocation = locationInt(pieceString);
        if (boardStar[newLocation]) {return false;}
        return true;
    }

    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given an array of wizard strings, an array of star strings and a set of Integer which are the location of the
     * star strings from the array, check if these stars are correctly implemented:
     * - the stars cover all wizards of the same colour
     * - the stars do not cover any wizards of a different colour
     *
     * @param wizards An array of wizard strings
     * @param stars An array of piece strings
     * @param starsLocations A hashset of Integers which corresponding to the locations of the pieces in the
     *                       given array of piece strings
     * @return A boolean value which states if the pieces(stars) are correctly implemented according to the wizards,
     * true if stars are correctly implemented.
     */
    public static boolean wizardsCorrectlyCover(String[] wizards, String[] stars, Set<Integer> starsLocations) {
        Character starColour = stars[0].charAt(0);
        for (int w = 0; w < wizards.length; w++) { // get through all wizard pieces in the array of wizards
            String wizard = wizards[w];
            Character wizardColour = wizard.charAt(0); // wizard piece colour
            Integer wizardLocation = locationInt(wizard); // wizard piece location int
            // star piece should cover the wizard with the same colour, otherwise false
            if (wizardColour == starColour && !starsLocations.contains(wizardLocation)) {return false;}
            // star piece should not cover the wizard with a different colour
            if (wizardColour != starColour && starsLocations.contains(wizardLocation)) {return false;}
        }
        return true;
    }


    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given a string of piece placement, return a set of strings which are the colours of the pieces
     * of the given piece placement, each string is the first char of each piece string expressed as a string
     *
     * @param piecePlacement A piece placement
     * @return A set of strings which are the colours of the pieces in the piece placement
     */
    public static Set<String> occupiedColour(String piecePlacement) {
        Set<String> usedColours = new HashSet<>();
        if (piecePlacement.length() != 0) {
            for (int i = 0; i < piecePlacement.length(); i = i + 4) {
                usedColours.add(Character.toString(piecePlacement.charAt(i))); // add the piece colour to the set
            }
        }
        return usedColours;
    }


    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given a string of the game state, return a boolean array which tells if each of the 26 locations is occupied on
     * the board or not, according to the given game state. The boolean is true means there is a star on that location.
     *
     * @param gameState A string of the game state
     * @return An array of 26 booleans which tells if each location is occupied on the board or not
     */
    public static boolean[] occupiedLocation(String gameState) {
        int indexOfW = 0;
        for (int i = 0; i < gameState.length(); i++) {
            if (gameState.charAt(i) == 'W') {indexOfW = i;}
        }
        String piecePlacement = gameState.substring(0,indexOfW); // get piecePlacement

        boolean[] boardStar = new boolean[26];
        if (piecePlacement.length() != 0) {
            for (int i = 0; i < piecePlacement.length(); i = i + 4) {
                String star = piecePlacement.substring(i, i + 4); // the string for one star
                String[] wholePiece = fullPiece(star); // array of strings of all the stars in this entire piece
                for (String s : wholePiece) {
                    int occupiedLocation = locationInt(s);
                    boardStar[occupiedLocation] = true;
                } // if a location is occupied by a star, change its corresponding boolean value to true
            }
        }
        return boardStar;
    }

    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given an array of booleans of the board state, return a set of strings of locations which are empty.
     *
     * @param occupiedLocation An array of booleans which represents the 26 locations being occupied or not
     * @return A set of strings, each string which represents the column and row numbers of an empty location
     */
    public static Set<String> emptyLocation(boolean[] occupiedLocation) {
        Set<String> emptyLocations = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (occupiedLocation[i] == false) {emptyLocations.add(locationString(i));}
            // get the locationNo of an empty location and change the int to a string which contains the position's col
            // and row, add the string of location to the set
        }
        return emptyLocations;
    }

    /**
     * AUTHORSHIP: Ting Tang with contributions from Ben Pope and Shafin Kamal
     *
     * Given a string of game state and a string of piece string, return a string of the new game state after the input
     * piece string is added to the input game state.
     *
     * @param gameState A string of game state before adding the new piece string
     * @param pieceString A string of a piece string which is going to be added on to the game state
     * @return A string of the new game state which is a valid game state
     */
    public static String updateGameState(String gameState, String pieceString) {
        int indexOfW = 0;
        for (int i = 0; i < gameState.length(); i++) {
            if (gameState.charAt(i) == 'W') {indexOfW = i;}
        }
        String previousPlacement = gameState.substring(0,indexOfW);// get the piecePlacement
        String wAndWizardPlacement = gameState.substring(indexOfW);// get the other half of the gameState

        if (previousPlacement.length() != 0) {
            // find where in the game state should the new piece string be placed into
            int pieceNo = previousPlacement.length() / 4;
            for (int i = 0; i < pieceNo; i++) {
                String firstHalf = previousPlacement.substring(0,4*i);
                String secondHalf = previousPlacement.substring(4*i);
                StringBuilder newPlacement = new StringBuilder();
                newPlacement.append(firstHalf).append(pieceString).append(secondHalf);
                if (checkColourOrder(newPlacement.toString(),'p')) {return newPlacement + wAndWizardPlacement;}
            }
            return previousPlacement + pieceString + wAndWizardPlacement;
        }
        return pieceString + gameState;
    }


    /**
     * AUTHORSHIP: Ting Tang
     *
     * Implement a solver for this game that can return the solution to a
     * particular challenge.
     *
     * This task is at the heart of the assignment and requires you to write
     * solver, similar to the boggle solver presented as part of the J14 lecture.
     *
     * NOTE: Simply looking up the provided answers does not constitute a general
     * solver.  Such an implementation is not a solution to this task, and
     * will not receive marks.
     *
     * @param challenge A game state string describing the starting game state.
     * @return A game state string describing the encoding of the solution to
     * the challenge.
     */
    public static String getSolution(String challenge) {

        // identify if the challenge is a wizard challenge or not
        int indexForW = 0;
        if (challenge.charAt(0) != 'W') {indexForW = challenge.length()-1;}

        // find all the inputs needed for the recursive method based on the challenge
        boolean[] boardState = occupiedLocation(challenge);
        Set<String> emptyLocationNo = emptyLocation(boardState);
        Set<String> solutions = new HashSet<>();
        Set<String> usedColours = new HashSet<>();
        if (indexForW != 0) {
            String piecePlacement = challenge.substring(0,indexForW);
            usedColours = occupiedColour(piecePlacement); // for a piece challenge
        }

        // run the recursive helper function to find the solution which is stored in variable "solutions"
        getFixedSolution(usedColours,emptyLocationNo,challenge,solutions);

        // get the string of the solution out from the variable "solutions"
        String solution = new String();
        for (String s : solutions) {solution = s;}
        return solution;
    }
    // This method should work properly, but it takes a longer period of time which leads some of the tests to be failed


    /**
     * AUTHORSHIP: Ting Tang
     *
     * The recursive method to find the the solution of a correct game state by keeping adding piece strings.
     *
     * @param usedColours A set of strings which are the strings of colours used
     * @param emptyLocations A set of strings which are the strings of empty locations on the board
     * @param gameState A game state string
     * @param answerGameState A set of game state string which is usually empty, it is used to store the solution string
     *                        during the recursion
     */
    public static void getFixedSolution(Set<String> usedColours, Set<String> emptyLocations, String gameState,
                                        Set<String> answerGameState) {
        // iterate over all possible empty locations till a solution is found
        for (String emptyLoc :emptyLocations) {
            // get all possible viable pieces to cover this empty location
            int col = Integer.parseInt(String.valueOf(emptyLoc.charAt(0)));
            int row = Integer.parseInt(String.valueOf(emptyLoc.charAt(1)));
            Set<String> viablePieces = getViablePieceStrings(gameState, col, row);

            // if no viable piece can be found to cover this location,
            // it means some previous piece being placed wrong,
            // stop the for loop and move on to the previous for loop in the recursion
            if (viablePieces == null) {break;}

            // if there is a solution already, stop the for loop and stop the recursion
            if (!answerGameState.isEmpty()) {break;}

            // if no solution is found and there are viable piece(s) at this empty location,
            // iterate over all possible viable pieces
            else {
                for (String tryPiece : viablePieces) {
                    // try each viable piece and
                    // when trying that piece,
                    // update the game state with taking this piece string in to form a new game state
                    String tryColour = String.valueOf(tryPiece.charAt(0));
                    usedColours.add(tryColour);
                    String gameStateCopy = gameState;
                    gameState = updateGameState(gameState, tryPiece);
                    Set<String> emptyLocationsCopy = Set.copyOf(emptyLocations);
                    emptyLocations = emptyLocation(occupiedLocation(gameState));

                    // If the new formed game state contains 7 coloured pieces and no empty locations left,
                    // this game state is the solution for the challenge.
                    // add this new formed game state into the set which stores the solution
                    // and stop the for loop
                    if (usedColours.size() == 7 && emptyLocations.isEmpty()) {answerGameState.add(gameState);break;}


                    // If not all colours are used and still empty locations left,
                    // call this method again recursively to find next suitable piece to be placed
                    getFixedSolution(usedColours,emptyLocations,gameState,answerGameState);

                    // After trying this piece, remove all the information updated by this tried piece
                    // in order to let other pieces in the set to redo all the steps in this for loop
                    usedColours.remove(tryColour);
                    gameState = gameStateCopy;
                    emptyLocations = emptyLocationsCopy;
                }
            }
        }
    }

    /**
     * AUTHORSHIP: Ben Pope
     *
     * Enum for quick exchange between char and colours
     *  For the 7 unique colours of the IQStars pieces,
     *  RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, PINK
     */
    public enum ROYGBIP {
        RED('r', "red"), ORANGE('o', "orange"), YELLOW('y', "yellow"),
        GREEN('g', "green"), BLUE('b', "blue"), INDIGO('i', "indigo"),
        PINK('p', "pink");

        private final char pieceChar;
        private final String colour;

        ROYGBIP(char enumChar, String enumColour) {
            pieceChar = enumChar;
            colour = enumColour;
        }

        public char getChar() {
            return pieceChar;
        }

        public String getColour() {
            return colour;
        }

        public static ROYGBIP getROYGBIP(char givenChar) {
            switch (givenChar) {
                case 'r' -> { return RED; }
                case 'o' -> { return ORANGE; }
                case 'y' -> { return YELLOW; }
                case 'g' -> { return GREEN; }
                case 'b' -> { return BLUE; }
                case 'i' -> { return INDIGO; }
                case 'p' -> { return PINK; }
                default -> { return null; }
            }
        }
    }

}
