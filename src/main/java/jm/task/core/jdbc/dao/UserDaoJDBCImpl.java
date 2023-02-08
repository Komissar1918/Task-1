package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }
    public void createUsersTable() {     //cоздание таблицы
        Statement statement = null;
        String createTableSQL = """
                create table if not exists "User"(
                Id        serial,
                Name      varchar(100) not null,
                LastName  varchar(100),
                Age smallint
                ); """;
        try(Connection connection = Util.getConnectionBD();) {
            statement = connection.createStatement();
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {    //удаление таблицы
        Statement statement = null;
        String deleteTableSQL = """
                drop table "User";""";
        try(Connection connection =Util.getConnectionBD(); ) {
            statement = connection.createStatement();
            statement.execute(deleteTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) { //добавление user в таблицу
        PreparedStatement statement = null;
        String saveUserSQL = """
                insert into "User"(name,lastName,age)
                values(?,?,?);
               """;
        try (Connection connection = Util.getConnectionBD();){
            statement = connection.prepareStatement(saveUserSQL);
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) { //удаление user по id
        PreparedStatement statement = null;
        String deleteUserIdSQL = """
                delete from "User"
                where id = ?;
                """;
        try (Connection connection = Util.getConnectionBD();){
            statement = connection.prepareStatement(deleteUserIdSQL);
            statement.setLong(1,id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<User> getAllUsers() {   //получение всех user из таблицы
        Statement statement = null;
        ArrayList<User>userList = new ArrayList<>();
        String getAllUserSQL = """
                select * 
                from "User"
                """;
        try (Connection connection = Util.getConnectionBD()){
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUserSQL);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {  //очистка таблицы от user
        Statement statement = null;
        String cleanTableSQL = """
                delete from "User"
                """;
        try (Connection connection = Util.getConnectionBD()){
            statement = connection.createStatement();
            statement.execute(cleanTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
