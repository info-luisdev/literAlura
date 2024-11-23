package com.project.LiterAlura.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.LiterAlura.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> mostrarLibrosPorIdioma(String idioma);

}
