package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.repository;

import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Kavithma Thushal
 * @project : Demo
 * @since : 11:09 AM - 4/19/2024
 **/
public interface UserRepo extends JpaRepository<UserEntity, String> {
}
