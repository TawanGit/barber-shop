package tech.tawan.barber_project.controller.Barber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.tawan.barber_project.dtos.create.CreateBarberShopDTO;
import tech.tawan.barber_project.entity.BarberShop;
import tech.tawan.barber_project.service.BarberShopService;

@RestController
@RequestMapping("/api/v1/barber-shops")
public class BarberShopController {

    @Autowired
    private BarberShopService barberShopService;

    @PostMapping
    public ResponseEntity<BarberShop> createBarberShop(@RequestBody CreateBarberShopDTO createBarberShopDto) {
        BarberShop barberShop = barberShopService.createBarberShop(createBarberShopDto);
        return ResponseEntity.ok(barberShop);
    }
}
