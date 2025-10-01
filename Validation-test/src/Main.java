import entity.User;
import exception.ValidationException;

class Main {
    public static void main(String[] args) {
        User user1 = new User("John", "Doe", "johndoe@gmail.com");
        User user2 = new User("Matthew", "Lad", "alice.com");
        User user3 = new User(null,"Jude", "alicejude@gmail.com");
        User user4 = new User("", "", "");

        User[] users = {user1, user2, user3, user4};
        for (User user : users) {
            System.out.println("Validating User ..");
            try {
                Validator.validate(user);
                System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}