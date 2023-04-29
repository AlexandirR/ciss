package domain.task;

import domain.participant.Applicant;
import domain.participant.Executor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "task")
/**
 * Класс заявки.
 */
public class Task {
    /**
     * Id заявки.
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Дата создания заявки.
     */
    @Column(name = "create_dttm", nullable = false)
    private LocalDateTime createDateTime;

    /**
     * Дата закрытия заявки.
     */
    @Column(name = "end_dttm")
    private LocalDateTime endDateTime;

    /**
     * Тип заявки.
     */
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TaskType type;

    /**
     * Заявитель создавший заявку.
     */
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Applicant creator;

    /**
     * Описание.
     */
    @Column(name = "description")
    private String description;

    /**
     * Статус.
     */
    @ManyToOne
    @JoinColumn(name = "task_status_id")
    TaskStatus taskStatus;

    /**
     * Исполнители.
     */
    @ManyToMany
    @JoinTable(name = "task_executors",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "executors_id"))
    private Set<Executor> executors;

    /**
     * История состояний.
     */
    @OneToMany(mappedBy = "task", orphanRemoval = true)
    private Set<TaskHistory> taskHistories;

}