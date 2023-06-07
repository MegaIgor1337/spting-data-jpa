package by.itacademy.integration.database.repository;

import by.itacademy.TestApplicationRunner;
import by.itacademy.spring.ApplicationRunner;
import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.repository.CompanyRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Transactional
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
@RequiredArgsConstructor
@Rollback
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final static Integer COMPANY_ID = 1;
    private final CompanyRepository companyRepository;

    @Test
    void findByNameTest() {
        var company = companyRepository.findByName("Google");
        assertTrue(company.isPresent());
        company.ifPresent(c -> assertEquals("Google", c.getName()));
    }

    @Test
    void find() {
        var maybeCompany = companyRepository.findAllByNameContainingIgnoreCase("oo");
        assertFalse(maybeCompany.isEmpty());
        assertThat(maybeCompany.size()).isEqualTo(1);
    }

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
            var company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            assertThat(company.getLocales()).hasSize(2);
        });

    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple1")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
        transactionTemplate.execute(s -> {
            s.setRollbackOnly();
            return null;
        });
    }

    // обновление компанни по id
    @Test
    void update() {
        companyRepository.updateNameById( "Google Corporation", COMPANY_ID);
        var company = companyRepository.findById(COMPANY_ID);
        company.ifPresent(c -> assertEquals("Google Corporation", c.getName()));
    }

    // удалить компании чьи имена начинаются на "А"
    @Test
    void deleteCompanyByFirstLetter() {
        companyRepository.deleteByNameStartingWith("A");
        var companies = companyRepository.findAll();
        assertFalse(companies.isEmpty());
        assertThat(companies).hasSize(2);
    }

}