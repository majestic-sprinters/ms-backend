package kz.azure.ms.service;

import kz.azure.ms.model.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
  Mono<UserDTO> createOrUpdateUser(UserDTO userDto);
  Flux<UserDTO> getUsers();
  Mono<UserDTO> getUserByUserName(String username);
  Mono<Void> deleteUserByUserName(String username);
}
