package domain.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "task_status")
/**
 * Статус завки.
 */
public class TaskStatus {

    public static final class Names {
        public static final String REGISTERED = "registered";

        public static final String PERFORMED = "performed";

        public static final String COMPLETED = "completed";

        public static final String RETURNED = "returned";

        public static final String CLOSED = "closed";
    }
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

}