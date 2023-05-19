package by.itacademy.spring.mapper;

import by.itacademy.spring.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserMapper {
    private final CreateUserDto createUserDto;
}
