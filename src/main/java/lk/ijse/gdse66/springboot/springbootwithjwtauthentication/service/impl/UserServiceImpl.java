package lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.dto.UserDTO;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.repository.UserRepo;
import lk.ijse.gdse66.springboot.springbootwithjwtauthentication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Kavithma Thushal
 * @project : Demo
 * @since : 11:06 AM - 4/19/2024
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> geAllUsers() {
        return userRepo.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }
}
