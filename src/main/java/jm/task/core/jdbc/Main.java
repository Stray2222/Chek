package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        User user1 = new User("MAN", "LISENT", (byte) 12);
        User user2 = new User("WUMAN", "LIST", (byte) 14);
        User user3 = new User("GIRL", "FEAR", (byte) 88);
        User user4 = new User("BOY", "MERKOVICH", (byte) 67);

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем - " + user.getName() + " добавлен в базу данных");
        }

        List<User> userList = userService.getAllUsers();

        System.out.println("All users: " + userList);


        userService.cleanUsersTable();
        userService.dropUsersTable();
        getSessionFactory().close();


    }
}
