package back.h2Interaction.connection;

import back.h2Interaction.queries.Queries;
import back.point.Pipeline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class H2Actions {
    public java.sql.Connection connection;

    public void connectToDb() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTableIfThisExist(java.sql.Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.DROP_TABLE_IF_THIS_EXIST);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(java.sql.Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.CREATE_DATA_BASE);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createLine(List<Pipeline> data, java.sql.Connection connection) {
        for (Pipeline p : data) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Queries.CREATE_PIPELINE);
                preparedStatement.setInt(1, p.getStartId());
                preparedStatement.setInt(2, p.getEndpointId());
                preparedStatement.setInt(3, p.getLength());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Pipeline> readAll(java.sql.Connection connection) {
        try {
            List<Pipeline> pipelines = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pipeline pipeline = new Pipeline(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
                pipelines.add(pipeline);
            }
            return pipelines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
