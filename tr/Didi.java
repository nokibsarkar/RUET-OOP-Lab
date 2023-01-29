import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Didi extends Application {
    private Stage primaryStage;
    private Scene loginScene;
    private Scene welcomeScene;

    public Scene generateLoginScene() {
        Group y = new Group();
        Scene loginScene = new Scene(y, Color.BLUE);
        Button btn = new Button("Submit");

        TextField usernameInputField = new TextField();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String username = usernameInputField.getText();
                if(username.equals("ruit"))
                    primaryStage.setScene(welcomeScene);
                    
            }
        });
        btn.setTextFill(Color.RED);
        y.getChildren().add(btn);
        btn.setLayoutX(200);
        y.getChildren().add(usernameInputField);
        return loginScene;
    };

    public Scene generateWelcomeScene() {
        Group r = new Group();
        Label welcomeText = new Label("Welcome");
        Label hati = new Label("Welcome to this world");

        welcomeText.setTextFill(Color.WHITE);
        // welcomeText.setText("Me");
        r.getChildren().add(welcomeText);
        r.getChildren().add(hati);
        Scene welcomeScene = new Scene(r, Color.GREEN);
        Button b = new Button("Login");
        r.getChildren().add(b);

        b.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(loginScene);
            }
        });
        // b.setText("dgsuus");

        return welcomeScene;
    };

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.welcomeScene = generateWelcomeScene();
        this.loginScene = generateLoginScene();
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("MY PROJECT");

        primaryStage.setHeight(600);
        primaryStage.setWidth(400);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
