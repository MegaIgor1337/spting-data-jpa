package by.itacademy.spring.database.pool;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ConnectionPool {
    private String username;
    private String password;
    private Integer poolSize;
    private String url;

    @PostConstruct
    private void init() {
        System.out.println("Init pool");
    }

    private void destroy() {
        System.out.println("destroy pool");
    }
}
