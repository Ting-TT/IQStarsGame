package comp1110.ass2.gui;

import comp1110.ass2.IQStars;
import comp1110.ass2.Games;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

/**
 * This viewer was predominantly done by Ben Pope with contribution from Shafin Kamal for
 * the implementation of challenges
 *
 * A very simple viewer for game states in the IQ-Stars game.
 * <p>
 * NOTE: This class is separate from your main game class. This
 * class does not play a game, it just illustrates various game
 * states.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int VIEWER_WIDTH = 720;
    private static final int VIEWER_HEIGHT = 480;
    private Double[] wizardStarLocs = new Double[]{
            48.0, 28.0, 72.0, 42.0,
            96.0, 28.0, 96.0, 56.0,
            120.0, 70.0, 96.0, 86.0,
            96.0, 112.0, 72.0, 98.0,
            48.0, 112.0, 48.0, 86.0,
            24.0, 70.0, 48.0, 56.0
    };
    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField textField;
    private final Group piecesGroup = new Group();
    private final Group wizardGroup = new Group();

    private final char[] pieceLetters = new char[]{'r', 'o', 'y', 'g', 'b', 'i', 'p'};


    /**
     * Draw a game state in the window, removing any previously drawn one
     *
     * @param gameStateString A valid game state string
     */
    void makeGameState(String gameStateString) throws FileNotFoundException {
        // Clears existing pieces from the board for new gamestate
        piecesGroup.getChildren().clear();
        wizardGroup.getChildren().clear();

        //Declares new arrays to store each Piece and Wizard String(s)
        String pieceStringWhole = new String("");
        String[] pieceStringArray = new String[7];
        String wizardStringWhole = new String("");
        String[] wizardStringArray = new String[7];

        //Split pieceStringWhole to array
        if (IQStars.isGameStateStringWellFormed(gameStateString)) {
            for (int i = 0; i < gameStateString.length(); i++) {
                if (gameStateString.charAt(i) == 'W') {
                    pieceStringWhole = gameStateString.substring(0, i);
                    wizardStringWhole = gameStateString.substring(i+1);
                }
            }
        }

        /* Declares arrays to store:
            positioningArray: Modifications for each present piece
            imageViewArray: ImageView Asset-obtained Objects
            wizardArray: ImageView shape-composed Objects
         */
        String[] positioningArray = new String[7];
        ImageView[] imageViewArray = new ImageView[7];
        Polygon[] wizardArray = new Polygon[wizardStringWhole.length() /3];

        //Separates individual pieces to array
        if (!pieceStringWhole.equals("")) {
            int stringLength = pieceStringWhole.length();
            int noPieces = stringLength / 4;
            for (int i = 0; i < noPieces; i++) {
                pieceStringArray[i] = pieceStringWhole.substring(i * 4, i * 4 + 4);
            }
        }

        //Separates individual wizards strings to array
        if (!wizardStringWhole.equals("")) {
            int stringLength = wizardStringWhole.length();
            int noPieces = stringLength / 3;
            for (int i = 0; i < noPieces; i++) {
                wizardStringArray[i] = wizardStringWhole.substring(i * 3, i * 3 + 3);
            }
        }

        //Removes invalid strings and placements from array
        for (int i = 0; i < pieceStringArray.length; i++) {
            if (pieceStringArray[i] != null) {
                if ((!IQStars.isGameStringWellFormed(pieceStringArray[i]))
                        || IQStars.isOverhangingPos(pieceStringArray[i])) {
                    pieceStringArray[i] = null;
                }
            }
        }

        // Removes invalid wizard strings from array
        for (int i = 0; i < wizardStringArray.length; i++) {
            if (wizardStringArray[i] != null) {
                if (!IQStars.isGameStringWellFormed(wizardStringArray[i])) {
                    wizardStringArray[i] = null;
                }
            }
        }

        // Iterate through array, add pieces to ImageView[] if present
        for (String pieceString : pieceStringArray) {
            if (pieceString != null) {
                switch (pieceString.charAt(0)) {
                    case 'r':
                        FileInputStream redPieceIS = new FileInputStream("assets/redPiece.png");
                        Image redPieceImage = new Image(redPieceIS);
                        ImageView redPiece = new ImageView(redPieceImage);
                        imageViewArray[0] = redPiece;
                        positioningArray[0] = pieceString.substring(1);
                        break;
                    case 'o':
                        FileInputStream orangePieceIS = new FileInputStream("assets/orangePiece.png");
                        Image orangePieceImage = new Image(orangePieceIS);
                        ImageView orangePiece = new ImageView(orangePieceImage);
                        imageViewArray[1] = orangePiece;
                        positioningArray[1] = pieceString.substring(1);
                        break;
                    case 'y':
                        FileInputStream yellowPieceIS = new FileInputStream("assets/yellowPiece.png");
                        Image yellowPieceImage = new Image(yellowPieceIS);
                        ImageView yellowPiece = new ImageView(yellowPieceImage);
                        imageViewArray[2] = yellowPiece;
                        positioningArray[2] = pieceString.substring(1);
                        break;
                    case 'g':
                        FileInputStream greenPieceIS = new FileInputStream("assets/greenPiece.png");
                        Image greenPieceImage = new Image(greenPieceIS);
                        ImageView greenPiece = new ImageView(greenPieceImage);
                        imageViewArray[3] = greenPiece;
                        positioningArray[3] = pieceString.substring(1);
                        break;
                    case 'b':
                        FileInputStream bluePieceIS = new FileInputStream("assets/bluePiece.png");
                        Image bluePieceImage = new Image(bluePieceIS);
                        ImageView bluePiece = new ImageView(bluePieceImage);
                        imageViewArray[4] = bluePiece;
                        positioningArray[4] = pieceString.substring(1);
                        break;
                    case 'i':
                        FileInputStream indigoPieceIS = new FileInputStream("assets/indigoPiece.png");
                        Image indigoPieceImage = new Image(indigoPieceIS);
                        ImageView indigoPiece = new ImageView(indigoPieceImage);
                        imageViewArray[5] = indigoPiece;
                        positioningArray[5] = pieceString.substring(1);
                        break;
                    case 'p':
                        FileInputStream pinkPieceIS = new FileInputStream("assets/pinkPiece.png");
                        Image pinkPieceImage = new Image(pinkPieceIS);
                        ImageView pinkPiece = new ImageView(pinkPieceImage);
                        imageViewArray[6] = pinkPiece;
                        positioningArray[6] = pieceString.substring(1);
                        break;
                }
            }
        }
        // Generates wizards
        for (int i = 0; i < wizardStringArray.length; i++) {
            String wizardString = wizardStringArray[i];
            if (wizardString != null) {

                Polygon wizardStar = new Polygon();
                wizardStar.getPoints().addAll(wizardStarLocs);
                int wizardX = Character.getNumericValue(wizardString.charAt(1));
                int wizardY = Character.getNumericValue(wizardString.charAt(2));

                int xCoord = wizardX * 96;
                int yCoord = wizardY * 84;
                if (wizardY % 2 != 0) {
                    xCoord = xCoord + 48;
                }
                Translate translate = new Translate();
                translate.setX(xCoord);
                translate.setY(yCoord);
                switch (wizardString.charAt(0)) {
                    case 'r':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.RED);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                    case 'o':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.ORANGE);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                    case 'y':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.YELLOW);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                    case 'g':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.GREEN);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                    case 'b':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.BLUE);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                    case 'i':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.INDIGO);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                    case 'p':
                        wizardArray[i] = wizardStar;
                        wizardArray[i].setFill(Color.HOTPINK);
                        wizardArray[i].getTransforms().addAll(translate);
                        break;
                }
            }
        }
        // Preserves ratio for all images
        // Resizes pieces to match board
        for (int i = 0; i < 7; i++) {
            if (imageViewArray[i] != null) {
                imageViewArray[i].setPreserveRatio(true);
                if (i == 0 || i == 1 || i == 6) {
                    imageViewArray[i].setFitWidth(240);
                } else {
                    imageViewArray[i].setFitWidth(288);
                }
            }
        }
        // Orients picture according to second element of piece string
        for (int i = 0; i < 7; i++) {
            if (positioningArray[i] != null) {
                int imageRotation = positioningArray[i].charAt(0);
                assert imageViewArray[i] != null;
                imageViewArray[i].setRotate(60 * imageRotation);
            }
        }
        // Translates picture to position; final elements of piece string
        for (int i = 0; i < 7; i++) {
            if (positioningArray[i] != null) {
                //Instantiates and Declares variables for x and y translation(s)
                int xCoord = Character.getNumericValue(positioningArray[i].charAt(1));
                double xCoordTrans = xCoord * 96;
                int yCoord = Character.getNumericValue(positioningArray[i].charAt(2));
                double yCoordTrans = yCoord * 84;
                int rotateFactor = Character.getNumericValue(positioningArray[i].charAt(0));

                if (yCoord % 2 != 0) { //Accounts for alternating no. of columns
                    xCoordTrans = xCoordTrans + 48;
                }

                // translate x-coordinate, Switches for piece, and orientation
                switch (i) {
                    case 0:
                        switch (rotateFactor) {
                            case 0 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1 -> imageViewArray[i].setLayoutX(-48 + xCoordTrans);
                            case 2 -> imageViewArray[i].setLayoutX(-24 + xCoordTrans);
                        }
                        break;
                    case 1:
                        //
                        switch (rotateFactor) {
                            case 0 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1, 4 -> imageViewArray[i].setX(-48 + xCoordTrans);
                            case 2 -> imageViewArray[i].setX(-120 + xCoordTrans);
                            case 3, 6 -> imageViewArray[i].setX(24 + xCoordTrans);
                            case 5 -> imageViewArray[i].setX(-24 + xCoordTrans);
                        }
                        break;
                    case 2:
                        switch (rotateFactor) {
                            case 0, 6 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1, 2 -> imageViewArray[i].setLayoutX(-60 + xCoordTrans);
                            case 3 -> imageViewArray[i].setLayoutX(-120 + xCoordTrans);
                            case 4 -> imageViewArray[i].setLayoutX(12 + xCoordTrans);
                            case 5 -> imageViewArray[i].setLayoutX(-84 + xCoordTrans);
                        }
                        break;
                    case 3:
                        switch (rotateFactor) {
                            case 0, 3, 6 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1, 4 -> imageViewArray[i].setLayoutX(-96 + xCoordTrans);
                            case 2 -> imageViewArray[i].setLayoutX(-192 + xCoordTrans);
                            case 5 -> imageViewArray[i].setLayoutX(xCoordTrans);
                        }
                        break;
                    case 4:
                        switch (rotateFactor) {
                            case 0, 6 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1 -> imageViewArray[i].setLayoutX(-60 + xCoordTrans);
                            case 2 -> imageViewArray[i].setLayoutX(-156 + xCoordTrans);
                            case 3 -> imageViewArray[i].setLayoutX(-24 + xCoordTrans);
                            case 4 -> imageViewArray[i].setLayoutX(12 + xCoordTrans);
                            case 5 -> imageViewArray[i].setLayoutX(-84 + xCoordTrans);
                        }
                        break;
                    case 5:
                        switch (rotateFactor) {
                            case 0 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1 -> imageViewArray[i].setLayoutX(-24 + xCoordTrans);
                            case 2 -> imageViewArray[i].setLayoutX(-120 + xCoordTrans);
                        }
                        break;
                    case 6:
                        switch (rotateFactor) {
                            case 0, 6 -> imageViewArray[i].setLayoutX(24 + xCoordTrans);
                            case 1 -> imageViewArray[i].setLayoutX(-84 + xCoordTrans);
                            case 2 -> imageViewArray[i].setLayoutX(36 + xCoordTrans);
                            case 3 -> imageViewArray[i].setLayoutX(-24 + xCoordTrans);
                            case 4 -> imageViewArray[i].setLayoutX(-12 + xCoordTrans);
                            case 5 -> imageViewArray[i].setLayoutX(12 + xCoordTrans);
                        }
                        break;
                }

                // translates y-coordinate, Switches for piece, and orientation
                switch (i) {
                    case 0:
                        switch (rotateFactor) {
                            case 0, 2 -> imageViewArray[i].setLayoutY(28 + yCoordTrans);
                            case 1 -> imageViewArray[i].setLayoutY(72 + yCoordTrans);
                        }
                        break;
                    case 1:
                        switch (rotateFactor) {
                            case 0, 2, 3, 5, 6 -> imageViewArray[i].setLayoutY(28 + yCoordTrans);
                            case 1, 4 -> imageViewArray[i].setLayoutY(68 + yCoordTrans);
                        }
                        break;
                    case 2:
                    case 4:
                        switch (rotateFactor) {
                            case 0,3,6 -> imageViewArray[i].setLayoutY(28 + yCoordTrans);
                            case 1, 5 -> imageViewArray[i].setLayoutY(92 + yCoordTrans);
                            case 2, 4 -> imageViewArray[i].setLayoutY(50 + yCoordTrans);
                        }
                        break;
                    case 3:
                        switch (rotateFactor) {
                            case 0, 3, 6 -> imageViewArray[i].setLayoutY(28 + yCoordTrans);
                            case 1, 4 -> imageViewArray[i].setLayoutY(70 + yCoordTrans);
                            case 2, 5 -> imageViewArray[i].setLayoutY(-14 + yCoordTrans);
                        }
                        break;
                    case 5:
                        switch (rotateFactor) {
                            case 0 -> imageViewArray[i].setLayoutY(28 + yCoordTrans);
                            case 1, 2 -> imageViewArray[i].setLayoutY(112 + yCoordTrans);
                        }
                        break;
                    case 6:
                        switch (rotateFactor) {
                            case 0, 3, 6 -> imageViewArray[i].setLayoutY(28 + yCoordTrans);
                            case 1 -> imageViewArray[i].setLayoutY(49 + yCoordTrans);
                            case 2 -> imageViewArray[i].setLayoutY(-35 + yCoordTrans);
                            case 4, 5 -> imageViewArray[i].setLayoutY(7 + yCoordTrans);
                        }
                }
            }
        }
        // Add ImageView nodes to parent groups; to the scene.
        for (Polygon finalWizard : wizardArray) {
            if (finalWizard != null) {
                wizardGroup.getChildren().add(finalWizard);
            }
        }
        for (ImageView finalPiece : imageViewArray) {
            if (finalPiece != null) {
                piecesGroup.getChildren().add(finalPiece);
            }
        }
    }

    /**
     * getRandomChallenge selects a random challenge from the Games class depending on which difficulty is selected
     * @return random gameStateString String
     */
    public static String getRandomChallenge(int beginIdx, int endIdx) {
        String[] array = Arrays.copyOfRange(Games.ALL_CHALLENGES, beginIdx, endIdx);
        return array[new Random().nextInt(array.length)];
    }
    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Game State:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        Button starterButton = new Button("Starter");
        Button juniorButton = new Button("Junior");
        Button expertButton = new Button("Expert");
        Button masterButton = new Button("Master");
        Button wizardButton = new Button("Wizard");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    makeGameState(textField.getText());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                textField.clear();
            }
        });


        // Starter challenge button
        starterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String challenge = getRandomChallenge(0,23);
                try {
                    makeGameState(challenge);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                textField.clear();
            }
        });

        // Junior challenge button
        juniorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String challenge = getRandomChallenge(24,47);
                try {
                    makeGameState(challenge);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                textField.clear();
            }
        });

        // Expert challenge button
        expertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String challenge = getRandomChallenge(48, 71);
                try {
                    makeGameState(challenge);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                textField.clear();
            }
        });

        // Master challenge button
        masterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String challenge = getRandomChallenge(72,95);
                try {
                    makeGameState(challenge);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                textField.clear();
            }
        });

        // Wizard challenge button
        wizardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String challenge = getRandomChallenge(96,119);
                try {
                    makeGameState(challenge);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                textField.clear();
            }
        });



        VBox difficultyBox = new VBox();
        difficultyBox.getChildren().addAll(starterButton, juniorButton, expertButton, masterButton, wizardButton);
        difficultyBox.setSpacing(30);
        difficultyBox.setLayoutX(VIEWER_WIDTH + 20);
        difficultyBox.setLayoutY(VIEWER_HEIGHT-400);

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);

        controls.getChildren().addAll(hb,difficultyBox);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("IQ Stars Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH+100, VIEWER_HEIGHT+50);

        //Creates background image of the board
        FileInputStream blankBoardIS = new FileInputStream("assets/blankBoard.png");
        Image blankBoardImage = new Image(blankBoardIS);
        ImageView blankBoard = new ImageView(blankBoardImage);
        blankBoard.setPreserveRatio(true);
        blankBoard.setFitWidth(VIEWER_WIDTH);

        //All nodes added to root
        root.getChildren().add(controls);
        root.getChildren().add(blankBoard);
        root.getChildren().add(wizardGroup);
        root.getChildren().add(piecesGroup);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
