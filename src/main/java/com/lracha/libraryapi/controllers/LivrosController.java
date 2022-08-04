package com.lracha.libraryapi.controllers;

import com.lracha.libraryapi.DTOs.LivroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/library")
public class LivrosController {
    @PostMapping
    public ResponseEntity<Object> novoLivros(@RequestBody @Valid LivroDTO livroDTO){

    }
}
