package iftm.edu.leilao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "itens-leilao")
public class ItemDeLeilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double valorMinimo;

    private boolean leilaoAberto;

    @OneToOne
    private Lance lanceVencedor;

    @ManyToMany
    private List<Lance> lancesRecebidos = new ArrayList<Lance>();
}
