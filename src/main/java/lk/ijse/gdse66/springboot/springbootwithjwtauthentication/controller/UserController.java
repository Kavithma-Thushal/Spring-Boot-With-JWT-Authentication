package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.controller;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request.SignInRequest;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request.SignUpRequest;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.response.JwtAuthResponse;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto.UserDTO;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.AuthenticationService;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Kavithma Thushal
 * @project : Spring-Boot-With-JWT-Authentication
 * @since : 7:15 PM - 4/19/2024
 **/
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        System.out.println("User Request Received...!");
        return userService.geAllUsers();
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }
}
