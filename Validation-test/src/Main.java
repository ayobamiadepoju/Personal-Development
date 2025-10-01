import entity.User;
import exception.ValidationException;

class Main {
    public static void main(String[] args) {
        User user1 = new User("John", "Doe", "johndoe@gmail.com");
        User user2 = new User("Matthew", "Lad", "alice.com");
        User user3 = new User("Alice","Jude", "alicejude@gmail.com");
        User user4 = new User("", "", "");

        try{
            Validator.validate(user1);
            System.out.println(user1.getFirstName() + " " + user1.getLastName() + " " + user1.getEmail());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            Validator.validate(user2);
            System.out.println(user2.getFirstName() + " " + user2.getLastName() + " " + user2.getEmail());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            Validator.validate(user3);
            System.out.println(user3.getFirstName() + " " + user3.getLastName() + " " + user3.getEmail());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            Validator.validate(user4);
            System.out.println(user4.getFirstName() + " " + user4.getLastName() + " " + user4.getEmail());
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}