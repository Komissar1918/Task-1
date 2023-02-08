package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDaoJDBC = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
        System.out.println("Таблица создана");

    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
        System.out.println("Таблица удалена");

    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name,lastName,age);
        System.out.println("User с именем " + name +" добавлен в базу данных");

    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
        System.out.println("Пользователь с id " + id + " удален");

    }

    public List<User> getAllUsers() {

        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
        System.out.println("Таблица очищена");

    }
}
