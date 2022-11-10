package com.lracha.libraryapi.Services;

import com.lracha.libraryapi.Model.Livros;
import com.lracha.libraryapi.Repository.LivrosRepository;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

class LivrosServiceTest {


    private Long ID = Long.valueOf(1);
    @InjectMocks
    private LivrosService service;

    @Mock
    private LivrosRepository repository;

    @Mock
    private Livros livros;
    private Optional<Livros> optionalLivros;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startLivros();
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalLivros);

        ResponseEntity<Object> reponse = service.findById(ID);

        Assertions.assertEquals( new Livros(Long.valueOf(1), "Senhor dos Aneis", "Tolkien", LocalDate.now(), 551), reponse.getBody());
    }

    @Test
    void findAll() {
    }

    private void startLivros() {

        livros = new Livros(ID, "Senhor dos Aneis", "Tolkien", LocalDate.now(), 551);
        optionalLivros = Optional.of(new Livros(ID, "Senhor dos Aneis", "Tolkien", LocalDate.now(), 551));
    }
}