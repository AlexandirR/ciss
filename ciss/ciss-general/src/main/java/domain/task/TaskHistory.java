package domain.task;

import domain.participant.Participant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "task_history")
/**
 * История состояния заявки.
 */
public class TaskHistory {
    /**
     * Id заявки.
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Дата обновления в состяние.
     */
    @Column(name = "update_date_time", nullable = false)
    private LocalDateTime updateDateTime;

    /**
     * Статус заявки.
     */
    @ManyToOne
    @JoinColumn(name = "status_id")
    private TaskStatus status;

    /**
     * Изменивший в состояние участник.
     */
    @ManyToOne
    @JoinColumn(name = "modifier_id")
    private Participant modifier;

    /**
     * Заявка.
     */
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}