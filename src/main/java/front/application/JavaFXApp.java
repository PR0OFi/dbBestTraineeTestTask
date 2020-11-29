package front.application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFXApp extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group parent= new Group();
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
}
