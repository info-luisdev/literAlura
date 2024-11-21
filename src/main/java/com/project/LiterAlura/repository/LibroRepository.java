package com.project.LiterAlura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LiterAlura.models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTitulo(String titulo);

}
