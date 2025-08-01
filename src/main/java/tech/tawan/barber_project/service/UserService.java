package tech.tawan.barber_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tawan.barber_project.dtos.CreateUserDTO;
import tech.tawan.barber_project.entity.User;
import tech.tawan.barber_project.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.name());
        user.setEmail(createUserDTO.email());
        user.setPassword(createUserDTO.password());
        user.setCellphone(createUserDTO.cellphone());
        return userRepository.save(user);
    }

}
