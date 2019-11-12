package nazarii.tkachuk.com.providers;

import java.sql.*;
import java.sql.DriverManager;

public class JdbcWorkProvider {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_USER = PropertiesProvider.getProperty("db.user");
    private static final String DB_PASSWORD = PropertiesProvider.getProperty("db.password");
    private static final String URL = "jdbc:mysql://localhost:3306/drugstoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    static Connection connection = null;

    private static PreparedStatement preparedStatement = null;

    private static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStation(String sql) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static void UUUU(String sql){
        getPreparedStation(sql);

    }
}
