package com.lracha.libraryapi.DTOs;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

    @NotNull
    private String name;
    @NotNull
    private String author;
    @NotNull
    private LocalDate releaseDate;
}
