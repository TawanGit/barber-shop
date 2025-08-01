package tech.tawan.barber_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.tawan.barber_project.dtos.CreateUserDTO;
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

}
