package kz.azure.ms.controller;

import java.util.List;
import kz.azure.ms.model.dto.UserDTO;
import kz.azure.ms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/createOrUpdate")
    public UserDTO createOrUpdateUser(@RequestBody UserDTO userDto) {
        var createdOrUpdatedUser = userService.createOrUpdateUser(userDto);
        log.info("User created or updated successfully: {}", createdOrUpdatedUser);
        return createdOrUpdatedUser;
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers() {
        log.info("Received request to get all users");
        var users = userService.getUsers();
        log.info("Retrieved {} users", users.size());
        return users;
    }

    @GetMapping("/getUserByUsername/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        var userDto = userService.getUserByUserName(username);
        log.info("Retrieved user: {}", userDto);
        return userDto;
    }

    @DeleteMapping("/deleteUserByUsername/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUserName(username);
        log.info("User deleted successfully with username: {}", username);
    }
}