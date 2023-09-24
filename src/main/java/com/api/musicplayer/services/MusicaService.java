package com.api.musicplayer.services;

import com.api.musicplayer.entities.Musica;
import com.api.musicplayer.repositories.MusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MusicaService extends CrudService<Musica, Long> {

    private final MusicaRepository musicaRepository;

    public Page<Musica> listarTodos(Specification<Musica> specification, Pageable pageable) {
        return musicaRepository.findAll(specification, pageable);
    }
}