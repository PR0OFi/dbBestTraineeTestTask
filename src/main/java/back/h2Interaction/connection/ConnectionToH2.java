package back.h2Interaction.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToH2 {
    private static Connection connection;

    private ConnectionToH2() {
    }

    public static Connection connectToDb() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            return connection;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else return connectToDb();
    }
}
