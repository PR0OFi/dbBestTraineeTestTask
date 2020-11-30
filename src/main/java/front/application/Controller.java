package front.application;

import back.MakeAction;
import back.h2Interaction.connection.DatabaseActions;
import back.h2Interaction.queries.Constants;
import back.parser.PipelineMapper;
import back.point.Pipeline;
import back.point.SearchingPoints;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;


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
    private Button update_data;

    @FXML
    void initialize() {
        MakeAction makeAction = new MakeAction();
        okButton.setOnAction(event -> {
            outputField.setText(makeAction.search(createSearchPipeline()));
        });

        update_data.setOnAction(actionEvent -> writeToDatabase());
    }

    private SearchingPoints createSearchPipeline() {
        int startCoordinate = Integer.parseInt(fieldFirstParam.getText());
        int finishCoordinate = Integer.parseInt(secondFieldParam.getText());
        return new SearchingPoints(startCoordinate, finishCoordinate);
    }

    public void writeToDatabase() {
        PipelineMapper pipelineMapper = new PipelineMapper();
        List<Pipeline> dataFromFile = pipelineMapper.readPipelinesFromCSV(Constants.FILE_PATH);
        DatabaseActions databaseActions = new DatabaseActions();
        databaseActions.writeData(dataFromFile);
    }


}
