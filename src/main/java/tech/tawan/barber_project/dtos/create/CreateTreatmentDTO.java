package tech.tawan.barber_project.dtos.create;

import tech.tawan.barber_project.entity.BarberShop;
import tech.tawan.barber_project.enums.CategoryEnum;

public record CreateTreatmentDTO (String name, String description, Double price, Integer durationInMinutes, Boolean active, CategoryEnum category, String imageUrl, BarberShop barberShopId) {


}
