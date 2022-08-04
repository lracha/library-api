package com.lracha.libraryapi.Repository;

import com.lracha.libraryapi.Model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivrosRepository extends JpaRepository<Livros, UUID> {
    boolean existsLivrosByName(String name);
}
