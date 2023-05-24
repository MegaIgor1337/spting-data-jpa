package by.itacademy.spring;

import by.itacademy.spring.config.ApplicationConfiguration;
import by.itacademy.spring.database.repository.CompanyRepository;
import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var companyService = context.getBean("companyService", CompanyService.class);
            var company = companyService.findById(1);
            System.out.println(company);
        }
    }
}
