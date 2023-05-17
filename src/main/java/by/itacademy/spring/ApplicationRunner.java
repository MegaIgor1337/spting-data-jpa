package by.itacademy.spring;

import by.itacademy.spring.database.repository.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {

            var userRepository = context.getBean("r3", UserRepository.class);
            System.out.println(userRepository);
        }

    }
}
