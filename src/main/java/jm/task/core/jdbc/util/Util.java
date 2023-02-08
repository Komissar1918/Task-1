package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util  {
    // реализуйте настройку соеденения с БД

    public static Connection getConnectionBD() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/LessonJDBC","postgres", "Rammstein2012");
    }
}
