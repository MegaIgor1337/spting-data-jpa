package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.pool.ConnectionPool;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Getter
@ToString
public class CompanyRepository {

    private ConnectionPool connectionPool3;
    private Integer poolSize;
    private List<ConnectionPool> pools;
    private String driver;

    public CompanyRepository(@Qualifier("connectionPool2") ConnectionPool connectionPool3,
                             @Value("${db.pool.size}") Integer poolSize,
                             List<ConnectionPool> pools,
                             @Value("${db.driver}") String driver) {
        this.connectionPool3 = connectionPool3;
        this.poolSize = poolSize;
        this.pools = pools;
        this.driver = driver;
    }

    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }
}
