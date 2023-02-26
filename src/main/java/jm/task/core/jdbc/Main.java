package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ban", (byte) 20);
        userService.saveUser("Ban", "Black", (byte) 22);
        userService.saveUser("Kiriko", "Thum", (byte) 23);
        userService.saveUser("Clown", "Closs", (byte) 21);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
