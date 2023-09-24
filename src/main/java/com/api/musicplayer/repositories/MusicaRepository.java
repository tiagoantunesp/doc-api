package com.api.musicplayer.repositories;

import com.api.musicplayer.entities.Musica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long>, JpaSpecificationExecutor<Musica> {

    Page<Musica> findAll(Specification<Musica> specification, Pageable pageable);
}