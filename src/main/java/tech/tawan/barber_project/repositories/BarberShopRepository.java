package tech.tawan.barber_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.tawan.barber_project.entity.BarberShop;

public interface BarberShopRepository extends JpaRepository<BarberShop, Long> {
}
