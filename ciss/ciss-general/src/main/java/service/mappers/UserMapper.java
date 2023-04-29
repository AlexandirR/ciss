package service.mappers;

import domain.User;
import dto.UserDto;
import org.mapstruct.*;


/**
 * Маппер ДТО сущности юзера.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {DepartmentMapper.class})
public interface UserMapper {
    /**
     * Преобразование дто в сущность.
     * @param userDto дто user
     * @return сущность User
     */
    User toEntity(UserDto userDto);

    /**
     * Преобразование сущности в дто.
     * @param user сущность user
     * @return dto сущность
     */
    UserDto toDto(User user);

    /**
     * Метод обновления сущности через дто.
     * @param userDto дто
     * @param user сущность
     * @return обновленная сущность
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}