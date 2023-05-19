package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.pool.ConnectionPool;
import lombok.*;
import org.springframework.stereotype.Repository;


@Repository
@ToString
public class UserRepository {

    public UserRepository(ConnectionPool connectionPool2) {
    }
}
