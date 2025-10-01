import entity.User;
import exception.ValidationException;
import validator.Validator;

class Main {
    public static void main(String[] args) {
        User[] users = {
                createUser("John", "Doe", "johndoe@gmail.com"),
                createUser("Matthew", "Lad", "alice.com"),
                createUser(null, "Jude", "alicejude@gmail.com"),
                createUser("Seth", "", "")
        };

        for (User user : users) {
            if (user != null) {
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
            }
            System.out.println();
        }
    }

    private static User createUser(String firstName, String lastName, String email) {
        System.out.println("Validating User ..");
        try {
            User user = new User(firstName, lastName, email);
            System.out.println("Validation successful!");
            return user;
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}