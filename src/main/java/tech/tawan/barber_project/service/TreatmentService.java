package tech.tawan.barber_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tawan.barber_project.dtos.create.CreateTreatmentDTO;
import tech.tawan.barber_project.entity.Treatment;
import tech.tawan.barber_project.repositories.TreatmentRepository;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public Treatment createTreatment(CreateTreatmentDTO createTreatmentDTO) {
       Treatment treatment = new Treatment();
         treatment.setName(createTreatmentDTO.name());
        treatment.setDescription(createTreatmentDTO.description());
        treatment.setPrice(createTreatmentDTO.price());
        treatment.setDurationInMinutes(createTreatmentDTO.durationInMinutes());
        treatment.setActive(createTreatmentDTO.active());
        treatment.setCategory(createTreatmentDTO.category());
        treatment.setImageUrl(createTreatmentDTO.imageUrl());
        treatment.setBarberShop(createTreatmentDTO.barberShopId());
        return treatmentRepository.save(treatment);
    }
}
