package controller;

import domain.User;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.mappers.UserMapper;

/**
 * Класс контроллера для работы с пользователем.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("home/user")
public class UserController {

    /**
     * Сервис для обработки юзера.
     */
    @Autowired
    private UserService userService;

    /**
     * Маппер ДТО для юзера.
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * Создание нового пользователя.
     * @param userDto ДТО с полями юзера.
     * @return Ответ либо об успешном создании, либо о ошибке дублирования пользователя.
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        if(userService.existByLogin(userDto.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: user with login " + userDto.getLogin() + " is exist");
        }
        User user = userMapper.toEntity(userDto);
        userService.addUser(user);
        return ResponseEntity.ok().body("User create successfully.");
    }

    /**
     * Метод полученя пользователя по id.
     * @param id id пользователя.
     * @return Возвращается либо найденный пользователь, либо ошибка о его не существовании.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        if (userService.existById(id)) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: user with id " + id + " not exist");
        }
        return ResponseEntity.ok().body(userService.findById(id));
    }

    /**
     * Метод удаления пользователя по id.
     * @param id id пользователя.
     * @return Возвращение сообщения о результате удаления.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable String id) {
        if (userService.existById(id)) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: user with id " + id + " not exist");
        }
        userService.deleteById(id);
        return ResponseEntity.ok().body("User deleted successfully!");
    }
}
