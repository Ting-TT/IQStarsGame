package comp1110.ass2.gui;

import comp1110.ass2.*;
import comp1110.ass2.Games;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

/**
 * AUTHORSHIP: This Class was authored by Benjamin Pope. With additional code by Shafin Kamal.
 */

public class Board extends Application {

    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    //initialise 7 unique Pieces
    Piece[] pieceArray = new Piece[]{new Piece("r0"), new Piece("o0"),
            new Piece("y0"), new Piece("g0"), new Piece("b0"),
            new Piece("i0"), new Piece("p0")};

    private final Group root = new Group();

    private static String GAME_STATE = "W";
    private static String GAME_CHALLENGE = "W";
    private static String GAME_WIZARDS = "";

    //Points for formation of blank siz-pointed star
    Double[] starVertices = new Double[]{
            48.0, 28.0, 72.0, 42.0,
            96.0, 28.0, 96.0, 56.0,
            120.0, 70.0, 96.0, 86.0,
            96.0, 112.0, 72.0, 98.0,
            48.0, 112.0, 48.0, 86.0,
            24.0, 70.0, 48.0, 56.0
    };

    // FIXME Task 8 (CR): Implement a basic playable IQ Stars game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 9 (D): Implement challenges (you may use the set of challenges in the Games class)

    // FIXME Task 11 (HD): Implement hints (should become visible when the user presses '/' -- see gitlab issue for details)

    // FIXME Task 12 (HD): Generate interesting challenges (each challenge must have exactly one solution)


    //Initialise activeStarLoc and activePiece to be effectively "null"
    int activeStarLoc = -1; //Stores current location mouse is over
    Piece activePiece = null; // Stores current piece being dragged

    Group wizGroup = new Group(); //Stores wizard stars

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("IQ Stars");
        Scene scene = new Scene(root, BOARD_WIDTH, BOARD_HEIGHT);

        makeBoard(); //Form blank Board

        root.getChildren().add(wizGroup);

        makeSnapLoc(); // Form "location" stars (Board spaces)

        makePieces(); // Form ImageViews for the pieceArray

        makeControls(); // Form game controls

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //Initialises Board and adds to root
    public void makeBoard() throws FileNotFoundException {
        FileInputStream blankBoardIS = new FileInputStream("assets/blankBoard.png");
        Image blankBoardImage = new Image(blankBoardIS);
        ImageView blankBoard = new ImageView(blankBoardImage);
        blankBoard.setPreserveRatio(true);
        blankBoard.setFitWidth(600);
        blankBoard.setLayoutX(166); //1/2*(StageWidth * blankBoardWidth)

        blankBoard.setOnMouseDragExited(e -> {
            activeStarLoc = -1;
        });
        blankBoard.setOnMouseDragReleased(e -> {
            activeStarLoc = -1;
        });

        root.getChildren().add(blankBoard);
    }

    //Initialises Pieces and adds to root
    public void makePieces() throws FileNotFoundException {
        Piece[] gamePieces = new Piece[]{ new Piece("r0"), new Piece("o0"),
                new Piece("y0"), new Piece("g0"), new Piece("b0"),
                new Piece("i0"), new Piece("p0")};
        int i = 0;
        for (Piece gamePiece : gamePieces) {
            if (gamePiece.getPieceIV() != null) {
                root.getChildren().add(gamePiece.getDraggableGroup());
                formDragEvent(gamePiece);
            }
            pieceArray[i] = gamePieces[i];
            i++;
        }
    }

    //Snapping Locations
    public void makeSnapLoc() {
        Polygon activeStar = null;
        //Adjusts stars to appropriate size
        //(ie. ratio between blankBoard width and blankBoard of viewerCLass)
        for (int i = 0; i < starVertices.length; i++) {
            double starVertex = starVertices[i];
            starVertices[i] = starVertex * 0.83;
        }

        Polygon[] stars = new Polygon[26];
        Group rowGroup = new Group();
        TilePane row0 = new TilePane();
        TilePane row1 = new TilePane();
        TilePane row2 = new TilePane();
        TilePane row3 = new TilePane();

        row0.setPrefColumns(7);
        row1.setPrefColumns(6);
        row2.setPrefColumns(7);
        row3.setPrefColumns(6);

        for (int i = 0; i < 26; i++) {
            stars[i] = new Polygon();
            stars[i].getPoints().addAll(starVertices);
            stars[i].setFill(Color.SKYBLUE);
            stars[i].setOpacity(0);
            makeDetectable(stars[i], i);
            if (i < 7) {
                row0.getChildren().add(stars[i]);
            } else if (i < 13) {
                row1.getChildren().add(stars[i]);
            } else if (i < 20) {
                row2.getChildren().add(stars[i]);
            } else {
                row3.getChildren().add(stars[i]);
            }
        }
        rowGroup.getChildren().addAll(row0, row1, row2, row3);
        row0.setLayoutX(186);
        row0.setLayoutY(24);
        row1.setLayoutX(186 + 40);
        row1.setLayoutY(24 + 70);
        row2.setLayoutX(186);
        row2.setLayoutY(24 + 140);
        row3.setLayoutX(186 + 40);
        row3.setLayoutY(24 + 210);
        root.getChildren().add(rowGroup);
    }

