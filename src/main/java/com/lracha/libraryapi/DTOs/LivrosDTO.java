package com.lracha.libraryapi.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivrosDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String author;
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    private long pages;
}
