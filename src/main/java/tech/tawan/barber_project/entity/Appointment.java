package tech.tawan.barber_project.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "barber_shop_id")
    private BarberShop barberShop;

    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;
}
