package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.auth.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignInRequest {
    private String email;
    private String password;
}
