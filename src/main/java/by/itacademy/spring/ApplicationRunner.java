package by.itacademy.spring;

import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.dto.CreateUserDto;
import by.itacademy.spring.mapper.CreateUserMapper;
import by.itacademy.spring.service.UserService;

public class ApplicationRunner {
    public static void main(String[] args) {
        var userRepository = new UserRepository();
        var createUserDto = new CreateUserDto();
        var createUserMapper = new CreateUserMapper(createUserDto);
        var userService = new UserService(userRepository, createUserMapper);
    }
}
