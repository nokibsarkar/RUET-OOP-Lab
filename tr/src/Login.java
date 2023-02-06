package src;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class Login {
    String instructMessage = "Please enter your username and password";
    String successMessage = "Login successful";
    String failMessage = "Login failed";
    private Callback<Void, Void> loginSuccessCallback = null;
    void setupLoginSuccessCallback(Callback<Void, Void> callback){
        loginSuccessCallback = callback;
    }
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button resetButton;
    @FXML
    private Text messageText;
    @FXML
    void login(Event e){
        if(e.getEventType().toString().equals("MOUSE_CLICKED"))
            login();
        else if(e.getEventType().toString().equals("KEY_RELEASED") && ((KeyEvent) e).getCode().toString().equals("ENTER")){
            login();
        }
    }
    void login(){
        String username = usernameField.getText();
        String password = passwordField.getText();
        messageText.setText("Logging in...");
        if(username.equals("admin") && password.equals("admin")){
            messageText.setText(successMessage);
        }else{
            messageText.setText(failMessage);
        }
        if(loginSuccessCallback != null)
            loginSuccessCallback.call(null);
    }
    @FXML
    void reset(Event e){
        if(e.getEventType().toString().equals("MOUSE_CLICKED")){
            System.out.println("reset");
            reset();
        } else if(e.getEventType().toString().equals("KEY_RELEASED")){
            KeyEvent keyEvent = (KeyEvent) e;
            if(keyEvent.getCode().toString().equals("ENTER")){
                reset();
            }
        }
    }
    void reset(){
        usernameField.setText("");
        passwordField.setText("");
        messageText.setText(instructMessage);
    }
    @FXML
    void checkDisable(){
        boolean disabled = usernameField.getText().equals("") || passwordField.getText().equals("");
        loginButton.setDisable(disabled);
    }
}
