package by.itacademy.integration.database.repository;


import by.itacademy.annotation.IT;
import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.dto.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@IT
@RequiredArgsConstructor
@Rollback
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkProjections() {
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
    }

    @Test
    void findByNames() {
        var user = userRepository.findByAll("a", "a");
        assertFalse(user.isEmpty());
    }

    @Test
    void updateRole() {
        var admin = userRepository.findById(1L);
        assertEquals(Role.ADMIN, admin.get().getRole());
        int count = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, count);

    }

    @Test
    void testFind3FirstByOrderByIdDesc() {
        var users = userRepository.findFirst3ByOrderByIdDesc();
        assertFalse(users.isEmpty());
        assertEquals(3, users.size());
    }

    @Test
    void testFind3By() {
        var users = userRepository.findFirst3By(
                Sort.by("firstname").and(Sort.by("lastname")).descending());
        assertFalse(users.isEmpty());
        assertEquals(3, users.size());
    }

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(u -> System.out.println(u.getId()));
        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(u -> System.out.println(u.getId()));
        }
    }

    // выбрать первыз четырёх пользователей
    @Test
    void findFirst4() {
        var users = userRepository.findFirst4ByOrderById();
        assertFalse(users.isEmpty());
        assertEquals(4, users.size());
        assertEquals("Vlad", users.get(3).getFirstname());
    }


    // тест на сортировку по дате рождения и фио
    @Test
    void findBySortByBdAndFio() {
        var users = userRepository.findFirst4By(
                Sort.by("birthDate")
                        .and(Sort.by("firstname")
                                .and(Sort.by("lastname"))));
        assertFalse(users.isEmpty());
        assertEquals(4, users.size());
    }

    // тест на сортировку по дате рождения
    @Test
    void findBySortBd() {
        var users = userRepository.findFirst4By(Sort.by("birthDate"));
        assertFalse(users.isEmpty());
        assertEquals(4, users.size());
        assertThat(users.get(0).getFirstname()).isEqualTo("Vlad");
    }


    @Test
    void findAllBySortAndPage1() {
        var pageable = PageRequest.of(0, 2, Sort.by("firstname")
                .and(Sort.by("lastname")));
        var users = userRepository.findAllByRole(Role.USER, pageable);
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(2);

    }

    @Test
    void findAllBySortAndPage2() {
        var pageable = PageRequest.of(2, 2, Sort.by("username"));
        var users = userRepository.findAllByRole(Role.USER, pageable);
        assertTrue(users.isEmpty());

    }

    @Test
    void findAllBySortAndPage3() {
        var pageable = PageRequest.of(0, 3, Sort.by("username"));
        var users = userRepository.findAllByRole(Role.ADMIN, pageable);
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(2);
        assertThat(users.get().toList().get(0).getUsername()).isEqualTo("ivan@gmail.com");
    }


    // поиск админов, родившихся между 1980 и 1990
    @Test
    void findByRoleAndBd() {
        var users = userRepository.findByRoleAndBirthDateBetween(Role.ADMIN,
                LocalDate.of(1980, 1, 1),
                LocalDate.of(1990, 1, 1));
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getFirstname()).isEqualTo("Kate");
    }




}
