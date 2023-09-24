package com.api.musicplayer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class CrudService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    public Page<T> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<T> buscarPorId(ID id) {
        return repository.findById(id);
    }

    public T salvar(T entity) {
        return repository.save(entity);
    }

    public T atualizar(T entity) {
        return repository.save(entity);
    }

    public void excluir(ID id) {
        repository.deleteById(id);
    }
}