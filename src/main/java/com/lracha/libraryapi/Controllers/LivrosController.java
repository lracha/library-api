package com.lracha.libraryapi.Controllers;

import com.lracha.libraryapi.DTOs.LivrosDTO;
import com.lracha.libraryapi.Repository.LivrosRepository;
import com.lracha.libraryapi.Model.Livros;
import com.lracha.libraryapi.Services.LivrosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/library")
public class LivrosController {

    @Autowired
    private LivrosService service;
    @PostMapping
    public ResponseEntity<Object> postLivro(@RequestBody @Valid LivrosDTO livrosDTO){

        Livros livros = new Livros();
        BeanUtils.copyProperties(livrosDTO, livros);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(livros));
    }

//    @GetMapping("/livro/{id}")
//    public ResponseEntity<Livros> getById(UUID id){
//    }
}
