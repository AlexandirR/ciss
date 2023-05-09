package service.mappers;

import domain.task.TaskType;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskTypeMapper {
    TaskType toEntity(TaskType taskType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TaskType partialUpdate(TaskType taskType, @MappingTarget TaskType mappingTaskType);
}