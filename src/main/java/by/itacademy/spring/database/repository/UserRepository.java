package by.itacademy.spring.database.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;

import java.util.List;
import java.util.Map;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRepository {
    private String username;
    private String url;

    @PostConstruct
    private void init() {
        System.out.println("init repo");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("destroy repo");
    }

    private Integer poolSize;
    private List<Object> args;
    private Map<String, Object> properties;
}
