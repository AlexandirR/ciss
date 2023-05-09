package dto;

import domain.Department;
import domain.User;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final LocalDate birthday;
    private final String login;
    private final String passwordHash;
    //private final Department department;
}