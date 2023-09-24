package com.api.musicplayer.resources;

import com.api.musicplayer.controllers.MusicaController;
import com.api.musicplayer.entities.Musica;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
public class MusicaResource extends RepresentationModel<MusicaResource> {

    private Long id;

    private String nome;

    private String urlMusica;

    private LocalDateTime dataLancamento;

    public MusicaResource(Musica musica) {
        this.id = musica.getId();
        this.nome = musica.getNome();
        this.urlMusica = musica.getUrlMusica();
        this.dataLancamento = musica.getDataLancamento();

        add(linkTo(MusicaController.class).slash(id).withSelfRel());
    }

}