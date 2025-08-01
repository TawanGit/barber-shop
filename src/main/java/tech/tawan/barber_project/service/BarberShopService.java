package tech.tawan.barber_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tawan.barber_project.dtos.create.CreateBarberShopDTO;
import tech.tawan.barber_project.entity.BarberShop;
import tech.tawan.barber_project.repositories.BarberShopRepository;

@Service
public class BarberShopService {


 @Autowired
 private BarberShopRepository barberShopRepository;

    public BarberShop createBarberShop(CreateBarberShopDTO createBarberShopDto) {
        BarberShop createdBarberShop = new BarberShop();
        createdBarberShop.setName(createBarberShopDto.name());
        createdBarberShop.setCnpj(createBarberShopDto.cnpj());
        createdBarberShop.setEmail(createBarberShopDto.email());
        createdBarberShop.setCellphone(createBarberShopDto.cellphone());
        createdBarberShop.setAddress(createBarberShopDto.address());
        return barberShopRepository.save(createdBarberShop);

    }

}
