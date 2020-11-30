package back.h2Interaction.connection;

import back.point.Pipeline;

import java.sql.Connection;
import java.util.List;

public class DatabaseActions {
    private final H2Queries h2Queries = new H2Queries();
    private final Connection connection = ConnectionToH2.getConnection();

    public List<Pipeline> getAllPipelines() {
        return h2Queries.readAll(connection);
    }

    public void writeData(List<Pipeline> pipelineList) {
        H2Queries h2Queries = new H2Queries();
        h2Queries.deleteTableIfThisExist(connection);
        h2Queries.createTable(connection);
        h2Queries.writeData(pipelineList, connection);
    }
}