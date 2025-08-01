package tech.tawan.barber_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.tawan.barber_project.dtos.AuthResponse;
import tech.tawan.barber_project.dtos.create.CreateUserDTO;
import tech.tawan.barber_project.dtos.login.LoginUserDTO;
import tech.tawan.barber_project.entity.User;
import tech.tawan.barber_project.repositories.UserRepository;
import tech.tawan.barber_project.config.JwtService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired private JwtService jwtService;

    public User createUser(CreateUserDTO createUserDTO) {
        if (userRepository.findByEmail(createUserDTO.email()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setName(createUserDTO.name());
        user.setEmail(createUserDTO.email());
        user.setPassword(encoder.encode(createUserDTO.password()));
        user.setCellphone(createUserDTO.cellphone());
        return userRepository.save(user);
    }

    public AuthResponse loginUser(LoginUserDTO loginUserDTO) {
        User user = userRepository.findByEmail(loginUserDTO.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(loginUserDTO.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

}
