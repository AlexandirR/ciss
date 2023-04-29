package repository;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Репозиторий для обращения к бд пользователей.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * ПОлучение пользователя по логину.
     * @param login логин
     * @return Найденный пользователь
     */
    Optional<User> findByLogin(String login);

    /**
     * Проверка существлвания пользователя с логином.
     * @param login логин
     * @return Результат проверки
     */
    Boolean existsByLogin(String login);
}
