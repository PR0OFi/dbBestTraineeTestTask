package back.h2Interaction.connection;

import back.point.Pipeline;

import java.util.List;

public class Procedure {
    public List<Pipeline> processingToGiveAllUsers(List<Pipeline> pipelineList) {
        ConnectionToH2 connection = new ConnectionToH2();
        H2Actions h2Actions = new H2Actions();
        h2Actions.deleteTableIfThisExist(connection.getConnection());
        h2Actions.createTable(connection.getConnection());
        h2Actions.createLine(pipelineList, connection.getConnection());
        return h2Actions.readAll(connection.getConnection());
    }
}
