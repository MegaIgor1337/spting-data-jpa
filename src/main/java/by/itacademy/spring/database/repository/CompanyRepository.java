package by.itacademy.spring.database.repository;

import by.itacademy.spring.bpp.InjectBean;
import by.itacademy.spring.database.pool.ConnectionPool;
import lombok.ToString;

@ToString
public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;
}
