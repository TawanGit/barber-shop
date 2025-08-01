package tech.tawan.barber_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String cellphone;

    // um usuario pode ter muitos tratamentos
    // eu coloco o mappedby pra falar que eu quero ver as informações que criei
    @OneToMany(mappedBy = "createdBy")
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;


  }
