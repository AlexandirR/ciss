package domain.participant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "participant_role")
/**
 * Роль участника.
 */
public class ParticipantRole {

    /**
     * Id роли участника.
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Название роли участника.
     */
    @Column(name = "name", nullable = false)
    private String name;
}