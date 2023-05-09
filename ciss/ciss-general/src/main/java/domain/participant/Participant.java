package domain.participant;

import domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/**
 * Абстрактный класс участника процесса. Является общим описанием пользователя в рамках процесса по заявке.
 */
public abstract class Participant {

    /**
     * Id участника.
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Пользователь от которого создан участник.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Роль участинка.
     */
    @ManyToOne
    @JoinColumn(name = "role_id")
    private ParticipantRole role;
}