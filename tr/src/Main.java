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
    Scene getLoginScene(){
        return loginPage;
    }
    void constructLoginPage() throws IOException{
        // Create the root
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        // create welcome text
        
        loginPage = new Scene(root,600, 400, Color.LIGHTBLUE);
    }
    void construct(){
        try {
            constructLoginPage();
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
        stage.addEventHandler(KeyEvent.KEY_RELEASED,  e -> {
            // check is it ctrl + c
            if(e.isControlDown() && e.getCode().toString().equals("X")){
                System.exit(0);
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}