package by.itacademy.spring.config;

import by.itacademy.spring.database.pool.ConnectionPool;
import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.web.config.WebConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Import(WebConfiguration.class)
@Configuration
public class ApplicationConfiguration {

    @Bean("connectionPool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool connectionPool2() {
        return new ConnectionPool("postgres", "root", 20, "url");
    }

    @Bean("connectionPool3")
    public ConnectionPool connectionPool3() {
        return new ConnectionPool("msql", "root", 1, "url");
    }

    @Bean
    public UserRepository userRepository2(ConnectionPool connectionPool2) {
        return new UserRepository(connectionPool2);
    }

    @Bean
    @Profile("!web")
    public UserRepository userRepository1() {
        return new UserRepository(connectionPool3());
    }
}
