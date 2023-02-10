package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Йосыф","Ахметов", (byte) 31);
        userService.saveUser("Ольга", "Ахметова", (byte) 34);
        userService.saveUser("Александр","Беланов", (byte) 32);
        userService.saveUser("Данил","Хайрутдинов", (byte) 30);
        userService.removeUserById(2);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
