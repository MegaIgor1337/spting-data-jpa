package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.pool.ConnectionPool;
import jakarta.annotation.Resource;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@ToString
public class CompanyRepository {
    private ConnectionPool connectionPool1;

    @Autowired
    private List<ConnectionPool> pools;
}
