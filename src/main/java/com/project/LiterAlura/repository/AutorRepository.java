package com.project.LiterAlura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.LiterAlura.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {


    Optional<Autor> findByNombreAutor(String nombreAutor);

    @Query("SELECT a FROM Autor a WHERE a.fechaFallecimiento > :fechaFallecimiento")
    List<Autor> autoresVivosPorPeriodo(Integer fechaFallecimiento);

}
