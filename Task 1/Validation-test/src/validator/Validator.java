package validator;

import annotations.Email;
import annotations.NotEmpty;
import annotations.NotNull;
import exception.ValidationException;

import java.lang.reflect.Field;

public class Validator {

    public static void validate(Object object) throws ValidationException {
        Class<?> c = object.getClass();

        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);

                // @NotNull check
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (value == null) {
                        String message = field.getAnnotation(NotNull.class).message();
                        throw new ValidationException(field.getName(), message);
                    }
                }

                // @NotEmpty check
                if (field.isAnnotationPresent(NotEmpty.class)) {
                    if (value == null || value.toString().trim().isEmpty()) {
                        String message = field.getAnnotation(NotEmpty.class).message();
                        throw new ValidationException(field.getName(), message);
                    }
                }

                // @Email check
                if (field.isAnnotationPresent(Email.class)) {
                    String email = value == null ? "" : value.toString(); //ternary operator
                    if (!email.contains("@") || !email.contains(".")) {
                        String message = field.getAnnotation(Email.class).message();
                        throw new ValidationException(field.getName(), message);
                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to access field " + field.getName(), e);
            }
        }
    }
}
