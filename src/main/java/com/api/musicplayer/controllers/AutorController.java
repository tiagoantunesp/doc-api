package com.api.musicplayer.controllers;

import com.api.musicplayer.entities.Autor;
import com.api.musicplayer.services.AutorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/autores")
public class AutorController extends BaseController<Autor, Long> {

    public AutorController(AutorService autorService) {
        super(autorService);
    }

}