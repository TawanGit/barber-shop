package tech.tawan.barber_project.controller.Treatment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.tawan.barber_project.dtos.create.CreateTreatmentDTO;
import tech.tawan.barber_project.entity.Treatment;
import tech.tawan.barber_project.service.TreatmentService;

@RestController
@RequestMapping("/api/v1/treatments")
public class TreatmentController {


    @Autowired
    private TreatmentService treatmentService;

    @PostMapping
    public ResponseEntity<Treatment> createTreatment(@RequestBody  CreateTreatmentDTO createTreatmentDTO) {
       Treatment treatment = treatmentService.createTreatment(createTreatmentDTO);
        return ResponseEntity.ok(treatment);
    }
}
