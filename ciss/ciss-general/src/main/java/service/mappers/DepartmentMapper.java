package service.mappers;

import domain.Department;
import org.mapstruct.*;

/**
 * Маппер ДТО сущности департамента.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(Department department);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department partialUpdate(Department department, @MappingTarget Department mappingDepartment);
}