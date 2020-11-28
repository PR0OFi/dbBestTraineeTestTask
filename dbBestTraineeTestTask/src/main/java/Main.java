import javafx.application.Application;

import javafx.scene.Group;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application{
    public static void main(String[] args) {
        Application.launch();
      /*  Connection connection = new Connection();
        connection.connectToDb();
        connection.closeConnection();*/
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world Application");

/*        InputStream iconStream = getClass().getResourceAsStream("/icon.png");
        Image image = new Image(iconStream);
        stage.getIcons().add(image);*/

        Label helloWorldLabel = new Label("Hello world!");
        helloWorldLabel.setAlignment(Label.CENTER);
        Label label = new Label("TORAS nyhal HUI SOBAKI");
        Group group = new Group();
        /*FlowPane root = new FlowPane(label, group);       // корневой узел
        Scene scene = new Scene(root, 300, 150);        // создание Scene
        stage.setScene(scene);      */                    // установка Scene для Stage


        stage.show();
    }
}
