import entity.User;
import exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public void registerUsers(String[]... userData) {
        for (String[] data : userData) {
            createAndAddUser(data[0], data[1], data[2]);
        }
    }

    private void createAndAddUser(String firstName, String lastName, String email) {
        try {
            User user = new User(firstName, lastName, email);
            users.add(user);
            System.out.println("User registered: " + user);
        } catch (ValidationException e) {
            System.out.println("Could not register user: " + e.getMessage());
        }
    }

//    public void printAllUsers() {
//        System.out.println("\nRegistered Users:");
//        if (users.isEmpty()) {
//            System.out.println("No valid users found.");
//            return;
//        }
//        users.forEach(System.out::println);
//    }
}