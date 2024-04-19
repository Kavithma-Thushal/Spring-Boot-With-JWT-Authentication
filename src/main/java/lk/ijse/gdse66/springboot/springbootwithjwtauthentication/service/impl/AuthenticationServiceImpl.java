package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.impl;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request.SignInRequest;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request.SignUpRequest;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.response.JwtAuthResponse;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto.UserDTO;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.entity.UserEntity;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.repository.UserRepo;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.AuthenticationService;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.JwtService;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.util.Role;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Kavithma Thushal
 * @project : Spring-Boot-With-JWT-Authentication
 * @since : 8:28 PM - 4/19/2024
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepo userRepo;
    private ModelMapper mapper;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepo userRepo, ModelMapper mapper, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JwtAuthResponse signIn(SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        UserEntity user = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String generatedToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUpRequest signUpRequest) {
        UserDTO userDTO = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(Role.valueOf(signUpRequest.getRole()))
                .build();
        UserEntity savedUser = userRepo.save(mapper.map(userDTO, UserEntity.class));
        String generatedToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(generatedToken).build();
    }
}
