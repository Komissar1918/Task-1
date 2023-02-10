package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sessionFactory;

    public static Connection getConnectionBD() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/LessonJDBC", "postgres", "Rammstein2012");
    }

    public static SessionFactory getHBconnection() {
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "org.postgresql.Driver");
                setting.put(Environment.URL,"jdbc:postgresql://localhost:5432/LessonHibernate");
                setting.put(Environment.USER, "postgres");
                setting.put(Environment.PASS,"Rammstein2012");
                setting.put(Environment.SHOW_SQL, "true");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //setting.put(Environment.HBM2DDL_AUTO,"none");
                configuration.addProperties(setting);
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
