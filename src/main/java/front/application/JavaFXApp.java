package front.application;

import back.h2Interaction.connection.DatabaseReader;
import back.h2Interaction.queries.Constants;
import back.parser.PipelineMapper;
import back.point.Pipeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;


public class JavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/app.fxml"));
        Parent content = loader.load();
        primaryStage.setTitle("Pipeline route");
        primaryStage.setScene(new Scene(content, 700, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void initialize() {
        PipelineMapper pipelineMapper = new PipelineMapper();
        List<Pipeline> dataFromFile = pipelineMapper.readPipelinesFromCSV(Constants.FILE_PATH);
        DatabaseReader databaseReader = new DatabaseReader();
        databaseReader.writeData(dataFromFile);

    }


}
