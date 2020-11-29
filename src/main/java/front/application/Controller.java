package front.application;

import back.LaunchBack;
import back.point.SearchingPoints;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField fieldFirstParam;

    @FXML
    private TextField secondFieldParam;

    @FXML
    private Button okButton;

    @FXML
    private TextField outputField;

    @FXML
    void initialize() {
        LaunchBack launchBack = new LaunchBack();
        okButton.setOnAction(event -> {
            outputField.setText(launchBack.search(createSearchPipeline()));
        });
    }

    private SearchingPoints createSearchPipeline() {
        int startCoordinate = Integer.parseInt(fieldFirstParam.getText());
        int finishCoordinate = Integer.parseInt(secondFieldParam.getText());
        return new SearchingPoints(startCoordinate, finishCoordinate);
    }


}
