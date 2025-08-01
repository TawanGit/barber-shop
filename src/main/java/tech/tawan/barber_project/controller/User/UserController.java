package tech.tawan.barber_project.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.tawan.barber_project.dtos.AuthResponse;
import tech.tawan.barber_project.dtos.create.CreateUserDTO;
import tech.tawan.barber_project.dtos.login.LoginUserDTO;
import tech.tawan.barber_project.entity.User;
import tech.tawan.barber_project.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User>  createUser(@RequestBody CreateUserDTO createUserDTO) {

         User user = userService.createUser(createUserDTO);
         return ResponseEntity.ok(user);

    }


    @GetMapping()
    public ResponseEntity<AuthResponse> loginUser(@RequestBody  LoginUserDTO loginUserDTO) {
        AuthResponse token = userService.loginUser(loginUserDTO);
        return ResponseEntity.ok(token);
    }
}
