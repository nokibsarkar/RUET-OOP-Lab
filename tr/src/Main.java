package src;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    int count = 0;
    Scene loginPage;
    Wordle gameScene;
    private Login loginController;
    Scene getLoginScene(){
        return loginPage;
    }
    Scene getGameScene(){
        return gameScene;
    }
    void constructLoginPage() throws IOException{
        // Create the root
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        // create welcome text
        loginController = (Login) loader.getController();
        loginPage = new Scene(root, 600, 400, Color.LIGHTBLUE);
    }
    private void constructGamePage(){
        // Create the root
        gameScene = new Wordle();
    }
    void construct(){
        try {
            constructLoginPage();
            constructGamePage();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    Image loadIcon(){
        Image icon = new Image("assets/ruet logo.png");
        return icon;
    }
    public void start(Stage stage) {
        construct();
        stage.getIcons().add(loadIcon());
        stage.setScene(getLoginScene());
        stage.setTitle("Login Please");
        stage.setResizable(false);
        // stage.setWidth(800);
        // stage.setHeight(600);
         stage.addEventHandler(KeyEvent.KEY_RELEASED,  e -> {
            // check is it ctrl + c
            if(e.isControlDown() && e.getCode().toString().equals("X")){
                System.exit(0);
            }
        });
        loginController.setupLoginSuccessCallback((Void) -> {
            stage.setScene(getGameScene());
            stage.setTitle("Wordle");
            stage.setResizable(true);
            stage.setWidth(800);
            stage.setHeight(600);
            return null;
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}