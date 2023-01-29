import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
public class Test extends Application{

    public void start(Stage primaryStage){
        Group root = new Group();
        Scene welcome = new Scene(root);
        welcome.setFill(Color.BLUE);
        //primaryStage.setScene(welcome);
        
        primaryStage.setTitle("MY PROJECT");
        Scene logIn = new Scene(root);
        primaryStage.setScene(logIn);
        primaryStage.show();

    }
  public static void main(String[] cms){
    launch();
  }  

    
}
