package entity;


import annotations.Email;
import annotations.NotEmpty;
import annotations.NotNull;
import exception.ValidationException;
import validator.Validator;

public class User {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @Email
    private String email;



    public User(String firstName, String lastName, String email) throws ValidationException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        Validator.validate(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + email;
    }
}