    /**
     * AUTHORSHIP: Button functionality by Shafin Kamal with contributions by Ben Pope
    Forms challenge buttons, as well as reset buttons
     */
    public void makeControls() {
        Group controlsGroup = new Group();
        Text instruct = new Text("Click pieces to rotate. Drag pieces to place." +
                " The board will light up where the top left-most star would be placed" +
                " when released. Replay button will reset game challenge.");
        Button replayBtn = new Button("Replay");
        Button starterBtn = new Button("Starter");
        Button juniorBtn = new Button("Junior");
        Button expertBtn = new Button("Expert");
        Button masterBtn = new Button("Master");
        Button wizardBtn = new Button("Wizard");

        // aligns the reset button
        VBox refreshVBox = new VBox();
        refreshVBox.getChildren().add(replayBtn);
        refreshVBox.setLayoutX(BOARD_WIDTH - 120);
        refreshVBox.setLayoutY(BOARD_HEIGHT - 690);

        VBox buttonVbox = new VBox();
        buttonVbox.getChildren().addAll(starterBtn, juniorBtn,
                expertBtn, masterBtn, wizardBtn);
        controlsGroup.getChildren().addAll(buttonVbox, refreshVBox);
        Button[] difficultyButtons = new Button[]{starterBtn, juniorBtn,
                expertBtn, masterBtn, wizardBtn};

        // aligning challenges button
        buttonVbox.setSpacing(25);
        buttonVbox.setLayoutX(BOARD_WIDTH - 933);
        buttonVbox.setLayoutY(BOARD_HEIGHT - 690);
        buttonVbox.setAlignment(Pos.CENTER);
        root.getChildren().add(controlsGroup);
        root.getChildren().add(instruct);

        instruct.setLayoutX(775);
        instruct.setLayoutY(80);
        instruct.setWrappingWidth(150);


        //Creates event handler for each difficulty button.
        for (Button btn : difficultyButtons) {

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    String actionButton = actionEvent.getSource().toString();
                    int i = 0;
                    int multiplier = 0;
                    for (Button btn : difficultyButtons) {
                        if (actionButton.equals(btn.toString())) {
                            multiplier = i;
                        }
                        i++;
                    }

                    setRandomChallenge(multiplier*24, (multiplier*24)+24);
                    setChallenge(); //Set CURRENT_CHALLENGE
                    actionEvent.consume();
                }
            });
        }

        replayBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent replayPress) {
                setChallenge();
                System.out.println(GAME_STATE);
            }
        });
    }

    public void makeDetectable(Polygon star, int loc) {
        star.setOnMouseDragEntered(e -> {
            star.setOpacity(50);
            activeStarLoc = loc;
        });
        star.setOnMouseDragExited(e -> {
            star.setOpacity(0);
            if (activePiece != null) { activePiece.xyPrime = -1;}
            activeStarLoc = -1;
        });

    }

    public void formDragEvent(Piece piece) {
        piece.pieceIV.setOnMouseDragged(e -> {
            piece.pieceIV.setLayoutX(e.getSceneX());
            piece.pieceIV.setLayoutY(e.getSceneY());
        });
        piece.pieceIV.addEventHandler(MouseEvent.DRAG_DETECTED, e -> {
            piece.pieceIV.startFullDrag();
            activePiece = piece;
        });
        piece.pieceIV.setOnMouseReleased(e -> {
            if (activePiece != null) {
                GAME_STATE = updateGS(pieceArray, activePiece, activeStarLoc);
            }
            activeStarLoc = -1;
            activePiece = null;
        });
    }

    /** Updates GAME_CHALLENGE and GAME_STATE
     * AUTHORSHIP: Shafin Kamal
     *
     * getRandomChallenge selects a random challenge from the Games class depending on which difficulty is selected
     * @return random gameStateString String, sets GAME_CHALLENGE and GAME_STATE
     */
    public static void setRandomChallenge(int beginIdx, int endIdx) {
        String[] array = Arrays.copyOfRange(Games.ALL_CHALLENGES, beginIdx, endIdx);
        String selection = array[new Random().nextInt(array.length)];
        GAME_CHALLENGE = selection;
    }

    /**
     * sets up/refreshes current GAME_STATE
     */
    public void setGameState() {
        String crntState = this.GAME_STATE;
        for (int i = 0; i < crntState.length(); i++) {
            if (crntState.charAt(i) == 'W') {
                String pieceStrings = crntState.substring(0, i);
                String wizardStrings = crntState.substring(i + 1);
                setPieces(pieceStrings);
                setWizards(wizardStrings);
            }
        }
    }

    /**
     * AUTHORSHIP: Shafin Kamal
     *
     * sets up current challenge
     */
    public void setChallenge() {
        resetPositions();
        String crntChallenge = this.GAME_CHALLENGE;
        GAME_STATE = crntChallenge;
        setGameState();
    }

    /**
     * Sets up pieces from given gameString
     * @param gamePieceString a valid gamePiece string
     */
    public void setPieces(String gamePieceString) {
        String[] pieceStringArr = new String[gamePieceString.length()/4];
        for (int i = 0; i < gamePieceString.length()/4; i++) {
            pieceStringArr[i] = gamePieceString.substring(i*4, i*4+4);
        }
        for (String pieceString : pieceStringArr) {
            char pieceChar = pieceString.charAt(0);
            for (Piece piece : pieceArray) {
                char compareChar = piece.colour.getChar();
                if (pieceChar == compareChar) {
                    piece.ornt = Character.getNumericValue(pieceString.charAt(1));
                    int newLoc = Integer.parseInt(pieceString.substring(2));
                    piece.xyPrime = newLoc;
                    piece.updateLocation(piece.coorderToOrder(newLoc));
                }
            }
        }
    }

    /**
     * Sets wizards from given wizard gamestate string
     * @param gameWizString Sets up wizard stars from a valid wizard string
     */
    public void setWizards(String gameWizString) {
        wizGroup.getChildren().clear();
        String[] wizardStringArray = new String[gameWizString.length()/3];
        Polygon[] wizArray = new Polygon[gameWizString.length()/3];
        int j = 0;
        for (int i = 0; i < gameWizString.length()/ 3; i++){
            wizardStringArray[j] = gameWizString.substring((i* 3), (i*3) + 3);
            j++;
        }
        for (int i = 0; i < wizardStringArray.length; i++) {
            String wizString = wizardStringArray[i];
            if (wizString != null) {
                Polygon wizardStar = new Polygon();
                wizardStar.getPoints().addAll(starVertices);
                int wizX = Character.getNumericValue(wizString.charAt(1));
                int wizY = Character.getNumericValue(wizString.charAt(2));
                switch (wizString.charAt(0)) {
                    case 'r' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.RED);
                    }
                    case 'o' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.ORANGE);
                    }
                    case 'y' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.YELLOW);
                    }
                    case 'g' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.GREEN);
                    }
                    case 'b' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.BLUE);
                    }
                    case 'i' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.INDIGO);
                    }
                    case 'p' -> {
                        wizArray[i] = wizardStar;
                        wizArray[i].setFill(Color.HOTPINK);
                    }
                }
                double wizLayX = (wizY % 2 == 0)?  166 + (wizX * 80) : 206 +
                        (wizX * 80);
                double wizLayY = (70 * wizY);
                wizArray[i].setLayoutX(wizLayX);
                wizArray[i].setLayoutY(wizLayY);
            }
        }
        for (Polygon wizArr : wizArray) {
            wizGroup.getChildren().add(wizArr);
        }
    }

    /**
     * update the current GAME_STATE with an activePiece's newMove
     * @param gamePieces current pieceArray
     * @param activePiece active piece
     * @param newMove new move for active piece
     * @return gamestate string
     */
    public String updateGS(Piece[] gamePieces, Piece activePiece,
                           int newMove) {
        String crntGS = GAME_STATE;
        int crntPos = activePiece.xyPrime;
        activePiece.updateLocation(newMove);
        String stepGameState = formGSString(gamePieces);
        return stepGameState;
    }

    public void resetPositions(){
        for (Piece piece : pieceArray) {
            piece.defaultPosition();
        }
    }

    public String formGSString(Piece[] gamePieces) {
        String piecesString = "";
        for (Piece gamePiece : gamePieces) {
            if (gamePiece.xyPrime != -1) {
                piecesString += gamePiece;
            }
        }
        return piecesString+"W"+GAME_WIZARDS;
    }
}

