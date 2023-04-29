package domain.task;

import domain.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task_type")
/**
 * Тип заявки.
 */
public class TaskType {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name = "template_code", nullable = false)
    private String templateCode;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}