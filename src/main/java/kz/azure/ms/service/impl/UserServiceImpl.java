package kz.azure.ms.service.impl;

import kz.azure.ms.exceptions.ObjectNotFoundException;
import kz.azure.ms.mapper.UserMapper;
import kz.azure.ms.model.dto.UserDTO;
import kz.azure.ms.model.entity.User;
import kz.azure.ms.repository.UserRepository;
import kz.azure.ms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public Mono<UserDTO> createOrUpdateUser(UserDTO userDto) {
    return userRepository.findByUsername(userDto.getUsername())
            .defaultIfEmpty(new User())
            .flatMap(user -> {
              userMapper.updateOnly(userDto, user);
              return userRepository.save(user);
            })
            .map(userMapper::userToDto);
  }

  @Override
  public Flux<UserDTO> getUsers() {
    return userRepository.findAll()
            .map(userMapper::userToDto);
  }

  @Override
  public Mono<UserDTO> getUserByUserName(String username) {
    return userRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(new ObjectNotFoundException(
                    String.format("User with username %s is not found", username))))
            .map(userMapper::userToDto);
  }

  @Override
  public Mono<Void> deleteUserByUserName(String username) {
    return userRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(new ObjectNotFoundException(
                    String.format("User with username %s is not found", username))))
            .flatMap(userRepository::delete);
  }
}