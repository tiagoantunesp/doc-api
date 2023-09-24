package com.api.musicplayer.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "musica")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String urlMusica;

    private LocalDateTime dataLancamento;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
