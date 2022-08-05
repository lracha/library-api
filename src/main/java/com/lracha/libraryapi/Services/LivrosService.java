package com.lracha.libraryapi.Services;

import com.lracha.libraryapi.Model.Livros;
import com.lracha.libraryapi.Repository.LivrosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> delete(Long id) {
        Optional<Livros> livrosOptional = lr.findById(id);
        if (!livrosOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi Encontrado nenhum Livro para ser deletado");
        }
        lr.delete(livrosOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Foi deletado com Sucesso");
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Livros> livrosOptional = lr.findById(id);
        if (!livrosOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi Encontrado nenhum Livro para ser deletado");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(livrosOptional.get());
    }

    public ResponseEntity<List<Livros>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(lr.findAll());
    }
}
