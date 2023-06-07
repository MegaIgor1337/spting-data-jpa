package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c " +
           "join fetch c.locales c1 " +
           "where c.name = :name2")
    Optional<Company> findByName(@Param("name2") String name);
    List<Company> findAllByNameContainingIgnoreCase(String fragment);

    // обновление компанни по id
    @Modifying(clearAutomatically = true)
    @Query("update Company c " +
           "set c.name = :name " +
           "where c.id = :id")
    Integer updateNameById(String name, Integer id);

    // удалить компании чьи имена начинаются на определённую букву
    void deleteByNameStartingWith(String prefix);
}
