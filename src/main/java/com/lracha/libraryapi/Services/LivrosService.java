package com.lracha.libraryapi.Services;

import com.lracha.libraryapi.Model.Livros;
import com.lracha.libraryapi.Repository.LivrosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LivrosService {

    final LivrosRepository lr;

    public ResponseEntity<Object> save(Livros livros) {
        if (lr.existsLivrosByName(livros.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse Livro já existe");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(lr.save(livros));
    }
}
