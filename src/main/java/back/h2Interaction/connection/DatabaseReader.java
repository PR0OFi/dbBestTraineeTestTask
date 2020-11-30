package back.h2Interaction.connection;

import back.point.Pipeline;

import java.sql.Connection;
import java.util.List;

public class DatabaseReader {
    private final H2Actions h2Actions = new H2Actions();
    private final Connection connection = ConnectionToH2.getConnection();

    public List<Pipeline> getAllPipelines() {
        return h2Actions.readAll(connection);
    }

    public void writeData(List<Pipeline> pipelineList) {
        H2Actions h2Actions = new H2Actions();
        h2Actions.deleteTableIfThisExist(connection);
        h2Actions.createTable(connection);
        h2Actions.writeData(pipelineList, connection);
    }
}