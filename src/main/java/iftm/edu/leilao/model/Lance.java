package iftm.edu.leilao.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lances")
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double valor;

    @OneToOne
    private Participante participante;
}
