package com.lracha.libraryapi.Repository;

import com.lracha.libraryapi.Model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LivrosRepository extends JpaRepository<Livros, Long> {
    boolean existsLivrosByName(String name);
}
