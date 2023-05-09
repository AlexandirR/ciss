package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

/**
 * Сервис работы с пользователем.
 */
@Service
public class UserService {

    /**
     * Репозитроий пользователя.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Добавлние нового юзера.
     * @param user пользователь которого гужно добавить.
     * @return Добавленный пользователь.
     */
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Проверка существования пользователя с логином.
     * @param login логин.
     * @return результат проверки.
     */
    public Boolean existByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    /**
     * Проверка существования пользователя по id.
     * @param id id
     * @return Проверка существования
     */
    public Boolean existById(String id) {
        return userRepository.existsById(id);
    }

    /**
     * Нахождение пользователя по id.
     * @param id id
     * @return Найденный пользователь
     */
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
