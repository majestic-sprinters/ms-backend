package kz.azure.ms.service.impl;

import java.util.List;
import kz.azure.ms.exceptions.ObjectNotFoundException;
import kz.azure.ms.mapper.UserMapper;
import kz.azure.ms.model.dto.UserDTO;
import kz.azure.ms.model.entity.User;
import kz.azure.ms.reporitory.UserRepository;
import kz.azure.ms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserDTO createOrUpdateUser(UserDTO userDto) {
    var byCtn = userRepository.findByFio(userDto.getFio());
    var user = byCtn.orElseGet(User::new);
    userMapper.updateOnly(userDto, user);
    return saveAndMapToDto(user);
  }

  public UserDTO saveAndMapToDto(User user) {
    return userMapper.userToDto(userRepository.save(user));
  }

  @Override
  public List<UserDTO> getUsers() {
    return userMapper.userToDtos(userRepository.findAll());
  }

  @Override
  public UserDTO getUserByUserName(String username) {
    return userMapper.userToDto(userRepository.findByUsername(username)
        .orElseThrow(() -> new ObjectNotFoundException(
            String.format("User with username %s is not found", username))));
  }

  @Override
  public void deleteUserByUserName(String username) {
    var user =
        userRepository.findByUsername(username)
            .orElseThrow(
                () -> new ObjectNotFoundException(
                    String.format("User with username %s is not found", username)));

    userRepository.delete(user);
  }
}