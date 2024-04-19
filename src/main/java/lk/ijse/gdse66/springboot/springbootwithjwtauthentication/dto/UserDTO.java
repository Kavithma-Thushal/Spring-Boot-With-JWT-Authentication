package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto;

import lombok.AllArgsConstructor;
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
public class UserDTO {
    private String id;
    private String name;
    private String address;
}
