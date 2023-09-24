package com.api.musicplayer.controllers;

import com.api.musicplayer.entities.Musica;
import com.api.musicplayer.resources.MusicaResource;
import com.api.musicplayer.services.MusicaService;
import com.api.musicplayer.specifications.SpecificationTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/musicas")
public class MusicaController extends BaseController<Musica, Long> {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        super(musicaService);
        this.musicaService = musicaService;
    }

    @GetMapping
    public Page<MusicaResource> listarTodos(Pageable pageable, @RequestParam(name = "nomeAutor", required = false) Optional<String> nomeAutor) {

        Page<Musica> page;

        if (nomeAutor.isPresent()) {
            Specification<Musica> specification = SpecificationTemplate.musicaPorNomeAutor(nomeAutor.get());
            page = musicaService.listarTodos(specification, pageable);
        } else {
            page = musicaService.listarTodos(pageable);
        }

        Page<MusicaResource> musicaResources = page.map(MusicaResource::new);

        return musicaResources;
    }
}