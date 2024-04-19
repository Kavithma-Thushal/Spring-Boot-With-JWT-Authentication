package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request.SignInRequest;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request.SignUpRequest;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.response.JwtAuthResponse;

/**
 * @author : Kavithma Thushal
 * @project : Spring-Boot-With-JWT-Authentication
 * @since : 8:27 PM - 4/19/2024
 **/
public interface AuthenticationService {
    JwtAuthResponse signIn(SignInRequest signInRequest);
    JwtAuthResponse signUp(SignUpRequest signUpRequest);
}
