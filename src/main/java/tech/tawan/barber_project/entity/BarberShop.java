package tech.tawan.barber_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BarberShop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String cnpj;

    @Column
    private String name;

    @Column
    private String address;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String cellphone;

    // um usuario pode ter muitos tratamentos
    // eu coloco o mappedby pra falar que eu quero ver as informações que criei

    @OneToMany(mappedBy = "barberShop")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "barberShop")
    private List<Treatment> treatments;



}
