package kz.azure.ms.mapper;

import java.util.List;
import kz.azure.ms.model.dto.UserDTO;
import kz.azure.ms.model.entity.User;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = org.mapstruct.MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  UserDTO userToDto(User user);

  List<UserDTO> userToDtos(List<User> users);

  @Mapping(target = "id", ignore = true)
  User userDtoToModel(UserDTO userDto);

  @Mapping(target = "id", ignore = true)
  void updateOnly(UserDTO userDto, @MappingTarget User user);

  default String map(ObjectId objectId) {
    return objectId != null ? objectId.toString() : null;
  }
}
