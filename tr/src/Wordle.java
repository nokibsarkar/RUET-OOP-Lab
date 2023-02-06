package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import java.util.Random;

class WordBox {
    private String[] database;

    private Random randomGenerator = new Random();
    private String currentGuess;

    WordBox() {
        File f = new File("src/words.csv");
        // load the words from the file into the database
        Scanner sc;
        try {
            sc = new Scanner(f);
            String line = sc.nextLine();
            database = line.split(",");
            //System.out.println(database);
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        chooseRandomWord();
    }

    public void chooseRandomWord() {
        // choose a random word from the database
        int index = randomGenerator.nextInt(database.length);
        currentGuess =  database[index].toUpperCase();
    }

    public String getCurrentGuess() {
        return currentGuess;
    }

    public String[] matchGuess(String word, String same, String position, String nonexists) {
        // return an array of colors that match the word
        // same = same letter, different position
        // position = same letter, same position
        // nonexists = letter does not exist in the word
        System.out.println("Current guess: " + currentGuess);
        System.out.println("Word: " + word);
        String[] colors = new String[word.length()];
        ArrayList<Character> guessed = new ArrayList<Character>();
        for (int i = 0; i < currentGuess.length(); i++) {
            guessed.add((Character )currentGuess.charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            char curchar = word.charAt(i);
            if (curchar == currentGuess.charAt(i)) {
                colors[i] = same;
                guessed.remove((Character) curchar);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            char curchar = word.charAt(i);
            if (curchar == currentGuess.charAt(i)) {
               
            } else if (guessed.contains(curchar)) {
                colors[i] = position;
                guessed.remove((Character) curchar);
            } else {
                colors[i] = nonexists;
            }
        }
        return colors;
    }
}

public class Wordle extends Scene {
    // private TextField[][] cells;
    private int WORDLENGTH = 5;
    private int CHANCES = 5;
    WordBox wordBox = new WordBox();
    private TextField[] inputCells;
    private GridPane gamePane = new GridPane();
    private VBox verticalBox = new VBox();
    private Font bigFont = new Font(20);
    private Font mediumFont = new Font(20);
    private int currentRow = 0;
    private GridPane inputPane = new GridPane();
    private Button restartButton = new Button("Restart");
    private Label result = new Label();
    private void showResult(boolean correct) {
        inputPane.setVisible(false);
        result.setVisible(true);
        restartButton.setVisible(true);
        // show the result
        if (!correct) {
            result.setTextFill(javafx.scene.paint.Color.RED);
            result.setText("You have guessed " + wordBox.getCurrentGuess() + " incorrectly!");
        } else {
            result.setTextFill(javafx.scene.paint.Color.GREEN);
            result.setText("You have guessed " + wordBox.getCurrentGuess() + " correctly!");
        }
        result.setFont(mediumFont);
        result.setAlignment(Pos.CENTER);
        restartButton.setOnAction(e -> {
            restart();
            restartButton.setVisible(false);
            result.setVisible(false);
        });
        restartButton.setVisible(true);
    }

    private void submit(String word) {
        word = word.toUpperCase();
        String[] colors = wordBox.matchGuess(word, "green", "blue", "red");
        for (int currentColumn = 0; currentColumn < WORDLENGTH; currentColumn++) {
            TextField cell = new TextField();
            cell.setText(word.substring(currentColumn, currentColumn + 1));
            cell.setAlignment(Pos.CENTER);
            cell.setEditable(false);
            // cell.setDisable(true);
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

    private GridPane generateInputPane() {
        // add 1x5 textfields
        inputCells = new TextField[WORDLENGTH];
        
        for (int j = 0; j < WORDLENGTH; j++) {
            TextField t = new TextField();
            // t.setPrefColumnCount(1);
            t.setAlignment(Pos.CENTER);
            t.setFont(bigFont);
            t.setOnKeyReleased(e -> {
                int currentIndex = inputPane.getChildren().indexOf(t);
                KeyCode code = e.getCode();
                if (code.isLetterKey()) {
                    // A letter key was pressed
                    t.setText(code.toString());
                    // move to next textfield
                    if (currentIndex == WORDLENGTH - 1) {
                        return;
                    }
                    if (currentIndex < WORDLENGTH - 1) {
                        TextField nextField = (TextField) inputPane.getChildren().get(currentIndex + 1);
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
                        TextField prevField = (TextField) inputPane.getChildren().get(currentIndex - 1);
                        prevField.requestFocus();
                    }
                } else if (code.equals(KeyCode.ENTER)) {
                    if (getCurrentGuess().length() == WORDLENGTH) {
                        submit(getCurrentGuess());
                        evacuateCells();
                    }
                } else {
                    // Some other key was pressed
                    t.setText("");
                }
            });
            t.minHeightProperty().bind(t.minWidthProperty());
            GridPane.setConstraints(t, j, 0);
            inputPane.getChildren().add(t);
            inputCells[j] = t;
        }

        return inputPane;

    }
    private void restart(){
        currentRow = 0;
        gamePane.getChildren().clear();
        evacuateCells();
        inputPane.setVisible(true);
        gamePane.setVisible(true);
        inputCells[0].requestFocus();
        wordBox.chooseRandomWord();
    }
    private String getCurrentGuess() {
        String word = "";
        for (int i = 0; i < WORDLENGTH; i++) {
            word += ((TextField) inputCells[i]).getText();
        }
        return word;
    }

    Wordle(){
        super(new VBox());
        GridPane inputs = generateInputPane();
        verticalBox.getChildren().add(gamePane);
        verticalBox.getChildren().add(inputs);
        restartButton.setFont(mediumFont);
        restartButton.setVisible(false);
        verticalBox.getChildren().add(restartButton);
        result.setVisible(false);
        verticalBox.getChildren().add(result);
        this.setRoot(verticalBox);
    }
   
}
