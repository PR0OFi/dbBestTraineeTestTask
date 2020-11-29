package front.application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField fieldFirstParam;

    @FXML
    private TextField secondFieldParam;

    @FXML
    private Button okButton;

    @FXML
    void initialize() {
        assert fieldFirstParam != null : "fx:id=\"fieldFirstParam\" was not injected: check your FXML file 'Window.fxml'.";
        assert secondFieldParam != null : "fx:id=\"secondFieldParam\" was not injected: check your FXML file 'Window.fxml'.";
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'Window.fxml'.";
        okButton.setOnAction(event -> {
            System.out.println("HELLO WORLD");
        });

    }
}
