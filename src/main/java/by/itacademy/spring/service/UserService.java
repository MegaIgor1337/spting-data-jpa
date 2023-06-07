package by.itacademy.spring.service;

import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.dto.UserReadDto;
import by.itacademy.spring.mapper.CreateUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CreateUserMapper createUserMapper;

    public Optional<UserReadDto> findById() {
        return Optional.empty();
    }

    public List<UserReadDto> findAll() {
        return Collections.emptyList();
    }

    public void update(UserReadDto userReadDto) {

    }

    public void delete(UserReadDto userReadDto) {

    }

    public void save(UserReadDto userReadDto) {

    }
}
