package domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user")
/**
 * Сущность пользователь.
 */
public class User {
    /**
     * Id пользоватея.
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Имя.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Фамилия.
     */
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    /**
     * Отчетсво.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Дата рождения.
     */
    @Column(name = "birthday")
    private LocalDate birthday;

    /**
     * Логин.
     */
    @Column(name = "login")
    private String login;

    /**
     * Адрес электронной почты.
     */
    @Column(name = "email")
    private String email;

    /**
     * Хэш пароля.
     */
    @Column(name = "password_hash")
    private String passwordHash;

    /**
     * Номер телефона.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Департамент к которму привзян пользователь.
     */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}