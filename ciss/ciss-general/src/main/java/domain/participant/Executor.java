package domain.participant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "executor")
/**
 * Класс исполнителя.
 */
public class Executor extends Participant {
}