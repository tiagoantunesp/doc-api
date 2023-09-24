package com.api.musicplayer.controllers;

import com.api.musicplayer.services.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public abstract class BaseController<T, ID> {

    protected final CrudService<T, ID> service;

    public BaseController(CrudService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<Page<T>> listarTodos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable ID id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/salvar")
    public T salvar(@RequestBody T entidade) {
        return service.salvar(entidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> atualizar(@PathVariable ID id, @RequestBody T entidade) {

        Optional<T> entidadeAtualizada = service.buscarPorId(id);

        if (entidadeAtualizada.isEmpty())
            return ResponseEntity.notFound().build();

        service.atualizar(entidade);

        return ResponseEntity.ok(entidadeAtualizada.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable ID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}