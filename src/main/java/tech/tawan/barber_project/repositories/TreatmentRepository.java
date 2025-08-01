package tech.tawan.barber_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tawan.barber_project.entity.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
