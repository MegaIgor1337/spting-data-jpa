package by.itacademy.spring.dto;

import by.itacademy.spring.database.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    CompanyReadDto company;
}
