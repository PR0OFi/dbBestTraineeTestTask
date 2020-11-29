package back.h2Interaction.connection;


import back.parser.CSVtoPipelineObject;
import back.point.Pipeline;

import java.util.List;


public class TestConnection {
    public static void main(String[] args) {
        H2Actions connection = new H2Actions();
        connection.connectToDb();
        connection.deleteTableIfThisExist(connection.connection);
        connection.createTable(connection.connection);
        connection.createLine(CSVtoPipelineObject.readPipelinesFromCSV("D:\\Projects\\demo\\dbBestTraineeTestTask\\src\\main\\resources\\Data.csv")
                , connection.connection);
        List<Pipeline> l = connection.readAll(connection.connection);
        for (Pipeline p: l
             ) {
            System.out.println(p);
        }
    }

}