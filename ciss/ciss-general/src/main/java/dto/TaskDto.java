package dto;

import domain.task.TaskType;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link domain.task.Task} entity
 */
@Data
public class TaskDto implements Serializable {
    private final TaskType type;
    private final String description;
}