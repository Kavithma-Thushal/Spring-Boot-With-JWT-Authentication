package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author : Kavithma Thushal
 * @project : Demo
 * @since : 11:06 AM - 4/19/2024
 **/
public interface UserService {
    List<UserDTO> geAllUsers();
    UserDetailsService userDetailsService();
}
