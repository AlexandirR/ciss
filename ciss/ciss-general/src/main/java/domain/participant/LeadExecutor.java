package domain.participant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lead_executor")
/**
 * Класс ведущего испонителя.
 */
public class LeadExecutor extends Executor {
}