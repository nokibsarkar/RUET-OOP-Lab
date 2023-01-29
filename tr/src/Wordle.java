package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import java.util.Random;

class WordBox {
    private String[] database;

    Random randomGenerator = new Random();
    private String currentGuess;

    WordBox() {
        File f = new File("src/words.csv");
        // load the words from the file into the database
        Scanner sc;
        try {
            sc = new Scanner(f);
            String line = sc.nextLine();
            database = line.split(",");
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(int i =0; i < database.length; i++){
            database[i] = database[i].toUpperCase();
            chooseRandomWord();
            if(currentGuess.length() < 5){
                System.out.println(currentGuess);
            }
        }
    }

    public void chooseRandomWord() {
        // choose a random word from the database
        int index = randomGenerator.nextInt(database.length);
        currentGuess = database[index].toUpperCase();
    }

    public String getCurrentGuess() {
        return currentGuess;
    }

    public String[] matchGuess(String word, String same, String position, String nonexists) {
        // return an array of colors that match the word
        // same = same letter, different position
        // position = same letter, same position
        // nonexists = letter does not exist in the word

        System.out.println(getCurrentGuess());
        String[] colors = new String[word.length()];
        HashSet<Character> guessed = new HashSet<Character>();
        for (int i = 0; i < currentGuess.length(); i++) {
            guessed.add(currentGuess.charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == currentGuess.charAt(i)) {
                colors[i] = same;
                guessed.remove(word.charAt(i));
            } else if (guessed.contains(word.charAt(i))) {
                colors[i] = position;
                guessed.remove(word.charAt(i));
            } else {
                colors[i] = nonexists;
            }
        }
        return colors;
    }
}

public class Wordle extends Application {
    // private TextField[][] cells;
    private int WORDLENGTH = 5;
    private int CHANCES = 5;
    WordBox wordBox = new WordBox();
    private TextField[] inputCells;
    private GridPane gamePane = new GridPane();
    private VBox verticalBox = new VBox();
    private Font bigFont = new Font(40);
    private Font mediumFont = new Font(20);
    private int currentRow = 0;

    private void showResult(boolean correct) {
        // show the result
        Label result = new Label();
        if (!correct) {
            result.setTextFill(javafx.scene.paint.Color.RED);
            result.setText("You have guessed " + wordBox.getCurrentGuess() + " incorrectly!");
        } else {
            result.setTextFill(javafx.scene.paint.Color.GREEN);
            result.setText("You have guessed " + wordBox.getCurrentGuess() + " correctly!");
        }
        result.setFont(mediumFont);
        result.setAlignment(Pos.CENTER);
        verticalBox.getChildren().add(result);
    }

    private void submit(String word) {
        word = word.toUpperCase();
        String[] colors = wordBox.matchGuess(word, "green", "blue", "red");
        for (int currentColumn = 0; currentColumn < WORDLENGTH; currentColumn++) {
            TextField cell = new TextField();
            cell.setText(word.substring(currentColumn, currentColumn + 1));
            cell.setAlignment(Pos.CENTER);
            cell.setEditable(false);
            //cell.setDisable(true);
            cell.setStyle("-fx-background-color: " + colors[currentColumn] + "; -fx-text-fill: white;");
            // cell.minHeightProperty().bind(cell.minWidthProperty());
            cell.setFont(bigFont);
            GridPane.setConstraints(cell, currentColumn, currentRow);
            gamePane.getChildren().add(cell);
        }
        boolean guessed = word.equals(wordBox.getCurrentGuess());
        if (guessed || currentRow >= CHANCES) {
            // game over
            showResult(guessed);
            return;
        } else {
            currentRow++;
            evacuateCells();
            inputCells[0].requestFocus();
        }
    }

    private void evacuateCells() {
        for (int i = 0; i < WORDLENGTH; i++) {
            inputCells[i].setText("");
        }
    }

    private GridPane generateCells() {
        // add 1x5 textfields
        inputCells = new TextField[WORDLENGTH];
        GridPane h = new GridPane();
        for (int j = 0; j < WORDLENGTH; j++) {
            TextField t = new TextField();
            //t.setPrefColumnCount(1);
            t.setAlignment(Pos.CENTER);
            t.setFont(bigFont);
            t.setOnKeyReleased(e -> {
                int currentIndex = h.getChildren().indexOf(t);
                KeyCode code = e.getCode();
                if (code.isLetterKey()) {
                    // A letter key was pressed
                    t.setText(code.toString());
                    // move to next textfield
                    if (currentIndex == WORDLENGTH - 1) {
                        return;
                    }
                    if (currentIndex < WORDLENGTH - 1) {
                        TextField nextField = (TextField) h.getChildren().get(currentIndex + 1);
                        nextField.requestFocus();
                    }
                } else if (code.equals(KeyCode.SHIFT)) {
                    // do nothing
                } else if (code.equals(KeyCode.BACK_SPACE) || code.equals(KeyCode.DELETE)) {
                    // backspace was pressed
                    if (t.getText().length() == 0) {
                        // move to previous textfield
                        if (currentIndex == 0) {
                            return;
                        }
                        TextField prevField = (TextField) h.getChildren().get(currentIndex - 1);
                        prevField.requestFocus();
                    }
                } else if(code.equals(KeyCode.ENTER)) {
                    if(getCurrentGuess().length() == WORDLENGTH ) {
                        submit(getCurrentGuess());
                        evacuateCells();
                    }
                } 
                else
                    {
                        // Some other key was pressed
                    t.setText("");
                }
            });
            t.minHeightProperty().bind(t.minWidthProperty());
            GridPane.setConstraints(t, j, 0);
            h.getChildren().add(t);
            inputCells[j] = t;
        }
        
        return h;

    }
    private String getCurrentGuess() {
        String word = "";
        for (int i = 0; i < WORDLENGTH; i++) {
            word += ((TextField) inputCells[i]).getText();
        }
        return word;
    }

    public void start(Stage primaryStage) throws Exception {
        GridPane inputs = generateCells();
        verticalBox.getChildren().add(gamePane);
        verticalBox.getChildren().add(inputs);
        
        Scene sc = new Scene(verticalBox, 600, 600);
        primaryStage.setScene(sc);
        gamePane.minWidthProperty().bind(primaryStage.widthProperty());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
