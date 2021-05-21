package View;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StartView {
    private static Stage stage;
    private static AnchorPane pane;
    private static Scene scene;
    private Button generateB;
    private ColorPicker colorPicker1;
    private ColorPicker colorPicker2;
    private Label colorPickL1;
    private Label colorPickL2;
    private Label title;
    private Label copyRight;
    private Label limitMins;
    private TextField tfNumRows;
    private TextField tfNumCols;
    private TextField tfNumZombies;
    private Button sound;
    private Button question;
    private Button wallImage;
    private Button pathImage;
    private ImageView onAuI;
    private ImageView offAuI;
    private ImageView myImage;
    private String tfRowsEntered;
    private String tfColsEntered;
    private String tfZombiesEntered;
    private boolean clicked;
    private static int inputRows;
    private static int inputCols;
    private static int inputZombies;
    private static Color colorPath;
    private static Color colorWall;
    private static Image wallImageR;
    private static Image pathImageR;
    private static ImageView wallImageIV;
    private static ImageView pathImageIV;
    private static boolean isImageWall;
    private static boolean isImagePath;
    private static File file;
    private static File file2;
    private int soundClickCount;
    private static int moveCount;
    private static int moveCount2;

    public static Image getWallImageR() {
        return wallImageR;
    }

    public static Image getPathImageR() {
        return pathImageR;
    }

    public static boolean isIsImageWall() {
        return isImageWall;
    }

    public static boolean isIsImagePath() {
        return isImagePath;
    }

    public static Color getColorPath() {
        return colorPath;
    }

    public static Color getColorWall() {
        return colorWall;
    }

    public static int getInputRows() {
        return inputRows;
    }

    public static int getInputCols() {
        return inputCols;
    }

    public static int getInputZombies() {
        return inputZombies;
    }

    /*Creates the main menu where the user can customize the maze*/
    public StartView(){
        stage = new Stage();
        pane = new AnchorPane();
        scene = new Scene(pane,730,620);
        stage.setScene(scene);
        Image icon = new Image(getClass().getResourceAsStream("/View/Assets/GameLogo.PNG"));
        stage.getIcons().add(icon);
        createBackground(new Image(getClass().getResourceAsStream("/View/Assets/back.jpg")));
        stage.setResizable(false);
        scene.getStylesheets().addAll("Stylesheet.css");
        if(Audio.plays==0) {
            Audio.playMusic("/View/Assets/GameMusic.m4a");
            Audio.plays++;
        }
        addSoundButton();
        addHelpButton();
        createButtons();
        createLabels();
        addColorPickers();
        createTextFields();
        setButtonActions();
        setColorPickerValues();
        addSoundActions();
        addHelpActions();
        putImageActions();
        stage.show();
    }
    /*Sets the background image of the main menu*/
    private void createBackground(Image f) {
        BackgroundImage backImage = new BackgroundImage(f, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(f.getWidth()-15,f.getHeight()-20,false,false,false,false));
        Background back = new Background(backImage);
        pane.setBackground(back);
    }
    /*Creates a sound button for background sound if wanted*/
    private void addSoundButton(){
        sound = new Button("");
        onAuI = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/AudioOn.png")));
        sound.setGraphic(onAuI);
        sound.setLayoutX(650);
        sound.setLayoutY(40);
        sound.setId("sound");
        pane.getChildren().addAll(sound);
    }
    /*Creates a help button for a tutorial*/
    private void addHelpButton(){
        question = new Button("");
        question.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/whiteQuestion.png"))));
        question.setLayoutX(650);
        question.setLayoutY(550);
        question.setId("help");
        pane.getChildren().addAll(question);
    }
    /*Sets the actions of the sound button*/
    private void addSoundActions(){
        sound.setOnAction(event -> {
            if(sound.getGraphic().equals(onAuI)) {
                Audio.getClip().stop();
                sound.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/AudioOff.png"))));
                soundClickCount++;
            }
            else {
                Audio.playMusic("GameMusic.m4a");
                onAuI = new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/AudioOn.png")));
                sound.setGraphic(onAuI);
                soundClickCount++;
            }
        });
    }
    /*Sets the actions for the help button*/
    private void addHelpActions(){
        question.setOnAction(event -> {
            Alert alert0 = new Alert(Alert.AlertType.NONE, "Input a color for your path and walls, or upload your own path and wall images");
            alert0.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/HelpColor.JPG"))));
            alert0.getDialogPane().getStylesheets().add("Stylesheet.css");

            ButtonType alertButton0 = new ButtonType("Next");
            alert0.getButtonTypes().setAll(alertButton0);
            Optional<ButtonType> result0 = alert0.showAndWait();
            try {
                if(result0.get() == alertButton0) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Once you create the maze use the arrow keys to move");
                    alert.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/keys.png"))));
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");

                    ButtonType alertButton = new ButtonType("Next");
                    alert.getButtonTypes().setAll(alertButton);
                    Optional<ButtonType> result = alert.showAndWait();
                    try {
                        if (result.get() == alertButton) {
                            Alert alert2 = new Alert(Alert.AlertType.NONE);
                            alert2.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/View/Assets/helpItems.JPG"))));
                            alert2.getDialogPane().getStylesheets().add("Stylesheet.css");
                            alert2.getDialogPane().setPrefWidth(5);
                            ButtonType alertButton2 = new ButtonType("Next");
                            alert2.getButtonTypes().setAll(alertButton2);
                            Optional<ButtonType> result2 = alert2.showAndWait();
                            try {
                                if (result2.get() == alertButton2) {
                                    Alert alert3 = new Alert(Alert.AlertType.NONE, "Good Luck on your journey");
                                    alert3.getDialogPane().getStylesheets().add("Stylesheet.css");
                                    ButtonType alertButton3 = new ButtonType("Ok");
                                    alert3.getButtonTypes().setAll(alertButton3);
                                    alert3.showAndWait();
                                }
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            } catch(Exception e){

            }
        });
    }
    /*Creates all labels in the main menu*/
    private void createLabels(){
        colorPickL1 = new Label("Select your path color");
        colorPickL1.setLayoutX(203);
        colorPickL1.setLayoutY(270);
        colorPickL2 = new Label("Select your wall color");
        colorPickL2.setLayoutX(410);
        colorPickL2.setLayoutY(270);
        colorPickL1.setId("start-colorpick");
        colorPickL2.setId("start-colorpick");
        title = new Label("Zombie Apocalypse Maze Generator");
        title.setLayoutX(scene.getWidth()/2-230);
        title.setLayoutY(scene.getHeight()/5);
        title.setId("start-title");
        copyRight = new Label("© Christian Ibarbia");
        copyRight.setLayoutX(640);
        copyRight.setLayoutY(608);
        copyRight.setId("copy-label");
        limitMins = new Label("1 - 10");
        limitMins.setLayoutX(355);
        limitMins.setLayoutY(460);
        limitMins.setId("start-colorpick");
        pane.getChildren().addAll(colorPickL1,colorPickL2,title,copyRight,limitMins);
    }
    /*Creates buttons to vhange the path and wall images and one to generate the maze*/
    private void createButtons(){
        generateB = new Button("Generate");
        generateB.setLayoutX(340);
        generateB.setLayoutY(550);

        wallImage = new Button("Upload wall");
        wallImage.setId("my-image");
        wallImage.setLayoutX(486);
        wallImage.setLayoutY(300);
        wallImage.setPrefHeight(29);

        pathImage = new Button("Upload path");
        pathImage.setId("my-image");
        pathImage.setLayoutX(168);
        pathImage.setLayoutY(300);
        pathImage.setPrefHeight(29);

        generateB.getStylesheets().addAll("Stylesheet.css");

        pane.getChildren().addAll(generateB,wallImage,pathImage);
    }
    /*Sets actions for when the path and image buttons are clicked to change the
    images of the path and wall to the ones uploaded by the user*/
    private void putImageActions(){
        wallImage.setOnAction(event -> {
            wallImageIV = new ImageView();
            wallImage.setGraphic(wallImageIV);
            isImageWall = true;
            colorPicker1.setDisable(true);
            colorPicker2.setDisable(true);
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

             file = fileChooser.showOpenDialog(null);

            try {
                if(fileChooser.getSelectedExtensionFilter()!=null) {
                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    wallImageR = image;
                    wallImageIV = new ImageView(wallImageR);
                    wallImageIV.setFitWidth(12);
                    wallImageIV.setFitHeight(12);
                    wallImage.setGraphic(wallImageIV);
                }
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        });
        pathImage.setOnAction(event -> {
            pathImageIV = new ImageView();
            pathImage.setGraphic(pathImageIV);
            if(moveCount2==0) {
                pathImage.setLayoutX(pathImage.getLayoutX() - 3);
                moveCount2++;
            }
            isImagePath = true;
            colorPicker1.setDisable(true);
            colorPicker2.setDisable(true);
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            file2 = fileChooser.showOpenDialog(null);

            try {
                if(fileChooser.getSelectedExtensionFilter()!=null) {
                    BufferedImage bufferedImage = ImageIO.read(file2);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    pathImageR = image;
                    pathImageIV = new ImageView(pathImageR);
                    pathImageIV.setFitWidth(12);
                    pathImageIV.setFitHeight(12);
                    if(moveCount==0) {
                        pathImage.setLayoutX(pathImage.getLayoutX() - 12);
                        moveCount++;
                    }
                    pathImage.setGraphic(pathImageIV);
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    /*Creates two color pickers so that the user can ick the color of the path and the walls*/
    private void addColorPickers(){
        colorPicker1 = new ColorPicker();
        colorPicker1.setValue(Color.WHITE);
        colorPicker1.setStyle("-fx-cursor: hand");
        colorPicker1.setLayoutX(260);
        colorPicker1.setLayoutY(300);
        colorPath = Color.WHITE;

        colorPicker2= new ColorPicker();
        colorPicker2.setValue(Color.BLACK);
        colorPicker2.setStyle("-fx-cursor: hand");
        colorPicker2.setLayoutX(375);
        colorPicker2.setLayoutY(300);
        colorWall = Color.BLACK;
        pane.getChildren().addAll(colorPicker1,colorPicker2);
    }
    /*Sets the default values of the color pickers to white(path) and black(walls)*/
    private void setColorPickerValues(){
        colorPicker1.setOnAction(event -> {
            colorPicker1.setDisable(false);
            pathImage.setDisable(true);
            wallImage.setDisable(true);
            colorPath = colorPicker1.getValue();
        });
        colorPicker2.setOnAction(event -> {
            colorPicker2.setDisable(false);
            wallImage.setDisable(true);
            pathImage.setDisable(true);
            colorWall = colorPicker2.getValue();
        });
    }
    /*Sets actions for the generate button and checks that are conditions of the maze are met*/
    private void setButtonActions(){
        final boolean[] in = {false};
        final boolean[] done = {false};
        double compWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double compHeight = Screen.getPrimary().getVisualBounds().getHeight();
        if(!clicked) {
            generateB.setOnAction(event -> {
                if (validateZombieNum() && validateTextFields()&&(compWidth < ((35 * inputCols) + 40) || compHeight < ((35 * inputRows) + 150)) && !in[0]) {
                    done[0] = true;
                    Alert alert = new Alert(Alert.AlertType.NONE, "This maze won't fit on your screen, please reduce the number of rows and columns");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
                if (!done[0]&&(isIsImagePath() && isIsImageWall() && validateWallAndPathImages()&&validateZombieNum() && !file.getAbsolutePath().equals(file2.getAbsolutePath()))
                        || (!isIsImageWall() && !isIsImagePath()) && (validateZombieNum() && inputZombies <= 10 && inputZombies > 0) && inputRows >= 12 && inputCols >= 12
                        && validateTextFields() && !(equals(colorPicker2.getValue())) && !clicked
                         &&compWidth >= ((35 * inputCols) + 40) && compHeight >= ((35 * inputRows) + 150)) {
                    in[0] = true;
                    clicked = true;
                    stage.close();
                    MazeView mv = new MazeView();
                }
                if (validateWallAndPathImages() && file.getAbsolutePath().equals(file2.getAbsolutePath())) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Please upload different images for the path and the walls");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
                if((isIsImageWall() || isIsImagePath()) &&(!validateWallAndPathImages()) ){
                    Alert alert = new Alert(Alert.AlertType.NONE, "Please upload a picture for your path and and your walls");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
                if (!validateTextFields() || inputRows < 12 || inputCols < 12) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Please enter a number a minimum of 12 rows and 12 columns");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
                if (!validateZombieNum() || inputZombies > 10 || inputZombies <= 0) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Please enter a number of zombies between 1 and 10");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
                if (equals(colorPicker2.getValue())) {
                    Alert alert = new Alert(Alert.AlertType.NONE, "Please enter different colors for the path and the walls");
                    alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                    ButtonType alertButton = new ButtonType("Ok");
                    alert.getButtonTypes().setAll(alertButton);
                    alert.showAndWait();
                }
            });
        }
        if(!clicked) {
            scene.setOnKeyPressed(event -> {
                if(event.getCode()== KeyCode.ENTER) {
                    if (validateZombieNum() && validateTextFields()&&(compWidth < ((35 * inputCols) + 40) || compHeight < ((35 * inputRows) + 150)) && !in[0]) {
                        done[0] = true;
                        Alert alert = new Alert(Alert.AlertType.NONE, "This maze won't fit on your screen, please reduce the number of rows and columns");
                        alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                        ButtonType alertButton = new ButtonType("Ok");
                        alert.getButtonTypes().setAll(alertButton);
                        alert.showAndWait();
                    }
                    if (!done[0]&&(isIsImagePath() && isIsImageWall() && validateWallAndPathImages()&&validateZombieNum() && !file.getAbsolutePath().equals(file2.getAbsolutePath()))
                            || (!isIsImageWall() && !isIsImagePath()) && (validateZombieNum() && inputZombies <= 10 && inputZombies > 0) && inputRows >= 12 && inputCols >= 12
                            && validateTextFields() && !(equals(colorPicker2.getValue())) && !clicked
                            &&compWidth >= ((35 * inputCols) + 40) && compHeight >= ((35 * inputRows) + 150)) {
                        in[0] = true;
                        clicked = true;
                        stage.close();
                        MazeView mv = new MazeView();
                    }
                    if (validateWallAndPathImages() && file.getAbsolutePath().equals(file2.getAbsolutePath())) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "Please upload different images for the path and the walls");
                        alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                        ButtonType alertButton = new ButtonType("Ok");
                        alert.getButtonTypes().setAll(alertButton);
                        alert.showAndWait();
                    }
                    if((isIsImageWall() || isIsImagePath()) &&(!validateWallAndPathImages()) ){
                        Alert alert = new Alert(Alert.AlertType.NONE, "Please upload a picture for your path and and your walls");
                        alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                        ButtonType alertButton = new ButtonType("Ok");
                        alert.getButtonTypes().setAll(alertButton);
                        alert.showAndWait();
                    }
                    if (!validateTextFields() || inputRows < 12 || inputCols < 12) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "Please enter a number a minimum of 12 rows and 12 columns");
                        alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                        ButtonType alertButton = new ButtonType("Ok");
                        alert.getButtonTypes().setAll(alertButton);
                        alert.showAndWait();
                    }
                    if (!validateZombieNum() || inputZombies > 10 || inputZombies <= 0) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "Please enter a number of zombies between 1 and 10");
                        alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                        ButtonType alertButton = new ButtonType("Ok");
                        alert.getButtonTypes().setAll(alertButton);
                        alert.showAndWait();
                    }
                    if (equals(colorPicker2.getValue())) {
                        Alert alert = new Alert(Alert.AlertType.NONE, "Please enter different colors for the path and the walls");
                        alert.getDialogPane().getStylesheets().add("Stylesheet.css");
                        ButtonType alertButton = new ButtonType("Ok");
                        alert.getButtonTypes().setAll(alertButton);
                        alert.showAndWait();
                    }
                }
            });

        }
    }
    /*Creates textfields for the user to input the number of rows,columns, and zombies*/
    private void createTextFields(){
        tfNumRows = new TextField("Number of Rows");
        tfNumRows.setOnMouseClicked(event -> {
            tfNumRows.setText("");
        });
        tfNumRows.setLayoutX(195);
        tfNumRows.setLayoutY(400);

        tfNumCols = new TextField("Number of Columns");
        tfNumCols.setOnMouseClicked(event -> {
            tfNumCols.setText("");
        });
        tfNumCols.setLayoutX(395);
        tfNumCols.setLayoutY(400);

        tfNumZombies = new TextField("Number of Zombies");
        tfNumZombies.setOnMouseClicked(event -> {
            tfNumZombies.setText("");
        });
        tfNumZombies.setLayoutX(300);
        tfNumZombies.setLayoutY(480);

            pane.getChildren().addAll(tfNumRows,tfNumCols,tfNumZombies);
    }
    /*Validates that the inputs for the textfields are valid numbers*/
    public boolean validateTextFields(){
        tfRowsEntered = tfNumRows.getText();
        tfColsEntered = tfNumCols.getText();

        for (char c : tfRowsEntered.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        for (char c : tfColsEntered.toCharArray()) {
            if (!Character.isDigit(c)){
                return false;
            }
        }
        if(tfRowsEntered.length()==0||tfColsEntered.length()==0){
            return false;
        }
        inputRows = Integer.parseInt(tfRowsEntered);
        inputCols = Integer.parseInt(tfColsEntered);
        setButtonActions();
        return true;
    }
    /*Validates that the number of zombies entered fits the conditions of the game*/
    private boolean validateZombieNum(){
        tfZombiesEntered = tfNumZombies.getText();

        for (char c : tfZombiesEntered.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        if(tfZombiesEntered.length()==0){
            return false;
        }
        inputZombies = Integer.parseInt(tfZombiesEntered);
        setButtonActions();
        return true;
    }
    /*Validates that the images for the path and the walls uploaded by the user (if any) work properly*/
    private boolean validateWallAndPathImages(){
        if(file!=null && file2!=null){
            return true;
        }
        return false;

    }

}
