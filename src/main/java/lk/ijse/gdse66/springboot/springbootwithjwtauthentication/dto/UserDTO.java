package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Kavithma Thushal
 * @project : Demo
 * @since : 11:03 AM - 4/19/2024
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
