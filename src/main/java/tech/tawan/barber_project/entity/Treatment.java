package tech.tawan.barber_project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.tawan.barber_project.enums.CategoryEnum;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private Integer durationInMinutes;

    @Column
    private Boolean active;

    @Column
    private CategoryEnum category;

    @Column
    private String imageUrl;

    // eu coloco joincolumn pra dizer que a coluna user_id da tabela treatment
    // é a chave estrangeira que referencia a tabela user
    // e que o relacionamento é do tipo many to one, ou seja, muitos tratamentos podem
    // ser criados por um único usuário (createBy)
    @ManyToOne
    @JoinColumn(name = "barber_shop_id")
    private BarberShop barberShop;
}
