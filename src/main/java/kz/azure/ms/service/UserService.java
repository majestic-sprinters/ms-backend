package kz.azure.ms.service;

import java.util.List;
import kz.azure.ms.model.dto.UserDTO;

public interface UserService {
  UserDTO createOrUpdateUser(UserDTO userDto);

  List<UserDTO> getUsers();

  UserDTO getUserByUserName(String username);
  void deleteUserByUserName(String username);
}
