package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.pool.ConnectionPool;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ToString
public class CompanyRepository {

    private ConnectionPool connectionPool3;
    private Integer poolSize;
    private List<ConnectionPool> pools;

    public CompanyRepository(@Qualifier("connectionPool2") ConnectionPool connectionPool3,
                             @Value("${db.pool.size}") Integer poolSize,
                             List<ConnectionPool> pools) {
        this.connectionPool3 = connectionPool3;
        this.poolSize = poolSize;
        this.pools = pools;
    }
}
