package com.lracha.libraryapi.controllers;

import com.lracha.libraryapi.Repository.LivrosRepository;
import com.lracha.libraryapi.model.Livros;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/library")
public class LivrosController {

    @Autowired
    private LivrosRepository livrosRepository;
    @PostMapping
    public Livros postLivro(@RequestBody @Valid Livros livros){
        return livrosRepository.save(livros);
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<Livros> getById(UUID id){
        if(livrosRepository.existsById(id)){
            return new ResponseEntity<Livros>(livrosRepository.getById(id), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
