package domain;

import domain.participant.LeadExecutor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "department")
/**
 * Класс департамента.
 */
public class Department {
    /**
     * Id департамента.
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    /**
     * Название департамента.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Ведущий исполнитель в департаменте.
     */
    @OneToOne
    @JoinColumn(name = "lead_executor_id")
    private LeadExecutor leadExecutor;
}