package kz.azure.ms.controller;

import java.util.List;
import kz.azure.ms.model.dto.UserDTO;
import kz.azure.ms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/createOrUpdate")
    public UserDTO createOrUpdateUser(@RequestBody UserDTO userDto) {
        logger.info("Received request to create or update user: {}", userDto);
        return userService.createOrUpdateUser(userDto);
    }


    @PostMapping("/createOrUpdate")
    public UserDTO createOrUpdateUser(@RequestBody UserDTO userDto) {
        return userService.createOrUpdateUser(userDto);
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUserByUsername/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.getUserByUserName(username);
    }

    @DeleteMapping("/deleteUserByUsername/{username}")
    public void deleteUserByUsername(@PathVariable String username) {
        userService.deleteUserByUserName(username);
    }
}