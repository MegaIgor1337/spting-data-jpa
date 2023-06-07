package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.entity.User;
import by.itacademy.spring.dto.IPersonalInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   // List<PersonalInfo> findAllByCompanyId(Integer companyId);
   // <T> List<T> findAllByCompanyId(Integer id, Class<T> clazz);
 @Query(value = "SELECT firstname," +
                "lastname, " +
                "birth_date birthDate " +
                "FROM users " +
                "WHERE company_id = :companyId", nativeQuery = true)
   List<IPersonalInfo> findAllByCompanyId(Integer companyId);
    @Query(value = "SELECT u.* FROM users u " +
                   " WHERE u.firstname = :username",
    nativeQuery = true)
    List<User> findAllByUsername(String username);


    @Query("select u from User u " +
           "where u.firstname like %:firstname% and u.lastname like %:lastname% ")
    List<User> findByAll(String firstname, String lastname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
           " where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    List<User> findFirst3ByOrderByIdDesc();

    List<User> findFirst3By(Sort sort);
    //List<User> findAllBy(Pageable pageable);
    Page<User> findAllBy(Pageable pageable);

    // выбрать первыз четырёх пользователей
    List<User> findFirst4ByOrderById();

    // выбрать первыз четырёх пользователей по сортировке
    List<User> findFirst4By(Sort sort);

    Page<User> findAllByRole(Role role, Pageable pageable);


    // найти по роли и дате рождения
    List<User> findByRoleAndBirthDateBetween(Role role, LocalDate startDate, LocalDate endDate);


}


