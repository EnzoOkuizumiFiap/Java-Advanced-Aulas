package br.com.fiap.animes.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String personalidade;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;
}
