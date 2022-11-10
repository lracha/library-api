package com.lracha.libraryapi.Controllers;

import com.lracha.libraryapi.DTOs.LivrosDTO;
import com.lracha.libraryapi.Model.Livros;
import com.lracha.libraryapi.Services.LivrosService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LivrosController {

    @Autowired
    private LivrosService service;

    @RequestMapping("/status")
    public String status() {
        String ok = "Ta rodando";
        return ok;
    }

    @PostMapping
    public ResponseEntity<Object> postLivro(@RequestBody @Valid LivrosDTO livrosDTO){

        Livros livros = new Livros();
        BeanUtils.copyProperties(livrosDTO, livros);
        return service.save(livros);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livros>> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/livros/excluir/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
