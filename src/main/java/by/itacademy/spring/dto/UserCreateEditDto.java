package by.itacademy.spring.dto;

import by.itacademy.spring.database.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    Integer companyId;
}
