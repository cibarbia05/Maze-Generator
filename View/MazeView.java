package View;

import Controller.ControllerMaze;
import Model.Maze;
import Model.Zombie;
import Model.Player;
import Model.World;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;
import java.util.Timer;

public class MazeView extends Rectangle {
    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);

    private TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(0.25));
    private FillTransition fillAnimation = new FillTransition(Duration.seconds(0.25));
    private ParallelTransition animation = new ParallelTransition(translateAnimation, fillAnimation);
    private static Stage stage;
    private AnchorPane pane;
    private static Scene scene;
    private static Stage stage2;
    private static AnchorPane pane2;
    private static Scene scene2;
    private static Maze maze;
    private static Player p;
    private static Zombie zombie;
    private static Zombie zombie2;
    private static Zombie zombie3;
    private static Zombie zombie4;
    private static Zombie zombie5;
    private static Zombie zombie6;
    private static Zombie zombie7;
    private static Zombie zombie8;
    private static Zombie zombie9;
    private static Zombie zombie10;

    private Rectangle background;
    private Circle trigger;
    private int openedSettingsCount;
    private static boolean[][] itemMaze;
    private static boolean gameOver;
    private static ImageView playerImage;
    private ImageView minotaurImage;
    private ImageView minotaurImage2;
    private ImageView potionImage;
    private ImageView minotaurImage3;
    private ImageView minotaurImage4;
    private ImageView minotaurImage5;
    private ImageView minotaurImage6;
    private ImageView minotaurImage7;
    private ImageView minotaurImage8;
    private ImageView minotaurImage9;
    private ImageView minotaurImage10;

    private ImageView swordImage;
    private ImageView shieldImage;
    private static ImagePattern redSquareImage;
    private String name;
    private Button play;
    private Button reset;
    private Text timerLabel;
    private Integer timeSeconds = 3;
    private Timeline timeline;
    private HBox hbox;
    private HBox hbox2;
    private static ProgressBar healthBar;
    private static ProgressBar shieldBar;
    private static  double currentHealth = 1;
    private static  double currentShield = 1;
    private boolean drag1;
    private boolean drag2;
    private boolean drag3;
    private boolean drag4;
    private boolean drag5;
    private boolean drag6;
    private boolean drag7;
    private boolean drag8;
    private boolean drag9;
    private boolean drag10;
    private boolean drag11;
    private boolean drag12;
    private boolean drag13;
    private boolean drag14;
    private boolean drag15;
    private ImageView help;
    public static volatile boolean playerDead;
    private static int potion = 0;
    private static int swordT = 0;
    private static int shieldC = 0;
    private static int shieldSwordC = 0;
    private static boolean dead;
    private static  Image playerNoSword = new Image(MazeView.class.getResourceAsStream("/View/Assets/character_maleAdventurer_idle.png"));
    private static Image minotaur = new Image(MazeView.class.getResourceAsStream("/View/Assets/character_zombie_side.png"));
    private static ImageView redSquare = new ImageView(new Image(MazeView.class.getResourceAsStream("/View/Assets/RedSquare.png")));
    private static Rectangle[][] rect;
    private static Rectangle[][] firstSavedMaze;
    private static Rectangle[][] firstSavedMaze2;
    private static int[] firstPlyLocation = new int[2];
    private static int[] firstZombie3Location = new int[2];
    private static int[] firstZombieLocation = new int[2];
    private static int[] firstZombie2Location = new int[2];
    private static int[] firstZombie4Location = new int[2];
    private static int[] firstZombie5Location = new int[2];
    private static int[] firstZombie6Location = new int[2];
    private static int[] firstZombie7Location = new int[2];
    private static int[] firstZombie8Location = new int[2];
    private static int[] firstZombie9Location = new int[2];
    private static int[] firstZombie10Location = new int[2];
    private static int[] firstSwordLocation = new int[2];
    private static int[] firstShieldLocation = new int[2];
    private static int[] firstPotionLocation = new int[2];
    private static int[] firstRedSquareLocation = new int[2];
    private static boolean[][] mazeLayout;
    private int finalCounter;
    private int xCounter;
    private int yCounter;

    private static ImagePattern wallPattern;
    private static ImagePattern pathPattern;
    private static int[] track;
    private static  int[] trackM;
    private static  int[] trackM2;
    private static  int[] trackM3;
    private static  int[] trackM4;
    private static  int[] trackM5;
    private static  int[] trackM6;
    private static  int[] trackM7;
    private static  int[] trackM8;
    private static  int[] trackM9;
    private static  int[] trackM10;
    private static int stepCounter;
    private static int j=0;
    private boolean fasterWhiteColoring;
    private boolean fasterBlackColoring;
    private int whichColoring;
    private boolean isOn;
    private static int changeHealthAlert;

    public static Zombie getZombie() {
        return zombie;
    }

    public static Zombie getZombie2() {
        return zombie2;
    }

    public static Zombie getZombie3() {
        return zombie3;
    }

    public static Zombie getZombie4() {
        return zombie4;
    }

    public static Zombie getZombie5() {
        return zombie5;
    }

    public static Zombie getZombie6() {
        return zombie6;
    }

    public static Zombie getZombie7() {
        return zombie7;
    }

    public static Zombie getZombie8() {
        return zombie8;
    }

    public static Zombie getZombie9() {
        return zombie9;
    }

    public static Zombie getZombie10() {
        return zombie10;
    }

    public static int[] getFirstSwordLocation() {
        return firstSwordLocation;
    }

    public static int[] getFirstShieldLocation() {
        return firstShieldLocation;
    }

    public static int[] getFirstPotionLocation() {
        return firstPotionLocation;
    }

    public static ImagePattern getWallPattern() {
        return wallPattern;
    }

    public static ImagePattern getPathPattern() {
        return pathPattern;
    }

    public static ImagePattern getRSquareImage(){
        return redSquareImage;
    }

    public static boolean isPlayerDead() {
        return playerDead;
    }

    public static Scene getScene2(){
        return scene2;
    }

    public static int getCurRow(){
        return track[0];
    }

    public static int getCurCol(){
        return track[1];
    }

    public static int getCurRowM(){
        return trackM[0];
    }

    public static int getCurColM(){
        return trackM[1];
    }

    public static int getCurRowM2(){
        return trackM2[0];
    }

    public static int getCurColM2(){return trackM2[1]; }

    public static int getCurColM3(){
        return trackM3[1];
    }

    public static int getCurRowM3(){
        return trackM3[0];
    }

    public static int getCurColM4(){
        return trackM4[1];
    }

    public static int getCurRowM4(){
        return trackM4[0];
    }

    public static int getCurColM5(){
        return trackM5[1];
    }

    public static int getCurRowM5(){
        return trackM5[0];
    }

    public static int getCurColM6(){
        return trackM6[1];
    }

    public static int getCurRowM6(){
        return trackM6[0];
    }

    public static int getCurColM7(){
        return trackM7[1];
    }

    public static int getCurRowM7(){
        return trackM7[0];
    }

    public static int getCurColM8(){
        return trackM8[1];
    }

    public static int getCurRowM8(){
        return trackM8[0];
    }

    public static int getCurColM9(){
        return trackM9[1];
    }

    public static int getCurRowM9(){
        return trackM9[0];
    }

    public static int getCurColM10(){
        return trackM10[1];
    }

    public static int getCurRowM10(){
        return trackM10[0];
    }

    public static Rectangle[][] getRect(){
        return firstSavedMaze;
    }

    public static Image getPlayerNoSword() {
        return playerNoSword;
    }

    public static void setPlayerNoSword(Image i){
        playerNoSword = i;
    }

    public static Image getZombieImage() {
        return minotaur;
    }

    public MazeView(){
        maze = new Maze();
        maze.setMaze();
        stage = new Stage();
        Image icon = new Image(getClass().getResourceAsStream("/View/Assets/GameLogo.PNG"));
        stage.getIcons().add(icon);
        pane = new AnchorPane();

        scene = new Scene(pane, StartView.getInputCols() * 35 + 40, StartView.getInputRows() * 35 + 140);

        scene.getStylesheets().addAll("Stylesheet.css");
        stage.setScene(scene);
        stage.setResizable(false);
        mazeLayout = maze.getMaze();
        rect = new Rectangle[StartView.getInputRows()][StartView.getInputCols()];
        itemMaze = new boolean[StartView.getInputRows()][StartView.getInputCols()];
        if(StartView.isIsImageWall()){
            wallPattern = new ImagePattern(StartView.getWallImageR());
        }
        if(StartView.isIsImagePath()){
            pathPattern = new ImagePattern(StartView.getPathImageR());
        }
        createVBox();
        createButtons();
        playActions();
        resetActions();
        createSquares();
        addSquaresToPane();
        addImages();
        createHelpImage();
        helpActions();
        stage.show();
    }

    private void createVBox(){
        hbox = new HBox();
        if (StartView.getInputCols() < 25) {
            hbox.setSpacing(StartView.getInputCols() - 8);
        } else {
            hbox.setSpacing(20);
        }
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: #a5cff5 ");
        hbox.setLayoutY(scene.getHeight() - 70);
        hbox.setLayoutX(scene.getWidth() / 11);
        hbox.setMinWidth(60);
        hbox.setMinHeight(65);
        hbox2 = new HBox();
        if(StartView.getInputCols()<25) {
            hbox2.setSpacing(StartView.getInputCols()-8);
            hbox.setSpacing(StartView.getInputCols() - 8);
        }
        else{
            hbox2.setSpacing(20);
            hbox.setSpacing(20);
        }
        hbox2.setLayoutY(scene.getHeight()-56);
        hbox2.setStyle("-fx-border-color: #a5cff5 ");
        hbox.setStyle("-fx-border-color: #a5cff5 ");
        hbox2.setLayoutX(scene.getWidth()/11);
        hbox.setLayoutY(scene.getHeight() - 120);
        hbox.setLayoutX(scene.getWidth() / 11);
        hbox2.setMinWidth(60);
        hbox.setMinWidth(60);
        hbox.setMinHeight(65);
        hbox2.setMinHeight(65);
        pane.getChildren().addAll(hbox,hbox2);

    }
    /*Creates a timer form 3 to 1 to signal that the game is starting*/
    private void createTimer(){
        timerLabel = new Text();
        timerLabel.setText(timeSeconds.toString());
        timerLabel.setId("timer");
        Color c =  Color.GOLD;
        timerLabel.setFill(c);
        timerLabel.setFontSmoothingType(FontSmoothingType.GRAY);
        timerLabel.setLayoutX(scene2.getWidth()/2-33);
        timerLabel.setLayoutY(scene2.getHeight()/2-35);

        if (timeline != null) {
            timeline.stop();
        }
        timerLabel.setText(timeSeconds.toString());
        timeline = new Timeline();
        System.setProperty("prism.lcdtext", "false");
        System.setProperty("prism.text", "t2k");
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                      event -> {
                            timeSeconds--;
                            timerLabel.setText(
                                    timeSeconds.toString());
                            if (timeSeconds <= 0) {
                                timerLabel.setText("Go!");
                                ControllerMaze.ready=true;
                            }
                            if(timeSeconds<0){
                                timeline.stop();
                                timerLabel.setText("");
                            }

                        }));
        timeline.playFromStart();
        pane2.getChildren().addAll(timerLabel);
    }
    /*Creates a help button for a tutorial on how to play the game*/
    private void createHelpImage(){
        help = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Question.png")));

        if(StartView.getInputCols()<=20){
            help.setFitHeight((StartView.getInputRows()*35)/18);
            help.setFitWidth((StartView.getInputCols()*35)/18);
        }
        else {
            help.setFitHeight(50);
            help.setFitWidth(45);
        }
        help.setId("help");
        help.setStyle("-fx-cursor: hand");
        help.setLayoutX(20);
        if(StartView.getInputZombies()<6) {
            help.setLayoutY(scene.getHeight() - 39);
        }
        else{
            help.setLayoutY(scene.getHeight() - 45);
        }
        pane.getChildren().addAll(help);

    }
    /*Sets the actions for the help button which will show
     *the tutorial on how to play the game
     */
    private void helpActions(){
        help.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Help1.JPG"))));
            alert.getDialogPane().getStylesheets().add("Stylesheet.css");
            alert.getDialogPane().setPrefWidth(0);
            ButtonType alertButton = new ButtonType("Next");
            alert.getButtonTypes().setAll(alertButton);
            Optional<ButtonType> result = alert.showAndWait();
            try {
                if (result.get() == alertButton) {
                    Alert alert2 = new Alert(Alert.AlertType.NONE);
                    alert2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Help2.JPG"))));
                    alert2.getDialogPane().getStylesheets().add("Stylesheet.css");
                    alert2.getDialogPane().setPrefWidth(0);
                    ButtonType alertButton2 = new ButtonType("Next");
                    alert2.getButtonTypes().setAll(alertButton2);
                    Optional<ButtonType> result2 = alert2.showAndWait();
                    try{
                    if (result2.get() == alertButton2) {
                        Alert alert3 = new Alert(Alert.AlertType.NONE);
                        alert3.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Help3.JPG"))));
                        alert3.getDialogPane().getStylesheets().add("Stylesheet.css");
                        alert3.getDialogPane().setPrefWidth(0);
                        ButtonType alertButton3 = new ButtonType("Next");
                        alert3.getButtonTypes().setAll(alertButton3);
                        Optional<ButtonType> result3 = alert3.showAndWait();
                        try{
                            if (result3.get() == alertButton3) {
                                Alert alert4 = new Alert(Alert.AlertType.NONE,"Click the right button on your mouse once to change to fast path coloring, twice to change to fast wall coloring, and three times to go back to regular speed");
                                ImageView graphic = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Mouse.png")));
                                graphic.prefHeight(150);
                                graphic.prefWidth(85);
                                alert4.setGraphic(graphic);
                                alert4.getDialogPane().getStylesheets().add("Stylesheet.css");
                                alert4.getDialogPane().setPrefWidth(0);
                                ButtonType alertButton4 = new ButtonType("Ok");
                                alert4.getButtonTypes().setAll(alertButton4);
                                Optional<ButtonType> result4 = alert4.showAndWait();
                            }
                        }
                        catch(Exception e){

                        }

                    }
                    }
                    catch(Exception e){

                    }
                }
            }
            catch(Exception e){

            }

        });
    }
    /*Creates a health bar for the player*/
    private static void createHealthBar(){
        healthBar = new ProgressBar(currentHealth);
        healthBar.setId("health-bar");
        healthBar.setPrefWidth(140);
        healthBar.setPrefHeight(20);
        healthBar.setLayoutX(scene.getWidth()-160);
        healthBar.setLayoutY(StartView.getInputRows()*35+65);
        pane2.getChildren().add(healthBar);
    }
    /*Creates a shield bar for the player*/
    public static void createShieldBar(){
        shieldBar = new ProgressBar(currentShield);
        shieldBar.setId("shield-bar");
        shieldBar.setPrefWidth(140);
        shieldBar.setPrefHeight(20);
        shieldBar.setLayoutX(scene.getWidth()-160);
        shieldBar.setLayoutY(StartView.getInputRows()*35+40);
        pane2.getChildren().add(shieldBar);
    }
    /*Creates the reset (resets the maze that is currently being
     *created by the user) and play (starts the game) buttons
     * */
    private void createButtons(){
        scene.getStylesheets().addAll("Stylesheet.css");
        play = new Button("Play");
        play.setLayoutX(scene.getWidth()-60);
        reset = new Button("Reset");
        reset.setLayoutX(scene.getWidth()-120);
        play.setLayoutY(StartView.getInputRows() * 35 + 96);
        reset.setLayoutY(StartView.getInputRows() * 35 + 96);

        pane.getChildren().addAll(play,reset);
    }
    /*Sets the actions for the play button. On action checks if
     *all characters and items have been placed in the maze, and
     *if so the game starts
     */
    private void playActions(){
        play.setOnAction(event -> {
            if(StartView.getInputZombies()>=10) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9 && drag10&& drag11 && drag12 && drag13 && drag14 && drag15) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=9) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9 && drag10&& drag11 && drag12 && drag13 && drag14) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=8) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9 && drag10&& drag11 && drag12 && drag13) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=7) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9 && drag10 && drag11 && drag12) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=6) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9 && drag10 && drag11) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=5) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9 && drag10) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=4) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8 && drag9) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
            else if(StartView.getInputZombies()>=3) {
                if (drag1 && drag2 && drag3 && drag4 && drag5 && drag6 && drag7 && drag8) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
           else if(StartView.getInputZombies()>=2) {
                if (drag1 && drag3 && drag4&& drag5 && drag6 && drag7&& drag8) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }
           else{
                if (drag1 && drag3 && drag5 && drag6 &&  drag8) {
                    try {
                        saveMaze();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    ControllerMaze cm = new ControllerMaze();
                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Place all characters and items on the maze");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            }

        });
    }
    /*Sets the actions for the reset button*/
    private void resetActions(){
        reset.setOnAction(event -> {
            try {
                resetMaze();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (AWTException e) {
                e.printStackTrace();
            }

        });
    }
    /*Resets the maze by making all the squares the
     *wall color and removing all items and character
     *back to the item bar
     */
    private void resetMaze() throws IOException, AWTException {
        int countPly1 = 0;
        int countZombie3 = 0;
        int countPotion = 0;
        int countSword = 0;
        int countRedSquare = 0;
        int countZombie = 0;
        int countZombie2 = 0;
        int countZombie4 = 0;
        int countZombie5 = 0;
        int countZombie6 = 0;
        int countZombie7 = 0;
        int countZombie8 = 0;
        int countZombie9 = 0;
        int countZombie10 = 0;
        int countShield = 0;
        for (int r=0;r<rect.length;r++) {
            for (int c = 0; c < rect[0].length; c++) {
                if(!StartView.isIsImageWall()) {
                    rect[r][c].setFill(StartView.getColorWall());
                }
                else{
                    rect[r][c].setFill(wallPattern);
                }
            }
        }
        for(int i=0;i<hbox.getChildren().size();i++) {
            if (hbox.getChildren().get(i).getId().equals("Ply1")) {
                countPly1++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie3")) {
                countZombie3++;

            }  else if (hbox.getChildren().get(i).getId().equals("Zombie")) {
                countZombie++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie2")) {
                countZombie2++;

            }  else if (hbox.getChildren().get(i).getId().equals("Zombie4")) {
                countZombie4++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie5")) {
                countZombie5++;

            }
            else if (hbox.getChildren().get(i).getId().equals("Zombie6")) {
                countZombie6++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie7")) {
                countZombie7++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie8")) {
                countZombie8++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie9")) {
                countZombie9++;

            } else if (hbox.getChildren().get(i).getId().equals("Zombie10")) {
                countZombie10++;

            }
        }
        if(hbox2!=null) {
            for (int i = 0; i < hbox2.getChildren().size(); i++) {
                if (hbox2.getChildren().get(i).getId().equals("Shield")) {
                    countShield++;

                }
                else if (hbox2.getChildren().get(i).getId().equals("Potion")) {
                    countPotion++;

                } else if (hbox2.getChildren().get(i).getId().equals("Sword")) {
                    countSword++;

                } else if (hbox2.getChildren().get(i).getId().equals("RedSquare")) {
                    countRedSquare++;

                }
            }
        }
            if (countPly1==0) {
                pane.getChildren().removeAll(playerImage);
                if(StartView.getInputCols()<=20){
                    playerImage.setFitHeight((StartView.getInputRows()*35)/15);
                    playerImage.setFitWidth((StartView.getInputCols()*35)/15);

                }
                else {
                    playerImage.setFitHeight(60);
                    playerImage.setFitWidth(55);
                }
                hbox.getChildren().addAll(playerImage);
            }
            if (countZombie==0){
                pane.getChildren().removeAll(minotaurImage);
                if(StartView.getInputCols()<=20){
                    minotaurImage.setFitHeight((StartView.getInputRows()*35)/15);
                    minotaurImage.setFitWidth((StartView.getInputCols()*35)/15);

                }
                else {
                    minotaurImage.setFitHeight(60);
                    minotaurImage.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage);
            }
            if (countPotion==0) {
                pane.getChildren().removeAll(potionImage);
                if(StartView.getInputCols()<=20){
                    potionImage.setFitHeight((StartView.getInputRows()*35)/17);
                    potionImage.setFitWidth((StartView.getInputCols()*35)/17);

                }
                else {
                    potionImage.setFitHeight(45);
                    potionImage.setFitWidth(40);
                }
                hbox2.getChildren().addAll(potionImage);
            }
            if (countRedSquare==0) {
                pane.getChildren().removeAll(redSquare);
                if(StartView.getInputCols()<=20){
                    redSquare.setFitHeight((StartView.getInputRows()*35)/18);
                    redSquare.setFitWidth((StartView.getInputCols()*35)/18);

                }
                else {
                    redSquare.setFitHeight(35);
                    redSquare.setFitWidth(30);
                }
                hbox2.getChildren().addAll(redSquare);
            }
            if(StartView.getInputZombies()>=2){
                if (countZombie2==0) {
                    pane.getChildren().removeAll(minotaurImage2);
                    if(StartView.getInputCols()<=20){
                        minotaurImage2.setFitHeight((StartView.getInputRows()*35)/15);
                        minotaurImage2.setFitWidth((StartView.getInputCols()*35)/15);

                    }
                    else {
                        minotaurImage2.setFitHeight(60);
                        minotaurImage2.setFitWidth(55);
                    }
                    hbox.getChildren().addAll(minotaurImage2);
                    }
            }
           if(StartView.getInputZombies()>=3){
                if (countZombie3==0) {
                    pane.getChildren().removeAll(minotaurImage3);
                    if (StartView.getInputCols() <= 20) {
                        minotaurImage3.setFitHeight((StartView.getInputRows() * 35) / 15);
                        minotaurImage3.setFitWidth((StartView.getInputCols() * 35) / 15);

                    } else {
                        minotaurImage3.setFitHeight(60);
                        minotaurImage3.setFitWidth(55);
                    }
                    hbox.getChildren().addAll(minotaurImage3);
                }
            }
        if(StartView.getInputZombies()>=4){
            if (countZombie4==0) {
                pane.getChildren().removeAll(minotaurImage4);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage4.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage4.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage4.setFitHeight(60);
                    minotaurImage4.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage4);
            }
        }
        if(StartView.getInputZombies()>=5){
            if (countZombie5==0) {
                pane.getChildren().removeAll(minotaurImage5);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage5.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage5.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage5.setFitHeight(60);
                    minotaurImage5.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage5);
            }
        }
            if (countSword==0) {
                pane.getChildren().removeAll(swordImage);
                if(StartView.getInputCols()<=20){
                    swordImage.setFitHeight((StartView.getInputRows()*35)/17);
                    swordImage.setFitWidth((StartView.getInputCols()*35)/17);

                }
                else {
                    swordImage.setFitHeight(45);
                    swordImage.setFitWidth(40);
                }
                hbox2.getChildren().addAll(swordImage);
            }
        if(StartView.getInputZombies()>=6){
            if (countZombie6==0) {
                pane.getChildren().removeAll(minotaurImage6);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage6.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage6.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage6.setFitHeight(60);
                    minotaurImage6.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage6);
            }
        }
        if(StartView.getInputZombies()>=7){
            if (countZombie7==0) {
                pane.getChildren().removeAll(minotaurImage7);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage7.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage7.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage7.setFitHeight(60);
                    minotaurImage7.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage7);
            }
        }
        if(StartView.getInputZombies()>=8){
            if (countZombie8==0) {
                pane.getChildren().removeAll(minotaurImage8);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage8.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage8.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage8.setFitHeight(60);
                    minotaurImage8.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage8);
            }
        }
        if(StartView.getInputZombies()>=9){
            if (countZombie9==0) {
                pane.getChildren().removeAll(minotaurImage9);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage9.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage9.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage9.setFitHeight(60);
                    minotaurImage9.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage9);
            }
        }
        if(StartView.getInputZombies()>=10){
            if (countZombie10==0) {
                pane.getChildren().removeAll(minotaurImage10);
                if (StartView.getInputCols() <= 20) {
                    minotaurImage10.setFitHeight((StartView.getInputRows() * 35) / 15);
                    minotaurImage10.setFitWidth((StartView.getInputCols() * 35) / 15);

                } else {
                    minotaurImage10.setFitHeight(60);
                    minotaurImage10.setFitWidth(55);
                }
                hbox.getChildren().addAll(minotaurImage10);
            }
        }
        if (countShield==0) {
            pane.getChildren().removeAll(shieldImage);
            if(StartView.getInputCols()<=20){
                shieldImage.setFitHeight((StartView.getInputRows()*35)/17);
                shieldImage.setFitWidth((StartView.getInputCols()*35)/17);

            }
            else {
                shieldImage.setFitHeight(45);
                shieldImage.setFitWidth(40);
            }
            hbox2.getChildren().addAll(shieldImage);
        }
        drag1 = false;
        drag2 = false;
        drag3 = false;
        drag4 = false;
        drag5 = false;
        drag6 = false;
        drag7 = false;
        drag8 = false;
        drag9 = false;
        drag10 = false;
        drag11 = false;
        drag12 = false;
        drag13 = false;
        drag14 = false;
        drag15 = false;
    }
    /*Adds the characters and items to the item bar for
    the user to later drag and place them to the maze*/
    private void addImages(){
        playerImage = new ImageView(playerNoSword);
        playerImage.setId("Ply1");
        if(StartView.getInputCols()<=20){
            playerImage.setFitHeight((StartView.getInputRows()*35)/15);
            playerImage.setFitWidth((StartView.getInputCols()*35)/15);

        }
        else {
            playerImage.setFitHeight(60);
            playerImage.setFitWidth(55);
        }
        if(StartView.getInputZombies()>=3) {
            minotaurImage3 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage3.setId("Zombie3");
            if (StartView.getInputCols() <= 20) {
                minotaurImage3.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage3.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage3.setFitHeight(60);
                minotaurImage3.setFitWidth(55);
            }
        }


        minotaurImage = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
        minotaurImage.setId("Zombie");
        if(StartView.getInputCols()<=20){
            minotaurImage.setFitHeight((StartView.getInputRows()*35)/15);
            minotaurImage.setFitWidth((StartView.getInputCols()*35)/15);
        }
        else {
            minotaurImage.setFitHeight(60);
            minotaurImage.setFitWidth(55);
        }
        if(StartView.getInputZombies()>=4) {
            minotaurImage4 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage4.setId("Zombie4");
            if (StartView.getInputCols() <= 20) {
                minotaurImage4.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage4.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage4.setFitHeight(60);
                minotaurImage4.setFitWidth(55);
            }
        }
        if(StartView.getInputZombies()>=5) {
            minotaurImage5 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage5.setId("Zombie5");
            if (StartView.getInputCols() <= 20) {
                minotaurImage5.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage5.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage5.setFitHeight(60);
                minotaurImage5.setFitWidth(55);
            }
        }
        if(StartView.getInputZombies()>=6) {
            minotaurImage6 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage6.setId("Zombie6");
            if (StartView.getInputCols() <= 20) {
                minotaurImage6.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage6.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage6.setFitHeight(60);
                minotaurImage6.setFitWidth(55);
            }
        }
        if(StartView.getInputZombies()>=7) {
            minotaurImage7 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage7.setId("Zombie7");
            if (StartView.getInputCols() <= 20) {
                minotaurImage7.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage7.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage7.setFitHeight(60);
                minotaurImage7.setFitWidth(55);
            }
        }
        if(StartView.getInputZombies()>=8) {
            minotaurImage8 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage8.setId("Zombie8");
            if (StartView.getInputCols() <= 20) {
                minotaurImage8.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage8.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage8.setFitHeight(60);
                minotaurImage8.setFitWidth(55);
            }
        }
        if(StartView.getInputZombies()>=9) {
            minotaurImage9 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage9.setId("Zombie9");
            if (StartView.getInputCols() <= 20) {
                minotaurImage9.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage9.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage9.setFitHeight(60);
                minotaurImage9.setFitWidth(55);
            }
        }
        if(StartView.getInputZombies()>=10) {
            minotaurImage10 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage10.setId("Zombie10");
            if (StartView.getInputCols() <= 20) {
                minotaurImage10.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage10.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage10.setFitHeight(60);
                minotaurImage10.setFitWidth(55);
            }
        }

        if(StartView.getInputZombies()>=2) {
            minotaurImage2 = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png")));
            minotaurImage2.setId("Zombie2");
            if (StartView.getInputCols() <= 20) {
                minotaurImage2.setFitHeight((StartView.getInputRows() * 35) / 15);
                minotaurImage2.setFitWidth((StartView.getInputCols() * 35) / 15);
            } else {
                minotaurImage2.setFitHeight(60);
                minotaurImage2.setFitWidth(55);
            }
        }

        potionImage = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/TimePotion.png")));
        potionImage.setId("Potion");
        if(StartView.getInputCols()<=20){
            potionImage.setFitHeight((StartView.getInputRows()*35)/17);
            potionImage.setFitWidth((StartView.getInputCols()*35)/17);
        }
        else {
            potionImage.setFitHeight(45);
            potionImage.setFitWidth(40);
        }

        swordImage = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/SwordZ.png")));
        swordImage.setId("Sword");
        if(StartView.getInputCols()<=20){
            swordImage.setFitHeight((StartView.getInputRows()*35)/17);
            swordImage.setFitWidth((StartView.getInputCols()*35)/17);
        }
        else {
            swordImage.setFitHeight(45);
            swordImage.setFitWidth(40);
        }

        redSquare = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/RedSquare.png")));
        redSquare.setId("RedSquare");
        if(StartView.getInputCols()<=20){
            redSquare.setFitHeight((StartView.getInputRows()*35)/18);
            redSquare.setFitWidth((StartView.getInputCols()*35)/18);
        }
        else {
            redSquare.setFitHeight(42);
            redSquare.setFitWidth(40);
        }

        shieldImage = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/Shield.png")));
        shieldImage.setId("Shield");
        if(StartView.getInputCols()<=20){
            shieldImage.setFitHeight((StartView.getInputRows()*35)/18);
            shieldImage.setFitWidth((StartView.getInputCols()*35)/18);
        }
        else {
            shieldImage.setFitHeight(45);
            shieldImage.setFitWidth(40);
        }

        hbox.getChildren().addAll(playerImage,minotaurImage);
        if(StartView.getInputZombies()>=2){
            hbox.getChildren().addAll(minotaurImage2);
        }
        if(StartView.getInputZombies()>=3){
            hbox.getChildren().addAll(minotaurImage3);
        }
        if(StartView.getInputZombies()>=4){
            hbox.getChildren().addAll(minotaurImage4);
        }
        if(StartView.getInputZombies()>=5){
            hbox.getChildren().addAll(minotaurImage5);
        }
        if(StartView.getInputZombies()>=6){
            hbox.getChildren().addAll(minotaurImage6);
        }
        if(StartView.getInputZombies()>=7){
            hbox.getChildren().addAll(minotaurImage7);
        }
        if(StartView.getInputZombies()>=8){
            hbox.getChildren().addAll(minotaurImage8);
        }
        if(StartView.getInputZombies()>=9){
            hbox.getChildren().addAll(minotaurImage9);
        }
        if(StartView.getInputZombies()>=10){
            hbox.getChildren().addAll(minotaurImage10);
        }
        if(hbox2!=null){
            hbox2.getChildren().addAll(potionImage,swordImage,shieldImage,redSquare);
        }

        playerImage.setOnDragDetected(event -> {
            fasterWhiteColoring = false;
            whichColoring=0;
            itemMaze[firstPlyLocation[0]][firstPlyLocation[1]]=false;
            name = "Player1";
            imageDrag(playerImage,firstPlyLocation);
        });

        if(StartView.getInputZombies()>=3) {
            minotaurImage3.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage3, firstZombie3Location);
            });
        }
        if(StartView.getInputZombies()>=4) {
            minotaurImage4.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage4, firstZombie4Location);
            });
        }
        if(StartView.getInputZombies()>=5) {
            minotaurImage5.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage5, firstZombie5Location);
            });
        }
        if(StartView.getInputZombies()>=6) {
            minotaurImage6.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage6, firstZombie6Location);
            });
        }
        if(StartView.getInputZombies()>=7) {
            minotaurImage7.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage7, firstZombie7Location);
            });
        }
        if(StartView.getInputZombies()>=8) {
            minotaurImage8.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage8, firstZombie8Location);
            });
        }
        if(StartView.getInputZombies()>=9) {
            minotaurImage9.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage9, firstZombie9Location);
            });
        }
        if(StartView.getInputZombies()>=10) {
            minotaurImage10.setOnDragDetected(event -> {
                whichColoring=0;
                fasterWhiteColoring = false;
                name = "Zombie";
                imageDrag(minotaurImage10, firstZombie10Location);
            });
        }
        potionImage.setOnDragDetected(event -> {
            fasterWhiteColoring = false;
            whichColoring=0;
            name = "Potion";
            imageDrag(potionImage,firstPotionLocation);
        });
        minotaurImage.setOnDragDetected(event -> {
            fasterWhiteColoring = false;
            whichColoring=0;
            name = "Zombie";
            imageDrag(minotaurImage,firstZombieLocation);
        });
        if(StartView.getInputZombies()>=2) {
            minotaurImage2.setOnDragDetected(event -> {
                fasterWhiteColoring = false;
                whichColoring=0;
                name = "Zombie";
                imageDrag(minotaurImage2, firstZombie2Location);
            });
        }
        swordImage.setOnDragDetected(event -> {
            whichColoring=0;
            fasterWhiteColoring = false;
            name = "Sword";
            imageDrag(swordImage,firstSwordLocation);
        });
        redSquare.setOnDragDetected(event -> {
            whichColoring=0;
            fasterWhiteColoring = false;
            name = "RedSquare";
            imageDrag(redSquare,firstRedSquareLocation);
        });
        shieldImage.setOnDragDetected(event -> {
            whichColoring=0;
            fasterWhiteColoring = false;
            name = "Shield";
            imageDrag(shieldImage,firstShieldLocation);
        });
    }
    /*Is called on a drag detected on a character or item in the item bar
     *and removes the item from the item bar to the position being dragged
     *over in the maze
     */
    private void imageDrag(ImageView image, int[] arr){
        Dragboard db = image.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString("Circle source text");
        db.setContent(content);

        image.setOnMouseDragged((MouseEvent event) -> {
            event.setDragDetect(true);
        });

        for(int r=0;r<rect.length;r++){
            for(int c=0;c<rect[0].length;c++){
                int finalR = r;
                int finalC = c;
                rect[r][c].setOnDragOver(event -> {
                    arr[0] = finalR;
                    arr[1] = finalC;
                    if (event.getGestureSource() != null && event.getDragboard().hasString() && (rect[finalR][finalC].getFill().equals(StartView.getColorPath())||rect[finalR][finalC].getFill().equals(pathPattern)) && !rect[finalR][finalC].getFill().equals(redSquareImage)){
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }
                    event.consume();
                });
                hbox.setOnDragOver(event -> {
                    if(!image.getId().equals("Sword") &&!image.getId().equals("Shield")&&!image.getId().equals("Potion")
                            &&!image.getId().equals("RedSquare")) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }
                });
                if(hbox2!=null) {
                    hbox2.setOnDragOver(event -> {
                        if (image.getId().equals("Sword") || image.getId().equals("Shield") || image.getId().equals("Potion")
                                || image.getId().equals("RedSquare")) {
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        }
                    });
                }
                int finalR1 = r;
                int finalC1 = c;
                hbox.setOnDragDropped(event -> {
                    itemMaze[finalR1][finalC1] = false;
                    if(image.getId().equals("Ply1")){
                        drag1 = false;
                    }
                    else if(image.getId().equals("Zombie3")){
                        drag2 = false;
                    }
                    else if(image.getId().equals("Zombie")){
                        drag4 = false;
                    }
                    else if(image.getId().equals("Zombie4")){
                        drag9 = false;
                    }
                    else if(image.getId().equals("Zombie5")){
                        drag10 = false;
                    }
                    else if(image.getId().equals("Zombie6")){
                        drag11 = false;
                    }
                    else if(image.getId().equals("Zombie7")){
                        drag12 = false;
                    }
                    else if(image.getId().equals("Zombie8")){
                        drag13 = false;
                    }
                    else if(image.getId().equals("Zombie9")){
                        drag14 = false;
                    }
                    else if(image.getId().equals("Zombie10")){
                        drag15 = false;
                    }
                    else if(image.getId().equals("Zombie2")){
                        drag7 = false;
                    }
                    pane.getChildren().removeAll(image);
                    if(!image.getId().equals("Potion") && !image.equals("Sword") && !image.getId().equals("RedSquare") && !image.getId().equals("Shield") ){
                        if(StartView.getInputCols()<=20){
                            image.setFitHeight((StartView.getInputRows()*35)/15);
                            image.setFitWidth((StartView.getInputCols()*35)/15);

                        }
                        else {
                            image.setFitHeight(60);
                            image.setFitWidth(55);
                        }
                    }


                    hbox.getChildren().addAll(image);
                });
                hbox2.setOnDragDropped(event -> {
                    if(image.getId().equals("Potion")){

                        drag3 = false;
                    }
                    else if(image.getId().equals("Sword")){
                        drag5 = false;
                    }
                    else if(image.getId().equals("RedSquare")){
                        drag6 = false;
                    }
                    else if(image.getId().equals("Shield")){
                        drag8 = false;
                    }
                    pane.getChildren().removeAll(image);
                    if(image.getId().equals("Sword") || image.getId().equals("Shield")){
                        if(StartView.getInputCols()<=20){
                            if(image.getId().equals("Sword")) {
                                image.setFitHeight((StartView.getInputRows() * 35) / 17);
                                image.setFitWidth((StartView.getInputCols() * 35) / 17);
                            }
                            else{
                                image.setFitHeight((StartView.getInputRows() * 35) / 18);
                                image.setFitWidth((StartView.getInputCols() * 35) / 18);
                            }

                        }
                        else {
                            image.setFitHeight(45);
                            image.setFitWidth(40);
                        }
                    }
                    else if(image.getId().equals("Potion")){
                        if(StartView.getInputCols()<=20){
                            image.setFitHeight((StartView.getInputRows()*35)/17);
                            image.setFitWidth((StartView.getInputCols()*35)/17);

                        }
                        else {
                            image.setFitHeight(45);
                            image.setFitWidth(40);
                        }
                    }
                    else if(image.getId().equals("RedSquare")){
                        if(StartView.getInputCols()<=20){
                            image.setFitHeight((StartView.getInputRows()*35)/18);
                            image.setFitWidth((StartView.getInputCols()*35)/18);

                        }
                        else {
                            image.setFitHeight(42);
                            image.setFitWidth(40);
                        }
                    }
                    hbox2.getChildren().addAll(image);
                });
                rect[r][c].setOnDragDropped((DragEvent event) -> {
                    itemMaze[finalR1][finalC1] = true;
                    if(image.getId().equals("Potion")){

                        drag3 = true;
                    }
                    else if(image.getId().equals("Sword")){
                        drag5= true;
                    }
                    else if(image.getId().equals("RedSquare")){
                        firstRedSquareLocation[0]=finalR;
                        firstRedSquareLocation[1]=finalC;
                        drag6 = true;
                    }
                    else if(image.getId().equals("Ply1")){
                        p = new Player();
                        track = new int[]{firstPlyLocation[0],firstPlyLocation[1]};
                        drag1 = true;
                    }
                    else if(image.getId().equals("Zombie3")){
                        zombie3 = new Zombie();
                        trackM3 = new int[]{firstZombie3Location[0],firstZombie3Location[1]};
                        drag2 = true;
                    }
                    else if(image.getId().equals("Zombie")){
                        zombie = new Zombie();
                        trackM = new int[]{firstZombieLocation[0],firstZombieLocation[1]};
                        drag4 = true;
                    }
                    else if(image.getId().equals("Zombie2")){
                        zombie2 = new Zombie();
                        trackM2 = new int[]{firstZombie2Location[0],firstZombie2Location[1]};
                        drag7 = true;
                    }
                    else if(image.getId().equals("Zombie4")){
                        zombie4 = new Zombie();
                        trackM4 = new int[]{firstZombie4Location[0],firstZombie4Location[1]};
                        drag9 = true;
                    }
                    else if(image.getId().equals("Zombie5")){
                        zombie5 = new Zombie();
                        trackM5 = new int[]{firstZombie5Location[0],firstZombie5Location[1]};
                        drag10 = true;
                    }
                    else if(image.getId().equals("Zombie6")){
                        zombie6 = new Zombie();
                        trackM6 = new int[]{firstZombie6Location[0],firstZombie6Location[1]};
                        drag11 = true;
                    }
                    else if(image.getId().equals("Zombie7")){
                        zombie7 = new Zombie();
                        trackM7 = new int[]{firstZombie7Location[0],firstZombie7Location[1]};
                        drag12 = true;
                    }
                    else if(image.getId().equals("Zombie8")){
                        zombie8 = new Zombie();
                        trackM8 = new int[]{firstZombie8Location[0],firstZombie8Location[1]};
                        drag13 = true;
                    }
                    else if(image.getId().equals("Zombie9")){
                        zombie9 = new Zombie();
                        trackM9 = new int[]{firstZombie9Location[0],firstZombie9Location[1]};
                        drag14 = true;
                    }
                    else if(image.getId().equals("Zombie10")){
                        zombie10 = new Zombie();
                        trackM10 = new int[]{firstZombie10Location[0],firstZombie10Location[1]};
                        drag15 = true;
                    }
                    else if(image.getId().equals("Shield")){
                        drag8 = true;
                    }
                    arr[0] = finalR1;
                    arr[1] = finalC1;

                    Dragboard db2 = event.getDragboard();
                    hbox.getChildren().removeAll(image);
                    if(arr[1]==rect[0].length-1){
                        if(!image.getId().equals("Potion") && !image.getId().equals("Sword") && !image.getId().equals("RedSquare") &&  !image.getId().equals("Shield")) {
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 20);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 14);
                        }
                        else if(image.getId().equals("Potion")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 25);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 23);
                        }
                        else if(image.getId().equals("RedSquare")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 20);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 20);
                        }
                        else if(image.getId().equals("Shield")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 23);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 21);
                        }
                        else{
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 23);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 21);
                        }
                    }
                    else if(arr[0]!=rect.length-1 && arr[1]!=rect[0].length) {
                        if(!image.getId().equals("Potion") && !image.getId().equals("Sword") && !image.getId().equals("RedSquare") &&  !image.getId().equals("Shield")) {
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 20);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 15);
                        }
                        else if(image.getId().equals("Potion")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 25);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 23);
                        }
                        else if(image.getId().equals("RedSquare")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 20);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 20);
                        }
                        else if(image.getId().equals("Shield")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 23);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 21);
                        }
                        else{
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 23);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 21);
                        }
                    }
                    else if(arr[0]==rect.length-1){
                        if(!image.getId().equals("Potion") && !image.getId().equals("Sword") && !image.getId().equals("RedSquare") &&  !image.getId().equals("Shield"))  {
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 20);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 14);
                        }
                        else if(image.getId().equals("Potion")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 25);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 23);
                        }
                        else if(image.getId().equals("RedSquare")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 20);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 20);
                        }
                        else if(image.getId().equals("Shield")){
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 23);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 21);
                        }
                        else{
                            image.setLayoutX(rect[arr[0]][arr[1]].getLayoutX() + 23);
                            image.setLayoutY(rect[arr[0]][arr[1]].getLayoutY() + 21);
                        }
                    }
                    if(image.getId().equals("Sword")){
                        swordImage.setFitHeight(35);
                        swordImage.setFitWidth(30);
                    }
                    else if(image.getId().equals("Shield")){
                        image.setFitHeight(32);
                        image.setFitWidth(30);
                    }
                    else if(!image.getId().equals("Potion") && !image.equals("Sword") && !image.getId().equals("RedSquare") && ! image.getId().equals("Shield")) {
                        image.setFitHeight(40);
                        image.setFitWidth(35);
                    }
                    else if(image.getId().equals("Potion")){
                        image.setFitHeight(30);
                        image.setFitWidth(25);
                    }
                    else if(image.getId().equals("RedSquare")){
                        image.setFitHeight(35);
                        image.setFitWidth(35);
                    }
                    pane.getChildren().addAll(image);
                    if (db2.hasString()) {
                        event.setDropCompleted(true);
                        playerImage.setOnDragDetected(event2 -> {
                            whichColoring=0;
                            fasterWhiteColoring = false;
                            name = "Player1";
                            itemMaze[firstPlyLocation[0]][firstPlyLocation[1]]=false;
                            imageDrag(playerImage,firstPlyLocation);
                        });
                        if(StartView.getInputZombies()>=3) {
                            minotaurImage3.setOnDragDetected(event2 -> {
                                whichColoring=0;
                                fasterWhiteColoring = false;
                                itemMaze[firstZombie3Location[0]][firstZombie3Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage3, firstZombie3Location);
                            });
                        }    if(StartView.getInputZombies()>=4) {
                            minotaurImage4.setOnDragDetected(event2 -> {
                                whichColoring=0;
                                fasterWhiteColoring = false;
                                itemMaze[firstZombie4Location[0]][firstZombie4Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage4, firstZombie4Location);
                            });
                        }
                        if(StartView.getInputZombies()>=5) {
                            minotaurImage5.setOnDragDetected(event2 -> {
                                whichColoring=0;
                                fasterWhiteColoring = false;
                                itemMaze[firstZombie5Location[0]][firstZombie5Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage5, firstZombie5Location);
                            });
                        }
                        if(StartView.getInputZombies()>=6) {
                            minotaurImage6.setOnDragDetected(event2 -> {
                                whichColoring=0;
                                fasterWhiteColoring = false;
                                itemMaze[firstZombie6Location[0]][firstZombie6Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage6, firstZombie6Location);
                            });
                        }
                        if(StartView.getInputZombies()>=7) {
                            minotaurImage7.setOnDragDetected(event2 -> {
                                whichColoring=0;
                                fasterWhiteColoring = false;
                                itemMaze[firstZombie7Location[0]][firstZombie7Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage7, firstZombie7Location);
                            });
                        }
                        if(StartView.getInputZombies()>=8) {
                            minotaurImage8.setOnDragDetected(event2 -> {
                                fasterWhiteColoring = false;
                                whichColoring=0;
                                itemMaze[firstZombie8Location[0]][firstZombie8Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage8, firstZombie8Location);
                            });
                        }
                        if(StartView.getInputZombies()>=9) {
                            minotaurImage9.setOnDragDetected(event2 -> {
                                fasterWhiteColoring = false;
                                whichColoring=0;
                                itemMaze[firstZombie9Location[0]][firstZombie9Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage9, firstZombie9Location);
                            });
                        }
                        if(StartView.getInputZombies()>=10) {
                            minotaurImage10.setOnDragDetected(event2 -> {
                                fasterWhiteColoring = false;
                                whichColoring=0;
                                itemMaze[firstZombie10Location[0]][firstZombie10Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage10, firstZombie10Location);
                            });
                        }
                        potionImage.setOnDragDetected(event2 -> {
                            whichColoring=0;
                            fasterWhiteColoring = false;
                            itemMaze[firstPotionLocation[0]][firstPotionLocation[1]]=false;
                            name = "Potion";
                            imageDrag(potionImage,firstPotionLocation);
                        });
                        minotaurImage.setOnDragDetected(event2 -> {
                            whichColoring=0;
                            fasterWhiteColoring = false;
                            itemMaze[firstZombieLocation[0]][firstZombieLocation[1]]=false;
                            name = "Zombie";
                            imageDrag(minotaurImage,firstZombieLocation);
                        });
                        if(StartView.getInputZombies()>=2) {
                            minotaurImage2.setOnDragDetected(event2 -> {
                                fasterWhiteColoring = false;
                                whichColoring=0;
                                itemMaze[firstZombie2Location[0]][firstZombie2Location[1]]=false;
                                name = "Zombie";
                                imageDrag(minotaurImage2, firstZombie2Location);
                            });
                        }
                        swordImage.setOnDragDetected(event2 -> {
                            fasterWhiteColoring = false;
                            whichColoring=0;
                            itemMaze[firstSwordLocation[0]][firstSwordLocation[1]]=false;
                            name = "Sword";
                            imageDrag(swordImage,firstSwordLocation);
                        });
                        redSquare.setOnDragDetected(event2 -> {
                            fasterWhiteColoring = false;
                            whichColoring=0;
                            itemMaze[firstRedSquareLocation[0]][firstRedSquareLocation[1]]=false;
                            name = "RedSquare";
                            imageDrag(redSquare,firstRedSquareLocation);
                        });
                        shieldImage.setOnDragDetected(event2 -> {
                            fasterWhiteColoring = false;
                            whichColoring=0;
                            itemMaze[firstShieldLocation[0]][firstShieldLocation[1]]=false;
                            name = "RedSquare";
                            imageDrag(shieldImage,firstShieldLocation);
                        });
                        } else {
                        event.setDropCompleted(false);
                    }
                    event.consume();
                });
            }
        }
    }
    /*Creates all the squares in the maze*/
    private void createSquares(){
        for(int r=0;r< mazeLayout.length;r++){
            for(int c=0;c< mazeLayout[0].length;c++){
                setSquareColor(mazeLayout[r][c],r,c);
                setSquarePosition(r, c,rect);
                changeColors(rect[r][c],r,c);
            }
        }
    }
    /*Sets the color of all the squares of the maze to the
     *color selected by the user for the walls
     */
    private void setSquareColor(boolean b, int row, int col){
        if(b){
            if(!StartView.isIsImageWall()) {
                rect[row][col] = new Rectangle(20, 20, 35, 35);
                rect[row][col].setFill(StartView.getColorWall());
            }
            else{
                rect[row][col] = new Rectangle(20, 20, 35, 35);
                rect[row][col].setFill(wallPattern);
            }
        }
        else{
            rect[row][col] = new Rectangle(20, 20, 35, 35);
            rect[row][col].setFill(StartView.getColorPath());
        }
    }
    /*Sets the positions of all the squares in the maze*/
    private void setSquarePosition(int row, int col, Rectangle[][] r){

        if(finalCounter < mazeLayout[0].length) {

            r[row][col].setLayoutX(xCounter);
            r[row][col].setLayoutY(yCounter);
            xCounter+=35;
            finalCounter++;
        }
        else if(finalCounter >= mazeLayout[0].length){
            finalCounter = 0;
            xCounter=0;
            yCounter+=35;
            r[row][col].setLayoutX(xCounter);
            r[row][col].setLayoutY(yCounter);

            xCounter+=35;
            finalCounter++;
        }
    }
    /*Adss all the squares to the pane for them to be visible*/
    private void addSquaresToPane() {
        for(int r=0;r< mazeLayout.length;r++){
            for(int c=0;c< mazeLayout[0].length;c++) {
                pane.getChildren().addAll(rect[r][c]);
            }
        }
    }
    /*Sets the mouse actions for the color choosing
     *of the squares to either one by one, drag over path (faster path coloring),
     *or drag over walls (faster wall coloring)
     */
    private void changeColors(Rectangle r, int row, int col){
        r.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY)
            {
                translateAnimation.setToX(isOn ? 70 - 50 : 0);
                fillAnimation.setFromValue(isOn ? Color.WHITE : Color.web("#a5cff5"));
                fillAnimation.setToValue(isOn ? Color.web("#a5cff5") : Color.WHITE);
                if(whichColoring<2) {
                    whichColoring++;
                }
                else{
                    whichColoring=0;
                }
            }
            if (event.getButton() == MouseButton.PRIMARY) {
                if (whichColoring == 0) {
                    if (!StartView.isIsImageWall()) {
                        if (r.getFill().equals(StartView.getColorWall())) {
                            r.setFill(StartView.getColorPath());
                        } else if (r.getFill().equals(StartView.getColorPath()) && !itemMaze[row][col]) {
                            r.setFill(StartView.getColorWall());
                        }
                    } else {
                        if (r.getFill().equals(wallPattern)) {
                            r.setFill(pathPattern);
                        } else if (r.getFill().equals(pathPattern) && !itemMaze[row][col]) {
                            r.setFill(wallPattern);
                        }
                    }
                }
            }
        });
        r.setOnMouseEntered(event -> {
            if(whichColoring==1) {
                if (!StartView.isIsImageWall()) {
                    if (r.getFill().equals(StartView.getColorWall())) {
                        r.setFill(StartView.getColorPath());
                    }

                } else {
                    if (r.getFill().equals(wallPattern)) {
                        r.setFill(pathPattern);
                    }

                }
            }
            if(whichColoring==2) {
                if (!StartView.isIsImagePath()) {
                    if (r.getFill().equals(StartView.getColorPath())) {
                        r.setFill(StartView.getColorWall());
                    }

                } else {
                    if (r.getFill().equals(pathPattern)) {
                        r.setFill(wallPattern);
                    }

                }
            }
        });
    }
    /*Saves the maze created by the user for it to be playable right after*/
    private void saveMaze() throws IOException, AWTException {
        xCounter = 0;
        yCounter = 0;
        finalCounter = 0;
        stage2 = new Stage();
        Image icon = new Image(getClass().getResourceAsStream("/View/Assets/GameLogo.PNG"));
        stage2.getIcons().add(icon);
        stage2.setResizable(false);
        pane2 = new AnchorPane();
        scene2 = new Scene(pane2,StartView.getInputCols()*35+40,StartView.getInputRows()*35+90);
        scene2.getStylesheets().addAll("Stylesheet.css");
        stage2.setScene(scene2);
        firstSavedMaze2 = new Rectangle[rect.length][rect[0].length];
        for(int i=0;i<rect.length;i++){
            for(int j=0;j<rect[0].length;j++){
                firstSavedMaze2[i][j] = new Rectangle(20, 20, 35, 35);
                setSquarePosition(i, j,firstSavedMaze2);
                firstSavedMaze2[i][j].setFill(rect[i][j].getFill());
            }
        }
        xCounter=0;
        yCounter=0;
        finalCounter=0;
        firstSavedMaze = new Rectangle[rect.length][rect[0].length];
        for(int i=0;i<rect.length;i++){
            for(int j=0;j<rect[0].length;j++){
                firstSavedMaze[i][j] = new Rectangle(20, 20, 35, 35);
                setSquarePosition(i, j,firstSavedMaze);
                firstSavedMaze[i][j].setFill(rect[i][j].getFill());
            }
        }


        redSquareImage = new ImagePattern((new Image(getClass().getResourceAsStream("/View/Assets/RedSquare.png"))));

        firstSavedMaze[firstPlyLocation[0]][firstPlyLocation[1]].setFill(new ImagePattern(playerNoSword));
        if(StartView.getInputZombies()>=3) {
            firstSavedMaze[firstZombie3Location[0]][firstZombie3Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        firstSavedMaze[firstZombieLocation[0]][firstZombieLocation[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream(  "/View/Assets/character_zombie_side.png"))));
        firstSavedMaze[firstPotionLocation[0]][firstPotionLocation[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/TimePotion.png"))));
        firstSavedMaze[firstSwordLocation[0]][firstSwordLocation[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/SwordZ.png"))));
        firstSavedMaze[firstRedSquareLocation[0]][firstRedSquareLocation[1]].setFill(redSquareImage);
        if(StartView.getInputZombies()>=2) {
            firstSavedMaze[firstZombie2Location[0]][firstZombie2Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=4) {
            firstSavedMaze[firstZombie4Location[0]][firstZombie4Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=5) {
            firstSavedMaze[firstZombie5Location[0]][firstZombie5Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=6) {
            firstSavedMaze[firstZombie6Location[0]][firstZombie6Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=7) {
            firstSavedMaze[firstZombie7Location[0]][firstZombie7Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=8) {
            firstSavedMaze[firstZombie8Location[0]][firstZombie8Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=9) {
            firstSavedMaze[firstZombie9Location[0]][firstZombie9Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        if(StartView.getInputZombies()>=10) {
            firstSavedMaze[firstZombie10Location[0]][firstZombie10Location[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/View/Assets/character_zombie_side.png"))));
        }
        firstSavedMaze[firstShieldLocation[0]][firstShieldLocation[1]].setFill(new ImagePattern(new Image(getClass().getResourceAsStream(  "/View/Assets/Shield.png"))));

        for(int i=0;i<rect.length;i++){
            for(int j=0;j<rect[0].length;j++) {
                pane2.getChildren().addAll(firstSavedMaze2[i][j]);
                pane2.getChildren().addAll(firstSavedMaze[i][j]);
            }
        }
        stage.close();
        stage2.show();
        createTimer();
        createHealthBar();

    }
    /*When the player reaches the square in which the sword is,
     *changes the image of the player to the one with the
     *sword and the position of the player is changed to that
     *of the sword
     */
    public static void setPlayerWithSwordImage(){
        if(swordT == 0) {
            playerNoSword = new Image(MazeView.class.getResourceAsStream("/View/Assets/PlayerWithSword.jpg"));
            ImagePattern ip = new ImagePattern(playerNoSword);
            playerImage = new ImageView(playerNoSword);
            firstSavedMaze[firstSwordLocation[0]][firstSwordLocation[1]].setFill(ip);
            if(!StartView.isIsImageWall()) {
                firstSavedMaze[track[0]][track[1]].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]][track[1]].setFill(pathPattern);
            }
            track[0] = firstSwordLocation[0];
            track[1] = firstSwordLocation[1];
            swordT++;
        }
    }
    /*Changes the image of the player to one square to the right.
     *Changes the color of the previous position of the
     *player to the color of the path. Increments the step counter
     * Updates the position of the player
     */
    public static void setImageRight(Image fl, int theRow, int theCol){
        stepCounter++;
        int[] player = firstPlyLocation;
        int i=0;
        ImagePattern ip = new ImagePattern(fl);
        Rectangle next = null;

        if(i==0) {
            if (track == null) {
                next = firstSavedMaze[player[0]][player[1] + theCol];

            } else {
                next = firstSavedMaze[track[0]][track[1] + theCol];
            }
            i++;
        }
        track = new int[]{track[0] , track[1] + theCol};


        if(!StartView.isIsImagePath()) {
             firstSavedMaze[track[0]][track[1] - theCol].setFill(StartView.getColorPath());
         }
        else{
            firstSavedMaze[track[0]][track[1] - theCol].setFill(pathPattern);
        }



        if(track[1]< firstSavedMaze[0].length && isPath(firstSavedMaze[track[0]][track[1]])) {
            next.setFill(ip);
        }
    }
    /*Changes the image of the player to one square to the left.
     *Changes the color of the previous position of the
     *player to the color of the path. Increments the step counter
     * Updates the position of the player
     */
    public static void setImageLeft(Image fl, int theRow, int theCol){
        stepCounter++;

        ImagePattern ip = new ImagePattern(fl);
        Rectangle previous = firstSavedMaze[track[0]][track[1]];
        Rectangle last = firstSavedMaze[track[0]][track[1]-theCol];
        track = new int[]{track[0],track[1]-theCol};


        if( track[1]< firstSavedMaze[0].length && isPath(firstSavedMaze[track[0]][track[1]])) {
            last.setFill(ip);
            if(!StartView.isIsImagePath()) {
                previous.setFill(StartView.getColorPath());
            }
            else{
                previous.setFill(pathPattern);
            }

        }
        if(!isPath(firstSavedMaze[theRow][theCol])){
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[track[0]][track[1]+theCol].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]][track[1] +theCol].setFill(pathPattern);
            }
        }
    }
    /*Changes the image of the player to one square up.
     *Changes the color of the previous position of the
     *player to the color of the path. Increments the step counter
     * Updates the position of the player
     */
    public static void setImageUp(Image fl, int theRow, int theCol){
        stepCounter++;

        ImagePattern ip = new ImagePattern(fl);

        Rectangle previous = firstSavedMaze[track[0]][track[1]];
        Rectangle last =  firstSavedMaze[track[0]-theRow][track[1]];

        track = new int[]{track[0]-theRow, track[1] };

        if(!StartView.isIsImagePath()) {
            firstSavedMaze[track[0]+theRow][track[1]].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[track[0]+theRow][track[1]].setFill(pathPattern);
        }
        if(track[0]< mazeLayout.length && isPath(firstSavedMaze[track[0]][track[1]]) ) {
            last.setFill(ip);
            if(!StartView.isIsImagePath()) {
                previous.setFill(StartView.getColorPath());
            }
            else{
                previous.setFill(pathPattern);
            }

        }
        if(!isPath(firstSavedMaze[theRow][theCol])){
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[track[0]+theRow][track[1]+theCol].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]+theRow][track[1]+theCol].setFill(pathPattern);
            }
        }
    }
    /*Changes the image of the player to one square up.
     *Changes the color of the previous position of the
     *player to the color of the path. Increments the step counter
     * Updates the position of the player
     */
    public static void setImageDown(Image fl, int theRow, int theCol){
        stepCounter++;
        ImagePattern ip = new ImagePattern(fl);

        Rectangle previous = firstSavedMaze[track[0]][track[1]];
        Rectangle last =  firstSavedMaze[track[0]+theRow][track[1]];
        track = new int[]{track[0]+theRow, track[1]};

        if(!StartView.isIsImagePath()) {
            firstSavedMaze[track[0]-theRow][track[1]].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[track[0]-theRow][track[1]].setFill(pathPattern);
        }

        if(track[0]< mazeLayout.length  && isPath(firstSavedMaze[track[0]][track[1]])) {
            last.setFill(ip);
            if(!StartView.isIsImagePath()) {
                previous.setFill(StartView.getColorPath());
            }
        }
    }
    /*Changes the image of  zombie number 1 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 2 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage2(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM2 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 3 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage3(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM3 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 4 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage4(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM4 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 5 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage5(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM5 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 6 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage6(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM6 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 7 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage7(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM7 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 8 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage8(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM8 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 9 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage9(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM9 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Changes the image of  zombie number 10 to the specified row and column.
     *Changes the color of the previous position of the
     *zombie (specified by prevRow and prevCol) to the color of the path
     */
    public static void changeZombieImage10(Image fl, int row, int col, int prevRow, int prevCol){
        ImagePattern ip = new ImagePattern(fl);

        Rectangle next = firstSavedMaze[row][col];
        trackM10 = new int[]{row, col};

        next.setFill(ip);
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[prevRow][prevCol].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[prevRow][prevCol].setFill(pathPattern);
        }
    }
    /*Checks if a square is pat of the path*/
    public static boolean isPath(Rectangle r){
        if(r.getFill().equals(pathPattern) || r.getFill().equals(StartView.getColorPath())){
            return true;
        }
        return false;
    }
    /*Checks if the player's position matches that of a Zombie
     *and has no shield or sword and if so the player dies
     */
    public static boolean isPlayerKilled(Rectangle r, Player pt,int row, int col){
        ImagePattern ip = new ImagePattern(playerNoSword);
        if(row==track[0] && col==track[1] && !pt.hasSword() && !pt.hasShield()){
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[getCurRowM()][getCurColM()].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[getCurRowM()][getCurColM()].setFill(pathPattern);
            }
            firstSavedMaze[getCurRow()][getCurCol()].setFill(new ImagePattern(minotaur));
            pt.kill();
            dead(p);

            return true;
        }
        return false;
    }
    /*Checks if the player's position matches that of the exit (red square)
     *and if so the player gets a win message
     */
    public static void winMessage() {
        if(firstSavedMaze[getCurRow()][getCurCol()]==firstSavedMaze[firstRedSquareLocation[0]][firstRedSquareLocation[1]]){
            playerDead=true;

            Alert alert = new Alert(Alert.AlertType.NONE, "You did it! You escaped from the horrific Zombies\nYou walked a total of " + stepCounter + " steps");
            alert.getDialogPane().getStylesheets().add("Stylesheet.css");

            Platform.runLater(alert::showAndWait);

            Timer t = new java.util.Timer();
            t.schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            try {
                                stage2.close();
                                System.exit(0);
                            }
                            catch(Exception e){
                                System.exit(0);
                            }
                            t.cancel();
                        }
                    },
                    5000
            );
        }
    }
    /*The player kills Zombie number 1 (which is replaced by a square
    with the color of the path)*/
    public static void alive(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie.kill();

       firstSavedMaze[getCurRowM()][getCurColM()].setFill(ip);
       track[0] = trackM[0];
       track[1] = trackM[1];
    }
    /*The player kills Zombie number 2 (which is replaced by a square
    with the color of the path)*/
    public static void alive2(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);
        zombie2.kill();

        firstSavedMaze[getCurRowM2()][getCurColM2()].setFill(ip);
        track[0] = trackM2[0];
        track[1] = trackM2[1];
    }
    /*The player kills Zombie number 3 (which is replaced by a square
    with the color of the path)*/
    public static void alive3(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie3.kill();
        firstSavedMaze[getCurRowM3()][getCurColM3()].setFill(ip);
        track[0] = trackM3[0];
        track[1] = trackM3[1];
    }
    /*The player kills Zombie number 4 (which is replaced by a square
    with the color of the path)*/
    public static void alive4(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie4.kill();
        firstSavedMaze[getCurRowM4()][getCurColM4()].setFill(ip);
        track[0] = trackM4[0];
        track[1] = trackM4[1];
    }
    /*The player kills Zombie number 5 (which is replaced by a square
    with the color of the path)*/
    public static void alive5(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie5.kill();
        firstSavedMaze[getCurRowM5()][getCurColM5()].setFill(ip);
        track[0] = trackM5[0];
        track[1] = trackM5[1];
    }
    /*The player kills Zombie number 6 (which is replaced by a square
    with the color of the path)*/
    public static void alive6(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie6.kill();
        firstSavedMaze[getCurRowM6()][getCurColM6()].setFill(ip);
        track[0] = trackM6[0];
        track[1] = trackM6[1];
    }
    /*The player kills Zombie number 7 (which is replaced by a square
    with the color of the path)*/
    public static void alive7(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie7.kill();
        firstSavedMaze[getCurRowM7()][getCurColM7()].setFill(ip);
        track[0] = trackM7[0];
        track[1] = trackM7[1];
    }
    /*The player kills Zombie number 8 (which is replaced by a square
    with the color of the path)*/
    public static void alive8(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie8.kill();
        firstSavedMaze[getCurRowM8()][getCurColM8()].setFill(ip);
        track[0] = trackM8[0];
        track[1] = trackM8[1];
    }
    /*The player kills Zombie number 9 (which is replaced by a square
    with the color of the path)*/
    public static void alive9(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie9.kill();
        firstSavedMaze[getCurRowM9()][getCurColM9()].setFill(ip);
        track[0] = trackM9[0];
        track[1] = trackM9[1];
    }
    /*The player kills Zombie number 10 (which is replaced by a square
    with the color of the path)*/
    public static void alive10(){
        if(!StartView.isIsImagePath()) {
            firstSavedMaze[getCurRow()][getCurCol()].setFill(StartView.getColorPath());
        }
        else{
            firstSavedMaze[getCurRow()][getCurCol()].setFill(pathPattern);
        }
        ImagePattern ip = new ImagePattern(playerNoSword);

        zombie10.kill();
        firstSavedMaze[getCurRowM10()][getCurColM10()].setFill(ip);
        track[0] = trackM10[0];
        track[1] = trackM10[1];
    }
    /*GIves the user a message that the player has
     *been killed by the zombies and replaces the image
     *of the player with a dead face*/
    public static void dead(Player p) {
        if(!dead) {
            gameOver = true;
            dead = true;
            playerDead=true;
            Alert alert = new Alert(Alert.AlertType.NONE, "The zombies ate you, you failed to escape" + "\nYour step count was: " + stepCounter);
            alert.getDialogPane().getStylesheets().add("Stylesheet.css");

            Platform.runLater(alert::showAndWait);

            Timer t = new java.util.Timer();
            t.schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            try {
                                stage2.close();
                                System.exit(0);
                            }
                            catch(Exception e){
                                System.exit(0);
                            }
                            t.cancel();
                        }
                    },
                    5000
            );
        }
        Image image = new Image(MazeView.class.getResourceAsStream("/View/Assets/character_zombie_side.png"));
        ImagePattern ip = new ImagePattern(image);

        firstSavedMaze[getCurRowM()][getCurColM()].setFill(ip);
        p.kill();
    }
    /*Changes the health or shield of the player and if the health is
     *zero then the player dies and receives a message that tells them
     */
    public static void changeHealth(){
        if(currentShield<=0 || !World.getP().hasShield()) {
            if(currentHealth>=0 && currentHealth<=0.02){
                currentHealth=0;
                checkForZeroHealth();
            }
            if (currentHealth >= 0.02) {
                currentHealth -= 0.02;
                healthBar.setProgress(currentHealth);
                checkForZeroHealth();
            }
        }
        else{
            if(currentShield>=0 && currentShield<=0.02){
                currentShield=0;
                checkForZeroHealth();
            }
            if (currentShield >= 0.02) {
                currentShield -= 0.02;
                shieldBar.setProgress(currentShield);
                checkForZeroHealth();
            }
        }
    }
    /*Checks if the health of the player is 0 and if so the player is told that he has died
    and the health and shield bars are u[dated accordingly*/
    private static void checkForZeroHealth(){
        if (changeHealthAlert == 0) {
            if (!World.getP().hasShield() && currentHealth <= 0) {
                changeHealthAlert++;
                gameOver = true;
                playerDead = true;
                healthBar.setProgress(0.0);
                Alert alert = new Alert(Alert.AlertType.NONE, "The zombies ate you, you failed to escape" + "\nYour step count was: " + stepCounter);
                alert.getDialogPane().getStylesheets().add("Stylesheet.css");

                Platform.runLater(alert::showAndWait);

                Timer t = new java.util.Timer();
                t.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                try {
                                    stage2.close();
                                    System.exit(0);
                                } catch (Exception e) {
                                    System.exit(0);
                                }
                                t.cancel();
                            }
                        },
                        5000
                );
            } else if (World.getP().hasShield() && currentShield <= 0 && currentHealth <= 0) {
                changeHealthAlert++;
                playerDead = true;
                healthBar.setProgress(0.0);
                shieldBar.setProgress(0.0);
                gameOver = true;
                playerNoSword = new Image(MazeView.class.getResourceAsStream("/View/Assets/PlayerDead.png"));
                ImagePattern ip = new ImagePattern(playerNoSword);
                firstSavedMaze[track[0]][track[1]].setHeight(20);
                firstSavedMaze[track[0]][track[1]].setWidth(20);
                firstSavedMaze[track[0]][track[1]].setLayoutY(firstSavedMaze[track[0]][track[1]].getLayoutY()+9);
                firstSavedMaze[track[0]][track[1]].setLayoutX(firstSavedMaze[track[0]][track[1]].getLayoutX()+9);

                firstSavedMaze[track[0]][track[1]].setFill(ip);
                Alert alert = new Alert(Alert.AlertType.NONE, "The zombies ate you, you failed to escape" + "\nYour step count was: " + stepCounter);
                alert.getDialogPane().getStylesheets().add("Stylesheet.css");

                Platform.runLater(alert::showAndWait);

                Timer t = new java.util.Timer();
                t.schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                try {
                                    stage2.close();
                                    System.exit(0);
                                } catch (Exception e) {
                                    System.exit(0);
                                }
                                t.cancel();
                            }
                        },
                        5000
                );
            }
        }
    }
    /*Sets the square with the potion to the image of the
    player. Creates a rain gif. Updates the position of the player*/
    public static void setPotionImages(){
        if(potion==0) {
            createGif();
            ImagePattern ip = new ImagePattern(playerNoSword);
            firstSavedMaze[firstPotionLocation[0]][firstPotionLocation[1]].setFill(ip);
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[track[0]][track[1]].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]][track[1]].setFill(pathPattern);
            }

            track[0] = firstPotionLocation[0];
            track[1] = firstPotionLocation[1];
            potion++;
        }
    }
    /*Creates a rain gif on the maze*/
    public static void createGif(){
        final boolean[] ready = {false};
        Image fis = new Image(MazeView.class.getResourceAsStream("/View/Assets/PotionRain.gif"));
        final ImageView[] waitGifView = {new ImageView(fis)};
        waitGifView[0].setFitWidth(stage2.getWidth());
        waitGifView[0].setFitHeight(stage2.getHeight());
        pane2.getChildren().add(waitGifView[0]);

        Timer t = new java.util.Timer();
        t.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            ready[0] = true;
                            pane2.getChildren().remove(waitGifView);
                        }
                        catch(Exception e){
                        }
                    }
                },
                2500
        );
    }
    /*Sets the image of the player to that of the player with a
    shield and updates the position of the player*/
    public static void setShieldImages(){
        if(shieldC==0) {
            playerNoSword =  new Image(MazeView.class.getResourceAsStream("/View/Assets/PlayerWithShield.png"));
            ImagePattern ip = new ImagePattern(playerNoSword);
            firstSavedMaze[firstShieldLocation[0]][firstShieldLocation[1]].setFill(ip);
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[track[0]][track[1]].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]][track[1]].setFill(pathPattern);
            }
            track[0] = firstShieldLocation[0];
            track[1] = firstShieldLocation[1];
            shieldC++;
        }
    }
    /*Sets the image of the player to that of the player with a sword and
    shield and updates the position of the player*/
    public static void setSwordShieldImages(){
        if(shieldSwordC==0) {
            playerNoSword = new Image(MazeView.class.getResourceAsStream("/View/Assets/PlayerWithSword&Shield.png"));
            ImagePattern ip = new ImagePattern(playerNoSword);
            playerImage = new ImageView(playerNoSword);
            firstSavedMaze[firstSwordLocation[0]][firstSwordLocation[1]].setFill(ip);
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[track[0]][track[1]].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]][track[1]].setFill(new ImagePattern(StartView.getPathImageR()));
            }
            track[0] = firstSwordLocation[0];
            track[1] = firstSwordLocation[1];
            swordT++;
        }
    }
    /*Sets the image of the player to that of the player with a sword and
    shield and updates the position of the player*/
    public static void setSwordShieldImages2(){
        if(shieldSwordC==0) {
            playerNoSword = new Image(MazeView.class.getResourceAsStream("/View/Assets/PlayerWithSword&Shield.png"));
            ImagePattern ip = new ImagePattern(playerNoSword);
            firstSavedMaze[firstShieldLocation[0]][firstShieldLocation[1]].setFill(ip);
            if(!StartView.isIsImagePath()) {
                firstSavedMaze[track[0]][track[1]].setFill(StartView.getColorPath());
            }
            else{
                firstSavedMaze[track[0]][track[1]].setFill(pathPattern);
            }
            track[0] = firstShieldLocation[0];
            track[1] = firstShieldLocation[1];
            shieldSwordC++;
        }
    }
}