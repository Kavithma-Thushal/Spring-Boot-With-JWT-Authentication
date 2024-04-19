package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.controller;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto.UserDTO;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Kavithma Thushal
 * @project : Spring-Boot-With-JWT-Authentication
 * @since : 7:15 PM - 4/19/2024
 **/
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        System.out.println("User Request Received...!");
        return userService.geAllUsers();
    }
}
