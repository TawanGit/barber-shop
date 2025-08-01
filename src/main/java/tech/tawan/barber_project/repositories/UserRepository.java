package tech.tawan.barber_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tawan.barber_project.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
