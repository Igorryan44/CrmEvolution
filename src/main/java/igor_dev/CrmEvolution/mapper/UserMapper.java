package igor_dev.CrmEvolution.mapper;

import igor_dev.CrmEvolution.dto.UserRequestDTO;
import igor_dev.CrmEvolution.dto.UserResponseDTO;
import igor_dev.CrmEvolution.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "User.id", ignore = true)
    User toUserEntity(UserRequestDTO userDTO);

    UserResponseDTO toUserResponseDTO(User userEntity);

    List<UserResponseDTO> toUserResponseDTO(List<User> userEntityList);
}
