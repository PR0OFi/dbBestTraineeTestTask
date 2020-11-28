package h2Interaction.connection;


import parser.CSVtoPipelineObject;


public class TestConnection {
    public static void main(String[] args) {
        H2Actions connection = new H2Actions();
        connection.connectToDb();
        connection.deleteTableIfThisExist(connection.connection);
        connection.createTable(connection.connection);
        connection.createLine(CSVtoPipelineObject.readPipelinesFromCSV("D:\\Projects\\demo\\dbBestTraineeTestTask\\src\\main\\resources\\Data.csv")
                , connection.connection);
    }

}